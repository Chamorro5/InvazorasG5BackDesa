package es.uah.invaZoras.hibernate.pojo;

public class Usuario {
	private int id_usuario;
	private String nombre;
	private String correo;
	private String clave;
	private boolean habilitado;
	private boolean moderador;
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public String getClave() {
		return clave;
	}
	
	public boolean isHabilitado() {
		return habilitado;
	}
	
	public boolean isModerador() {
		return moderador;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public void setModerador(boolean moderador) {
		this.moderador = moderador;
	}

	@Override
	public String toString() {
		return "Usuario {id_usuario=" + id_usuario + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave
				+ ", habilitado=" + habilitado + ", moderador=" + moderador + "}";
	}
	
	
	
}
