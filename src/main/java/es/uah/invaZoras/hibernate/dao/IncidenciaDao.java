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
	
	public Incidencia conseguirIncidencia (int id) throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		Incidencia incidencia;
		
		try {
			tx = session.beginTransaction();
			
			Query<?> queryIncidencia = session.createSQLQuery("SELECT * FROM Incidencia WHERE id_incidencia = :param1");
			queryIncidencia.setParameter("param1", id);
			List<?> listIncidencia = queryIncidencia.list();
			if (listIncidencia.size() == 1) {
				incidencia = new Incidencia();
				incidencia.setId_incidencia(((Incidencia) listIncidencia.get(0)).getId_incidencia());
				incidencia.setFecha(((Incidencia) listIncidencia.get(0)).getFecha());
				incidencia.setFk_planta(((Incidencia) listIncidencia.get(0)).getFk_planta());
				incidencia.setFk_usuario(((Incidencia) listIncidencia.get(0)).getFk_usuario());
				incidencia.setImagen(((Incidencia) listIncidencia.get(0)).getImagen());
				incidencia.setValor_invasion(((Incidencia) listIncidencia.get(0)).getValor_invasion());
				incidencia.setLatitud(((Incidencia) listIncidencia.get(0)).getLatitud());
				incidencia.setLongitud(((Incidencia) listIncidencia.get(0)).getLongitud());
				incidencia.setAdmitida(((Incidencia) listIncidencia.get(0)).isAdmitida());;
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
	
	public List<Incidencia> conseguirIncidencias () throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		List<Incidencia> listIncidencia = new ArrayList <> ();
		
		try {
			tx = session.beginTransaction();
			
			List incidencias = session.createQuery("FROM Incidencia").list();
			for (Iterator iterator = incidencias.iterator(); iterator.hasNext();){
				Object it = iterator.next();
				Incidencia incidencia = new Incidencia();
				incidencia.setId_incidencia(((Incidencia) it).getId_incidencia());
				incidencia.setFecha(((Incidencia) it).getFecha());
				incidencia.setFk_planta(((Incidencia) it).getFk_planta());
				incidencia.setFk_usuario(((Incidencia) it).getFk_usuario());
				incidencia.setImagen(((Incidencia) it).getImagen());
				incidencia.setValor_invasion(((Incidencia) it).getValor_invasion());
				incidencia.setLatitud(((Incidencia) it).getLatitud());
				incidencia.setLongitud(((Incidencia) it).getLongitud());
				incidencia.setAdmitida(((Incidencia) it).isAdmitida());
				listIncidencia.add(incidencia);
			}
			
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
