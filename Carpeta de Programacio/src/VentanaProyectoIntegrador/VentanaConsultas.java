/**
 * Este paquete contiene las clases de la interfaz de usuario para el Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import javax.swing.*;
import java.awt.Font;

/**
 * Clase VentanaConsultas.
 * Esta clase es una ventana de la interfaz de usuario que permite realizar consultas sobre los proyectos, alumnos y áreas.
 * Hereda de JFrame y proporciona funcionalidades para filtrar y visualizar los resultados de las consultas.
 * 
 * @author Mario
 */
public class VentanaConsultas extends JFrame {
	
	// Componentes de la interfaz de usuario
	JLabel lblConsultas;
	JLabel lblFiltro;
	JTextField txtBusqueda;
	JTextArea txtResultados;
	JButton btnDetalles;

	/**
	 * Constructor de la clase VentanaConsultas.
	 * Inicializa la ventana y los componentes de la interfaz de usuario.
	 */
	public VentanaConsultas() {
		super("Consultor de Proyectos/alumnos/áreas");
		inicializarComponentes();
	}
	
	/**
	 * Método para inicializar los componentes de la interfaz de usuario de la ventana.
	 * Configura el layout, crea e inicializa las etiquetas, el campo de texto para el filtro, 
	 * el área de texto para los resultados y el botón para ver los detalles, y los añade al contenedor principal.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		// Creación e inicialización de los componentes de la interfaz de usuario
		
		lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblConsultas.setBounds(10, 10, 134, 32);
		getContentPane().add(lblConsultas);
		
		lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiltro.setBounds(10, 52, 105, 20);
		getContentPane().add(lblFiltro);
		
		txtBusqueda = new JTextField("");
		txtBusqueda.setBounds(113, 52, 284, 20);
		getContentPane().add(txtBusqueda);
		
		txtResultados = new JTextArea("");
		txtResultados.setBounds(10, 94, 416, 116);
		getContentPane().add(txtResultados);
		
		btnDetalles = new JButton("Detalles");
		btnDetalles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDetalles.setBounds(145, 233, 116, 20);
		getContentPane().add(btnDetalles);
	}
}
