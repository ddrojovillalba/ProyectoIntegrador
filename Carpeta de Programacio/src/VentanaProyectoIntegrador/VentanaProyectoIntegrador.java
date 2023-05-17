/**
 * Este paquete contiene las clases de la interfaz de usuario para el Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import javax.swing.*;
import java.awt.Font;

/**
 * Clase VentanaProyectoIntegrador.
 * Esta clase es una ventana de la interfaz de usuario que permite gestionar los proyectos.
 * Hereda de JFrame y proporciona funcionalidades para crear, consultar, editar y eliminar proyectos.
 * 
 * @author Mario
 */
public class VentanaProyectoIntegrador extends JFrame{
	
	// Componentes de la interfaz de usuario
	JLabel lblProyecto;
	JButton btnCrear;
	JButton btnConsultar;
	JButton btnEditar;
	JButton btnEliminar;
	JLabel lblCrear;
	JLabel lblConsultar;
	JLabel lblEditar;
	JLabel lblEliminar;
	
	/**
	 * Constructor de la clase VentanaProyectoIntegrador.
	 * Inicializa la ventana y los componentes de la interfaz de usuario.
	 */
	public VentanaProyectoIntegrador() {
		super("Gestor de Proyectos");
		inicializarComponentes();
	}
	
	/**
	 * Método para inicializar los componentes de la interfaz de usuario de la ventana.
	 * Configura el layout, crea e inicializa las etiquetas y botones, y los añade al contenedor principal.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		// Creación e inicialización de los componentes de la interfaz de usuario
		
		lblProyecto =new JLabel("Proyectos");
		lblProyecto.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblProyecto.setBounds(22, 41, 167, 32);
		getContentPane().add(lblProyecto);
		
		btnCrear = new JButton("Pulse aquí");
		btnCrear.setBounds(22, 83, 83, 20);
		getContentPane().add(btnCrear);
		
		btnConsultar = new JButton("Pulse aquí");
		btnConsultar.setBounds(22, 113, 83, 20);
		getContentPane().add(btnConsultar);
		
		btnEditar = new JButton("Pulse aquí");
		btnEditar.setBounds(22, 143, 83, 20);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("Pulse aquí");
		btnEliminar.setBounds(22, 173, 83, 20);
		getContentPane().add(btnEliminar);
		
		lblCrear =new JLabel("Crear proyectos");
		lblCrear.setBounds(133, 83, 83, 20);
		getContentPane().add(lblCrear);
		
		lblConsultar = new JLabel("Consultar Proyectos");
		lblConsultar.setBounds(133, 113, 98, 20);
		getContentPane().add(lblConsultar);
		
		lblEditar = new JLabel("Consultar Proyectos");
		lblEditar.setBounds(133, 143, 98, 20);
		getContentPane().add(lblEditar);
		
		lblEliminar = new JLabel("Eliminar Proyectos");
		lblEliminar.setBounds(133, 173, 98, 20);
		getContentPane().add(lblEliminar);
	}
}
