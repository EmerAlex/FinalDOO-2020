package co.edu.uco.proyectonotas.negocio.negocio.impl;

import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.objetoEsNulo;

import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.factoria.DAOFactory;
import co.edu.uco.proyectonotas.dto.DepartamentoDTO;
import co.edu.uco.proyectonotas.dto.PaisDTO;
import co.edu.uco.proyectonotas.negocio.negocio.PaisNegocio;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

public class PaisNegocioImpl implements PaisNegocio {

	private DAOFactory factoriaDao;

	public PaisNegocioImpl(DAOFactory factoria) {

		if (objetoEsNulo(factoria)) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_DAO_FACTORY_NULO));
		}

		factoriaDao = factoria;
	}

	@Override
	public void registrar(PaisDTO paisDto) {

		if (objetoEsNulo(paisDto)) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_PAIS_NULO_AL_REGISTRAR));
		}

		// 1. Validar que el país no exista
		List<PaisDTO> resultados = consultarPaisPorNombre(paisDto);

		if (!resultados.isEmpty()) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_REGISTRO_PAIS_YA_EXISTE));
		}

		factoriaDao.obtenerPaisDAO().crear(paisDto);
	}

	@Override
	public void modificar(PaisDTO paisDto) {

		if (objetoEsNulo(paisDto)) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_PAIS_NULO_AL_MODIFICAR));
		}

		// 1. Consultar que existe el país a modificar
		List<PaisDTO> resultados = consultarPaisPorCodigo(paisDto);

		if (resultados.isEmpty()) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_PAIS_NO_EXISTE_AL_MODIFICAR));
		}

		// 2. Consultar que el nombre del país a modificar ya no exista
		resultados = consultarPaisPorNombre(paisDto);

		if (resultados.isEmpty() || resultados.get(0).getCodigo() == paisDto.getCodigo()) {
			factoriaDao.obtenerPaisDAO().actualizar(paisDto);
		} else {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_PAIS_NOMBRE_YA_EXISTE_MODIFICAR));
		}
	}

	@Override
	public void eliminar(PaisDTO paisDto) {

		if (objetoEsNulo(paisDto)) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_PAIS_NULO_AL_MODIFICAR));
		}

		// 1. Consultar que existe el país a eliminar
		List<PaisDTO> resultados = consultarPaisPorCodigo(paisDto);

		if (resultados.isEmpty()) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_PAIS_NO_EXISTE_AL_ELIMINAR));
		}

		// 2. Consultar si el país tiene departamentos asociados
		DepartamentoDTO departamentoConsulta = new DepartamentoDTO();
		departamentoConsulta.setPais(paisDto);

		List<DepartamentoDTO> departamentos = factoriaDao.obtenerDepartamentoDAO().consultar(departamentoConsulta);

		if (!departamentos.isEmpty()) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_AL_ELIMINAR_PAIS_CON_DEPARTAMENTOS_ASOCIADOS));
		}

		factoriaDao.obtenerPaisDAO().eliminar(paisDto);
	}

	private List<PaisDTO> consultarPaisPorCodigo(PaisDTO pais) {
		PaisDTO paisConsulta = new PaisDTO();
		paisConsulta.setCodigo(pais.getCodigo());

		return consultar(paisConsulta);
	}

	private List<PaisDTO> consultarPaisPorNombre(PaisDTO pais) {
		PaisDTO paisConsulta = new PaisDTO();
		paisConsulta.setNombre(pais.getNombre());

		return consultar(paisConsulta);
	}

	@Override
	public List<PaisDTO> consultar(PaisDTO paisDto) {
		return factoriaDao.obtenerPaisDAO().consultar(paisDto);
	}

}
