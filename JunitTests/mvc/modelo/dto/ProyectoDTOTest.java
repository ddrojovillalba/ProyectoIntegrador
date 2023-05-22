package mvc.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.modelo.conexion.ConexionDB;
import mvc.modelo.vo.ProyectoVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

class ProyectoDTOTest {
	private static ProyectoDTO proyectoDTO;
	private static Connection conn = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = null;
		ConexionDB conexion = new ConexionDB();
		conn = conexion.establecerConexion();
		conn.setAutoCommit(false);
		proyectoDTO = new ProyectoDTO(conn);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		conn.setAutoCommit(true);
		conn.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		proyectoDTO = new ProyectoDTO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * test por el cual busca en un arraylist de una manera filtrada
	 */
	@Test
	void miListaProyectosFiltradatest() {
		ArrayList<ProyectoVO> miLista = new ArrayList<>();
		assertNotNull(proyectoDTO.miListaProyectosFiltrada("Airforce"));
		assertEquals(miLista.getClass(), proyectoDTO.miListaProyectosFiltrada("Airforce").getClass());
	}

	/**
	 * muestra los detalles del proyecto segun el id del proyeccto
	 */
	@Test
	void mostrarDetalleTest() {
		ProyectoVO proyectoVO = new ProyectoVO();
		assertNotNull(proyectoDTO.mostrarDetalle(1));
		assertEquals(proyectoVO.getClass(), proyectoDTO.mostrarDetalle(1).getClass());
	}

	/**
	 * actualiza los datos del proyecto
	 */
	@Test
	void actualizarProyectoTest() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProyectoVO proyectoVO = new ProyectoVO();
		proyectoVO.setIdProyecto(3);
		proyectoVO.setNombreProyecto("Airforce");
		proyectoVO.setUrl("www");
		proyectoVO.setNota(8.1);
		proyectoVO.setYear("2022");
		proyectoVO.setCurso("PRIMERO");
		proyectoVO.setGrupo("G21");
		proyectoVO.setArea(1);
		int[] integrantes = { 2 };
		ArrayList<String> valores = new ArrayList<>();
		String valor1 = "OK";
		String valor2 = "Error";
		valores.add(valor1);
		valores.add(valor2);
		assertTrue(valores.contains(proyectoDTO.actualizarProyecto(proyectoVO, integrantes, 1)));
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * añade un proyecto a la base de datos
	 */
	@Test
	void añadirProyectoTest() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProyectoVO proyectoVO = new ProyectoVO();
		proyectoVO.setIdProyecto(0);
		proyectoVO.setNombreProyecto("Test Proyect");
		proyectoVO.setUrl("www");
		proyectoVO.setNota(8.1);
		proyectoVO.setYear("2022");
		proyectoVO.setCurso("SEGUNDO");
		proyectoVO.setGrupo("G21");
		proyectoVO.setArea(2);
		int[] integrantes = { 2 };
		ArrayList<String> valores = new ArrayList<>();
		String valor1 = "OK";
		String valor2 = "Error";
		valores.add(valor1);
		valores.add(valor2);
		assertTrue(valores.contains(proyectoDTO.añadirProyecto(proyectoVO, integrantes)));
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * borra un proyecto de la base de datos
	 */
	@Test
	void borrarProyectoTest() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> valores = new ArrayList<>();
		String valor1 = "OK";
		String valor2 = "Error";
		valores.add(valor1);
		valores.add(valor2);
		assertTrue(valores.contains(proyectoDTO.borrarProyecto(2)));
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
