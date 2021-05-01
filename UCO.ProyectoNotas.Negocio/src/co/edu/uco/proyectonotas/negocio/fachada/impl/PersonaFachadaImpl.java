package co.edu.uco.proyectonotas.negocio.fachada.impl;

import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.factoria.DAOFactory;
import co.edu.uco.proyectonotas.datos.dao.factoria.enumeracion.FactoriaEnum;
import co.edu.uco.proyectonotas.dto.PersonaDTO;
import co.edu.uco.proyectonotas.negocio.fachada.PersonaFachada;
import co.edu.uco.proyectonotas.negocio.negocio.PersonaNegocio;
import co.edu.uco.proyectonotas.negocio.negocio.impl.PersonaNegocioImpl;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

public class PersonaFachadaImpl implements PersonaFachada {
	@Override
	public void registrar(PersonaDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);
		try {
			factoriaDao.iniciarTransaccion();
			PersonaNegocio personaNegocio = new PersonaNegocioImpl(factoriaDao);
//			paisDto.setCodigo(98282);
//			System.out.println(paisDto.getCodigo());
			personaNegocio.registrar(personaDto);
			factoriaDao.confirmarTransaccion();
		} catch (NotasExcepcion excepcion) {
			factoriaDao.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			factoriaDao.cancelarTransaccion();
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CREANDO_PAIS));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}

	@Override
	public void modificar(PersonaDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			factoriaDao.iniciarTransaccion();
			PersonaNegocio personaNegocio = new PersonaNegocioImpl(factoriaDao);
			personaNegocio.modificar(personaDto);
			factoriaDao.confirmarTransaccion();
		} catch (NotasExcepcion excepcion) {
			factoriaDao.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			factoriaDao.cancelarTransaccion();
			throw NotasExcepcion.crear(excepcion,
					MensajesEstrategia.obtener(CodigosMensajes.ERROR_MODIFICANDO_PERSONA));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}

	@Override
	public void eliminar(PersonaDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			factoriaDao.iniciarTransaccion();
			PersonaNegocio personaNegocio = new PersonaNegocioImpl(factoriaDao);
			personaNegocio.eliminar(personaDto);
			factoriaDao.confirmarTransaccion();
		} catch (NotasExcepcion excepcion) {
			factoriaDao.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			factoriaDao.cancelarTransaccion();
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_ELIMINANDO_PAIS));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}

	@Override
	public List<PersonaDTO> consultar(PersonaDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);
		System.out.println("entro a persona fachada con:");

		try {
			PersonaNegocio personaNegocio = new PersonaNegocioImpl(factoriaDao);
			return personaNegocio.consultar(personaDto);
		} catch (NotasExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONSULTANDO_PAISES));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}
	
	public List<PersonaDTO> consultarPorCodigo(PersonaDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			PersonaNegocio personaNegocio = new PersonaNegocioImpl(factoriaDao);
			return personaNegocio.consultar(personaDto);
		} catch (NotasExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONSULTANDO_PAISES));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}


}
