package com.qmr.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import com.qmr.model.Paziente;
import com.qmr.model.PazientePK;

public class PazienteDAO {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addPaziente(Paziente paziente){
		
		try{
			
			Session session = sessionFactory.openSession();
	        session.beginTransaction();
						
			session.save(paziente);
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	public Object getPazienteByCf(String cf){
		try{
			Session session = sessionFactory.openSession();
			
			Query q = session.createQuery(""
					+ "select m "
					+ "from MedicalRecord as m "
					+ "inner join m.mrPK.paziente as p "
					+ "inner join m.gs as g "
					+ "where p.pazientePK.CF = :cf "
			);
			
			q.setParameter("cf", cf);
			List result = q.list();
			if(result.size()>0)
				return result.get(0);
			else 
				return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Object getPazienteById(int id){
		try{
			Session session = sessionFactory.openSession();
			
			Query q = session.createQuery(""
					+ "select m "
					+ "from MedicalRecord as m "
					+ "inner join m.mrPK.paziente as p "
					+ "inner join m.gs as g "
					+ "where p.pazientePK.ID = :id "
			);
			
			q.setParameter("id", id);
			List result = q.list();
			if(result.size()>0)
				return result.get(0);
			else 
				return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Object getPazienteByCF(String cf){
		try{
			Session session = sessionFactory.openSession();
			
			Query q = session.createQuery(""
					+ "select m "
					+ "from MedicalRecord as m "
					+ "inner join m.mrPK.paziente as p "
					+ "inner join m.gs as g "
					+ "where p.pazientePK.CF = :cf "
			);
			
			q.setParameter("cf", cf);
			List result = q.list();
			return result.get(0);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void updatePaziente(Paziente paziente){
		try{
			Session session = sessionFactory.openSession();
			session.update(paziente);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void removePaziente(int id, String cf){
		try{
			Session session = sessionFactory.openSession();
			PazientePK key = new PazientePK();
			key.setID(id);
			key.setCF(cf);
			
			Paziente paziente = (Paziente) session.load(Paziente.class, key);
			if (paziente != null)
				session.delete(paziente);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}