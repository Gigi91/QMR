package com.qmr.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.qmr.model.GruppoSanguigno;
import com.qmr.model.MedicalRecord;
import com.qmr.model.MedicalRecordPK;
import com.qmr.model.Paziente;

public class MedicalRecordDAO {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addMedicalRecord(String cf, String gs_tipo, boolean gs_rh){
		try{
			
			Session session = sessionFactory.openSession();
	        session.beginTransaction();
						
	        /*get paziente with a cf*/
	        Query query = session.createQuery("from Paziente as p where p.pazientePK.CF = :cf");
	        query.setParameter("cf", cf);
	        Paziente paziente = (Paziente)query.list().get(0);
	        
	        /*get grupposanguigno id*/
	        query = session.createQuery("from GruppoSanguigno as gs where gs.tipo = :tipo and gs.Rh = :rh");
	        query.setParameter("tipo", gs_tipo);
	        query.setParameter("rh", gs_rh);
	        GruppoSanguigno gs = (GruppoSanguigno) query.list().get(0);
	        
	        /*create medical record*/
	        MedicalRecord mr = new MedicalRecord();
	   
	        
	        MedicalRecordPK key = new MedicalRecordPK();
	        key.setPaziente(paziente);
	        mr.setMrPK(key);
	        
			session.save(mr);
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
