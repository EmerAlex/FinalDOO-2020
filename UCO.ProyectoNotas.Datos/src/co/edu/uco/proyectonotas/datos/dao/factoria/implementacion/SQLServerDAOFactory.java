package co.edu.uco.proyectonotas.datos.dao.factoria.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
import co.edu.uco.proyectonotas.datos.dao.factoria.DAOFactory;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.AdministradorSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.AsignaturaSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.CiudadSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.DepartamentoSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.DiaSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.EstadoCivilSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.EstudianteSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.GrupoSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.InstitucionSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.PaisSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.PersonaSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.ProgramaSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.SedeSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.SesionSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.TipoFormacionSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver.TipoProgramaSQLServerDAO;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;
import co.edu.uco.transversal.utilitario.sql.UtilSQL;

public class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;

	public SQLServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String urlConexion = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=FinalDOO;";
			String usuario = "Santi";
			String clave = "santi123";
			conexion = DriverManager.getConnection(urlConexion, usuario, clave);
			System.out.println("Conectó");
		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONEXION_SQL_SERVER));
		} catch (ClassNotFoundException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CLASE_CONEXION_SQL_SERVER_NO_ENCONTRADA));
		} catch (Exception excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONEXION_SQL_SERVER));
		}

	}

	@Override
	public void iniciarTransaccion() {

		UtilSQL.validarConexionActiva(conexion);

		try {
			conexion.setAutoCommit(false);
		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_INICIANDO_TRANSACCION));
		}
	}

	@Override
	public void cancelarTransaccion() {
		UtilSQL.validarConexionActiva(conexion);

		try {
			conexion.rollback();
		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CANCELANDO_TRANSACCION));
		}

	}

	@Override
	public void confirmarTransaccion() {
		UtilSQL.validarConexionActiva(conexion);

		try {
			conexion.commit();
		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONFIRMANDO_TRANSACCION));
		}
	}

	@Override
	public void cerrarConexion() {
		UtilSQL.validarConexionActiva(conexion);

		try {
			conexion.close();
		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CERRANDO_CONEXION));
		}
	}

	@Override
	public AsignaturaDAO obtenerAsignaturaDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new AsignaturaSQLServerDAO(conexion);
	}

	@Override
	public CiudadDAO obtenerCiudadDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new CiudadSQLServerDAO(conexion);
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new DepartamentoSQLServerDAO(conexion);
	}

	@Override
	public DiaDAO obtenerDiaDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new DiaSQLServerDAO(conexion);
	}

	@Override
	public EstadoCivilDAO obtenerEstadoCivilDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new EstadoCivilSQLServerDAO(conexion);
	}

	@Override
	public EstudianteDAO obtenerEstudianteDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new EstudianteSQLServerDAO(conexion);
	}

	@Override
	public GrupoDAO obtenerGrupoDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new GrupoSQLServerDAO(conexion);
	}

	@Override
	public InstitucionDAO obtenerInstitucionDTO() {
		UtilSQL.validarConexionActiva(conexion);
		return new InstitucionSQLServerDAO(conexion);
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new PaisSQLServerDAO(conexion);
	}

	@Override
	public ProgramaDAO obtenerProgramaDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new ProgramaSQLServerDAO(conexion);
	}

	@Override
	public SedeDAO obtenerSedeDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new SedeSQLServerDAO(conexion);
	}

	@Override
	public SesionDAO obtenerSesionDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new SesionSQLServerDAO(conexion);
	}

	@Override
	public TipoFormacionDAO obtenerTipoFormacionDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new TipoFormacionSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new TipoIdentificacionSQLServerDAO(conexion);
	}

	@Override
	public TipoProgramaDAO obtenerTipoProgramaDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new TipoProgramaSQLServerDAO(conexion);
	}

	@Override
	public PersonaDAO obtenerPersonaDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new PersonaSQLServerDAO(conexion);
	}

	@Override
	public AdministradorDAO obtenerAdministradorDAO() {
		UtilSQL.validarConexionActiva(conexion);
		return new AdministradorSQLServerDAO(conexion);
	}
}
