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

import es.uah.invaZoras.hibernate.dao.IncidenciaDao;
import es.uah.invaZoras.hibernate.dao.PlantasDao;
import es.uah.invaZoras.hibernate.pojo.Incidencia;
import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;

public class IncidenciaSrv {
	
	private static IncidenciaSrv instance;
	private static SessionFactory factory;
	
	private  IncidenciaSrv () {
		
	}
	
	public static IncidenciaSrv getInstance() {
		if (instance == null) {
			instance = new IncidenciaSrv();
		}
		
		return instance;
	}
	
	public Incidencia conseguirIncidencia (int id) throws Exception {
		
		return IncidenciaDao.getInstance().conseguirIncidencia(id);
		
	}
	
	public List<Incidencia> conseguirIncidencias () throws Exception {
		
		return IncidenciaDao.getInstance().conseguirIncidencias();
		
	}
	
	public int insertarIncidencia (Incidencia incidencia) {
		
		return IncidenciaDao.getInstance().insertarIncidencia(incidencia);
		
	}
	
	public void eliminarIncidencia (int id) {
		
		IncidenciaDao.getInstance().eliminarIncidencia(id);
		
	}
	
	public void eliminarIncidencia (Incidencia incidencia) {
		
		IncidenciaDao.getInstance().eliminarIncidencia(incidencia);
		
	}
	
	public void actualizarIncidencia (Incidencia incidencia) {
		
		IncidenciaDao.getInstance().actualizarIncidencia(incidencia);
		
	}
	
}
