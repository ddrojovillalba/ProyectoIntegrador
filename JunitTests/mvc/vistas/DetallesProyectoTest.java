package mvc.vistas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.controlador.Coordinador;
import mvc.modelo.dto.AreaDTO;
import mvc.modelo.dto.IntegrantesDTO;
import mvc.modelo.dto.ProyectoDTO;
import mvc.modelo.vo.ProyectoVO;

class DetallesProyectoTest {
	private static DetallesProyecto detallesProyecto;
	private static IntegrantesDTO integrantesDTO = new IntegrantesDTO();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		detallesProyecto = new DetallesProyecto();
		detallesProyecto.cargarIntegrantes(integrantesDTO.CargarIntegrantes(3));
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
	 * devuelve los integrantes del array de integrantes
	 */
	@Test
	void getIntegrantesTest() {

		int[] integrantes = new int[] { 1 };
		assertNotNull(detallesProyecto.getIntegrantes());

		assertEquals(integrantes.getClass(), detallesProyecto.getIntegrantes().getClass());
	}

	/**
	 * comprueba que los campos han sido rellenados
	 */
	@Test
	void estanCamposRellenosTest() {
		ProyectoVO proyectoVO = new ProyectoVO();
		detallesProyecto.getTxtNomnrePr().setText("JI");
		detallesProyecto.getTxtYear().setText("");
		detallesProyecto.getTxtUrl().setText("www");
		assertFalse(detallesProyecto.estanCamposRellenos());
		detallesProyecto.getTxtNomnrePr().setText("JI");
		detallesProyecto.getTxtYear().setText("2023");
		detallesProyecto.getTxtUrl().setText("www");
		assertTrue(detallesProyecto.estanCamposRellenos());
	}

	/**
	 * coge los datos que hay en los campos
	 */
	@Test
	void getCamposTest() {
		ProyectoVO proyectoVO = new ProyectoVO();
		Coordinador micoordinador = new Coordinador();
		AreaDTO miAreaDTO = new AreaDTO();

		detallesProyecto.setCoordinador(micoordinador);
		micoordinador.setAreaDTO(miAreaDTO);
		detallesProyecto.rellenarComboAreas(micoordinador.rellenarComboAreas());
		detallesProyecto.getCmbAreas().setSelectedItem(1);

		detallesProyecto.getTxtId().setText("0");
		detallesProyecto.getTxtNomnrePr().setText("JI");
		detallesProyecto.getTxtGrupo().setText("H89");
		detallesProyecto.getTxtYear().setText("2012");
		detallesProyecto.getTxtUrl().setText("www");
		detallesProyecto.getTxtNota().setText("8.9");
		assertNotNull(detallesProyecto.getCampos());
		assertEquals(proyectoVO.getClass(), detallesProyecto.getCampos().getClass());
	}
}
