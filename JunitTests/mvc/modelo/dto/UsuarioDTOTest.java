package mvc.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.modelo.conexion.ConexionDB;
import mvc.modelo.vo.ProyectoVO;
import mvc.modelo.vo.UsuarioVO;

class UsuarioDTOTest {
	private static UsuarioDTO usuarioDTO;
	private static Connection conn = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = null;
		ConexionDB conexion = new ConexionDB();
		conn = conexion.establecerConexion();
		conn.setAutoCommit(false);
		usuarioDTO = new UsuarioDTO(conn);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		conn.setAutoCommit(true);
		conn.close();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * comprueba que el usuario introducido está en la base de datos
	 */
	@Test
	void comprobarUsuariotest() {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setNick_name("admin");
		usuarioVO.setPassword("1234");
		ArrayList<String> valores = new ArrayList<>();
		String valor1 = "Logged";
		String valor2 = "Error";
		String valor3 = "Credenciales";
		valores.add(valor1);
		valores.add(valor2);
		valores.add(valor3);
		assertTrue(valores.contains(usuarioDTO.comprobarUsuario(usuarioVO)));
	}

	/**
	 * realiza una busqueda filtrada por una condición
	 */
	@Test
	void miListaUsuariosFiltadaTest() {
		ArrayList<UsuarioVO> miLista = new ArrayList<>();
		assertNotNull(usuarioDTO.miListaUsuariosFiltada(""));
		assertEquals(miLista.getClass(), usuarioDTO.miListaUsuariosFiltada("").getClass());
	}

	/**
	 * se muestra los detalles del usuario
	 */
	@Test
	void mostrarDetalleTest() {
		UsuarioVO usuarioVO = new UsuarioVO();
		assertNotNull(usuarioDTO.mostrarDetalle(2));
		assertEquals(usuarioVO.getClass(), usuarioDTO.mostrarDetalle(2).getClass());
	}

	/**
	 * actualiza los datos del usuario
	 */
	@Test
	void actualizarUsuarioTest() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setUser_id(3);
		usuarioVO.setNombre("Juan");
		usuarioVO.setExpediente("994933838");
		usuarioVO.setPassword("3456");
		usuarioVO.setNick_name("Juanito");
		usuarioVO.setIs_teacher("0");
		ArrayList<String> valores = new ArrayList<>();
		String valor1 = "OK";
		String valor2 = "Error";
		valores.add(valor1);
		valores.add(valor2);
		assertTrue(valores.contains(usuarioDTO.actualizarUsuario(usuarioVO)));
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * registra un nuevo usuario
	 */
	@Test
	void registrarUsuarioTest() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setUser_id(0);
		usuarioVO.setNombre("Manolo");
		usuarioVO.setExpediente("050449483");
		usuarioVO.setPassword("0606");
		usuarioVO.setNick_name("Loco");
		usuarioVO.setIs_teacher("0");
		ArrayList<String> valores = new ArrayList<>();
		String valor1 = "OK";
		String valor2 = "Error";
		valores.add(valor1);
		valores.add(valor2);
		assertTrue(valores.contains(usuarioDTO.registrarUsuario(usuarioVO)));
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * borra un usuario de la base de datos
	 */
	@Test
	void borrarUsuarioTest() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UsuarioVO usuarioVO = new UsuarioVO();
		ArrayList<String> valores = new ArrayList<>();
		String valor1 = "OK";
		String valor2 = "Error";
		valores.add(valor1);
		valores.add(valor2);
		assertTrue(valores.contains(usuarioDTO.borrarUsuario(usuarioVO)));
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * carga los alumnos en un arraylist de usuarioVO
	 */
	@Test
	void cargarAlumnosTest() {
		UsuarioVO usuario = new UsuarioVO();
		ArrayList<UsuarioVO> lista = new ArrayList<>();
		assertNotNull(usuarioDTO.cargarAlumnos());
		assertEquals(lista.getClass(), usuarioDTO.cargarAlumnos().getClass());
	}

	/**
	 * comprueba que los campos no estén vacios
	 */
	@Test
	void validarCamposTest() {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setNick_name("");
		usuarioVO.setPassword("");
		assertFalse(usuarioDTO.validarCampos(usuarioVO));
		usuarioVO.setNick_name("Juan");
		usuarioVO.setPassword("448484");
		assertTrue(usuarioDTO.validarCampos(usuarioVO));

	}

}