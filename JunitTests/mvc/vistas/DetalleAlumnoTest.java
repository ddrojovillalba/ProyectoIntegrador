package mvc.vistas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.modelo.dto.UsuarioDTO;
import mvc.modelo.vo.UsuarioVO;

class DetalleAlumnoTest {
	private DetalleAlumno detalleAlumno;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		detalleAlumno = new DetalleAlumno(null);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * recoge los datos y los encapsula para luego devolvernos esa informacion
	 * encapsulada
	 */
	@Test
	void capturarDatosUsuarioTest() {
		UsuarioVO usuario = new UsuarioVO();
		assertNotNull(detalleAlumno.capturarDatosUsuario());
		assertEquals(usuario.getClass(), detalleAlumno.capturarDatosUsuario().getClass());
	}

	/**
	 * comprueba que los campos de los datos del alumno están rellenos
	 */
	@Test
	void comprobarCamposRellenosTest() {
		UsuarioVO usuarioVO = new UsuarioVO();
		detalleAlumno.getTxtNombre().setText("María");
		usuarioVO.setUser_id(0);
		detalleAlumno.getTxtExpediente().setText("2983822");
		detalleAlumno.getTxtNick_user().setText("");
		detalleAlumno.getTxtPassword().setText("4567");
		detalleAlumno.getRdbtnAlumno().setSelected(true);
		assertFalse(detalleAlumno.comprobarCamposRellenos());
		detalleAlumno.getTxtNombre().setText("María");
		detalleAlumno.getTxtNick_user().setText("Mery");
		detalleAlumno.getTxtPassword().setText("4567");
		usuarioVO.setUser_id(0);
		detalleAlumno.getTxtExpediente().setText("2983822");
		detalleAlumno.getRdbtnAlumno().setSelected(true);
		assertTrue(detalleAlumno.comprobarCamposRellenos());

	}

}
