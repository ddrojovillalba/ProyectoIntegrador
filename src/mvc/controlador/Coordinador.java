package mvc.controlador;

import java.awt.Component;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.modelo.vo.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthScrollBarUI;

import mvc.modelo.Logica;
import mvc.modelo.dto.AreaDTO;
import mvc.modelo.dto.IntegrantesDTO;
import mvc.modelo.dto.ProyectoDTO;
import mvc.modelo.dto.UsuarioDTO;
import mvc.modelo.vo.UsuarioVO;
import mvc.vistas.*;

/**
 * @author Mario
 *
 */
public class Coordinador implements ActionListener, KeyListener, ItemListener {

	private VentanaPrincipal miVentanaAplicacion;
	private VentanaLogin miVentanaLogin;
	private Logica miLogica;
	private UsuarioDTO miUsuarioDTO;
	private BusquedaEdicionAlumnos miBuscarAlumnos;
	private DetalleAlumno miDetalle;
	private BuscarProyectos miBuscarProyectos;
	private DetallesProyecto miDetallesProyectos;
	private AreaDTO miAreaDTO;
	private ProyectoDTO miProyectoDTO;
	private IntegrantesDTO miIntegrantesDTO;
	private DetallesAreas miDetallesAreas;

	public static boolean esProfesor = true;
	public static int usuarioLoggeado = -1;

	// ----------------------------------------- Setters de instancias únicas
	// -------------------------------------------

	/**
	 * Método para tener una instancia de DetallesAreas
	 * 
	 * @param miDetallesAreas
	 */
	public void setDetallesAreas(DetallesAreas miDetallesAreas) {

		this.miDetallesAreas = miDetallesAreas;

	}

	/**
	 * setter de la VentanaBusqueda
	 * 
	 * @param miBuscarAlumnos
	 */
	public void setVentanaBusqueda(BusquedaEdicionAlumnos miBuscarAlumnos) {

		this.miBuscarAlumnos = miBuscarAlumnos;

	}

	/**
	 * setter de la VentanaDetalle
	 * 
	 * @param miDetalleAlumno
	 */
	public void setVentanaDetalle(DetalleAlumno miDetalleAlumno) {

		this.miDetalle = miDetalleAlumno;

	}

	/**
	 * setter de la VentanaAplicacion
	 * 
	 * @param miVentanaAplicacion2
	 */
	public void setVentanaAplicacion(VentanaPrincipal miVentanaAplicacion2) {

		this.miVentanaAplicacion = miVentanaAplicacion2;

	}

	/**
	 * setter de la VentanaLogin
	 * 
	 * @param miVentanaLogin
	 */
	public void setVentanaLogin(VentanaLogin miVentanaLogin) {

		this.miVentanaLogin = miVentanaLogin;

	}

	/**
	 * setter de DetallesProyectos
	 * 
	 * @param miDetallesProyectos
	 */
	public void setDetallesProyecto(DetallesProyecto miDetallesProyectos) {
		this.miDetallesProyectos = miDetallesProyectos;

	}

	/**
	 * setter de BuscarProyectos
	 * 
	 * @param miBuscarProyectos
	 */
	public void setBuscarProyectos(BuscarProyectos miBuscarProyectos) {
		this.miBuscarProyectos = miBuscarProyectos;

	}

	/**
	 * setter de la Logica
	 * 
	 * @param miLogica
	 */
	public void setLogica(Logica miLogica) {

		this.miLogica = miLogica;
	}

	/**
	 * setter del UsuarioDTO
	 * 
	 * @param miUsuarioDTO
	 */
	public void setUsuarioDTO(UsuarioDTO miUsuarioDTO) {

		this.miUsuarioDTO = miUsuarioDTO;

	}

	/**
	 * setter del AreaDTO
	 * 
	 * @param miAreaDTO
	 */
	public void setAreaDTO(AreaDTO miAreaDTO) {
		this.miAreaDTO = miAreaDTO;

	}

	/**
	 * setter de ProyectoDTO
	 * 
	 * @param miProyectoDTO
	 */
	public void setProyectoDTO(ProyectoDTO miProyectoDTO) {

		this.miProyectoDTO = miProyectoDTO;

	}

