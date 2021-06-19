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
import es.uah.invaZoras.hibernate.pojo.Planta;
import es.uah.invaZoras.hibernate.pojo.Usuario;
import es.uah.invaZoras.srv.PlantasSrv;
import es.uah.invaZoras.srv.UsuarioSrv;

@RestController
public class PlantaServiceController {
	
	
	 @RequestMapping(value = "/planta/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") int id) { 
		   PlantasSrv.getInstance().eliminarPlanta(id);
	       return new ResponseEntity<>("Planta satisfactoriamente eliminada.", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/planta/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Planta planta) { 
		   PlantasSrv.getInstance().actualizarPlanta(planta);
		   return new ResponseEntity<>("Planta satisfactoriamente actualizada.", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/planta", method = RequestMethod.POST)
	   public ResponseEntity<Object> crearUsuario(@RequestBody Planta usuario) {
		   PlantasSrv.getInstance().insertarPlanta(usuario);
	      return new ResponseEntity<>("Planta satisfactoriamente creada.", HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/planta")
	   public ResponseEntity<Object> recuperarUsuarios() {
	      try {
			return new ResponseEntity<>(PlantasSrv.getInstance().conseguirListaPlantas(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ERROR RECUPERANDO LAS PLANTAS: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	   }
	   
	   @RequestMapping(value = "/planta/{id}")
	   public ResponseEntity<Object> recuperarUsuario(@PathVariable int id) {
		   
		    Planta planta;
			try {
				planta = PlantasSrv.getInstance().conseguirPlanta(id);
			} catch (Exception e) {
				return new ResponseEntity<>("ERROR RECUPERANDO LA PLANTA: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		
			return new ResponseEntity<>(planta != null ? planta : "No se ha encontrado ningun planta con esa id.", HttpStatus.OK);
	      
	   }

}
