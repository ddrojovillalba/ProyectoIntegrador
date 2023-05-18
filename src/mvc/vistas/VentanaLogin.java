
package mvc.vistas;


import javax.swing.*;


import java.awt.*;
import java.awt.event.*;



import mvc.controlador.*;
import mvc.modelo.vo.UsuarioVO;
/**
 *
 * @author estudio
 */

public class VentanaLogin extends JDialog {

    /**
     * Creates new form VentanaLogins
     */
	
    private JButton btnLogin;
    private JButton btnSalir;
    private JPanel loginPanel;
    private JLabel lblLogin;
    private JLabel lblUser;
    private JLabel lblPassword;
    private JPasswordField txtPass;
    private JTextField txtUser;
	private Coordinador miCoordinador; 
	
		
	
    public VentanaLogin(Frame parent, boolean modal) {
    	
    	super(parent, modal);
    	
    	setSize(460, 432);
        setLocationRelativeTo(null);
        initComponents();
      
    }

   
    private void initComponents() {
    	
    	

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(460,460);

    	

        loginPanel = new JPanel();
        lblLogin = new JLabel("LOGIN");
        lblUser = new JLabel("Usuario");
        lblPassword = new JLabel("Contraseña");
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btnLogin = new JButton("LOGIN");
        btnSalir = new JButton("Salir");

        loginPanel.setLayout(null);

        lblLogin.setFont(new Font("Helvetica Neue", 0, 36));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(lblLogin);
        lblLogin.setBounds(0, 40, 460, 30);

        lblUser.setHorizontalAlignment(SwingConstants.TRAILING);
        loginPanel.add(lblUser);
        lblUser.setBounds(40, 130, 90, 30);

        lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
        loginPanel.add(lblPassword);
        lblPassword.setBounds(40, 170, 90, 30);
        
        loginPanel.add(txtUser);
        txtUser.setBounds(170, 130, 180, 30);
        loginPanel.add(txtPass);
        txtPass.setBounds(170, 170, 180, 30);

        btnLogin.setFont(new Font("Helvetica Neue", 0, 18)); 
        btnLogin.setText("LOGIN");
        btnLogin.setBounds(122, 230, 180, 60);
        loginPanel.add(btnLogin);
        

        btnSalir.setIcon(new ImageIcon(VentanaLogin.class.getResource("/main/imagenes/iconoSalir.png")));
        btnSalir.setBounds(292, 312, 90, 65);
        loginPanel.add(btnSalir);
        
        

        getContentPane().add(loginPanel);
        loginPanel.setBounds(0, 0, 460, 426);


    }


		
	// ------------------------------------------------------ Getters y Setters ---------------------------------------------


	public JButton getBtnLogin() {
		return btnLogin;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}


	public JPasswordField getTxtPass() {
		return txtPass;
	}


	public void setTxtPass(JPasswordField txtPass) {
		this.txtPass = txtPass;
	}


	public JTextField getTxtUser() {
		return txtUser;
	}


	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
	}

	public void setListener(Coordinador miCoordinador) {
		
		btnLogin.addActionListener(miCoordinador);
		btnSalir.addActionListener(miCoordinador);
	}

	
	// -------------------------- Método que devuelve los datos del formulario Login encapsulados en un UsuarioVO ----------------------------------

	public UsuarioVO cargarDatosLogin() {
		
		UsuarioVO usuarioLogin= new UsuarioVO();
		usuarioLogin.setNick_name(getTxtUser().getText().trim());
		usuarioLogin.setPassword(getTxtPass().getText().trim());
		
		return usuarioLogin;
		
	}
}
