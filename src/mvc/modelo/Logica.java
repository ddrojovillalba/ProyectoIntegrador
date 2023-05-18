package mvc.modelo;

import javax.swing.JOptionPane;

import mvc.controlador.Coordinador;
import mvc.vistas.VentanaLogin;

public class Logica {

	@SuppressWarnings("unused")
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador=miCoordinador;
		
	}
	
	// ---------------------- Método que comprueba la validez de los datos introducidos en VentanaLogin antes de mandar la consulta a BD ---------------
	

	public void comprobarUsuario(VentanaLogin miVentanaLogin) {
		
		boolean validUser=true;
		boolean validPass=true;
		
		
		String usuario=miVentanaLogin.getTxtUser().getText().trim();
		String pass=miVentanaLogin.getTxtPass().getText().trim();
		
		if ((usuario.equals(""))|| (usuario==null)){
			validUser=false;
		}
		if ((pass.equals("")) || pass==null){
			validPass=false;
		}
		
		if (validUser && validPass) {
			System.out.println("El usuario introducido es "+ usuario + " y su password " + pass);
		}
		else {
			JOptionPane.showMessageDialog(null, "Debes rellenar los campos", "Campos sin rellnar", JOptionPane.WARNING_MESSAGE);
		}
	}



}
