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
	private String driver ="com.mysql.cj.jdbc.Driver";

	Connection conn = null;

	// Constructor

	/**
	 * Constructor de la clase
	 */
	public ConexionDB() {

		try {

			// Buscamos el Driver de la BD

			Class.forName(driver);

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
	
	/** Constructor para los Test 
	 * @param driver
	 * @param usuario
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ConexionDB(String driver, String usuario) throws ClassNotFoundException, SQLException {
		
		try {

			// Buscamos el Driver de la BD

			Class.forName(driver);

			// Obtenemos la conexion

			conn = DriverManager.getConnection(url, usuario, password);

			if (conn != null) {

				System.out.println("Conexion establecida a " + nombreDB);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch

			System.out.println("Error de Conexion. " + e.getMessage());
			e.printStackTrace();
			throw e;

		} catch (ClassNotFoundException e) {

			System.out.println("Error de Driver JDBC. " + e.getMessage());
			e.printStackTrace();
			throw e;

		}

	}

	public Connection establecerConexion() {

		return conn;
	}

	public void desconectar() {

		conn = null;

	}

}
