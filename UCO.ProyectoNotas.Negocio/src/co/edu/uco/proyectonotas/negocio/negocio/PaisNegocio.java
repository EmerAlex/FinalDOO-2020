package co.edu.uco.proyectonotas.negocio.negocio;

import java.util.List;

import co.edu.uco.proyectonotas.dto.PaisDTO;

public interface PaisNegocio {

	void registrar(PaisDTO paisDto);

	void modificar(PaisDTO paisDto);

	void eliminar(PaisDTO paisDto);

	List<PaisDTO> consultar(PaisDTO paisDto);
}
