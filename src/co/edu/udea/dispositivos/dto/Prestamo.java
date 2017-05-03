package co.edu.udea.dispositivos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Especifica el DTO Prestamo con sus setters y getters
 * @author lenovo
 *
 */
public class Prestamo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String investigador;
	private String dispositivo;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;//{Sin Procesar, Aprobado, Rechazado, Finalizado}
	/**
	 * @return la id del Prestamo
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id la id que diferencia un préstamo de otro
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return la id del investigador
	 */
	public String getInvestigador() {
		return investigador;
	}
	/**
	 * @param investigador la id del investigador
	 */
	public void setInvestigador(String investigador) {
		this.investigador = investigador;
	}
	/**
	 * @return la id del dispositivo en préstamo
	 */
	public String getDispositivo() {
		return dispositivo;
	}
	/**
	 * @param dispositivo la id dispositivo a prestar 
	 */
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	/**
	 * @return la fecha de inicio del préstamo
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio la fecha de inicio en la cual se desea prestar un dispositivo
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return la fecha de finalización del préstamo
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin la fecha en la cual finaliza el préstamo
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return el estado del préstamo
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado el estado en el cual se encuentra el préstamo
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}

