package es.uah.invaZoras.zzpruebas;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.uah.invaZoras.hibernate.dao.UsuarioDao;
import es.uah.invaZoras.hibernate.pojo.Incidencia;
import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;
 
public class StoreData {
 
    public static void main(String[] args) {
        // Creating Hibernate Configuration Object 
        Configuration cfgObj = new Configuration();
        // Populating the data of the Configuration File
        cfgObj.configure("hibernate.cfg.xml");       
 
        // Creating Session Factory Object  
        SessionFactory factoryObj = cfgObj.buildSessionFactory();  
 
        // Creating Session Object  
        Session sessionObj = factoryObj.openSession();  
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();  
 
        Usuario usuario = new Usuario();  
        usuario.setCorreo("correo@prueba.es");
        usuario.setClave("1234");
        usuario.setNombre("Prueba");
        usuario.setModerador(true);
        usuario.setHabilitado(true); 
         
        // Persisting The Object  
        sessionObj.persist(usuario); 
         
        // Transaction Is Committed To Database
        transObj.commit();  
        sessionObj.close();  
        
        for (int i = 1; i < 4; i++) {
        	try {
    			Usuario userP = UsuarioDao.getInstance().conseguirUsuario(i);
    			System.out.println(userP.getCorreo());
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        
        List<Usuario> listUsuarios;
		try {
			listUsuarios = UsuarioDao.getInstance().conseguirUsuarios();
		} catch (Exception e) {
			listUsuarios = new ArrayList <> ();
			e.getStackTrace();
			System.out.println("ERROR RECUPERANDO USUARIOS.");
		}
        
        for (Usuario user : listUsuarios) {
        	System.out.println(user.getCorreo());
        }
 
        
//      // Creating Session Factory Object  
//      SessionFactory factoryObj = cfgObj.buildSessionFactory();  
//
//      // Creating Session Object  
//      Session sessionObj = factoryObj.openSession();  
//
//      //Creating Transaction Object  
//      Transaction transObj = sessionObj.beginTransaction();  

      Planta planta = new Planta(); 
      planta.setNombre("Arbol del Cielo");
      planta.setDescripcion("Ailanthus altissima");
      planta.setPais("España");
      planta.setPais_siglas("ES");
       
      // Persisting The Object  
      sessionObj.persist(planta); 
       
      
      
      
      Incidencia incidencia = new Incidencia();
      
      
   // Transaction Is Committed To Database
      transObj.commit();  
      sessionObj.close();  
        
        
      System.out.println("Employee Data Successfully Saved In Database!"); 
    }
}