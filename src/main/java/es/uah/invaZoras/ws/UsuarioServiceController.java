package es.uah.invaZoras.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uah.invaZoras.hibernate.dao.UsuarioDao;
import es.uah.invaZoras.hibernate.pojo.Usuario;
import es.uah.invaZoras.srv.UsuarioSrv;

@RestController
public class UsuarioServiceController {
	
	
	 @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> eliminarUsuario(@PathVariable("id") int id) { 
	      UsuarioSrv.getInstance().eliminarUsuario(id);
	      return new ResponseEntity<>("Usuario satisfactoriamente eliminado.", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> actualizarUsuario(@PathVariable("id") String id, @RequestBody Usuario usuario) { 
	      UsuarioSrv.getInstance().actualizarUsuario(usuario);
	      return new ResponseEntity<>("Usuario satisfactoriamente actualizado.", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/usuario", method = RequestMethod.POST)
	   public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {
		   UsuarioSrv.getInstance().insertarUsuario(usuario);
	      return new ResponseEntity<>("Usuario satisfactoriamente creado.", HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/usuario")
	   public ResponseEntity<Object> recuperarUsuarios() {
	      try {
			return new ResponseEntity<>(UsuarioSrv.getInstance().conseguirUsuarios(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ERROR RECUPERANDO LOS USUARIOS: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	   }
	   
	   @RequestMapping(value = "/usuario/{id}")
	   public ResponseEntity<Object> recuperarUsuario(@PathVariable int id) {
		   
		Usuario usuario;
		try {
			usuario = UsuarioSrv.getInstance().conseguirUsuario(id);
		} catch (Exception e) {
			return new ResponseEntity<>("ERROR RECUPERANDO EL USUARIO: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(usuario != null ? usuario : "No se ha encontrado ningun usuario con esa id.", HttpStatus.OK);
	      
	   }

}
