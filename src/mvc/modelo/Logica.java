package mvc.modelo;

import javax.swing.JOptionPane;

import mvc.controlador.Coordinador;
import mvc.vistas.VentanaLogin;

/**
 * @author Mario
 *
 */
public class Logica {

	@SuppressWarnings("unused")
	private Coordinador miCoordinador;

	/**
	 * Método para tener una instancia del coordinador
	 * 
	 * @param miCoordinador
	 */
	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;

	}

	// ---------------------- Método que comprueba la validez de los datos
	// introducidos en VentanaLogin antes de mandar la consulta a BD ---------------

	/**
	 * Método que comprueba la validez de los datos introducidos en VentanaLogin
	 * antes de mandar la consulta a BD
	 * 
	 * @param miVentanaLogin
	 */
	public void comprobarUsuario(VentanaLogin miVentanaLogin) {

		boolean validUser = true;
		boolean validPass = true;

		String usuario = miVentanaLogin.getTxtUser().getText().trim();
		String pass = miVentanaLogin.getTxtPass().getText().trim();

		if ((usuario.equals("")) || (usuario == null)) {
			validUser = false;
		}
		if ((pass.equals("")) || pass == null) {
			validPass = false;
		}

		if (validUser && validPass) {

		} else {
			JOptionPane.showMessageDialog(null, "Debes rellenar los campos", "Campos sin rellenar",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
