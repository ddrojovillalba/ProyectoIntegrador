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
public class VentanaAreas extends JFrame {

	JLabel lblAreas;
	JLabel lblAñadir;
	JLabel lblConsultar;
	JLabel lblEditar;
	JLabel lblEliminar;
	JButton btnAñadir;
	JButton btnConsultar;
	JButton btnEditar;
	JButton btnEliminar;
	
	
	public VentanaAreas() {
		super("Gestor de áreas");
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		lblAreas = new JLabel("Áreas");
		lblAreas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAreas.setBounds(10, 10, 88, 32);
		getContentPane().add(lblAreas);
		
		btnAñadir = new JButton("Pulse aquí");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAñadir.setBounds(10, 64, 105, 20);
		getContentPane().add(btnAñadir);
		
		lblAñadir = new JLabel("Añadir área");
		lblAñadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAñadir.setBounds(125, 63, 104, 20);
		getContentPane().add(lblAñadir);
		
		btnConsultar = new JButton("Pulse Aquí");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setBounds(10, 94, 105, 20);
		getContentPane().add(btnConsultar);
		
		lblConsultar = new JLabel("Consultar área");
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultar.setBounds(125, 93, 116, 20);
		getContentPane().add(lblConsultar);
		
		btnEditar = new JButton("Pulse aquí");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(10, 124, 105, 20);
		getContentPane().add(btnEditar);
		
		lblEditar = new JLabel("Editar área");
		lblEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEditar.setBounds(125, 123, 116, 20);
		getContentPane().add(lblEditar);
		
		btnEliminar = new JButton("Pulse aquí");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.setBounds(10, 154, 105, 20);
		getContentPane().add(btnEliminar);
		
		lblEliminar = new JLabel("Eliminar área");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEliminar.setBounds(125, 153, 116, 20);
		getContentPane().add(lblEliminar);
		
	}
}
