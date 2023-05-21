package mvc.controlador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.modelo.dto.AreaDTO;
import mvc.modelo.dto.UsuarioDTO;
import mvc.modelo.vo.AreaVO;
import mvc.modelo.vo.UsuarioVO;

class CoordinadorTest {
	private Coordinador coordinador;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		coordinador = new Coordinador();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDevolverArea() {
		AreaDTO areaDTO = new AreaDTO();
		coordinador.setAreaDTO(areaDTO);
		assertNotNull(coordinador.devolverArea(1));
		assertEquals("DAW", coordinador.devolverArea(1));
	}

	@Test
	void testCargarAlumnos() {
		UsuarioDTO usuario = new UsuarioDTO();
		coordinador.setUsuarioDTO(usuario);
		ArrayList<UsuarioVO> lista = new ArrayList<>();
		assertNotNull(coordinador.cargarAlumnos());
		assertEquals(lista.getClass(), coordinador.cargarAlumnos().getClass());
	}

	@Test
	void testRellenarComboAreas() {
		AreaDTO areaDTO = new AreaDTO();
		coordinador.setAreaDTO(areaDTO);
		ArrayList<String> miLista = new ArrayList<>();
		assertNotNull(coordinador.rellenarComboAreas());
		assertEquals(miLista.getClass(), coordinador.rellenarComboAreas().getClass());
	}

	@Test
	void testDevolverIdArea() {
		AreaDTO areaDTO = new AreaDTO();
		coordinador.setAreaDTO(areaDTO);
		assertNotNull(coordinador.devolverIdArea("DAW"));
		assertEquals(1, coordinador.devolverIdArea("DAW"));
		
	}

}
