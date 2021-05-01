package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la información de un
 * tipo de programa.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:31 p. m.
 */
public class ProgramaDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el código de un programa.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser único.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nombre de un programa.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>Sólo permite letras y espacios.</li>
	 * <li>Su longitud máxima es de 100 caracteres.</li>
	 * <li>El nombre de un programa no se puede repetir para una institución
	 * determinada.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String nombre;
	/**
	 * <ul>
	 * <li>Propiedad que representa el tipo de programa de un programa.</li>
	 * <li>Es un dato de tipo TipoPrograma.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto TipoPrograma.</li>
	 * </ul>
	 */
	private TipoProgramaDTO tipoPrograma;
	/**
	 * <ul>
	 * <li>Propiedad que representa el tipo de formación de un programa.</li>
	 * <li>Es un dato de tipo TipoFormacion.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto TipoFormacion.</li>
	 * </ul>
	 */
	private TipoFormacionDTO tipoFormacion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoProgramaDTO getTipoPrograma() {
		return tipoPrograma;
	}

	public void setTipoPrograma(TipoProgramaDTO tipoPrograma) {
		this.tipoPrograma = tipoPrograma;
	}

	public TipoFormacionDTO getTipoFormacion() {
		return tipoFormacion;
	}

	public void setTipoFormacion(TipoFormacionDTO tipoFormacion) {
		this.tipoFormacion = tipoFormacion;
	}
}