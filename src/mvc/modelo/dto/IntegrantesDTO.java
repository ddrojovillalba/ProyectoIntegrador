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
	private Connection connection;
	private ConexionDB conexionIntegrantesDTO = new ConexionDB();

	public IntegrantesDTO() {
		connection = conexionIntegrantesDTO.establecerConexion();
	}

	/**
	 * getter de la conexion de la clase a la BD
	 * 
	 * @return connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Constructor para los test
	 * 
	 * @param conn
	 */
	public IntegrantesDTO(Connection conn) {
		connection = conn;
	}

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
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta;
		consulta = "SELECT users.user_id, nombre, expediente FROM users INNER JOIN integrantes ON (users.user_id = integrantes.user_id) WHERE integrantes.proyecto_id= ?"; // Devuelveme
																																											// todos
																																											// los
																																											// usuarios

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

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;

	}

	/**
	 * Método para saber el ID del proyecto de un alumno consultando
	 * 
	 * @param id_alumno
	 * @return prID
	 */
	public int devolverIdProyecto(int id_alumno) { // Método para saber el ID del proyecto de un alumno consultando

		int prID = 0;
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta = "SELECT proyecto_id FROM integrantes WHERE user_id =?";

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

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return prID;

	}

}
