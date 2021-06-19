package es.uah.invaZoras.zzpruebas;
 
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.uah.invaZoras.hibernate.dao.IncidenciaDao;
import es.uah.invaZoras.hibernate.dao.PlantasDao;
import es.uah.invaZoras.hibernate.dao.UsuarioDao;
import es.uah.invaZoras.hibernate.pojo.Incidencia;
import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;
 
public class StoreData2 {
 
    public static void main(String[] args) throws IOException {
        
//    	// Creating Hibernate Configuration Object 
//        Configuration cfgObj = new Configuration();
//        // Populating the data of the Configuration File
//        cfgObj.configure("hibernate.cfg.xml");  
        
        Usuario usuario = new Usuario();  
        usuario.setCorreo("correo1@prueba.es");
        usuario.setClave("1234");
        usuario.setNombre("Prueba5");
        usuario.setModerador(true);
        usuario.setHabilitado(true); 
        
        UsuarioDao.getInstance().insertarUsuario(usuario);
        
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
 
        List<Planta> listPlantas;
		try {
			listPlantas = PlantasDao.getInstance().conseguirListaPlantas();
		} catch (Exception e) {
			listPlantas = new ArrayList <> ();
			e.getStackTrace();
			System.out.println("ERROR RECUPERANDO PLANTAS.");
		}
        
        for (Planta planta : listPlantas) {
        	System.out.println(planta.getNombre());
        }
        
        File imgF = new File ("src/main/resources/img/arbolDelCielo2.jpg");
        Incidencia inci = new Incidencia ();
        
        inci.setFk_usuario(listUsuarios.get(0).getId_usuario());
        inci.setFk_planta(listPlantas.get(0).getId_planta());
        inci.setLatitud(new BigDecimal (40.4829));
        inci.setLongitud(new BigDecimal (-3.3629));
        inci.setAdmitida(true);
        inci.setValor_invasion((short) 1);
        byte [] imagen = "adawdadadaw".getBytes();
//        inci.setImagen(imagen );
        inci.setImagen(Base64.getEncoder().encode(FileUtils.readFileToByteArray(imgF)));
        Date now = new java.util.Date();
        inci.setFecha(new Timestamp(now.getTime()));

        IncidenciaDao.getInstance().insertarIncidencia(inci);
        
        
      System.out.println("Employee Data Successfully Saved In Database!"); 
    }
}