	/**
	 * Método para tener una instancia de IntegrantesDTO
	 * 
	 * @param miIntengrantesDTO
	 */
	public void setIntegrantesDTO(IntegrantesDTO miIntengrantesDTO) {

		this.miIntegrantesDTO = miIntengrantesDTO;

	}

	// Control de los ActionListener
	// ===================================================================================================

	/**
	 * Control de los ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// ------------------------------------------===========================Eventos
		// de la ventana Login ======================-------------------

		if (e.getSource() == miVentanaLogin.getBtnLogin()) {

			UsuarioVO usuarioLogeando = miVentanaLogin.cargarDatosLogin();

			System.out.println("He clickado en el boton");
			String resp = miUsuarioDTO.comprobarUsuario(usuarioLogeando);

			comprobarRespuesta(usuarioLogeando, resp);
		}

		if (e.getSource() == miVentanaLogin.getBtnSalir()) {

			int resp = JOptionPane.showConfirmDialog(null, "¿Quiere salir de la aplicación", "WARNING",
					JOptionPane.YES_NO_OPTION);
			if (resp == 0) {
				try {
					miProyectoDTO.getConnection().close();
					miUsuarioDTO.getConnection().close();
					miIntegrantesDTO.getConnection().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}

		}

		// ----------------------------------------------------------------------===
		// Eventos de la ventana Principal (SIDEBAR) ========---------------

		// Selecciono la pestaña Proyectos, Alumnos, etc...

		if (e.getSource() == miVentanaAplicacion.getSideBar().getBtnProyectos()) {

			miVentanaAplicacion.getTabbedPane().setSelectedIndex(0);
		}

		if (e.getSource() == miVentanaAplicacion.getSideBar().getBtnAlumnos()) {

			miVentanaAplicacion.getTabbedPane().setSelectedIndex(1);
		}

		if (e.getSource() == miVentanaAplicacion.getSideBar().getBtnAreas()) {

			miVentanaAplicacion.getTabbedPane().setSelectedIndex(2);
			miVentanaAplicacion.getPestañaAreas().getLblConsulta().setText("CONSULTAR AREAS");
			miVentanaAplicacion.getPestañaAreas().getLblDarDeAlta().setVisible(false);
			miVentanaAplicacion.getPestañaAreas().getBtnAlta().setVisible(false);
			miVentanaAplicacion.getPestañaAreas().getBtnConsulta().setText("CONSULTAR AREAS");

		}

		if (e.getSource() == miVentanaAplicacion.getSideBar().getBtnAyuda()) {

			System.out.println("Click en editar proyectos ");
			JOptionPane.showMessageDialog(miVentanaAplicacion, "La ayuda está en camino");

		}

		if (e.getSource() == miVentanaAplicacion.getSideBar().getBtnAcercaDe()) {

			System.out.println("Click en editar proyectos ");
			JOptionPane.showMessageDialog(miVentanaAplicacion,
					"Proyecto realizado por el grupo Codies \n \n © 2023 - Universidad Europea");
		}

		if (e.getSource() == miVentanaAplicacion.getSideBar().getBtnSalir()) {
			int resp = JOptionPane.showOptionDialog(miVentanaAplicacion, "¿Quieres salir?", null, 0, 0, null, null, e);
			System.out.println(resp);
			if (resp == 0) {
				try {
					miProyectoDTO.getConnection().close();
					miUsuarioDTO.getConnection().close();
					miIntegrantesDTO.getConnection().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		}

		// -------------------------------------------------------------==== Eventos
		// pestaña Proyectos ====-----------------------

		// Botón CONSULTAR/EDITAR (pestaña Proyectos)

		if (e.getSource() == miVentanaAplicacion.getPestañaProyectos().getBtnConsulta()) {

			if (Coordinador.esProfesor) { // Si es profesor, permite todo

				System.out.println("He clikado en botón consulta de la pestaña proyectos");
				miBuscarProyectos.setVisible(true);
				miDetallesProyectos.setVisible(false);

			} else { // Si no, solo permite mostrar su proyecto, si existe

				int prID = miIntegrantesDTO.devolverIdProyecto(Coordinador.usuarioLoggeado);
				if (prID == 0) {
					JOptionPane.showMessageDialog(null, "No tienes ningún proyecto registrado");
				} else {
					miBuscarProyectos.setVisible(false);
					miDetallesProyectos.cambiarVistaDetalle();
					miDetallesProyectos.setVisible(true);
					miDetallesProyectos.rellenarTabla(miUsuarioDTO.cargarAlumnos());
					miDetallesProyectos.mostrarProyecto(miProyectoDTO.mostrarDetalle(prID));
					miDetallesProyectos.cargarIntegrantes(miIntegrantesDTO.CargarIntegrantes(prID));
				}

			}

		}

		// Botón REGISTRAR (pestaña Proyectos)

		if (e.getSource() == miVentanaAplicacion.getPestañaProyectos().getBtnAlta()) {

			miDetallesProyectos.modoRegistro();
			miDetallesProyectos.rellenarTabla(miUsuarioDTO.cargarAlumnos());
			miDetallesProyectos.setVisible(true);

		}

		// --------------------------------------------------------------==== Eventos
		// pestaña Alumnos ====------------

		// ------------ Botón CONSULTAR/EDITAR (pestaña Alumnos)

		if (e.getSource() == miVentanaAplicacion.getPestañaAlumnos().getBtnConsulta()) {

			if (Coordinador.esProfesor) { // Si es profesor, permite buscar alumnos

				System.out.println("He clikado en botón consulta de la pestaña alumnos");
				miBuscarAlumnos.setVisible(true);

			} else { // Si no, muestra el detalle del usuario loggeado

				miDetalle.setVisible(true);
				miDetalle.VistaAlumno();
				miDetalle.mostrarUsuario(miUsuarioDTO.mostrarDetalle(Coordinador.usuarioLoggeado));

			}

		}

		// Botón REGISTAR (pestaña Alumnos)

		if (e.getSource() == miVentanaAplicacion.getPestañaAlumnos().getBtnAlta()) {

			miDetalle.modoRegistro();
			miDetalle.setVisible(true);

		}

		// ---------------------------------------------------------==== Eventos pestaña
		// Areas ====-------------------------------------------------------------

		if (e.getSource() == miVentanaAplicacion.getPestañaAreas().getBtnConsulta()) {

			miDetallesAreas.setVisible(true);

		}

		//////////////////////////////////////////////
		// //
		// Ventana Buscar Alumnos //
		// //
		//////////////////////////////////////////////

		// -------============================================ Eventos Ventana buscar
		// Alumnos
		// ====================================---------------------------------------

		// Boton BUSCAR

		// Generamos la tabla con los usuarios que cumplen el criterio de busqueda,
		// comprobándolo en los campos nombre o expediente

		if (e.getSource() == miBuscarAlumnos.getBtnBuscar()) {

			System.out.println("He pulsado en buscar");
			String textoABuscar = miBuscarAlumnos.getTxtBuscar().getText().trim();

			System.out.println(textoABuscar);
			ArrayList<UsuarioVO> resultadoBusqueda = miUsuarioDTO.miListaUsuariosFiltada(textoABuscar);
			miBuscarAlumnos.generarTabla(resultadoBusqueda);

		}

		// Botón DETALLE

		// Muestra el detalle del usuario seleccionado en la tabla

		if (e.getSource() == miBuscarAlumnos.getBtnDetalle()) {

			miDetalle.cambiarVistaDetalle();

			int filaSeleccionada = miBuscarAlumnos.getTablaAlunmos().getSelectedRow();
			if (filaSeleccionada >= 0) {
				int userID = Integer.parseInt(
						(String) miBuscarAlumnos.getTablaAlunmos().getModel().getValueAt(filaSeleccionada, 0));

				miDetalle.mostrarUsuario(miUsuarioDTO.mostrarDetalle(userID));
				miDetalle.setVisible(true);
			}

		}

		// Botón CERRAR

		// Oculta la vista BuscarAlumnos

		if (e.getSource() == miBuscarAlumnos.getBtnCerrar()) {
			miBuscarAlumnos.setVisible(false);
		}

		//////////////////////////////////////////////
		// //
		// Ventana VentanaDetalle Alumnos //
		// //
		//////////////////////////////////////////////

		// --------==================================================== Eventos
		// VentanaDetalle Alumno
		// ===============-----------------------------------------------------

		// Botón EDITAR

		if (e.getSource() == miDetalle.getBtnEditar()) {

			// Si estamos en modo Detalle (pondrá EDITAR), cambiamos a edición

			if (miDetalle.getBtnEditar().getText().equals("EDITAR")) {

				miDetalle.cambiarVistaAEdicion();

				// Si estamos en modo edición (pondrá CANCELAR y en botón ACEPTAR pondrá
				// GUARDAR), cambiamos otra vez a Detalle

			} else if ((miDetalle.getBtnEditar().getText().equals("CANCELAR"))
					&& (miDetalle.getBtnAceptar().getText().equals("GUARDAR"))) {

				miDetalle.cambiarVistaDetalle();

				// Si estamos en modo registro (pondrá CANCELAR y en botón ACEPTAR pondrá
				// REGISTRAR), cerramos la ventana y limpiamos campos

			} else if ((miDetalle.getBtnEditar().getText().equals("CANCELAR"))
					&& (miDetalle.getBtnAceptar().getText().equals("REGISTRAR"))) {

				miDetalle.limpiarCampos();
				miDetalle.setVisible(false);

			}
		}

		// ------ Botón ACEPTAR

		if (e.getSource() == miDetalle.getBtnAceptar()) {

			// Si estamos en modo Detalle, cerramos la ventana

			if (miDetalle.getBtnAceptar().getText().equals("ACEPTAR")) {

				miDetalle.setVisible(false);

				// Si estamos en modo Edición, Actualizamos la BD y cambiamos a vista Detalle

			} else if (miDetalle.getBtnAceptar().getText().equals("GUARDAR")) {

				UsuarioVO usuario = miDetalle.capturarDatosUsuario();
				String resultado = miUsuarioDTO.actualizarUsuario(usuario);
				if (resultado.equals("OK")) {

					JOptionPane.showMessageDialog(null, "Registro Actualizado");
					miDetalle.cambiarVistaDetalle();

				} else if (resultado.equals("Error")) {

					JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar");

				}
				// Si estamos en modo Registro, Insertamos en BD y cambiamos a vista Detalle

			} else if (miDetalle.getBtnAceptar().getText().equals("REGISTRAR")) {

				String resultado = "";

				if (miDetalle.comprobarCamposRellenos()) {

					UsuarioVO usuario = miDetalle.capturarDatosUsuario();
					resultado = miUsuarioDTO.registrarUsuario(usuario);

				}
				if (resultado.equals("OK")) {

					JOptionPane.showMessageDialog(null, "Registro Insertado en Base de Datos");
					miDetalle.setVisible(false);
					miDetalle.cambiarVistaDetalle();

				} else if (resultado.equals("Error")) {

					JOptionPane.showMessageDialog(null, "Ha habido un error al registrar");

				}
			}
		}

		// ---------- Botón Borrar ---------

		// Borramos el usuario de la BD, cambiamos a vista Detalle y ocultamos la vista

		if (e.getSource() == miDetalle.getBtnBorrar()) {

			int resp = JOptionPane.showOptionDialog(miVentanaAplicacion, "¿Quieres borrar el registro?", null, 0, 0,
					null, null, e);
			System.out.println(resp);

			String respuesta = "";

			if (resp == 0) {
				UsuarioVO usuario = new UsuarioVO();
				usuario = miDetalle.capturarDatosUsuario();
				if (usuario.getUser_id() > 0) {
					respuesta = miUsuarioDTO.borrarUsuario(usuario);
				} else {
					System.out.println("NO HAY USER_ID!!!!!!!");
				}
				if (respuesta.equals("OK")) {

					JOptionPane.showMessageDialog(null, "Registro Borrado");
					miDetalle.setVisible(false);
					miDetalle.limpiarCampos();
					miDetalle.cambiarVistaDetalle();

				} else if (respuesta.equals("Error")) {

					JOptionPane.showMessageDialog(null, "Ha habido un error al borrar");
				}
			}
		}

		//////////////////////////////////////////////
		// //
		// Ventana Buscar Poryectos //
		// //
		//////////////////////////////////////////////

		// -------============================================== Eventos Ventana Buscar
		// Proyectos ============================---------------------

		// Botón BUSCAR

		// Generamos la tabla con los proyectos que cumplen el criterio de busqueda,
		// comprobándolo en los campos nombre o grupo, año o curso

		if (e.getSource() == miBuscarProyectos.getBtnBuscar()) {

			System.out.println("He pulsado en buscar");
			String textoABuscar = miBuscarProyectos.getTxtBuscar().getText().trim();
			System.out.println(textoABuscar);
			ArrayList<ProyectoVO> resultadoBusqueda = miProyectoDTO.miListaProyectosFiltrada(textoABuscar);
			miBuscarProyectos.generarTabla(resultadoBusqueda);

		}

		// Botón VER DETALLE

		if (e.getSource() == miBuscarProyectos.getBtnVerDetalle()) {

			// muestra el detalle del proyecto seleccionado en la tabla

			miDetallesProyectos.cambiarVistaDetalle();

			int filaSeleccionada = miBuscarProyectos.getTblDatosProyectos().getSelectedRow();
			if (filaSeleccionada >= 0) {
				int prID = Integer.parseInt(
						(String) miBuscarProyectos.getTblDatosProyectos().getModel().getValueAt(filaSeleccionada, 0));
				miDetallesProyectos.setVisible(true);
				miDetallesProyectos.rellenarTabla(miUsuarioDTO.cargarAlumnos());
				miDetallesProyectos.mostrarProyecto(miProyectoDTO.mostrarDetalle(prID));
				miDetallesProyectos.cargarIntegrantes(miIntegrantesDTO.CargarIntegrantes(prID));

			}

		}

		// Botón CERRAR

		if (e.getSource() == miBuscarProyectos.getBtnCerrar()) {

			miBuscarProyectos.setVisible(false);

		}

		//////////////////////////////////////////////
		// //
		// Ventana Detalles Proyectos //
		// //
		//////////////////////////////////////////////

		// -------------------------------------------- Eventos ventana Detalle proyecto
		// -------------------

		// Botón Buscar

		// Generamos la tabla con los usuarios que cumplen el criterio de busqueda,
		// comprobándolo en los campos nombre o expediente

		if (e.getSource() == miDetallesProyectos.getBtnBuscar()) {

			String textoABuscar = miDetallesProyectos.getTxtBuscar().getText().trim();

			System.out.println(textoABuscar);
			ArrayList<UsuarioVO> resultadoBusqueda = miUsuarioDTO.miListaUsuariosFiltada(textoABuscar);
			miDetallesProyectos.rellenarTabla(resultadoBusqueda);

		}

		// Botón AÑADIR

		// Añadimos el alumno seleccionado a la tabla de integrantes

		if (e.getSource() == miDetallesProyectos.getBtnAñadir()) { /// Botones para añadir y quitar integrantes
			UsuarioVO integrante = null;
			;
			int alumnoSeleccionado = miDetallesProyectos.alumnoSeleccionado();

			if (alumnoSeleccionado > 0) {
				integrante = miUsuarioDTO.mostrarDetalle(alumnoSeleccionado);
			}
			if (integrante != null) {
				miDetallesProyectos.añadirIntegrante(integrante);
			}

		}

		// Botón QUITAR

		// Borramos el alumno seleccionado de la tabla de integrantes

		if (e.getSource() == miDetallesProyectos.getBtnQuitar()) {
			int integranteSeleccionado = miDetallesProyectos.integranteSeleccionado();
			miDetallesProyectos.quitarIntegrante(integranteSeleccionado);
		}

		// Botón CERRAR

		// Si en el botón pone CERRAR, ocultamos la vista y limpiamos los campos

		if (e.getSource() == miDetallesProyectos.getBtnCerrar()) {

			if (miDetallesProyectos.getBtnCerrar().getText().equals("CERRAR")) {
				miDetallesProyectos.setVisible(false);
				miDetallesProyectos.limpiarCampos();

				// Si pone actualizar, comprobamos que los campos obligatorios están rellenos y
				// actualizamos el registro del proyecto mostrado en BD

			} else if (miDetallesProyectos.getBtnCerrar().getText().equals("ACTUALIZAR")) {

				boolean camposRellenos = miDetallesProyectos.estanCamposRellenos();
				if (camposRellenos) {
					String resultadoActualizar = "";

					int idPR = Integer.parseInt(miDetallesProyectos.getTxtId().getText());
					ProyectoVO proyecto = miDetallesProyectos.getCampos();
					int[] integrantes = miDetallesProyectos.getIntegrantes();
					resultadoActualizar = miProyectoDTO.actualizarProyecto(proyecto, integrantes, idPR);

					if (resultadoActualizar.equals("OK")) {

						JOptionPane.showMessageDialog(null, "Registro Actualizado");

					} else {

						JOptionPane.showMessageDialog(null, "Algo ha fallado al actualizar");

					}
				} else {

					JOptionPane.showMessageDialog(null, "Debes rellenar los campos marcados con asterisco");

				}

				// Si pone GUARDAR, comprobamos que los campos obligatorios están rellenos y
				// insertamos el registro del proyecto en BD

			} else if ((miDetallesProyectos.getBtnCerrar().getText().equals("GUARDAR"))) {

				boolean camposRellenos = miDetallesProyectos.estanCamposRellenos();
				if (camposRellenos) {

					int[] integrantes = miDetallesProyectos.getIntegrantes();
					String proyectoAñadido = miProyectoDTO.añadirProyecto(miDetallesProyectos.getCampos(), integrantes);

					if (proyectoAñadido.equals("OK")) {
						JOptionPane.showMessageDialog(null, "Proyecto añadido");
					} else {
						JOptionPane.showMessageDialog(null, "Algo ha ido mal. Proyecto no añadido a DB");
					}
				} else {

					JOptionPane.showMessageDialog(null, "Debes rellenar los campos marcados con asterisco");

				}
			}

		}

		// Botón EDITAR

		// Si pone EDITAR, cambiamos a modo de edición

		if (e.getSource() == miDetallesProyectos.getBtnEditar()) {

			if (miDetallesProyectos.getBtnEditar().getText().equals("EDITAR")) {
				miDetallesProyectos.cambiarVistaAEdicion();
			}

			// Si pone CANCELAR y en BOTON CERRAR pone ACTUALIZAR cambiamos a vista ddetalle

			else if ((miDetallesProyectos.getBtnEditar().getText().equals("CANCELAR"))
					&& (miDetallesProyectos.getBtnCerrar().getText().equals("ACTUALIZAR"))) {
				miDetallesProyectos.cambiarVistaDetalle();

				// Si pone CANCELAR y en BOTON CERRAR pone ACTUALIZAR ocultamos la vista

			} else if ((miDetallesProyectos.getBtnEditar().getText().equals("CANCELAR"))
					&& (miDetallesProyectos.getBtnCerrar().getText().equals("GUARDAR"))) {
				miDetallesProyectos.setVisible(false);
			}

		}

		// Botón BORRAR

		// Borramos el proyecto mostrado de la BD

		if (e.getSource() == miDetallesProyectos.getBtnBorrar()) {

			int resp = JOptionPane.showOptionDialog(miVentanaAplicacion, "¿Quieres borrar el registro?", null, 0, 0,
					null, null, e);
			System.out.println(resp);

			String respuesta = "";

			if (resp == 0) {

				int idPR = Integer.parseInt(miDetallesProyectos.getTxtId().getText());
				String resultado = miProyectoDTO.borrarProyecto(idPR);
				if (resultado.equals("OK")) {
					JOptionPane.showMessageDialog(null, "Proyecto borrado");
					miDetallesProyectos.limpiarCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Algo ha ido mal");
				}

			}

		}

		// ----------------------- Eventos Ventana Detalles Areas --------------------

		//////////////////////////////////////////////
		// //
		// Ventana Detalles Areas //
		// //
		//////////////////////////////////////////////

		if (e.getSource() == miDetallesAreas.getBtnSalir()) {

			miDetallesAreas.setVisible(false);

		}

	} /// Cierre del ActionPerformed

	// ------------------------------------------------ Métodos Ventana Login
	// -----------------------------------

	/**
	 * Método para que si hay un campo vacio en el login no le deje inciar sesion y
	 * le obligue a rellenar todos los campo de forma correcta
	 * 
	 * @param usuarioLogeando
	 * @param resp
	 */
	private void comprobarRespuesta(UsuarioVO usuarioLogeando, String resp) {
		if (resp.equals("Logged")) {

			System.out.println("usuario logeado");
			JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioLogeando.getNick_name());

			miVentanaAplicacion.getSideBar().getLblUsuario().setText(miVentanaLogin.getTxtUser().getText());
			miVentanaLogin.dispose();

		} else if (resp.equals("faltan campos")) {

			JOptionPane.showMessageDialog(null, "Debes rellenar ambos campos", "Campos sin rellenar",
					JOptionPane.WARNING_MESSAGE);
			System.out.println("rellenar todos los campos");
		} else if (resp.equals("Error")) {

			JOptionPane.showMessageDialog(null, "Fallo en la base de datos");
			System.out.println("Excepción en DB");

		} else {

			JOptionPane.showMessageDialog(null, "Credenciales no válidas");
			System.out.println("usuario no encontrado");
		}

