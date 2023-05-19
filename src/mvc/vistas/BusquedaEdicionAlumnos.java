package mvc.vistas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

import mvc.controlador.Coordinador;
import mvc.modelo.vo.UsuarioVO;

import java.awt.Component;

/**
 * @author Mario
 *
 */
public class BusquedaEdicionAlumnos extends JDialog {

	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JTable tblDatosAlumnos;
	private JScrollPane scrPn;
	private JButton btnVerDetalle;
	private JButton btnBuscar;

	private String[] cabeceraTabla = { "Identificador de Usuario", "Nombre", "Nº de Expediente" };

	private Coordinador miCoordinador;
	private JButton btnCerrar;

	/**
	 * Constructor de la clase
	 * 
	 * @param parent
	 * @param modal
	 */
	public BusquedaEdicionAlumnos(Frame parent, boolean modal) {

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

		scrPn = new JScrollPane(tblDatosAlumnos);
		scrPn.setBounds(30, 81, 436, 346);
		getContentPane().add(scrPn);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(357, 29, 109, 29);
		getContentPane().add(btnBuscar);

		btnCerrar = new JButton("CERRAR");
		btnCerrar.setBounds(341, 450, 125, 35);
		getContentPane().add(btnCerrar);

	}

	// ------------------------------------------------------------ Getters y
	// Setters ----------------------------------------------

	/**
	 * getter del BtnBuscar
	 * 
	 * @return btnBuscar
	 */
	public JButton getBtnBuscar() {

		return btnBuscar;
	}

	/**
	 * getter del BtnDetalle
	 * 
	 * @return btnVerDetalle
	 */
	public JButton getBtnDetalle() {

		return btnVerDetalle;
	}

	/**
	 * getter de TxtBuscar
	 * 
	 * @return txtBuscar
	 */
	public JTextField getTxtBuscar() {
		// TODO Auto-generated method stub
		return txtBuscar;
	}

	/**
	 * getter de TablaAlunmos
	 * 
	 * @return tblDatosalumnos
	 */
	public JTable getTablaAlunmos() {
		return tblDatosAlumnos;
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
	 * Método que añade listeners a los botones del formulario
	 * 
	 * @param miCoordinador
	 */
	public void setListeners(Coordinador miCoordinador) { // Añadimos Listeners a los botones del formulario

		btnBuscar.addActionListener(miCoordinador);
		btnVerDetalle.addActionListener(miCoordinador);
		btnCerrar.addActionListener(miCoordinador);

	}

	/**
	 * Método para tener una instancia del coordinador
	 * 
	 * @param miCoordinador
	 */
	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;

	}

	// ------------------------------------- Método que genera y nos inserta la
	// tabla de resultados de la búsqueda -----------------------------------------

	/**
	 * Método que genera y nos inserta la tabla de resultados de la búsqueda
	 * 
	 * @param resultadoBusqueda
	 */
	public void generarTabla(ArrayList<UsuarioVO> resultadoBusqueda) {

		Object[][] alumnos = new String[resultadoBusqueda.size()][3];

		for (int i = 0; i < resultadoBusqueda.size(); i++) {

			alumnos[i][0] = resultadoBusqueda.get(i).getUser_id() + "";
			alumnos[i][1] = resultadoBusqueda.get(i).getNombre();
			alumnos[i][2] = resultadoBusqueda.get(i).getExpediente();

		}

		tblDatosAlumnos = new JTable(alumnos, cabeceraTabla);
		scrPn.setViewportView(tblDatosAlumnos);

	}

}
