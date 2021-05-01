package co.edu.uco.proyectonotas.negocio.negocio;

import java.util.List;

import co.edu.uco.proyectonotas.dto.PersonaDTO;

public interface PersonaNegocio {
	void registrar(PersonaDTO personaDto);

	void modificar(PersonaDTO personaDto);

	void eliminar(PersonaDTO personaDto);

	List<PersonaDTO> consultar(PersonaDTO personaDto);

}
