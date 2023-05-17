/**
 * Este paquete contiene las clases de la interfaz de usuario para el Proyecto Integrador.
 */
package VentanaProyectoIntegrador;

import javax.swing.*;
import java.awt.Font;

/**
 * Clase DetallesAlumnos.
 * Esta clase es una ventana de la interfaz de usuario que muestra los detalles de los alumnos.
 * Hereda de JFrame y se utiliza para presentar información detallada sobre un alumno específico.
 * 
 * @author Mario
 */
public class DetallesAlumnos extends JFrame {

	// Etiqueta para el título de la ventana
	JLabel lblDetalles;
	
	// Etiqueta para mostrar los datos del alumno
	JLabel lblDatos;
	
	/**
	 * Constructor de la clase DetallesAlumnos.
	 * Inicializa la ventana y los componentes de la interfaz de usuario.
	 */
	public DetallesAlumnos() {
		super("Detalles de alumnos");
		inicializarComponentes();
	}

	/**
	 * Método para inicializar los componentes de la interfaz de usuario de la ventana.
	 * Configura el layout, crea e inicializa las etiquetas, y las añade al contenedor principal.
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
