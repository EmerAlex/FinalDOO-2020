package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la información de
 * una asignatura para un programa determinado.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:30 p. m.
 */
public class AsignaturaProgramaDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el código de una asignatura por programa.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser único.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa la asignatura asociada a un programa.</li>
	 * <li>Es un dato de tipo Asignatura.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Asignatura.</li>
	 * <li>No es posible registrar más de una vez la misma asignatura en el mismo
	 * programa.</li>
	 * </ul>
	 */
	private AsignaturaDTO asignatura;
	/**
	 * <ul>
	 * <li>Propiedad que representa el programa que pertenece a una asignatura.</li>
	 * <li>Es un dato de tipo ProgramaInstitucion.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto ProgramaInstitucion.</li>
	 * <li>No es posible registrar más de una vez la misma asignatura en el mismo
	 * programa.</li>
	 * </ul>
	 */
	private ProgramaInstitucionDTO programa;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public AsignaturaDTO getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(AsignaturaDTO asignatura) {
		this.asignatura = asignatura;
	}

	public ProgramaInstitucionDTO getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramaInstitucionDTO programa) {
		this.programa = programa;
	}

}