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

	

	
	
	
	public DetalleAlumno(BusquedaEdicionAlumnos miBuscarAlumnos) {
		super(miBuscarAlumnos);
		getContentPane().setForeground(new Color(0, 0, 255));
		setSize(520,449);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		inicializarComponentes();
	}

	



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

	
		
	/////// --------------------------------------- Getters y Setters ---------------------------------------------	
	

	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public JTextField getTxtExpediente() {
		return txtExpediente;
	}


	public JTextField getTxtNick_user() {
		return txtNick_user;
	}



	public JPasswordField getTxtPassword() {
		return txtPassword;
	}


	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}



	public JRadioButton getRdbtnProfesor() {
		return rdbtnProfesor;
	}



	public JRadioButton getRdbtnAlumno() {
		return rdbtnAlumno;
	}



	public JTextField getTextId() {
		return textId;
	}


	public JButton getBtnAceptar() {
		return btnAceptar;
	}


	public JButton getBtnEditar() {
		return btnEditar;
	}
	
	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}


	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
		
	}


	public void setListeners(Coordinador miCoordinador) {
		

		btnAceptar.addActionListener(miCoordinador);
		btnEditar.addActionListener(miCoordinador);
		btnBorrar.addActionListener(miCoordinador);
		
		
	}


// --------------------------- Métodos para cambiar aspecto de la Ventana para reutilizarla al mostrar, editar o registrar ----------------------


	public void cambiarVistaAEdicion() {
		
		btnAceptar.setText("GUARDAR");
		txtPassword.setEditable(true);
		btnEditar.setText("CANCELAR");
		btnBorrar.setVisible(true);
		btnBorrar.setVisible(true);
		txtExpediente.setEnabled(true);
		rdbtnProfesor.setEnabled(true);
		
		
	}


	public void cambiarVistaDetalle() {
		
		btnAceptar.setText("ACEPTAR");
		txtPassword.setEditable(false);
		btnEditar.setText("EDITAR");
		btnBorrar.setVisible(false);
		
		
	}


	public void modoRegistro() {
		
		btnAceptar.setText("REGISTRAR");
		txtPassword.setEditable(true);
		btnEditar.setText("CANCELAR");
		btnBorrar.setVisible(false);
		txtExpediente.setEnabled(true);
		rdbtnProfesor.setEnabled(true);
		
		limpiarCampos();

	}
	
	
	public void VistaAlumno() {

		btnBorrar.setVisible(false);
		txtExpediente.setEnabled(false);
		rdbtnProfesor.setEnabled(false);
		btnEditar.setEnabled(false);
		
	}

	// ------------------------ Método que coge los datos del formulario, los encapsula en un objeto UsuarioVO y nos devuelve ese objeto -------------
	

	public UsuarioVO capturarDatosUsuario() {
		
		UsuarioVO usuario = new UsuarioVO();
		
		// -------------------- Si el campo ID está vació, es porque estamos registrando un nuevo usuario, y lo obviamos -----------------------------
		
		if (!textId.getText().equals("")) {       
			usuario.setUser_id(Integer.parseInt(textId.getText()));
		}
		usuario.setNombre(txtNombre.getText());
		usuario.setExpediente(txtExpediente.getText());
		usuario.setPassword(txtPassword.getText());
		usuario.setNick_name(txtNick_user.getText());
		
		if (rdbtnProfesor.isSelected()) {
			usuario.setIs_teacher("1");
		}else {
			usuario.setIs_teacher("0");
		}
		
		return usuario;
	}

	
	// -------------------------------------------- Método que recibe un UsuaroVo para mostrárnoslo en el formulario ---------------------------------
	

	public void mostrarUsuario(UsuarioVO usuario) {
		
		int id=usuario.getUser_id();
		String name=usuario.getNombre();
		String expediente=usuario.getExpediente();
		String nick=usuario.getNick_name();
		String password=usuario.getPassword();
		
		
		System.out.println(name);
		System.out.println(expediente);
		System.out.println(nick);
		System.out.println(password);
		
		
		getTextId().setText(id+"");
		getTxtNombre().setText(name);
		getTxtExpediente().setText(expediente);
		getTxtNick_user().setText(nick);
		getTxtPassword().setText(password);
		if (usuario.getIs_teacher()) {
			
			rdbtnProfesor.setSelected(true);
						
		}else{
			
			rdbtnAlumno.setSelected(true);
			
		}
	}
	
	
	// -------------------------------- Método que limpia el formulario ----------------------------

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





	public boolean comprobarCamposRellenos() {
		// TODO Auto-generated method stub
		boolean perfilRelleno = ((rdbtnAlumno.isSelected()) || (rdbtnProfesor.isSelected()));
		boolean camposTexto = (txtNombre.getText().equals("") || txtExpediente.getText().equals("") || txtNick_user.getText().equals("") ||
				txtPassword.getText().equals("")); 
		
		if (!perfilRelleno) {
			
			JOptionPane.showMessageDialog(null, "Debe selecionar el perfil", "Atención", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (camposTexto) {
			
			JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Atención", JOptionPane.WARNING_MESSAGE);
			return false;
			
		}
		if (!camposTexto && perfilRelleno) {
			
			return true;
		}
		
		
		
		return (camposTexto && perfilRelleno);
	}








}




