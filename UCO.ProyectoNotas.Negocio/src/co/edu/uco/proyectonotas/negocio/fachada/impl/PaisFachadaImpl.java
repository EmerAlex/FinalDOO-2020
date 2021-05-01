package co.edu.uco.proyectonotas.negocio.fachada.impl;

import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.factoria.DAOFactory;
import co.edu.uco.proyectonotas.datos.dao.factoria.enumeracion.FactoriaEnum;
import co.edu.uco.proyectonotas.dto.PaisDTO;
import co.edu.uco.proyectonotas.negocio.fachada.PaisFachada;
import co.edu.uco.proyectonotas.negocio.negocio.PaisNegocio;
import co.edu.uco.proyectonotas.negocio.negocio.impl.PaisNegocioImpl;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

class PaisFachadaImpl implements PaisFachada {

	@Override
	public void registrar(PaisDTO paisDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			factoriaDao.iniciarTransaccion();
			PaisNegocio paisNegocio = new PaisNegocioImpl(factoriaDao);

			paisNegocio.registrar(paisDto);
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
	public void modificar(PaisDTO paisDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			factoriaDao.iniciarTransaccion();
			PaisNegocio paisNegocio = new PaisNegocioImpl(factoriaDao);
			paisNegocio.modificar(paisDto);
			factoriaDao.confirmarTransaccion();
		} catch (NotasExcepcion excepcion) {
			factoriaDao.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			factoriaDao.cancelarTransaccion();
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_MODIFICANDO_PAIS));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}

	@Override
	public void eliminar(PaisDTO paisDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			factoriaDao.iniciarTransaccion();
			PaisNegocio paisNegocio = new PaisNegocioImpl(factoriaDao);
			paisNegocio.eliminar(paisDto);
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
	public List<PaisDTO> consultar(PaisDTO paisDto) {
		DAOFactory factoriaDao = DAOFactory.obtener(FactoriaEnum.SQLSERVER);

		try {
			PaisNegocio paisNegocio = new PaisNegocioImpl(factoriaDao);
			return paisNegocio.consultar(paisDto);
		} catch (NotasExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONSULTANDO_PAISES));
		} finally {
			factoriaDao.cerrarConexion();
		}
	}
}
