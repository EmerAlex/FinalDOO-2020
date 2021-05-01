package co.edu.uco.proyectonotas.dto;

import java.util.Date;

/**
 * Clase que representa a un objeto de dominio que contiene la información de un
 * grupo para asignatura determinada.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:30 p. m.
 */
public class GrupoDTO {

	private int codigo;

	/**
	 * <ul>
	 * <li>Propiedad que representa la cantidad máxima de personas que puede tener
	 * un grupo.</li>
	 * <li>Es un dato de tipo Entero.</li>
	 * <li>Es un dato que debe ser mayor a cero.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int cantidad;
	/**
	 * <ul>
	 * <li>Propiedad que representa la asignatura que será entregada en el grupo.
	 * </li>
	 * <li>Es un dato de tipo AsignaturaPrograma.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto AsignaturaPrograma.</li>
	 * </ul>
	 */
	private AsignaturaProgramaDTO asignatura;
	/**
	 * <ul>
	 * <li>Propiedad que representa la sede en la cual se dictará un curso.</li>
	 * <li>Es un dato de tipo Sede.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Sede.</li>
	 * </ul>
	 */
	private SedeDTO sede;
	/**
	 * <ul>
	 * <li>Propiedad que representa la fecha de inicio de un grupo.</li>
	 * <li>Es un dato de tipo Date.</li>
	 * <li>Es un dato que debe ser menor o igual a la fecha de fin.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private Date fechaInicio;
	/**
	 * <ul>
	 * <li>Propiedad que representa la fecha de fin de un grupo.</li>
	 * <li>Es un dato de tipo Date.</li>
	 * <li>Es un dato que debe ser mayor o igual a la fecha de inicio.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private Date fechaFin;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public AsignaturaProgramaDTO getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(AsignaturaProgramaDTO asignatura) {
		this.asignatura = asignatura;
	}

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(SedeDTO sede) {
		this.sede = sede;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}