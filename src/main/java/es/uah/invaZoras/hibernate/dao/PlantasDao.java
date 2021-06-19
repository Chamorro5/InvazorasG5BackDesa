package es.uah.invaZoras.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;

public class PlantasDao {
	
	private static PlantasDao instance;
	private static SessionFactory factory;
	
	private  PlantasDao () {
		
	}
	
	public static PlantasDao getInstance() {
		if (instance == null) {
			instance = new PlantasDao();
		}
		
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public Planta conseguirPlanta (int id) throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		Planta planta;
		
		try {
			tx = session.beginTransaction();
			
			Query<Planta> queryPlanta = session.createQuery("FROM Planta WHERE id_planta = ?0");
			List<Planta> listPlantas = queryPlanta.setParameter(0, id).list();
			if (listPlantas.size() == 1) {
				planta = (Planta)listPlantas.get(0);
			} else {
				planta = null;
			}
			
			tx.commit();
		} catch (HibernateException e) {
			throw new Exception ( e.getMessage());
		} finally {
			session.close();
		}
		
		return planta;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Planta> conseguirListaPlantas () throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		List<Planta> listPlantas = new ArrayList <> ();
		
		try {
			tx = session.beginTransaction();
			
			List<Planta> plantas = session.createQuery("FROM Planta").list();
			listPlantas.addAll(plantas);
//			List plantas = session.createQuery("FROM Planta").list();
//			
//			for (Iterator iterator = plantas.iterator(); iterator.hasNext();){
//				Object it = iterator.next();
//				Planta planta = new Planta();
//				planta.setId_planta(((Planta) it).getId_planta());
//				planta.setNombre(((Planta) it).getNombre());
//				planta.setDescripcion(((Planta) it).getDescripcion());
//				planta.setPais(((Planta) it).getPais());
//				planta.setPais_siglas(((Planta) it).getPais_siglas());
//				listPlantas.add(planta);
//			}
			
			tx.commit();
		} catch (HibernateException e) {
			throw new Exception ( e.getMessage());
		} finally {
			session.close();
		}
		
		return listPlantas;
		
	}
	
	public int insertarPlanta (Planta planta) {
		Session session = crearSession();
		Transaction tx = null;
		Integer plantaID = null;
		
		try {
			tx = session.beginTransaction();
			plantaID = (Integer) session.save(planta);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return plantaID;
	}
	
	public void eliminarPlanta (int id) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Planta planta = (Planta)session.get(Planta.class, id);
			session.delete(planta);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void eliminarPlanta (Planta planta) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(planta);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void actualizarPlanta (Planta planta) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(planta);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private Session crearSession () {
		if (factory == null) {
			try {
				factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    } catch (Throwable ex) { 
		    	System.err.println("Failed to create sessionFactory object." + ex);
		        throw new ExceptionInInitializerError(ex); 
		    }
		}
		
		return factory.openSession();
		
	}
	
	

}
