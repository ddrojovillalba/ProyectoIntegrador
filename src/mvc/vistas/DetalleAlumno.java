package mvc.vistas;

import javax.swing.*;

import mvc.controlador.Coordinador;
import mvc.modelo.vo.UsuarioVO;

import java.awt.event.*;
import java.awt.*;

/**
 * @author Mario
 *
 */
public class DetalleAlumno extends JDialog {

	private JLabel lblDetalles;
	private JTextField txtNombre;
	private JTextField txtExpediente;
	private JTextField txtNick_user;
	private JPasswordField txtPassword;

	private JLabel lblNombreAlumno;
	private JLabel lblExpediente;
	private JLabel lblNick_user;
	private JLabel lblPassword;
	private JLabel lblEsProfesor;

	private ButtonGroup btnGroup;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnAlumno;

	private JButton btnAceptar;
	private JButton btnEditar;
	JButton btnBorrar;

	private Coordinador miCoordinador;
	private JTextField textId;

	/**
	 * constructor de la clase
	 * 
	 * @param miBuscarAlumnos
	 */
	public DetalleAlumno(BusquedaEdicionAlumnos miBuscarAlumnos) {
		super(miBuscarAlumnos);
		getContentPane().setForeground(new Color(0, 0, 255));
		setSize(520, 449);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		inicializarComponentes();
	}

	/**
	 * Método para crear y hacer visible el contenido de la vista
	 */
	private void inicializarComponentes() {
		getContentPane().setLayout(null);

		lblDetalles = new JLabel("Detalle Alumno");
		lblDetalles.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDetalles.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDetalles.setBounds(6, 25, 160, 32);
		getContentPane().add(lblDetalles);

		lblNombreAlumno = new JLabel("Nombre");
		lblNombreAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreAlumno.setBounds(6, 96, 160, 25);
		getContentPane().add(lblNombreAlumno);

		lblExpediente = new JLabel("Número de expediente");
		lblExpediente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpediente.setBounds(6, 146, 160, 25);
		getContentPane().add(lblExpediente);

		lblNick_user = new JLabel("Nombre Usuario");
		lblNick_user.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNick_user.setBounds(6, 196, 160, 25);
		getContentPane().add(lblNick_user);

		lblEsProfesor = new JLabel("Perfil");
		lblEsProfesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEsProfesor.setBounds(6, 312, 160, 25);
		getContentPane().add(lblEsProfesor);

		txtNombre = new JTextField();
		txtNombre.setBounds(205, 96, 255, 25);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtExpediente = new JTextField();
		txtExpediente.setColumns(10);
		txtExpediente.setBounds(205, 145, 255, 25);
		getContentPane().add(txtExpediente);

		txtNick_user = new JTextField();
		txtNick_user.setColumns(10);
		txtNick_user.setBounds(205, 195, 255, 25);
		getContentPane().add(txtNick_user);

		txtPassword = new JPasswordField();
		txtPassword.setBackground(new Color(240, 255, 255));
		txtPassword.setBounds(205, 245, 255, 26);
		txtPassword.setEditable(false);
		getContentPane().add(txtPassword);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(343, 366, 117, 29);
		getContentPane().add(btnAceptar);

		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(223, 366, 117, 29);
		getContentPane().add(btnEditar);

		lblPassword = new JLabel("Contraseña");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(6, 246, 160, 25);
		getContentPane().add(lblPassword);

		btnGroup = new ButtonGroup();

		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setBounds(199, 312, 100, 23);
		getContentPane().add(rdbtnProfesor);

		rdbtnAlumno = new JRadioButton("Alumno");
		rdbtnAlumno.setBounds(360, 312, 100, 23);
		getContentPane().add(rdbtnAlumno);

		btnGroup.add(rdbtnAlumno);
		btnGroup.add(rdbtnProfesor);

		JLabel lblIdLabel = new JLabel("Nº de ID");
		lblIdLabel.setBounds(260, 25, 94, 25);
		getContentPane().add(lblIdLabel);

		textId = new JTextField();
		textId.setBackground(new Color(240, 255, 255));
		textId.setEditable(false);
		textId.setBounds(330, 25, 130, 26);
		getContentPane().add(textId);
		textId.setColumns(10);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(18, 366, 117, 29);
		getContentPane().add(btnBorrar);

	}

	/////// --------------------------------------- Getters y Setters
	/////// ---------------------------------------------

	/**
	 * getter del TxtNombre
	 * 
	 * @return txtnombre
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * getter del TxtExpediente
	 * 
	 * @return txtExpediente
	 */
	public JTextField getTxtExpediente() {
		return txtExpediente;
	}

	/**
	 * getter del TxtNick_user
	 * 
	 * @return txtNick_user
	 */
	public JTextField getTxtNick_user() {
		return txtNick_user;
	}

	/**
	 * getter del TxtPassword
	 * 
	 * @return txtPassword
	 */
	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	/**
	 * getter del BtnGroup
	 * 
	 * @return btnGroup
	 */
	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}

	/**
	 * getter del RdbtnProfesor
	 * 
	 * @return rdbtnProfesor
	 */
	public JRadioButton getRdbtnProfesor() {
		return rdbtnProfesor;
	}

	/**
	 * getter del RdbtnAlumno
	 * 
	 * @return rdbtnAlumno
	 */
	public JRadioButton getRdbtnAlumno() {
		return rdbtnAlumno;
	}

	/**
	 * getter del TxtId
	 * 
	 * @return textId
	 */
	public JTextField getTextId() {
		return textId;
	}

	/**
	 * getter del BtnAceptar
	 * 
	 * @return btnAceptar
	 */
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	/**
	 * getter del BtnEditar
	 * 
	 * @return
	 */
	public JButton getBtnEditar() {
		return btnEditar;
	}

	/**
	 * getter del BtnBorrar
	 * 
	 * @return btnBorrar
	 */
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	/**
	 * Método para tener una instancia del coordinador
	 * 
	 * @param miCoordinador
	 */
	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;

	}

	/**
	 * Método para añadir Listenrs a los botones del formulario
	 * 
	 * @param miCoordinador
	 */
	public void setListeners(Coordinador miCoordinador) {

		btnAceptar.addActionListener(miCoordinador);
		btnEditar.addActionListener(miCoordinador);
		btnBorrar.addActionListener(miCoordinador);

	}

