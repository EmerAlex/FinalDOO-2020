package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.TipoFormacionDAO;
import co.edu.uco.proyectonotas.dto.TipoFormacionDTO;

public class TipoFormacionSQLServerDAO implements TipoFormacionDAO {
	private Connection conexion;

	public TipoFormacionSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoFormacionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(TipoFormacionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(TipoFormacionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoFormacionDTO> consultar(TipoFormacionDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
