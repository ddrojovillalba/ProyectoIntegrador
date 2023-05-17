/**
 * Este paquete contiene las clases de la interfaz de usuario para el Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import java.awt.Font;
import javax.swing.*;

/**
 * Clase DetalleProyectos.
 * Esta clase es una ventana que muestra los detalles específicos de los proyectos.
 * Hereda de JFrame y se utiliza para presentar información detallada sobre un proyecto específico.
 * 
 * @author Mario
 */
public class DetalleProyectos extends JFrame {
	
	// Etiqueta para el título de la ventana
	JLabel lblDetalles;
	
	// Etiqueta para mostrar los datos del proyecto
	JLabel lblDatos;
	
	/**
	 * Constructor de la clase DetalleProyectos.
	 * Inicializa la ventana y los componentes de la interfaz de usuario.
	 */
	public DetalleProyectos() {
		super("Detalles de Proyectos");
		inicializarComponentes();
	}

	/**
	 * Método para inicializar los componentes de la interfaz de usuario de la ventana.
	 * Configura el layout, crea e inicializa las etiquetas, y las añade al contenedor principal.
	 */
	private void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		lblDetalles = new JLabel("Detalle Proyectos");
		lblDetalles.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDetalles.setBounds(28, 36, 192, 32);
		getContentPane().add(lblDetalles);
		
		lblDatos = new JLabel("");
		lblDatos.setBounds(28, 97, 385, 156);
		getContentPane().add(lblDatos);
	}
}
