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

import co.edu.uco.proyectonotas.datos.dao.AdministradorDAO;
import co.edu.uco.proyectonotas.dto.AdministradorDTO;
import co.edu.uco.proyectonotas.dto.PersonaDTO;
import co.edu.uco.transversal.excepcion.NotasExcepcion;
import co.edu.uco.transversal.mensajes.codigos.CodigosMensajes;
import co.edu.uco.transversal.mensajes.estrategia.MensajesEstrategia;

public class AdministradorSQLServerDAO implements AdministradorDAO {
	private Connection conexion;

	public AdministradorSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(AdministradorDTO objeto) {

		String sentenciaSQL = "INSERT INTO Administrador(codigoSuperAdministrador, nombre, apellido, estado, nombreUsuario, contraseña) VALUES (?,?,?,?,?,?)";

		try (PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)) {

		
			sentencia.setInt(1, objeto.getCodigoSuperAdministrador());
			sentencia.setString(2, objeto.getNombre());
			sentencia.setString(3, objeto.getApellido());
			sentencia.setBoolean(4, objeto.isEstado());
			sentencia.setString(5, objeto.getNombreUsuario());
			sentencia.setString(6, objeto.getContraseña());
			
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CREANDO_PERSONA));
		}
	}

	@Override
	public void actualizar(AdministradorDTO objeto) {

		String sentenciaSQL = "UPDATE Administrador SET nombre = ?, apellido = ?, estado = ?, nombreUsuario = ?, contraseña = ? WHERE codigo = ?";

		try (PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)) {

			// Colocar parámetros de la sentencia
			sentencia.setInt(1, objeto.getCodigoSuperAdministrador());
			sentencia.setString(2, objeto.getNombre());
			sentencia.setString(3, objeto.getApellido());
			sentencia.setString(4, objeto.getNombreUsuario());
			sentencia.setString(5, objeto.getContraseña());
			
			sentencia.setInt(6, objeto.getCodigo());

			// Ejecución de la sentencia
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_MODIFICANDO_PAIS));
		}
	}

	@Override
	public void eliminar(AdministradorDTO objeto) {

		String sentenciaSQL = "DELETE FROM Administrador WHERE codigo = ?";

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
	public List<AdministradorDTO> consultar(AdministradorDTO objeto) {
		System.err.println("Entro a la consulta");

		List<AdministradorDTO> listaPersonas = new ArrayList<>();
		List<Object> parametros = new ArrayList<>();
		String sentenciaSQL = "SELECT codigo, nombre, apellido, estado, nombreUsuario, contraseña FROM Administrador ";
		String operador = "WHERE ";

		if (!objetoEsNulo(objeto)) {
			
			if ((objeto.getCodigo()>=0)) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "codigo = ? ");
				parametros.add( objeto.getCodigo());
				operador = "AND ";
			}

			if ((objeto.getCodigoSuperAdministrador()>=0)) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "codigoSuperAdministrador = ? ");
				parametros.add( objeto.getCodigoSuperAdministrador());
				operador = "AND ";
			}
			
			if (!cadenaEstaNulaOVacia(objeto.getNombre())) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "nombre LIKE ? ");
				parametros.add(concatenar("%", objeto.getNombre(), "%"));
				operador = "AND ";
			}
			if (!cadenaEstaNulaOVacia(objeto.getApellido())) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "apellido LIKE ? ");
				parametros.add(concatenar("%", objeto.getApellido(), "%"));
				operador = "AND ";
			}
			if (!objeto.isEstado()){
				sentenciaSQL = concatenar(sentenciaSQL, operador, "estado = ? ");
				parametros.add(concatenar("%", objeto.getApellido(), "%"));
				operador = "AND ";
			}
			if (!cadenaEstaNulaOVacia(objeto.getNombreUsuario())) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "nombreUsuario LIKE ? ");
				parametros.add(concatenar("%", objeto.getNombreUsuario(), "%"));
				operador = "AND ";
			}
			if (!cadenaEstaNulaOVacia(objeto.getContraseña())) {
				sentenciaSQL = concatenar(sentenciaSQL, operador, "contraseña LIKE ? ");
				parametros.add(concatenar("%", objeto.getContraseña(), "%"));
				
			}
		}

		try (PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)) {

			// Colocar los parámetros
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice, parametros.get(indice));
			}

			// Ejecución de la sentencia
			try (ResultSet cursor = sentencia.executeQuery()) {
				System.err.println("Entro a la consulta, no trajo datos");

				while (cursor.next()) {
					System.err.println("Entro a la consulta, trajo datos");

					AdministradorDTO persona = new AdministradorDTO();
					persona.setCodigo(cursor.getInt("codigo"));
					persona.setNombre(cursor.getString("nombre"));
					persona.setApellido(cursor.getString("apellido"));
					persona.setEstado(cursor.getBoolean("estado"));
					persona.setNombreUsuario(cursor.getString("nombreUsuario"));
					persona.setContraseña(cursor.getString("contraseña"));
					

					listaPersonas.add(persona);
				}
			}

		} catch (SQLException excepcion) {
			System.err.println("Error");
			throw NotasExcepcion.crear(excepcion, MensajesEstrategia.obtener(CodigosMensajes.ERROR_CONSULTANDO_PAISES));
		}

		return listaPersonas;
	}

}
