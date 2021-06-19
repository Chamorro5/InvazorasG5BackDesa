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

import es.uah.invaZoras.hibernate.pojo.Usuario;

public class UsuarioDao {
	
	private static UsuarioDao instance;
	private static SessionFactory factory;
	
	private  UsuarioDao () {
		
	}
	
	public static UsuarioDao getInstance() {
		if (instance == null) {
			instance = new UsuarioDao();
		}
		
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario conseguirUsuario (int id) throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		Usuario usuario;
		
		try {
			tx = session.beginTransaction();
			
			Query<Usuario> queryUsuario = session.createQuery("FROM Usuario WHERE id_usuario = ?0");
			List<Usuario> listUsuarios = queryUsuario.setParameter(0, id).list();
			if (listUsuarios.size() == 1) {
					usuario = listUsuarios.get(0);
			} else {
				usuario = null;
			}
			
			tx.commit();
		} catch (HibernateException e) {
			throw new Exception ( e.getMessage());
		} finally {
			session.close();
		}

		return usuario;
		
	}
	
	@SuppressWarnings("unchecked")
	public Usuario conseguirUsuario (String correo) throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		Usuario usuario;
		
		try {
			tx = session.beginTransaction();
			
			Query<Usuario> queryUsuario = session.createQuery("FROM Usuario WHERE correo = ?0");
			List<Usuario> listUsuarios = queryUsuario.setParameter(0, correo).list();
			if (listUsuarios.size() == 1) {
					usuario = listUsuarios.get(0);
			} else {
				usuario = null;
			}
			
			tx.commit();
		} catch (HibernateException e) {
			throw new Exception ( e.getMessage());
		} finally {
			session.close();
		}

		return usuario;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> conseguirUsuarios () throws Exception {
		
		Session session = crearSession();
		Transaction tx = null;
		
		List<Usuario> listUsuarios = new ArrayList <> ();
		
		try {
			tx = session.beginTransaction();
			
			List<Usuario> usuarios = session.createQuery("FROM Usuario").list();
			listUsuarios.addAll(usuarios);
//			for (Iterator iterator = usuarios.iterator(); iterator.hasNext();){
//				Object it = iterator.next();
//				Usuario usuario = new Usuario();
//				usuario.setId_usuario(((Usuario) it).getId_usuario());
//				usuario.setNombre(((Usuario) it).getNombre());
//				usuario.setCorreo(((Usuario) it).getCorreo());
//				usuario.setClave(((Usuario) it).getClave());
//				usuario.setHabilitado(((Usuario) it).isHabilitado());
//				usuario.setModerador(((Usuario) it).isModerador());
//				listUsuarios.add(usuario);
//			}
			
			tx.commit();
		} catch (HibernateException e) {
			throw new Exception ( e.getMessage());
		} finally {
			session.close();
		}
		
		return listUsuarios;
		
	}
	
	public long insertarUsuario (Usuario usuario) {
		Session session = crearSession();
		Transaction tx = null;
		Integer usuarioID = null;
		
		try {
			tx = session.beginTransaction();
			usuarioID = (Integer) session.save(usuario);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return usuarioID;
	}
	
	public void eliminarUsuario (int id) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Usuario usuario = (Usuario)session.get(Usuario.class, id);
			session.delete(usuario);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void eliminarUsuario (Usuario usuario) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(usuario);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void actualizarUsuario (Usuario usuario) {
		Session session = crearSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(usuario);
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
