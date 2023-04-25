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
public class VentanaConsultas extends JFrame {
	
	JLabel lblConsultas;
	JLabel lblFiltro;
	JTextField txtBusqueda;
	JTextArea txtResultados;
	JButton btnDetalles;


	public VentanaConsultas() {
		super("Consultor de Proyectos/alumnos/áreas");
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
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
