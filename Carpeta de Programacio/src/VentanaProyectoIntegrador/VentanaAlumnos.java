/**
 * Este paquete contiene las clases de la interfaz de usuario para el Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import javax.swing.*;
import java.awt.Font;

/**
 * Clase VentanaAlumnos.
 * Esta clase es una ventana de la interfaz de usuario que permite gestionar los alumnos.
 * Hereda de JFrame y proporciona funcionalidades para añadir, consultar, editar y eliminar alumnos.
 * 
 * @author Mario
 */
public class VentanaAlumnos extends JFrame {

	// Componentes de la interfaz de usuario
	JLabel lblAlumnos;
	JButton btnAñadir;
	JLabel lblAñadir;
	JButton btnConsultar;
	JLabel lblConsultar;
	JButton btnEditar;
	JLabel lblEditar;
	JButton btnEliminar;
	JLabel lblEliminar;
	
	/**
	 * Constructor de la clase VentanaAlumnos.
	 * Inicializa la ventana y los componentes de la interfaz de usuario.
	 */
	public VentanaAlumnos() {
		super("Gestor de Alumnos");
		inicializarComponentes();
	}

	/**
	 * Método para inicializar los componentes de la interfaz de usuario de la ventana.
	 * Configura el layout, crea e inicializa las etiquetas y los botones, y los añade al contenedor principal.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		// Creación e inicialización de los componentes de la interfaz de usuario

		lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlumnos.setBounds(10, 22, 88, 20);
		getContentPane().add(lblAlumnos);
		
		btnAñadir = new JButton("Pulse aquí");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAñadir.setBounds(10, 64, 105, 20);
		getContentPane().add(btnAñadir);
		
		lblAñadir = new JLabel("Añadir alumno");
		lblAñadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAñadir.setBounds(125, 63, 104, 20);
		getContentPane().add(lblAñadir);
		
		btnConsultar = new JButton("Pulse aquí");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setBounds(10, 94, 105, 20);
		getContentPane().add(btnConsultar);
		
		lblConsultar = new JLabel("Consultar alumno");
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultar.setBounds(125, 93, 116, 20);
		getContentPane().add(lblConsultar);
		
		btnEditar = new JButton("Pulse aquí");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(10, 124, 105, 20);
		getContentPane().add(btnEditar);
		
		lblEditar = new JLabel("Editar alumno");
		lblEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEditar.setBounds(125, 123, 116, 20);
		getContentPane().add(lblEditar);
		
		btnEliminar = new JButton("Pulse aquí");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.setBounds(10, 154, 105, 20);
		getContentPane().add(btnEliminar);
		
		lblEliminar = new JLabel("Eliminar alumno");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEliminar.setBounds(125, 153, 116, 20);
		getContentPane().add(lblEliminar);
	}
}
