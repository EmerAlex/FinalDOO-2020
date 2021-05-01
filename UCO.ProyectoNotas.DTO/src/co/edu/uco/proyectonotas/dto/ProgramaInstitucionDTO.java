package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la informaci�n de un
 * programa para una instituci�n determinada.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:31 p. m.
 */
public class ProgramaInstitucionDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el c�digo de un programa para una instituci�n.
	 * </li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser �nico.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa la instituci�n a la que pertenece el programa.
	 * </li>
	 * <li>Es un dato de tipo Institucion.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Institucion.</li>
	 * <li>No es posible registrar m�s de una vez el mismo programa para la misma
	 * instituci�n.</li>
	 * </ul>
	 */
	private InstitucionDTO institucion;
	/**
	 * <ul>
	 * <li>Propiedad que representa el programa asociado a la instituci�n.</li>
	 * <li>Es un dato de tipo Programa.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Programa.</li>
	 * <li>No es posible registrar m�s de una vez el mismo programa para la misma
	 * instituci�n.</li>
	 * </ul>
	 */
	private ProgramaDTO programa;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public InstitucionDTO getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDTO institucion) {
		this.institucion = institucion;
	}

	public ProgramaDTO getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramaDTO programa) {
		this.programa = programa;
	}

}