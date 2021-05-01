package co.edu.uco.transversal.utilitario.sql;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;
import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.*;

public class UtilSQL {

	public static boolean conexionEstaActiva(Connection conexion) {
		try {
			return (!objetoEsNulo(conexion) && !conexion.isClosed());
		} catch (SQLException excepcion) {
			return false;
		}
	}

	public static void validarConexionActiva(Connection conexion) {
		if (!UtilSQL.conexionEstaActiva(conexion)) {
			throw NotasExcepcion.crear(MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONEXION_NULA_O_CERRADA));
		}
	}
}
