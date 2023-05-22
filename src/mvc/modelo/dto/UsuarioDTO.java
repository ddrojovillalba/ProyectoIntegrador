package mvc.modelo.dto;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mvc.controlador.Coordinador;
import mvc.vistas.VentanaLogin;
import mvc.modelo.conexion.*;
import mvc.modelo.vo.UsuarioVO;

/**
 * @author Mario
 *
 */
public class UsuarioDTO {

	private Coordinador miCoordinador;
	private Connection connection;
	private ConexionDB conexionUsuarioDTO = new ConexionDB();

	public UsuarioDTO() {
		connection = conexionUsuarioDTO.establecerConexion();
	}

	/**
	 * Constructor para los test
	 * 
	 * @param conn
	 */
	public UsuarioDTO(Connection conn) {
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
	 * getter de la conexion de la clase a la BD
	 * 
	 * @return connection
	 */
	public Connection getConnection() {
		return connection;
	}

	// Método que comprueba las credenciales del usuario intentando acceder

	/**
	 * Método que comprueba las credenciales del usuario intentando acceder
	 * 
	 * @param usuarioVO
	 * @return respuesta
	 */
	public String comprobarUsuario(UsuarioVO usuarioVO) {

		String respuesta = "";
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta = "SELECT user_id, nombre, es_profesor FROM users WHERE nick_name = ? AND password = ?; ";

		if (validarCampos(usuarioVO)) {

			try {
				prepStatement = connection.prepareStatement(consulta);
				prepStatement.setString(1, usuarioVO.getNick_name());
				prepStatement.setString(2, usuarioVO.getPassword());
				resultadoConsulta = prepStatement.executeQuery();
				if (resultadoConsulta.next()) {

					if (resultadoConsulta.getString("es_profesor").equals("1")) { // Almacenamos si el usuario loggeado
																					// es o no profesor
						Coordinador.esProfesor = true; // para variar las vistas de las ventanas en función de ello
					} else if (resultadoConsulta.getString("es_profesor").equals("0")) {
						Coordinador.esProfesor = false;
					}

					Coordinador.usuarioLoggeado = (int) resultadoConsulta.getInt("user_id"); // Almacenamos el user_id
																								// del usuario Loggeado

					respuesta = "Logged";

				} else {

					respuesta = "Credenciales";
				}

			} catch (SQLException e) {

				e.printStackTrace();
				respuesta = "Error";

			} finally {

				try {

					resultadoConsulta.close();
					prepStatement.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

		} else {
			respuesta = "faltan campos";
		}

		return respuesta;

	}

	// Metodo que devuelve un ArryList con los usuarios que coinciden con la búsueda

	/**
	 * Metodo que devuelve un ArryList con los usuarios que coinciden con la búsueda
	 * 
	 * @param busqueda
	 * @return resultado
	 */
	public ArrayList<UsuarioVO> miListaUsuariosFiltada(String busqueda) {

		UsuarioVO usuario;
		ArrayList<UsuarioVO> resultado = new ArrayList<>();
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta;
		if (busqueda.equals("")) {
			consulta = "SELECT user_id, nombre, expediente FROM users"; // Devuelveme todos los usuarios
		} else {
			consulta = "SELECT user_id, nombre, expediente FROM users WHERE nombre REGEXP ? OR expediente REGEXP ? ORDER BY nombre"; // Devuelveme
			// los
			// usuarios
			// buscados
		}

		try {
			prepStatement = connection.prepareStatement(consulta);
			if (!busqueda.equals("")) {
				prepStatement.setString(1, busqueda + "");
				prepStatement.setString(2, busqueda + "");
			}

			resultadoConsulta = prepStatement.executeQuery();

			while (resultadoConsulta.next()) {

				usuario = new UsuarioVO();
				usuario.setUser_id(Integer.parseInt(resultadoConsulta.getString("user_id")));
				usuario.setNombre(resultadoConsulta.getString("nombre"));
				usuario.setExpediente(resultadoConsulta.getString("expediente"));
				resultado.add(usuario);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				resultadoConsulta.close();
				prepStatement.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return resultado;

	}

	/**
	 * Método para mostrar los datos de un usuario
	 * 
	 * @param userID
	 * @return usuario
	 */
	public UsuarioVO mostrarDetalle(int userID) {

		UsuarioVO usuario = null;
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta = "SELECT user_id, nombre, expediente, password, nick_name, es_profesor FROM users WHERE user_id LIKE ? ";

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setInt(1, userID);
			resultadoConsulta = prepStatement.executeQuery();

			while (resultadoConsulta.next()) {

				usuario = new UsuarioVO();
				usuario.setUser_id(Integer.parseInt(resultadoConsulta.getString("user_id")));
				usuario.setNombre(resultadoConsulta.getString("nombre"));
				usuario.setExpediente(resultadoConsulta.getString("expediente"));
				usuario.setNick_name(resultadoConsulta.getString("nick_name"));
				usuario.setPassword(resultadoConsulta.getString("password"));
				usuario.setIs_teacher(resultadoConsulta.getString("es_profesor"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				resultadoConsulta.close();
				prepStatement.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return usuario;
	}

	/**
	 * Método que actualiza los datos del usuario
	 * 
	 * @param usuario
	 * @return resultado
	 */
	public String actualizarUsuario(UsuarioVO usuario) {

		String resultado = "";
		PreparedStatement prepStatement = null;

		String consulta = "UPDATE users SET nombre = ?, expediente=?, password=?, nick_name=?, es_profesor=? WHERE user_id = ?";

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setString(1, usuario.getNombre());
			prepStatement.setString(2, usuario.getExpediente());
			prepStatement.setString(3, usuario.getPassword());
			prepStatement.setString(4, usuario.getNick_name());
			prepStatement.setBoolean(5, usuario.getIs_teacher());
			prepStatement.setInt(6, usuario.getUser_id());
			prepStatement.executeUpdate();

			resultado = "OK";

		} catch (Exception e) {

			e.printStackTrace();
			resultado = "Error";

		} finally {

			try {

				prepStatement.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return resultado;
	}

	/**
	 * Método para registrar a un nuevo usuario
	 * 
	 * @param usuario
	 * @return resultado
	 */
	public String registrarUsuario(UsuarioVO usuario) {

		String resultado = "";
		PreparedStatement prepStatement = null;

		String consulta = "INSERT INTO users (nombre, expediente, password, nick_name, es_profesor) VALUES (?, ?, ?, ?, ?)";

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setString(1, usuario.getNombre());
			prepStatement.setString(2, usuario.getExpediente());
			prepStatement.setString(3, usuario.getPassword());
			prepStatement.setString(4, usuario.getNick_name());
			prepStatement.setBoolean(5, usuario.getIs_teacher());
			prepStatement.executeUpdate();

			resultado = "OK";

		} catch (Exception e) {

			e.printStackTrace();
			resultado = "Error";

		} finally {

			try {

				prepStatement.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return resultado;
	}

	/**
	 * Método para borrar un usuario
	 * 
	 * @param usuario
	 * @return resultado
	 */
	public String borrarUsuario(UsuarioVO usuario) {

		String resultado = "";
		PreparedStatement prepStatement = null;

		String consulta = "DELETE FROM users WHERE user_id = ?";

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setInt(1, usuario.getUser_id());
			prepStatement.executeUpdate();

			resultado = "OK";

		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		} finally {

			try {

				prepStatement.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;

	}

	/**
	 * Método que sirve para devolver los usuarios buscados
	 * 
	 * @return listaUsuarios
	 */
	public ArrayList<UsuarioVO> cargarAlumnos() {

		UsuarioVO usuario;
		ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta;

		consulta = "SELECT user_id, nombre, expediente FROM users WHERE es_profesor = 0"; // Devuelveme los usuarios
																							// buscados

		try {
			prepStatement = connection.prepareStatement(consulta);
			resultadoConsulta = prepStatement.executeQuery();

			while (resultadoConsulta.next()) {

				usuario = new UsuarioVO();
				usuario.setUser_id(Integer.parseInt(resultadoConsulta.getString("user_id")));
				usuario.setNombre(resultadoConsulta.getString("nombre"));
				usuario.setExpediente(resultadoConsulta.getString("expediente"));
				listaUsuarios.add(usuario);

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

		return listaUsuarios;

	}

	// --------------------------------- Métodos auxiliares ---------

	/**
	 * Método para verificar que todos los campos están rellenados y no están vacios
	 * 
	 * @param usuario
	 * @return validPass && validUser
	 */
	public boolean validarCampos(UsuarioVO usuario) {

		boolean validUser = true;
		boolean validPass = true;

		if (usuario.getNick_name().isEmpty()) {
			validUser = false;
		}
		if (usuario.getPassword().isEmpty()) {
			validPass = false;
		}

		return validPass && validUser;
	}

}