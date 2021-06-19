package es.uah.invaZoras.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uah.invaZoras.hibernate.dao.PlantasDao;
import es.uah.invaZoras.hibernate.dao.UsuarioDao;
import es.uah.invaZoras.hibernate.pojo.Incidencia;
import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;
import es.uah.invaZoras.srv.IncidenciaSrv;
import es.uah.invaZoras.srv.PlantasSrv;
import es.uah.invaZoras.srv.UsuarioSrv;

@RestController
public class IncidenciaServiceController {
	
	
	 @RequestMapping(value = "/incidencia/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> eliminarIncidencia(@PathVariable("id") int id) { 
		   IncidenciaSrv.getInstance().eliminarIncidencia(id);
	       return new ResponseEntity<>("Incidencia satisfactoriamente eliminada.", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/incidencia/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> actualizarIncidencia(@PathVariable("id") String id, @RequestBody Incidencia incidencia) { 
		   IncidenciaSrv.getInstance().actualizarIncidencia(incidencia);
		   return new ResponseEntity<>("Incidencia satisfactoriamente actualizada.", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/incidencia", method = RequestMethod.POST)
	   public ResponseEntity<Object> crearIncidencia(@RequestBody Incidencia incidencia) {
		   IncidenciaSrv.getInstance().insertarIncidencia(incidencia);
	      return new ResponseEntity<>("Incidencia satisfactoriamente creada.", HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/incidencia")
	   public ResponseEntity<Object> recuperarIncidencias() {
	      try {
			return new ResponseEntity<>(IncidenciaSrv.getInstance().conseguirIncidencias(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ERROR RECUPERANDO LAS INCIDENCIAS: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	   }
	   
	   @RequestMapping(value = "/incidencia/{id}")
	   public ResponseEntity<Object> recuperaIncidencia(@PathVariable int id) {
		   
		    Incidencia incidencia;
			try {
				incidencia = IncidenciaSrv.getInstance().conseguirIncidencia(id);
			} catch (Exception e) {
				return new ResponseEntity<>("ERROR RECUPERANDO LA INCIDENCIA: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		
			return new ResponseEntity<>(incidencia != null ? incidencia : "No se ha encontrado ninguna incidencia con esa id.", HttpStatus.OK);
	      
	   }

}
