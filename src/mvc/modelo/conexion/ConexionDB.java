package mvc.modelo.conexion;

import java.sql.*;

/**
 * @author Mario
 *
 */
public class ConexionDB {

	private String nombreDB = "proyecto_integrador";
	private String usuario = "root";
	private String password = "rootroot";
	private String url = "jdbc:mysql://localhost/" + nombreDB;

	Connection conn = null;

	// Constructor

	/**
	 * Constructor de la clase
	 */
	public ConexionDB() {

		try {

			// Buscamos el Driver de la BD

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Obtenemos la conexion

			conn = DriverManager.getConnection(url, usuario, password);

			if (conn != null) {

				System.out.println("Conexion establecida a " + nombreDB);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch

			System.out.println("Error de Conexion. " + e.getMessage());
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("Error de Driver JDBC. " + e.getMessage());
			e.printStackTrace();

		}

	}

	public Connection establecerConexion() {

		return conn;
	}

	public void desconectar() {

		conn = null;

	}

}
