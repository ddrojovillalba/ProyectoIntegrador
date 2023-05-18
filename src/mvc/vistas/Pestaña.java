package mvc.vistas;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pestaña extends JPanel{

	
	private JLabel lblConsulta;
	private JLabel lblEditar;
	private JLabel lblAlta;
	
	private JButton btnConsulta;
	private JButton btnEditar;
	private JButton btnAlta;
	
	
	public Pestaña(String nombrePestaña) {
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		inicializarComponentes(nombrePestaña);
		}

		private void inicializarComponentes(String nombrePestaña) {
		
		lblConsulta = new JLabel("CONSULTAR/EDITAR " + nombrePestaña);
		lblConsulta.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConsulta.setFocusTraversalPolicyProvider(true);
		lblConsulta.setBounds(60, 40, 220, 80);
		this.add(lblConsulta);
		
		
		btnConsulta = new JButton("CONSULTAR/EDITAR");
		btnConsulta.setBounds(380, 55, 200, 50);
		this.add(btnConsulta);
		
		lblAlta = new JLabel("ALTA");
		lblAlta.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAlta.setFocusTraversalPolicyProvider(true);
		lblAlta.setBounds(60, 140, 220, 80);
		add(lblAlta);
		
		btnAlta = new JButton("REGISTRAR");
		btnAlta.setBounds(380, 155, 200, 50);
		add(btnAlta);

		
		
		
		
	}

		public JLabel getLblConsulta() {
			return lblConsulta;
		}

		public JLabel getLblDarDeAlta() {
			return lblAlta;
		}



		public JLabel getLblEditar() {
			return lblEditar;
		}

		public JButton getBtnConsulta() {
			return btnConsulta;
		}

		public JButton getBtnAlta() {
			return btnAlta;
		}

		public JButton getBtnEditar() {
			return btnEditar;
		}
}
