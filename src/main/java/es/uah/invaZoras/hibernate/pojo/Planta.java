package es.uah.invaZoras.hibernate.pojo;

public class Planta {

	private int id_planta;
	private String nombre;
	private String descripcion;
	private String pais_siglas;
	private String pais;
	
	public int getId_planta() {
		return id_planta;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getPais_siglas() {
		return pais_siglas;
	}
	
	public String getPais() {
		return pais;
	}

	public void setId_planta(int id_planta) {
		this.id_planta = id_planta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPais_siglas(String pais_siglas) {
		this.pais_siglas = pais_siglas;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Planta [id_planta=" + id_planta + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", pais_siglas=" + pais_siglas + ", pais=" + pais + "]";
	}
	
}
