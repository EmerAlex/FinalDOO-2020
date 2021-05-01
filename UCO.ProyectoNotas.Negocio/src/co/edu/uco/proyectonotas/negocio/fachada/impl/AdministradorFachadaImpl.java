package co.edu.uco.proyectonotas.negocio.fachada.impl;

import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.factoria.DAOFactory;
import co.edu.uco.proyectonotas.datos.dao.factoria.enumeracion.FactoriaEnum;
import co.edu.uco.proyectonotas.dto.AdministradorDTO;
import co.edu.uco.proyectonotas.negocio.fachada.AdministradorFachada;
import co.edu.uco.proyectonotas.negocio.negocio.AdministradorNegocio;
import co.edu.uco.proyectonotas.negocio.negocio.impl.AdministradorNegocioImpl;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

public class AdministradorFachadaImpl implements AdministradorFachada{
	@Override
	public void registrar(AdministradorDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);
		try {
			factoriaDao.iniciarTransaccion();
			AdministradorNegocio personaNegocio = new AdministradorNegocioImpl(factoriaDao);
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
	public void modificar(AdministradorDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			factoriaDao.iniciarTransaccion();
			AdministradorNegocio personaNegocio = new AdministradorNegocioImpl(factoriaDao);
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
	public void eliminar(AdministradorDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			factoriaDao.iniciarTransaccion();
			AdministradorNegocio personaNegocio = new AdministradorNegocioImpl(factoriaDao);
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
	public List<AdministradorDTO> consultar(AdministradorDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			AdministradorNegocio personaNegocio = new AdministradorNegocioImpl(factoriaDao);
			return personaNegocio.consultar(personaDto);
		} catch (NotasExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONSULTANDO_PAISES));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}
	
	public List<AdministradorDTO> consultarPorCodigo(AdministradorDTO personaDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			AdministradorNegocio personaNegocio = new AdministradorNegocioImpl(factoriaDao);
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
