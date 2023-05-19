package mvc.vistas;

import javax.swing.*;

import mvc.controlador.Coordinador;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author ;Mario
 *
 */
@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private SideBar sideBar;
	private JTabbedPane tabbedPane;
	private Pestaña pestañaProyectos;
	private Pestaña pestañaAlumnos;
	private Pestaña pestañaAreas;

	private Coordinador miCoordinador;

	/**
	 * Constructor de la clase
	 */
	public VentanaPrincipal() {

		inicializarComponentes();

	}

	/**
	 * Método para crear/añadir los componentes necesarios en la vista
	 */
	private void inicializarComponentes() {

		getContentPane().setBackground(new Color(0, 0, 205));
		setForeground(UIManager.getColor("ToolTip.background"));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("/Volumes/Datos 6 TB/Descargas/icons8-edit-profile-color/icons8-edit-profile-96.png"));
		setName("marcoPrincipal");
		// setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(1100, 600);
		this.setLocationRelativeTo(null);

		// Barra lateral

		sideBar = new SideBar();
		sideBar.setBackground(new Color(0, 0, 153));
		sideBar.setBounds(16, 16, 170, 531);
		getContentPane().add(sideBar);

		// Panel para las distintas vistas manejadas por el TabbedPane que viene a
		// continuacion

		JPanel pnlContenedorJTabbedPane = new JPanel();
		pnlContenedorJTabbedPane.setBackground(new Color(1, 4, 199));
		pnlContenedorJTabbedPane.setBounds(183, 16, 912, 531);
		getContentPane().add(pnlContenedorJTabbedPane);
		pnlContenedorJTabbedPane.setLayout(null);

		// tabbedPane que contendrá los distintos paneles

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 0, 900, 525);
		pnlContenedorJTabbedPane.add(tabbedPane);

		// Panel Proyectos

		pestañaProyectos = new Pestaña("PROYECTOS");
		pestañaProyectos.setBackground(SystemColor.textHighlight);
		tabbedPane.addTab("Proyectos", null, pestañaProyectos, null);

		// Panel Alumnos

		pestañaAlumnos = new Pestaña("ALUMNOS");
		pestañaAlumnos.setBackground(SystemColor.textHighlight);
		tabbedPane.addTab("Alumnos", null, pestañaAlumnos, null);

		// Panel Areas

		pestañaAreas = new Pestaña("AREAS");
		pestañaAreas.setBackground(SystemColor.textHighlight);
		tabbedPane.addTab("Areas", null, pestañaAreas, null);

		setVisible(true);

	}

	// Getters y Setters

	/**
	 * getter de SideBar
	 * 
	 * @return sideBar
	 */
	public SideBar getSideBar() {
		return sideBar;
	}

	/**
	 * getter del TabbedPane
	 * 
	 * @return tabbedPane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * getter de la PestañaProyectos
	 * 
	 * @return pestañaProyectos
	 */
	public Pestaña getPestañaProyectos() {
		return pestañaProyectos;
	}

	/**
	 * getter de la PestañaAlumnos
	 * 
	 * @return pestañaAlumnos
	 */
	public Pestaña getPestañaAlumnos() {
		return pestañaAlumnos;
	}

	/**
	 * getter de la pestañaAreas
	 * 
	 * @return pestañaAreas
	 */
	public Pestaña getPestañaAreas() {
		return pestañaAreas;
	}

	/**
	 * Método para tener una instancia del coordinador
	 * 
	 * @param miCoordinador
	 */
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}

	// Añadimos Listeners a los Botones

	/**
	 * Método para añadir Listeners a los Botones que lo requieran
	 * 
	 * @param miCoordinador
	 */
	public void setListener(Coordinador miCoordinador) {
		sideBar.getBtnProyectos().addActionListener(miCoordinador);
		sideBar.getBtnAlumnos().addActionListener(miCoordinador);
		sideBar.getBtnAreas().addActionListener(miCoordinador);
		sideBar.getBtnAyuda().addActionListener(miCoordinador);
		sideBar.getBtnAcercaDe().addActionListener(miCoordinador);
		sideBar.getBtnSalir().addActionListener(miCoordinador);

		pestañaProyectos.getBtnConsulta().addActionListener(miCoordinador);

		pestañaProyectos.getBtnAlta().addActionListener(miCoordinador);

		pestañaAlumnos.getBtnConsulta().addActionListener(miCoordinador);

		pestañaAlumnos.getBtnAlta().addActionListener(miCoordinador);

		pestañaAreas.getBtnConsulta().addActionListener(miCoordinador);

	}

}
