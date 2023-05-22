package mvc.modelo.conexion;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConexionDBTest {
	private ConexionDB conexionDB = new ConexionDB();
	private Connection con;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * prueba la conexion con la base de datos
	 */
	@Test
	void testConexionDB() {
		assertThrows(ClassNotFoundException.class, () -> {
			conexionDB = new ConexionDB("churro", "proyecto_integrador");
		});
		assertThrows(SQLException.class, () -> {
			conexionDB = new ConexionDB("com.mysql.cj.jdbc.Driver", "proyecto_churro");
		});

	}

	/**
	 * prueba la conexion con la base de datos utilizando el constructor normal y no el de test
	 */
	@Test
	void testConexionSinExcepcion() {
		con = conexionDB.establecerConexion();
		assertNotNull(conexionDB.establecerConexion());
		assertEquals(con.getClass(), conexionDB.establecerConexion().getClass());

	}

}
