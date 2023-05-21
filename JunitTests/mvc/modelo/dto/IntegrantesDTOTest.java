package mvc.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.modelo.vo.UsuarioVO;

class IntegrantesDTOTest {
	private IntegrantesDTO integrantesDTO;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		integrantesDTO = new IntegrantesDTO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void CargarIntegrantesTest() {
		UsuarioVO usuario = new UsuarioVO();
		ArrayList<UsuarioVO> lista = new ArrayList<>();
		assertNotNull(integrantesDTO.CargarIntegrantes(2));
		assertEquals(lista.getClass(), integrantesDTO.CargarIntegrantes(2).getClass());
	}
	
	@Test
	void devolverIdProyectoTest() {
		Integer id = 0;
		assertEquals(3, integrantesDTO.devolverIdProyecto(2));
		assertNotNull(integrantesDTO.devolverIdProyecto(3));
	}

}
