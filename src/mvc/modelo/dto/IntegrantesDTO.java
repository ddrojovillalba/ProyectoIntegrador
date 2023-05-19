package mvc.modelo.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.controlador.Coordinador;
import mvc.modelo.conexion.ConexionDB;
import mvc.modelo.vo.UsuarioVO;

/**
 * @author Mario
 *
 */
public class IntegrantesDTO {

	private Coordinador miCoordinador;

	/**
	 * Método para tener una instancia del coordinador
	 * 
	 * @param miCoordinador
	 */
	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;

	}

	/**
	 * Método que carga los integrantes de un proyecto
	 * 
	 * @param prID
	 * @return resultado
	 */
	public ArrayList<UsuarioVO> CargarIntegrantes(int prID) {

		UsuarioVO usuario;
		ArrayList<UsuarioVO> resultado = new ArrayList<>();
		Connection connection = null;
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		ConexionDB conexion = new ConexionDB();
		String consulta;
		consulta = "SELECT users.user_id, nombre, expediente FROM users INNER JOIN integrantes ON (users.user_id = integrantes.user_id) WHERE integrantes.proyecto_id= ?"; // Devuelveme
																																											// todos
																																											// los
																																											// usuarios
		connection = conexion.establecerConexion();

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setInt(1, prID);
			resultadoConsulta = prepStatement.executeQuery();

			while (resultadoConsulta.next()) {

				usuario = new UsuarioVO();
				usuario.setUser_id(Integer.parseInt(resultadoConsulta.getString("user_id")));
				System.out.println(resultadoConsulta.getString("user_id"));
				usuario.setNombre(resultadoConsulta.getString("nombre"));
				System.out.println(resultadoConsulta.getString("nombre"));
				usuario.setExpediente(resultadoConsulta.getString("expediente"));
				System.out.println(resultadoConsulta.getString(3));
				resultado.add(usuario);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				resultadoConsulta.close();
				prepStatement.close();
				conexion.desconectar();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;

	}

	/*
	 * public String borrarIntegrantes(int idPR) {
	 * 
	 * String resultado = ""; Connection connection=null; PreparedStatement
	 * prepStatement=null;
	 * 
	 * ConexionDB conexion = new ConexionDB(); String
	 * consulta="DELETE FROM integrantes WHERE proyecto_id = ?";
	 * connection=conexion.establecerConexion();
	 * 
	 * 
	 * try { prepStatement=connection.prepareStatement(consulta);
	 * prepStatement.setInt(1, idPR); prepStatement.execute();
	 * 
	 * resultado="OK";
	 * 
	 * 
	 * 
	 * }catch (Exception e) { e.printStackTrace(); resultado="Error"; } finally {
	 * 
	 * try {
	 * 
	 * prepStatement.close(); conexion.desconectar();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * System.out.println(resultado); return resultado;
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public String añadirIntegrantes(int idPR, int[] integrantes) {
	 * 
	 * String resultado = ""; Connection connection=null; PreparedStatement
	 * prepStatement=null;
	 * 
	 * ConexionDB conexion = new ConexionDB(); String
	 * consulta="INSERT INTO integrantes (proyecto_id, user_id) VALUES (?, ?)";
	 * connection=conexion.establecerConexion();
	 * 
	 * 
	 * try { prepStatement=connection.prepareStatement(consulta); for (int
	 * id_usuario : integrantes) { prepStatement.setInt(1, idPR);
	 * prepStatement.setInt(2, id_usuario); prepStatement.execute(); }
	 * resultado="OK";
	 * 
	 * 
	 * 
	 * }catch (Exception e) { e.printStackTrace(); resultado="Error"; }finally {
	 * 
	 * try {
	 * 
	 * prepStatement.close(); conexion.desconectar();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * return resultado;
	 * 
	 * 
	 * }
	 */

	/**
	 * Método para saber el ID del proyecto de un alumno consultando
	 * 
	 * @param id_alumno
	 * @return prID
	 */
	public int devolverIdProyecto(int id_alumno) { // Método para saber el ID del proyecto de un alumno consultando

		int prID = 0;
		Connection connection = null;
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		ConexionDB conexion = new ConexionDB();
		String consulta = "SELECT proyecto_id FROM integrantes WHERE user_id =?";
		connection = conexion.establecerConexion();

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setInt(1, id_alumno);
			resultadoConsulta = prepStatement.executeQuery();

			while (resultadoConsulta.next()) {

				prID = resultadoConsulta.getInt("proyecto_id");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				resultadoConsulta.close();
				prepStatement.close();
				conexion.desconectar();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return prID;

	}

}
