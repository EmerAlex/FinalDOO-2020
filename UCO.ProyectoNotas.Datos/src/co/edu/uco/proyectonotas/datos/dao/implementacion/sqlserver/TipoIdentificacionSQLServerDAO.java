package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.TipoIdentificacionDAO;
import co.edu.uco.proyectonotas.dto.TipoIdentificacionDTO;

public class TipoIdentificacionSQLServerDAO implements TipoIdentificacionDAO {
	private Connection conexion;

	public TipoIdentificacionSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoIdentificacionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(TipoIdentificacionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(TipoIdentificacionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
