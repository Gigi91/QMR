package com.qmr.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.qmr.model.Anamnesi;
import com.qmr.model.AnamnesiPK;
import com.qmr.model.MedicalRecord;

public class AnamnesiDAO {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void AggiungiAnamnesi(String cf, String allergie, String malattiePregresse,
			String malattieInfanzia, String intolleranze, String interventi, String vaccini){
		
		Anamnesi anamnesi = new Anamnesi();
		AnamnesiPK anPK = new AnamnesiPK();
		
		anamnesi.setAllergie(allergie);
		anamnesi.setInterventi(interventi);
		anamnesi.setIntolleranze(intolleranze);
		anamnesi.setMalattieInfanzia(malattieInfanzia);
		anamnesi.setMalattiePregresse(malattiePregresse);
		anamnesi.setVaccini(vaccini);
		
		try{
			
			Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        
	        Query query = session.createQuery(""
	        		+ "from MedicalRecord mr "
	        		+ "where mr.mrPK.paziente.pazientePK.CF = :cf");
	        query.setParameter("cf", cf);
	        MedicalRecord mr = (MedicalRecord)query.list().get(0);
	        anPK.setMr(mr);
	        anamnesi.setAnamnesiPK(anPK);
	        
	        session.save(anamnesi);
	        session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	       
		
	}
}
