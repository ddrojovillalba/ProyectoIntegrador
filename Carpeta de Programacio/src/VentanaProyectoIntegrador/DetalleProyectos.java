/**
 * Paquete con interfaces de usuario del Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import java.awt.Font;
import javax.swing.*;

/**
 * Clase DetalleProyectos.
 * Ventana para mostrar detalles de proyectos. Hereda de JFrame.
 * 
 * @author Mario
 */
public class DetalleProyectos extends JFrame {
	
	// Título de la ventana
	JLabel lblDetalles;
	
	// Datos del proyecto
	JLabel lblDatos;
	
	/**
	 * Constructor de DetalleProyectos. Inicializa la ventana y componentes.
	 */
	public DetalleProyectos() {
		super("Detalles de Proyectos");
		inicializarComponentes();
	}
	
	/**
	 * Método para configurar componentes de la interfaz.
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
