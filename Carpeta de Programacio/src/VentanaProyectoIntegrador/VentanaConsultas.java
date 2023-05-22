/**
 * Paquete con las clases de interfaz de usuario para el proyecto.
 */
package VentanaProyectoIntegrador;

import javax.swing.*;
import java.awt.Font;

/**
 * Clase VentanaConsultas.
 * Ventana para consultas sobre proyectos, alumnos y áreas.
 * Hereda de JFrame, permite filtrar y visualizar resultados de consultas.
 * 
 * @author Mario
 */
public class VentanaConsultas extends JFrame {
	
	// Componentes de la interfaz
	JLabel lblConsultas;
	JLabel lblFiltro;
	JTextField txtBusqueda;
	JTextArea txtResultados;
	JButton btnDetalles;

	/**
	 * Constructor.
	 * Inicializa la ventana y sus componentes.
	 */
	public VentanaConsultas() {
		super("Consultor de Proyectos/alumnos/áreas");
		inicializarComponentes();
	}
	
	/**
	 * Método para inicializar los componentes de la ventana.
	 * Configura el layout, crea e inicializa las etiquetas, el campo de texto y el botón.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		// Creación e inicialización de los componentes
		
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
