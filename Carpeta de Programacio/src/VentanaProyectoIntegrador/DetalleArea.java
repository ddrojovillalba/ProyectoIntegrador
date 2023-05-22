/**
 * Paquete con interfaces de usuario para el Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import java.awt.Font;
import javax.swing.*;

/**
 * Clase DetalleArea.
 * Ventana de detalles de las áreas del proyecto. Hereda de JFrame.
 * 
 * @author Mario
 */
public class DetalleArea extends JFrame {
	
	// Título de la ventana
	JLabel lblDetalles;
	
	// Datos del área
	JLabel lblDatos;
	
	/**
	 * Constructor de DetalleArea. Inicializa la ventana y los componentes.
	 */
	public DetalleArea() {
		super("Detalles de Proyectos");
		inicializarComponentes();
	}
	
	/**
	 * Método para configurar los componentes de la interfaz de usuario.
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
