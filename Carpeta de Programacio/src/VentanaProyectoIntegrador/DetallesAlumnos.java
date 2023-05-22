/**
 * Paquete con interfaces de usuario del Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import javax.swing.*;
import java.awt.Font;

/**
 * Clase DetallesAlumnos.
 * Ventana para mostrar detalles de alumnos. Extiende de JFrame.
 * 
 * @author Mario
 */
public class DetallesAlumnos extends JFrame {

	// Título de la ventana
	JLabel lblDetalles;
	
	// Datos del alumno
	JLabel lblDatos;
	
	/**
	 * Constructor de DetallesAlumnos. Configura la ventana y componentes.
	 */
	public DetallesAlumnos() {
		super("Detalles de alumnos");
		inicializarComponentes();
	}

	/**
	 * Método para configurar componentes de la interfaz.
	 */
	private void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		lblDetalles = new JLabel("Detalle Alumnos");
		lblDetalles.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDetalles.setBounds(28, 36, 169, 32);
		getContentPane().add(lblDetalles);
		
		lblDatos = new JLabel("");
		lblDatos.setBounds(28, 97, 385, 156);
		getContentPane().add(lblDatos);
	}
}
