package es.uah.invaZoras.srv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import es.uah.invaZoras.hibernate.dao.PlantasDao;
import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;

public class PlantasSrv {
	
	private static PlantasSrv instance;
	private static SessionFactory factory;
	
	private  PlantasSrv () {
		
	}
	
	public static PlantasSrv getInstance() {
		if (instance == null) {
			instance = new PlantasSrv();
		}
		
		return instance;
	}
	
	public Planta conseguirPlanta (int id) throws Exception {
		
		return PlantasDao.getInstance().conseguirPlanta(id);
		
	}
	
	public List<Planta> conseguirListaPlantas () throws Exception {
		
		return PlantasDao.getInstance().conseguirListaPlantas();
		
	}
	
	public int insertarPlanta (Planta planta) {
		
		return PlantasDao.getInstance().insertarPlanta(planta);
		
	}
	
	public void eliminarPlanta (int id) {
		
		PlantasDao.getInstance().eliminarPlanta(id);
		
	}
	
	public void eliminarPlanta (Planta planta) {
		
		PlantasDao.getInstance().eliminarPlanta(planta);
		
	}
	
	public void actualizarPlanta (Planta planta) {
		
		PlantasDao.getInstance().actualizarPlanta(planta);
		
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