		System.out.println(Coordinador.esProfesor);
		if (!Coordinador.esProfesor) {
			vistaAlumnos();
		} else {
			vistaProfesor();
		}
	}

	// Métodos que manejan lo que pueden ven los alumnos y los profesores
	// -----------------------------------------------------

	/**
	 * Método que maneja lo que pueden ver los profesores
	 */
	private void vistaProfesor() {

		miVentanaAplicacion.getPestañaProyectos().getLblConsulta().setText("CONSULTAR/EDITAR PROYECTOS");
		miVentanaAplicacion.getPestañaProyectos().getLblDarDeAlta().setVisible(true);
		miVentanaAplicacion.getPestañaProyectos().getBtnAlta().setVisible(true);

		miVentanaAplicacion.getPestañaAlumnos().getLblConsulta().setText("CONSULTAR/EDITAR USUARIOS");
		miVentanaAplicacion.getPestañaAlumnos().getLblDarDeAlta().setVisible(true);

		miVentanaAplicacion.getPestañaAlumnos().getBtnAlta().setVisible(true);

		// miVentanaAplicacion.getPestañaAreas().setVisible(true);

	}

	/**
	 * Método que maneja lo que pueden ver los profesores
	 */
	private void vistaAlumnos() {

		miVentanaAplicacion.getPestañaProyectos().getLblConsulta().setText("CONSULTAR PROYECTOS");
		miVentanaAplicacion.getPestañaProyectos().getBtnConsulta().setText("CONSULTAR PROYECTOS");
		miVentanaAplicacion.getPestañaProyectos().getLblDarDeAlta().setVisible(false);
		miVentanaAplicacion.getPestañaProyectos().getBtnAlta().setVisible(false);

		miVentanaAplicacion.getPestañaAlumnos().getLblConsulta().setText("CONSULTAR/EDITAR MI PERFIL");
		miVentanaAplicacion.getPestañaAlumnos().getBtnConsulta().setText("CONSULTAR/EDITAR");
		miVentanaAplicacion.getPestañaAlumnos().getLblDarDeAlta().setVisible(false);

		miVentanaAplicacion.getPestañaAlumnos().getBtnAlta().setVisible(false);

		// miVentanaAplicacion.getPestañaAreas().setVisible(false);

	}

	// ------------------------------

	/**
	 * Método por el cual reconoce cuando una tecla ha sido escrita por asi decirlo
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Método que reconoce cuando una tecla ha sido presionada
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Método que reconoce cuando has dejado de presionar una tecla
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Método que carga los alumnos en un arraylist con los datos de UsuarioVO
	 * 
	 * @return cargarAlumnos
	 */
	public ArrayList<UsuarioVO> cargarAlumnos() {
		return miUsuarioDTO.cargarAlumnos();
		// TODO Auto-generated method stub

	}

	/**
	 * Método para que se rellene el ArrayList con lo que hay en AreaDTO
	 * 
	 * @return
	 */
	public ArrayList<String> rellenarComboAreas() {

		return miAreaDTO.rellenarComboAreas();
	}

	/**
	 * Método para que nos devuelva el id de areas
	 * 
	 * @param nombre_corto
	 * @return devolverIdArea
	 */
	public int devolverIdArea(String nombre_corto) {
		// TODO Auto-generated method stub
		return miAreaDTO.devolverIdArea(nombre_corto);
	}

	/**
	 * Método para que nos devuelva el nombre corto del area
	 * 
	 * @param area
	 * @return devolverNombreCortoArea
	 */
	public String devolverArea(int id_area) {

		return miAreaDTO.devolverNombreCortoArea(id_area);
	}

	// ------------- Método para escuchar a los ComboBox

	/**
	 * Método para escuchar a los ComboBox
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {

		AreaVO area = miAreaDTO.devolverArea((String) miDetallesAreas.getCmbAreas().getSelectedItem());
		miDetallesAreas.rellenarCampos(area);

	}

}
