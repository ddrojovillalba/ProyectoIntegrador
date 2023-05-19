package mvc.vistas;

import java.awt.*;

import javax.swing.*;

import mvc.controlador.Coordinador;

/**
 * @author Mario
 *
 */
public class SideBar extends JPanel {

	private JButton btnProyectos;
	private JButton btnSalir;
	private JButton btnAlumnos;
	private JButton btnAreas;
	private JButton btnAyuda;
	private JButton btnAcercaDe;
	private JLabel lblLogo;
	private JLabel lblUsuario;

	/**
	 * Constructor en el que se han creado/añadido los elementos necesarios en la
	 * vista
	 */
	public SideBar() {
		this.setBackground(new Color(0, 0, 153));
		this.setBounds(16, 16, 190, 531);
		this.setLayout(null);

		lblUsuario = new JLabel();
		lblUsuario.setForeground(new Color(255, 255, 0));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUsuario.setBounds(16, 16, 153, 30);
		this.add(lblUsuario);

		btnProyectos = new JButton("PROYECTOS");
		btnProyectos.setFont(new Font("Arial", Font.PLAIN, 13));
		btnProyectos.setForeground(new Color(255, 255, 0));
		btnProyectos.setBorderPainted(false);
		btnProyectos.setOpaque(true);
		btnProyectos.setBackground(new Color(0, 51, 255));
		btnProyectos.setBounds(20, 190, 132, 29);
		this.add(btnProyectos);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.black);
		btnSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/main/imagenes/iconoSalir.png")));
		btnSalir.setBounds(24, 464, 120, 50);
		this.add(btnSalir);

		btnAlumnos = new JButton("ALUMNOS");
		btnAlumnos.setOpaque(true);
		btnAlumnos.setForeground(Color.YELLOW);
		btnAlumnos.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAlumnos.setBorderPainted(false);
		btnAlumnos.setBackground(new Color(0, 51, 255));
		btnAlumnos.setBounds(20, 245, 132, 29);

		this.add(btnAlumnos);

		btnAreas = new JButton("AREAS");
		btnAreas.setOpaque(true);
		btnAreas.setForeground(Color.YELLOW);
		btnAreas.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAreas.setBorderPainted(false);
		btnAreas.setBackground(new Color(0, 51, 255));
		btnAreas.setBounds(20, 300, 132, 29);

		this.add(btnAreas);

		btnAyuda = new JButton("AYUDA");

		btnAyuda.setOpaque(true);
		btnAyuda.setForeground(Color.YELLOW);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBackground(new Color(0, 51, 255));
		btnAyuda.setBounds(20, 355, 132, 29);
		this.add(btnAyuda);

		btnAcercaDe = new JButton("ACERCA DE...");
		btnAcercaDe.setOpaque(true);
		btnAcercaDe.setForeground(Color.YELLOW);
		btnAcercaDe.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAcercaDe.setBorderPainted(false);
		btnAcercaDe.setBackground(new Color(0, 51, 255));
		btnAcercaDe.setBounds(20, 410, 132, 29);
		this.add(btnAcercaDe);

		lblLogo = new JLabel("");
		lblLogo.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFocusable(false);
		lblLogo.setIconTextGap(0);
		lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/main/imagenes/logo.png")));
		lblLogo.setBounds(0, 58, 178, 106);
		this.add(lblLogo);

	}

	/**
	 * getetr del LblUsuario
	 * 
	 * @return lblUsuario
	 */
	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	/**
	 * getter del BtnProyectos
	 * 
	 * @return btnProyectos
	 */
	public JButton getBtnProyectos() {
		return btnProyectos;
	}

	/**
	 * getter del BtnSalir
	 * 
	 * @return btnSalir
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * getter del BtnAlumnos
	 * 
	 * @return btnSlumnos
	 */
	public JButton getBtnAlumnos() {
		return btnAlumnos;
	}

	/**
	 * getter del BtnAreas
	 * 
	 * @return btnAreas
	 */
	public JButton getBtnAreas() {
		return btnAreas;
	}

	/**
	 * getter del BtnAyuda
	 * 
	 * @return btnAyuda
	 */
	public JButton getBtnAyuda() {
		return btnAyuda;
	}

	/**
	 * getter del BtnAcercaDe
	 * 
	 * @return btnAcercaDe
	 */
	public JButton getBtnAcercaDe() {
		return btnAcercaDe;
	}
}
