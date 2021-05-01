package co.edu.uco.proyectonotas.negocio.fachada;

import java.util.List;

import co.edu.uco.proyectonotas.dto.PersonaDTO;

public interface PersonaFachada {
	void registrar(PersonaDTO personaDto);

	void modificar(PersonaDTO personaDto);

	void eliminar(PersonaDTO personaDto);

	List<PersonaDTO> consultar(PersonaDTO personaDto);

}
