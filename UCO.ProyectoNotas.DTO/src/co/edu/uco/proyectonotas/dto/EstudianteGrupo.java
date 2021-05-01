package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la información de
 * una asignatura para un programa determinado.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:30 p. m.
 */
public class EstudianteGrupo {

	/**
	 * <ul>
	 * <li>Propiedad que representa el código de un estudiante por grupo.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser único.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el estudiante matriculado en un grupo.</li>
	 * <li>Es un dato de tipo Estudiante.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Estudiante.</li>
	 * <li>No es posible matricular más de una vez el mismo estudiante en el mismo
	 * grupo.</li>
	 * </ul>
	 */
	private EstudianteDTO estudiante;
	/**
	 * <ul>
	 * <li>Propiedad que representa el grupo al que se ha matriculado un estudiante.
	 * </li>
	 * <li>Es un dato de tipo Grupo.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Grupo.</li>
	 * <li>No es posible matricular más de una vez el mismo estudiante en el mismo
	 * grupo.</li>
	 * </ul>
	 */
	private GrupoDTO grupo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public EstudianteDTO getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteDTO estudiante) {
		this.estudiante = estudiante;
	}

	public GrupoDTO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDTO grupo) {
		this.grupo = grupo;
	}

}