// --------------------------- Métodos para cambiar aspecto de la Ventana para reutilizarla al mostrar, editar o registrar ----------------------

	/**
	 * Método para cambiar el aspecto de la Ventana para reutilizarla al editar
	 */
	public void cambiarVistaAEdicion() {

		btnAceptar.setText("GUARDAR");
		txtPassword.setEditable(true);
		btnEditar.setText("CANCELAR");
		btnBorrar.setVisible(true);
		btnBorrar.setVisible(true);
		txtExpediente.setEnabled(true);
		rdbtnProfesor.setEnabled(true);

	}

	/**
	 * Métodos para cambiar aspecto de la Ventana para reutilizarla al mostrar
	 */
	public void cambiarVistaDetalle() {

		btnAceptar.setText("ACEPTAR");
		txtPassword.setEditable(false);
		btnEditar.setText("EDITAR");
		btnBorrar.setVisible(false);

	}

	/**
	 * Métodos para cambiar aspecto de la Ventana para reutilizarla al registrar
	 */
	public void modoRegistro() {

		btnAceptar.setText("REGISTRAR");
		txtPassword.setEditable(true);
		btnEditar.setText("CANCELAR");
		btnBorrar.setVisible(false);
		txtExpediente.setEnabled(true);
		rdbtnProfesor.setEnabled(true);

		limpiarCampos();

	}

	/**
	 * Método para que se desactiven ciertos botones para la vista de alumno
	 */
	public void VistaAlumno() {

		btnBorrar.setVisible(false);
		txtExpediente.setEnabled(false);
		rdbtnProfesor.setEnabled(false);
		btnEditar.setEnabled(false);

	}

	// -------------------------------------------- Método que recibe un UsuaroVo
	// para mostrárnoslo en el formulario ---------------------------------

	/**
	 * Método que recibe un UsuaroVo para mostrárnoslo en el formulario
	 * 
	 * @param usuario
	 */
	public void mostrarUsuario(UsuarioVO usuario) {

		int id = usuario.getUser_id();
		String name = usuario.getNombre();
		String expediente = usuario.getExpediente();
		String nick = usuario.getNick_name();
		String password = usuario.getPassword();

		getTextId().setText(id + "");
		getTxtNombre().setText(name);
		getTxtExpediente().setText(expediente);
		getTxtNick_user().setText(nick);
		getTxtPassword().setText(password);
		if (usuario.getIs_teacher()) {

			rdbtnProfesor.setSelected(true);

		} else {

			rdbtnAlumno.setSelected(true);

		}
	}

	/**
	 * Método que limpia el formulario
	 */
	public void limpiarCampos() {

		txtNombre.setText("");
		txtExpediente.setText("");
		txtNick_user.setText("");
		txtPassword.setText("");
		textId.setText("");
		textId.setEditable(false);
		rdbtnAlumno.setSelected(false);
		rdbtnProfesor.setSelected(false);
	}

	// ------------------------ Método que coge los datos del formulario, los
	// encapsula en un objeto UsuarioVO y nos devuelve ese objeto -------------

	/**
	 * Método que coge los datos del formulario, los encapsula en un objeto
	 * UsuarioVO y nos devuelve ese objeto
	 * 
	 * @return usuario
	 */
	public UsuarioVO capturarDatosUsuario() {

		UsuarioVO usuario = new UsuarioVO();

		// -------------------- Si el campo ID está vació, es porque estamos registrando
		// un nuevo usuario, y lo obviamos -----------------------------

		if (!textId.getText().equals("")) {
			usuario.setUser_id(Integer.parseInt(textId.getText()));
		}
		usuario.setNombre(txtNombre.getText());
		usuario.setExpediente(txtExpediente.getText());
		usuario.setPassword(txtPassword.getText());
		usuario.setNick_name(txtNick_user.getText());

		if (rdbtnProfesor.isSelected()) {
			usuario.setIs_teacher("1");
		} else {
			usuario.setIs_teacher("0");
		}

		return usuario;
	}

	// -------------------------------- Método que limpia el formulario
	// ----------------------------

	/**
	 * Método que comprueba si todos los campos han sido rellenados
	 * 
	 * @return camposTexto && perfilRelleno
	 */
	public boolean comprobarCamposRellenos() {
		// TODO Auto-generated method stub
		boolean perfilRelleno = ((rdbtnAlumno.isSelected()) || (rdbtnProfesor.isSelected()));
		boolean camposTexto = (txtNombre.getText().equals("") || txtExpediente.getText().equals("")
				|| txtNick_user.getText().equals("") || txtPassword.getText().equals(""));

		if (!perfilRelleno) {

			JOptionPane.showMessageDialog(null, "Debe selecionar el perfil", "Atención", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (camposTexto) {

			JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Atención",
					JOptionPane.WARNING_MESSAGE);
			return false;

		}
		if (!camposTexto && perfilRelleno) {

			return true;
		}

		return (camposTexto && perfilRelleno);
	}

}
