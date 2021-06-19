package es.uah.invaZoras.hibernate.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Incidencia {
	
	private int id_incidencia;
	private Timestamp fecha;
	private int fk_planta;
	private short valor_invasion;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private byte[] imagen;
	private int fk_usuario;
	private boolean admitida;
	
	public int getId_incidencia() {
		return id_incidencia;
	}
	
	public Timestamp getFecha() {
		return fecha;
	}
	
	public int getFk_planta() {
		return fk_planta;
	}
	
//	public Planta getFk_planta() {
//		return fk_planta;
//	}
	
	public short getValor_invasion() {
		return valor_invasion;
	}
	
	public BigDecimal getLatitud() {
		return latitud;
	}
	
	public BigDecimal getLongitud() {
		return longitud;
	}
	
	public byte[] getImagen() {
		return imagen;
	}
	
	public int getFk_usuario() {
		return fk_usuario;
	}
	
//	public Usuario getFk_usuario() {
//		return fk_usuario;
//	}
//	
	public boolean isAdmitida() {
		return admitida;
	}

	public void setId_incidencia(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public void setFk_planta(int fk_planta) {
		this.fk_planta = fk_planta;
	}

	public void setValor_invasion(short valor_invasion) {
		this.valor_invasion = valor_invasion;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	public void setAdmitida(boolean admitida) {
		this.admitida = admitida;
	}
	
}
