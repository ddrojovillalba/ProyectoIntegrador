/**
 * 
 */
package mvc.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import mvc.modelo.vo.AreaVO;
import mvc.modelo.vo.ProyectoVO;

/**
 * @author Mario
 *
 */
class AreaDTOTest {
	private AreaDTO areaDTO;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		areaDTO = new AreaDTO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * carga en el comboAreas de areaDTO las areas
	 */
	@Test
	void rellenarComboAreastest() {
		ArrayList<String> miLista = new ArrayList<>();
		assertNotNull(areaDTO.rellenarComboAreas());
		assertEquals(miLista.getClass(), areaDTO.rellenarComboAreas().getClass());
	}

	/**
	 * devuelve el id del nombre que introducimos
	 */
	@Test

	void devolverIdAreatest() {

		assertEquals(1, areaDTO.devolverIdArea("DAW"));
		assertEquals(2, areaDTO.devolverIdArea("DAM"));

	}

	/**
	 * devuelve el nombre segun el id que le introduzcamos
	 */
	@Test
	void devolverNombreCortoAreaTest() {

		assertEquals("DAW", areaDTO.devolverNombreCortoArea(1));
	}

	/**
	 * devuelve toda la informacion del area seleccionada
	 */
	@Test
	void devolverAreaTest() {
		AreaVO areaVO = new AreaVO();
		assertNotNull(areaDTO.devolverArea("DAW"));
		assertEquals(areaVO.getClass(), areaDTO.devolverArea("DAW").getClass());
	}

}
