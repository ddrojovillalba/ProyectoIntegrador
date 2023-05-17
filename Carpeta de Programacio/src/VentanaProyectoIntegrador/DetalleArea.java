/**
 * Este paquete contiene las clases de interfaz de usuario para el Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import java.awt.Font;
import javax.swing.*;

/**
 * Clase DetalleArea.
 * Esta clase es una ventana de detalles específicos de las áreas del Proyecto Integrador.
 * Hereda de JFrame y se utiliza para mostrar información detallada de un área específica.
 * 
 * @author Mario
 */
public class DetalleArea extends JFrame {
	
	// Etiqueta para el título de la ventana
	JLabel lblDetalles;
	
	// Etiqueta para mostrar los datos del área
	JLabel lblDatos;
	
	/**
	 * Constructor de la clase DetalleArea.
	 * Inicializa la ventana y los componentes de la interfaz de usuario.
	 */
	public DetalleArea() {
		super("Detalles de Proyectos");
		inicializarComponentes();
	}
	
	/**
	 * Método para inicializar los componentes de la interfaz de usuario de la ventana.
	 * Configura el layout, crea e inicializa las etiquetas y las añade al contenedor principal.
	 */
	private void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		lblDetalles = new JLabel("Detalle Area");
		lblDetalles.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDetalles.setBounds(28, 36, 192, 32);
		getContentPane().add(lblDetalles);
		
		lblDatos = new JLabel("");
		lblDatos.setBounds(28, 97, 385, 156);
		getContentPane().add(lblDatos);
	}
}
