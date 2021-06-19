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
import es.uah.invaZoras.srv.PlantasSrv;
 
public class RecoverData {
 
    public static void main(String[] args) throws IOException { 
        
//        List<Usuario> listUsuarios;
//		try {
//			listUsuarios = UsuarioSrvImpl.getInstance().conseguirUsuarios();
//		} catch (Exception e) {
//			listUsuarios = new ArrayList <> ();
//			e.getStackTrace();
//			System.out.println("ERROR RECUPERANDO USUARIOS.");
//		}
//		
//        for (Usuario user : listUsuarios) {
//        	System.out.println(user.getCorreo());
//        }
        
//		try {
//			Usuario usuario = UsuarioDao.getInstance().conseguirUsuario("manuelchamserr@gmail.com");
//			System.out.println(usuario.toString());
//		} catch (Exception e) {
//			e.getStackTrace();
//			System.out.println("ERROR RECUPERANDO USUARIO.");
//		}
		
//		
//		try {
//			Usuario usuario = UsuarioSrvImpl.getInstance().conseguirUsuario(1);
//			System.out.println(usuario.toString());
//		} catch (Exception e1) {
//			System.out.println(e1.getMessage());
//		}
 
//        List<Planta> listPlantas;
//		try {
//			listPlantas = PlantasSrvImpl.getInstance().conseguirListaPlantas();
//		} catch (Exception e) {
//			listPlantas = new ArrayList <> ();
//			e.getStackTrace();
//			System.out.println("ERROR RECUPERANDO PLANTAS.");
//		}
//        
//        for (Planta planta : listPlantas) {
//        	System.out.println(planta.getNombre());
//        }
    	
		try {
			Planta planta = PlantasSrv.getInstance().conseguirPlanta(2);
			System.out.println(planta.toString());
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("ERROR RECUPERANDO PLANTA." +  e.getMessage());
		}
        
//        File imgF = new File ("src/main/resources/img/arbolDelCielo2.jpg");
//        Incidencia inci = new Incidencia ();
//        
//        inci.setFk_usuario(listUsuarios.get(0).getId_usuario());
//        inci.setFk_planta(listPlantas.get(0).getId_planta());
//        inci.setLatitud(new BigDecimal (40.4829));
//        inci.setLongitud(new BigDecimal (-3.3629));
//        inci.setAdmitida(true);
//        inci.setValor_invasion((short) 1);
//        byte [] imagen = "adawdadadaw".getBytes();
////        inci.setImagen(imagen );
//        inci.setImagen(Base64.getEncoder().encode(FileUtils.readFileToByteArray(imgF)));
//        Date now = new java.util.Date();
//        inci.setFecha(new Timestamp(now.getTime()));
//
//        IncidenciaSrvImpl.getInstance().insertarIncidencia(inci);
        
        
      System.out.println("Employee Data Successfully Saved In Database!"); 
    }
}