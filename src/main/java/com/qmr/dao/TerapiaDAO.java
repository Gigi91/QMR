package com.qmr.dao;

import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.qmr.model.MedicalRecord;
import com.qmr.model.Terapia;

public class TerapiaDAO {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addTerapia(
			String cf,
    		Date dataInizio,
			Date dataFine,
			boolean stato,
			String descrizione){
		
		try{
			
			Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        
	        Query query = session.createQuery(""
	        		+ "from MedicalRecord mr "
	        		+ "where mr.mrPK.paziente.pazientePK.CF = :cf");
	        query.setParameter("cf", cf);
	        MedicalRecord mr = (MedicalRecord)query.list().get(0);
	        
	        Terapia t = new Terapia();
	        t.setDataInizio(dataInizio);
	        t.setDataFine(dataFine);
	        t.setStato(stato);
	        t.setDescrizione(descrizione);
	        t.setMr(mr);
	        
	        session.save(t);
	        session.getTransaction().commit();
	        
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
