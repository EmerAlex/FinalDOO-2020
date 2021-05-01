package co.edu.uco.proyectonotas.dto;

import java.util.Date;

/**
 * Clase que representa a un objeto de dominio que contiene la información de un
 * grupo para asignatura determinada.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:31 p. m.
 */
public class SesionDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el código de una sesión.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser único.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el día en el que se dictará la sesión.</li>
	 * <li>Es un dato de tipo Dia.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Dia.</li>
	 * </ul>
	 */
	private DiaDTO dia;
	/**
	 * <ul>
	 * <li>Propiedad que representa la hora de inicio de una sesión.</li>
	 * <li>Es un dato de tipo Date.</li>
	 * <li>Es un dato que debe ser menor a la hora de fin.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private Date horaInicio;
	/**
	 * <ul>
	 * <li>Propiedad que representa la hora de fin de una sesión.</li>
	 * <li>Es un dato de tipo Date.</li>
	 * <li>Es un dato que debe ser mayor a la hora de inicio.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private Date horaFin;
	/**
	 * <ul>
	 * <li>Propiedad que representa el grupo al que se ha configurado la sesión.
	 * </li>
	 * <li>Es un dato de tipo Grupo.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Grupo.</li>
	 * <li>No es posible configurar más de una sesión para el mismo grupo el mismo
	 * día que se cruce con las fechas de inicio y hora de fin.</li>
	 * </ul>
	 */
	private GrupoDTO grupo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public DiaDTO getDia() {
		return dia;
	}

	public void setDia(DiaDTO dia) {
		this.dia = dia;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public GrupoDTO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDTO grupo) {
		this.grupo = grupo;
	}

}