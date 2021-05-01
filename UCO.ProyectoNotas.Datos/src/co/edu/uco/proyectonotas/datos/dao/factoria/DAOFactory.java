package co.edu.uco.proyectonotas.datos.dao.factoria;

import co.edu.uco.proyectonotas.datos.dao.AdministradorDAO;
import co.edu.uco.proyectonotas.datos.dao.AsignaturaDAO;
import co.edu.uco.proyectonotas.datos.dao.CiudadDAO;
import co.edu.uco.proyectonotas.datos.dao.DepartamentoDAO;
import co.edu.uco.proyectonotas.datos.dao.DiaDAO;
import co.edu.uco.proyectonotas.datos.dao.EstadoCivilDAO;
import co.edu.uco.proyectonotas.datos.dao.EstudianteDAO;
import co.edu.uco.proyectonotas.datos.dao.GrupoDAO;
import co.edu.uco.proyectonotas.datos.dao.InstitucionDAO;
import co.edu.uco.proyectonotas.datos.dao.PaisDAO;
import co.edu.uco.proyectonotas.datos.dao.PersonaDAO;
import co.edu.uco.proyectonotas.datos.dao.ProgramaDAO;
import co.edu.uco.proyectonotas.datos.dao.SedeDAO;
import co.edu.uco.proyectonotas.datos.dao.SesionDAO;
import co.edu.uco.proyectonotas.datos.dao.TipoFormacionDAO;
import co.edu.uco.proyectonotas.datos.dao.TipoIdentificacionDAO;
import co.edu.uco.proyectonotas.datos.dao.TipoProgramaDAO;
import co.edu.uco.proyectonotas.datos.dao.factoria.enumeracion.FactoriaEnum;
import co.edu.uco.proyectonotas.datos.dao.factoria.implementacion.PostgreSQLDAOFactory;
import co.edu.uco.proyectonotas.datos.dao.factoria.implementacion.SQLServerDAOFactory;
import co.edu.uco.proyectonotas.dto.AdministradorDTO;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

public abstract class DAOFactory {

	public static DAOFactory obtener(FactoriaEnum factoria) {

		if (factoria == null) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.OBTENER_FACTORIA_CON_FACTORIA_NULA));
		}

		DAOFactory factoriaRetorno = null;

		switch (factoria) {
		case SQLSERVER:
			factoriaRetorno = new SQLServerDAOFactory();
			break;
		case POSTGRESQL:
			factoriaRetorno = new PostgreSQLDAOFactory();
			break;
		}

		return factoriaRetorno;
	}

	protected abstract void abrirConexion();

	public abstract void iniciarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cerrarConexion();
	
	public abstract AdministradorDAO obtenerAdministradorDAO();

	public abstract AsignaturaDAO obtenerAsignaturaDAO();

	public abstract CiudadDAO obtenerCiudadDAO();

	public abstract DepartamentoDAO obtenerDepartamentoDAO();

	public abstract DiaDAO obtenerDiaDAO();

	public abstract EstadoCivilDAO obtenerEstadoCivilDAO();

	public abstract EstudianteDAO obtenerEstudianteDAO();

	public abstract GrupoDAO obtenerGrupoDAO();

	public abstract InstitucionDAO obtenerInstitucionDTO();

	public abstract PaisDAO obtenerPaisDAO();

	public abstract ProgramaDAO obtenerProgramaDAO();
	
	public abstract PersonaDAO obtenerPersonaDAO();

	public abstract SedeDAO obtenerSedeDAO();

	public abstract SesionDAO obtenerSesionDAO();

	public abstract TipoFormacionDAO obtenerTipoFormacionDAO();

	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();

	public abstract TipoProgramaDAO obtenerTipoProgramaDAO();

}
