package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.objetoEsNulo;
import static co.edu.uco.transversal.utilitario.texto.UtilTexto.cadenaEstaNulaOVacia;
import static co.edu.uco.transversal.utilitario.texto.UtilTexto.concatenar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.PaisDAO;
import co.edu.uco.proyectonotas.dto.PaisDTO;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

public class PaisSQLServerDAO implements PaisDAO {
	private Connection conexion;

	public PaisSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(PaisDTO objeto) {

		String sentenciaSQL = "INSERT INTO Pais(nombre) VALUES (?)";

		try (PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)) {

			// Colocar parámetros de la sentencia
			sentencia.setString(1, objeto.getNombre());

			// Ejecución de la sentencia
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CREANDO_PAIS));
		}
	}

	@Override
	public void actualizar(PaisDTO objeto) {

		String sentenciaSQL = "UPDATE Pais SET nombre = ? WHERE codigo = ?";

		try (PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)) {

			// Colocar parámetros de la sentencia
			sentencia.setString(1, objeto.getNombre());
			sentencia.setInt(2, objeto.getCodigo());

			// Ejecución de la sentencia
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_MODIFICANDO_PAIS));
		}
	}

	@Override
	public void eliminar(PaisDTO objeto) {

		String sentenciaSQL = "DELETE FROM Pais WHERE codigo = ?";

		try (PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)) {

			// Colocar parámetros de la sentencia
			sentencia.setInt(1, objeto.getCodigo());

			// Ejecución de la sentencia
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_ELIMINANDO_PAIS));
		}
	}

	@Override
	public List<PaisDTO> consultar(PaisDTO objeto) {

		List<PaisDTO> listaPaises = new ArrayList<>();
		List<Object> parametros = new ArrayList<>();
		String sentenciaSQL = "SELECT codigo, nombre FROM Pais ";
		String operador = "WHERE ";

		if (!objetoEsNulo(objeto)) {

			if (objeto.getCodigo() > 0) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "codigo=? ");
				parametros.add(objeto.getCodigo());
				operador = "AND ";
			}

			if (!cadenaEstaNulaOVacia(objeto.getNombre())) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "nombre LIKE ? ");
				parametros.add(concatenar("%", objeto.getNombre(), "%"));
			}
		}

		try (PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)) {

			// Colocar los parámetros
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			// Ejecución de la sentencia
			try (ResultSet cursor = sentencia.executeQuery()) {

				while (cursor.next()) {

					PaisDTO pais = new PaisDTO();
					pais.setCodigo(cursor.getInt("codigo"));
					pais.setNombre(cursor.getString("nombre"));

					listaPaises.add(pais);
				}
			}

		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONSULTANDO_PAISES));
		}

		return listaPaises;
	}

}
