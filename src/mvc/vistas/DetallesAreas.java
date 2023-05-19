package mvc.vistas;

import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mvc.controlador.Coordinador;
import mvc.modelo.vo.AreaVO;

/**
 * @author Mario
 *
 */
public class DetallesAreas extends JDialog {

	private JTextField txtID;
	private JTextField txtNombre;
	private JButton btnSalir;
	private JTextArea textAreaDesc;
	private JComboBox cmbAreas;
	private Coordinador miCoordinador;

	/**
	 * Creates new form PanelAreas
	 */
	public DetallesAreas(Frame parent, boolean modal) {

		super(parent, modal);
		setSize(643, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		initComponents();

	}

	/**
	 * Método que crea/añade a la vista los elementos que deben aparecer en esta
	 */
	private void initComponents() {
		JLabel lblTitulo = new JLabel("Areas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(30, 30, 240, 50);
		getContentPane().add(lblTitulo);

		cmbAreas = new JComboBox();
		cmbAreas.setBounds(30, 90, 240, 30);
		getContentPane().add(cmbAreas);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(393, 96, 90, 14);
		getContentPane().add(lblId);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(271, 140, 90, 14);
		getContentPane().add(lblNombre);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(30, 189, 90, 20);
		getContentPane().add(lblDescripcion);

		txtID = new JTextField();
		txtID.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		txtID.setBounds(495, 90, 84, 24);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		txtNombre.setBounds(373, 130, 206, 30);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		textAreaDesc = new JTextArea();
		textAreaDesc.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textAreaDesc.setBounds(146, 190, 433, 121);
		textAreaDesc.setLineWrap(true);
		textAreaDesc.setWrapStyleWord(true);
		getContentPane().add(textAreaDesc);

		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(479, 372, 100, 35);
		getContentPane().add(btnSalir);

	}

	// ----------------------------------------- Getters y Setters
	// ------------------------

	/**
	 * getter del CmbAreas
	 * 
	 * @return cmbAreas
	 */
	public JComboBox getCmbAreas() {
		return cmbAreas;
	}

	/**
	 * getter del TxtID
	 * 
	 * @return txtID
	 */
	public JTextField getTxtID() {
		return txtID;
	}

	/**
	 * getter del TxtNombre
	 * 
	 * @return txtNombre
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * getter del TextAreaDesc
	 * 
	 * @return textAreaDesc
	 */
	public JTextArea getTextAreaDesc() {
		return textAreaDesc;
	}

	/**
	 * getter del BtnSalir
	 * 
	 * @return btnSalir
	 */
	public JButton getBtnSalir() {

		return btnSalir;
	}

	/**
	 * Método para tener una instancia del coordinador
	 * 
	 * @param miCoordinador
	 */
	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;

	}

	/**
	 * Método para añadir los listener as los botones
	 */
	public void SetListener() {

		cmbAreas.addItemListener(miCoordinador);
		btnSalir.addActionListener(miCoordinador);

	}

	/**
	 * Método para rellenar el comboBox de areas
	 * 
	 * @param Areas
	 */
	public void rellenarComboAreas(ArrayList<String> Areas) {

		for (String area : Areas) {
			cmbAreas.addItem(area);
		}

	}

	/**
	 * Método para mostrar los datos de areas cuando se haya seleccionado un item
	 * del ComboBox
	 * 
	 * @param area
	 */
	public void rellenarCampos(AreaVO area) {

		txtID.setText(area.getId() + "");
		txtNombre.setText(area.getNombre());
		textAreaDesc.setText(area.getDescripcion());

	}
}
