package co.edu.uco.proyectonotas.negocio.negocio.impl;

import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.objetoEsNulo;

import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.factoria.DAOFactory;
import co.edu.uco.proyectonotas.dto.AdministradorDTO;
import co.edu.uco.proyectonotas.negocio.negocio.AdministradorNegocio;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

public class AdministradorNegocioImpl implements AdministradorNegocio {
	
	private DAOFactory factoriaDao;

	public AdministradorNegocioImpl(DAOFactory factoria) {

		if (objetoEsNulo(factoria)) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_DAO_FACTORY_NULO));
		}

		factoriaDao = factoria;
	}

	@Override
	public void registrar(AdministradorDTO personaDto) {

		System.out.println("Entro al registrar de adminnegocioimpl");

		factoriaDao.obtenerAdministradorDAO().crear(personaDto);
	}

	@Override
	public void modificar(AdministradorDTO personaDto) {
		System.out.println("Entró");

		factoriaDao.obtenerAdministradorDAO().actualizar(personaDto);

		if (personaDto.getCodigo()>0) {
		} else {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_PERSONA_NOMBRE_YA_EXISTE_MODIFICAR));
		}
	}

	@Override
	public void eliminar(AdministradorDTO personaDto) {
		factoriaDao.obtenerAdministradorDAO().eliminar(personaDto);
	}

//	private List<PersonaDTO> consultarPersonaPorCodigo(PersonaDTO persona) {
//		PersonaDTO personaConsulta = new PersonaDTO();
//		personaConsulta.setCodigo(persona.getCodigo());
//
//		return consultar(personaConsulta);
//	}
//
//	private List<PersonaDTO> consultarPersonaPorNombre(PersonaDTO persona) {
//		PersonaDTO personaConsulta = new PersonaDTO();
//		personaConsulta.setNombre(persona.getNombre());
//		personaConsulta.setApellido(persona.getApellido());
//		personaConsulta.setEstado(persona.getEstado());
//		personaConsulta.setNombreUsuario(persona.getNombreUsuario());
//		personaConsulta.setContraseña(persona.getContraseña());
//
//
//		return consultar(personaConsulta);
//	}

	@Override
	public List<AdministradorDTO> consultar(AdministradorDTO personaDto) {
		return factoriaDao.obtenerAdministradorDAO().consultar(personaDto);
	}

}
