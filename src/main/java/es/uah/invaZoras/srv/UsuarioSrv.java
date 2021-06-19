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

import es.uah.invaZoras.hibernate.dao.UsuarioDao;
import es.uah.invaZoras.hibernate.pojo.Usuario;

public class UsuarioSrv {
	
	private static UsuarioSrv instance;
	private static SessionFactory factory;
	
	private  UsuarioSrv () {
		
	}
	
	public static UsuarioSrv getInstance() {
		if (instance == null) {
			instance = new UsuarioSrv();
		}
		
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario conseguirUsuario (int id) throws Exception {
		
		return UsuarioDao.getInstance().conseguirUsuario(id);
		
	}
	
	@SuppressWarnings("unchecked")
	public Usuario conseguirUsuario (String correo) throws Exception {
		
		return UsuarioDao.getInstance().conseguirUsuario(correo);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> conseguirUsuarios () throws Exception {
		
		return UsuarioDao.getInstance().conseguirUsuarios();
		
	}
	
	public long insertarUsuario (Usuario usuario) {
		
		return UsuarioDao.getInstance().insertarUsuario(usuario);
		
	}
	
	public void eliminarUsuario (int id) {
		
		UsuarioDao.getInstance().eliminarUsuario(id);
		
	}
	
	public void eliminarUsuario (Usuario usuario) {
		
		UsuarioDao.getInstance().eliminarUsuario(usuario);
		
	}
	
	public void actualizarUsuario (Usuario usuario) {
		
		UsuarioDao.getInstance().eliminarUsuario(usuario);
		
	}
	
	
	public boolean comprobarUsuarioPassword (String correo, String password) throws Exception {
		
		Usuario usuario = UsuarioDao.getInstance().conseguirUsuario(correo);
		
		return password.equals(usuario.getClave());
		
	}
	
	public boolean comprobarUsuarioPassword (int id, String password) throws Exception {
		
		Usuario usuario = UsuarioDao.getInstance().conseguirUsuario(id);
		
		return password.equals(usuario.getClave());
		
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
