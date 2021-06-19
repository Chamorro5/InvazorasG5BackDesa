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

import es.uah.invaZoras.hibernate.pojo.Incidencia;
import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;

public class IncidenciaDao {
	
	private static IncidenciaDao instance;
	private static SessionFactory factory;
	
	private  IncidenciaDao () {
		
	}
	
	public static IncidenciaDao getInstance() {
		if (instance == null) {
			instance = new IncidenciaDao();
		}
		
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public Incidencia conseguirIncidencia (int id) throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		Incidencia incidencia;
		
		try {
			tx = session.beginTransaction();
			
			Query<Incidencia> queryIncidencia = session.createQuery("FROM Incidencia WHERE id_incidencia = ?0");
			List<Incidencia> listIncidencia = queryIncidencia.setParameter(0, id).list();
			
			if (listIncidencia.size() == 1) {
				incidencia = listIncidencia.get(0);
			} else {
				incidencia = null;
			}
			
			tx.commit();
		} catch (HibernateException e) {
			throw new Exception ( e.getMessage());
		} finally {
			session.close();
		}
		
		return incidencia;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Incidencia> conseguirIncidencias () throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		List<Incidencia> listIncidencia = new ArrayList <> ();
		
		try {
			tx = session.beginTransaction();
			
			List<Incidencia> incidencias = session.createQuery("FROM Incidencia").list();
			listIncidencia.addAll(incidencias);
			
			tx.commit();
		} catch (HibernateException e) {
			throw new Exception ( e.getMessage());
		} finally {
			session.close();
		}
		
		return listIncidencia;
		
	}
	
	public int insertarIncidencia (Incidencia incidencia) {
		Session session = crearSession();
		Transaction tx = null;
		Integer plantaID = null;
		
		try {
			tx = session.beginTransaction();
			plantaID = (Integer) session.save(incidencia);
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
	
	public void eliminarIncidencia (int id) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Incidencia incidencia = (Incidencia)session.get(Incidencia.class, id);
			session.delete(incidencia);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void eliminarIncidencia (Incidencia incidencia) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(incidencia);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void actualizarIncidencia (Incidencia incidencia) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(incidencia);
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
