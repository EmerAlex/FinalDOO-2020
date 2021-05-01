package co.edu.uco.proyectonotas.dto;

import java.util.Date;

/**
 * Clase que representa a un objeto de dominio que contiene la información de un
 * estudiante.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:30 p. m.
 */
public class EstudianteDTO extends PersonaDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el estado civil de un estudiante.</li>
	 * <li>Es un dato de tipo EstadoCivil.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto EstadoCivil.</li>
	 * </ul>
	 */
	private EstadoCivilDTO estadoCivil;
	/**
	 * <ul>
	 * <li>Propiedad que representa la ciudad de residencia de un estudiante.</li>
	 * <li>Es un dato de tipo Ciudad.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Ciudad.</li>
	 * </ul>
	 */
	private CiudadDTO ciudadResidencia;
	/**
	 * <ul>
	 * <li>Propiedad que representa la fecha de nacimiento de un estudiante.</li>
	 * <li>Es un dato de tipo Date.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private Date fechaNacimiento;
	/**
	 * <ul>
	 * <li>Propiedad que representa la dirección de residencia de un estudiante.
	 * </li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>Permite cualquier caracter.</li>
	 * <li>Su longitud máxima es de 250 caracteres.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String direccionResidencia;

	public EstadoCivilDTO getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilDTO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public CiudadDTO getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(CiudadDTO ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

}