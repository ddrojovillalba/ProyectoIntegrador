/**
 * 
 */
package mvc.vistas;

import mvc.controlador.Coordinador;
import mvc.modelo.vo.ProyectoVO;
import mvc.modelo.vo.UsuarioVO;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Mario
 *
 */
public class BuscarProyectos extends JDialog {

	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JTable tblDatosProyectos;
	private JScrollPane scrPn;
	private JButton btnVerDetalle;
	private JButton btnBuscar;

	private String[] cabeceraTabla = { "ID Proyecto", "Nombre", "Area", "Curso" };

	private Coordinador miCoordinador;
	private JButton btnCerrar;

	/**
	 * Constructor de la clase
	 * 
	 * @param parent
	 * @param modal
	 */
	public BuscarProyectos(Frame parent, boolean modal) {

		super(parent, modal);
		setSize(500, 555);
		setLocationRelativeTo(null);
		inicializarComponentes();

	}

	/**
	 * Método para añadir y crear los componentes de la vista
	 */
	private void inicializarComponentes() {
		getContentPane().setLayout(null);

		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(30, 30, 65, 25);
		lblBuscar.setHorizontalAlignment(SwingConstants.TRAILING);
		getContentPane().add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtBuscar.setBounds(107, 29, 250, 25);
		txtBuscar.setHorizontalAlignment(SwingConstants.LEADING);

		getContentPane().add(txtBuscar);

		btnVerDetalle = new JButton("VER DETALLE");
		btnVerDetalle.setBounds(30, 450, 125, 35);
		getContentPane().add(btnVerDetalle);

		scrPn = new JScrollPane(tblDatosProyectos);
		scrPn.setBounds(30, 81, 436, 346);
		getContentPane().add(scrPn);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(357, 29, 109, 29);
		getContentPane().add(btnBuscar);

		btnCerrar = new JButton("CERRAR");
		btnCerrar.setBounds(341, 450, 125, 35);
		getContentPane().add(btnCerrar);

	}

	// --------------------------------------------getters y
	// setter---------------------------------

	/**
	 * getter del TxtBuscar
	 * 
	 * @return txtBuscar
	 */
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	/**
	 * getter del TblDatosProyectos
	 * 
	 * @return tblDatosProyectos
	 */
	public JTable getTblDatosProyectos() {
		return tblDatosProyectos;
	}

	/**
	 * getter del BtnDetalle
	 * 
	 * @return btnVerDetalle
	 */
	public JButton getBtnVerDetalle() {
		return btnVerDetalle;
	}

	/**
	 * getetr del BtnBuscar
	 * 
	 * @return btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/**
	 * getter del BtnCerrar
	 * 
	 * @return btnCerrar
	 */
	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	/**
	 * Setter de los Listeners de los botones del formulario
	 * 
	 * @param miCoordinador
	 */
	public void setListeners(Coordinador miCoordinador) { // Añadimos Listeners a los botones del formulario

		btnBuscar.addActionListener(miCoordinador);
		btnVerDetalle.addActionListener(miCoordinador);
		btnCerrar.addActionListener(miCoordinador);

	}

	/**
	 * Método para tenr una instancia del coordinador
	 * 
	 * @param miCoordinador
	 */
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}

	// ------------------------------------- Método que genera y nos inserta en la
	// tabla de resultados de la búsqueda -----------------------------------------

	/**
	 * Método que genera y nos inserta en la tabla de resultados de la búsqueda
	 * 
	 * @param resultadoBusqueda
	 */
	public void generarTabla(ArrayList<ProyectoVO> resultadoBusqueda) {

		Object[][] alumnos = new String[resultadoBusqueda.size()][4]; /// CAMBIAR TAMAÑO DE LA TABLA EN FUNCION DEL
																		/// NUMERO DE CAMPOS

		for (int i = 0; i < resultadoBusqueda.size(); i++) {

			alumnos[i][0] = resultadoBusqueda.get(i).getIdProyecto() + "";
			alumnos[i][1] = resultadoBusqueda.get(i).getNombreProyecto();
			String area = miCoordinador.devolverArea(resultadoBusqueda.get(i).getArea());
			alumnos[i][2] = area;
			alumnos[i][3] = resultadoBusqueda.get(i).getCurso();

		}

		tblDatosProyectos = new JTable(alumnos, cabeceraTabla);
		scrPn.setViewportView(tblDatosProyectos);

	}
}