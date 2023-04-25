/**
 * 
 */
package VentanaProyectoIntegrador;

import java.awt.Font;

import javax.swing.*;

/**
 * @author Mario
 *
 */
public class DetalleProyectos extends JFrame {
	
	JLabel lblDetalles;
	JLabel lblDatos;
	
	public DetalleProyectos() {
		super("Detalles de Proyectos");
		inicializarComponentes();
	}

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
