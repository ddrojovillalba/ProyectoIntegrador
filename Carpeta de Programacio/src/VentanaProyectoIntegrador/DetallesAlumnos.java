/**
 * 
 */
package VentanaProyectoIntegrador;

import javax.swing.*;
import java.awt.Font;

/**
 * @author Mario
 *
 */
public class DetallesAlumnos extends JFrame {

	JLabel lblDetalles;
	JLabel lblDatos;
	
	public DetallesAlumnos() {
		super("Detalles de alumnos");
		inicializarComponentes();
	}

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
