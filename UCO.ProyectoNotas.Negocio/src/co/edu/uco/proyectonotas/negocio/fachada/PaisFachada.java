package co.edu.uco.proyectonotas.negocio.fachada;

import java.util.List;

import co.edu.uco.proyectonotas.dto.PaisDTO;

public interface PaisFachada {

	void registrar(PaisDTO paisDto);

	void modificar(PaisDTO paisDto);

	void eliminar(PaisDTO paisDto);

	List<PaisDTO> consultar(PaisDTO paisDto);

}
