package mvc.vistas;

import javax.swing.*;
import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxResultset.FetchSuspendedOrBuilder;

import mvc.controlador.Coordinador;
import mvc.modelo.vo.ProyectoVO;
import mvc.modelo.vo.UsuarioVO;

import java.awt.Color;
import java.util.*;

/**
 * @author Mario
 *
 */
public class DetallesProyecto extends JDialog {

	// Variables declaration - do not modify
	private JButton btnAñadir;
	private JButton btnCerrar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnQuitar;
	private JButton btnBuscar;

	private JScrollPane JScrIntegrantes;
	private JScrollPane JSCrAlumnos;
	private JLabel lblArea;
	private JLabel lblCurso;
	private JLabel lblGrupo;
	private JLabel lblId;
	private JLabel lblNombrePr;
	private JLabel lblNota;
	private JLabel lblTitulo;

	private JLabel lblUrl;
	private JLabel lblYear;
	private JTextField txtBuscar;
	private JTextField txtCurso;
	private JTextField txtGrupo;
	private JTextField txtId;
	private JTextField txtNombrePr;
	private JTextField txtNota;
	private JTextField txtUrl;
	private JTextField txtYear;
	private JTextField txtArea;
	private JComboBox cmbAreas;
	private JComboBox JcmbCurso;
	private Coordinador miCoordinador;
	private DefaultListModel<String> modeloAlumnos;
	private DefaultListModel<String> modeloIntegrantes;
	private DefaultComboBoxModel modeloAreas;
	private JTable tblAlumnos;
	private JTable tblIntegrantes;
	private DefaultTableModel modelIntegrantes = new DefaultTableModel();

	private String[] cabeceraTabla = { "ID de Usuario", "Nombre", "Nº de Expediente" };

	/**
	 * Creates new form DetalleProyectos
	 */
	public DetallesProyecto(BuscarProyectos miBuscarProyectos) {
		super(miBuscarProyectos);
		setSize(1000, 603);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		inicializarComponentes();

	}

	/**
	 * Constructor vacio para los test
	 */
	public DetallesProyecto() {
		inicializarComponentes();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	/**
	 * Método que crea/añade los elementos necesarios a la vista
	 */

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void inicializarComponentes() {

		lblArea = new JLabel();
		lblNombrePr = new JLabel();
		lblYear = new JLabel();
		lblGrupo = new JLabel();
		lblCurso = new JLabel();
		lblNota = new JLabel();
		lblUrl = new JLabel();
		lblId = new JLabel();
		txtUrl = new JTextField();
		txtNombrePr = new JTextField();
		txtYear = new JTextField();
		txtCurso = new JTextField();
		txtGrupo = new JTextField();
		txtNota = new JTextField();
		txtId = new JTextField();
		txtBuscar = new JTextField();
		btnAñadir = new JButton();
		JSCrAlumnos = new JScrollPane();
		JScrIntegrantes = new JScrollPane();
		lblTitulo = new JLabel();
		modeloAlumnos = new DefaultListModel();
		modeloIntegrantes = new DefaultListModel();
		modeloAreas = new DefaultComboBoxModel();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Detalle Proyecto");
		getContentPane().setLayout(null);

		lblArea.setHorizontalAlignment(SwingConstants.TRAILING);
		lblArea.setText("Area *");
		lblArea.setBounds(60, 290, 130, 30);
		getContentPane().add(lblArea);

		lblNombrePr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombrePr.setText("Nombre Proyecto *");
		lblNombrePr.setBounds(60, 90, 130, 30);
		getContentPane().add(lblNombrePr);

		lblYear.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYear.setText("Año *");
		lblYear.setBounds(60, 140, 130, 30);
		getContentPane().add(lblYear);

		lblGrupo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGrupo.setText("Grupo");
		lblGrupo.setBounds(60, 240, 130, 30);
		getContentPane().add(lblGrupo);

		lblCurso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCurso.setText("Curso *");
		lblCurso.setBounds(60, 190, 130, 30);
		getContentPane().add(lblCurso);

		lblNota.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNota.setText("Nota Obtenida");
		lblNota.setBounds(60, 340, 130, 30);
		getContentPane().add(lblNota);

		lblUrl.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUrl.setText("URL de GitHub *");
		lblUrl.setBounds(60, 390, 130, 30);
		getContentPane().add(lblUrl);

		lblId.setText("ID proyecto");
		lblId.setBounds(560, 40, 90, 30);
		getContentPane().add(lblId);

		txtUrl.setBounds(240, 390, 270, 30);
		getContentPane().add(txtUrl);

		txtNombrePr.setBounds(240, 90, 270, 30);
		getContentPane().add(txtNombrePr);
		txtYear.setBounds(240, 140, 270, 30);
		getContentPane().add(txtYear);
		txtCurso.setBounds(240, 190, 270, 30);
		getContentPane().add(txtCurso);
		txtGrupo.setBounds(240, 240, 270, 30);
		getContentPane().add(txtGrupo);
		txtNota.setBounds(240, 340, 270, 30);
		getContentPane().add(txtNota);

		txtId.setText("ID");

		txtId.setBounds(650, 40, 50, 30);
		txtId.setEnabled(false);
		getContentPane().add(txtId);

		txtBuscar.setText("Buscar");
		txtBuscar.setBounds(560, 82, 254, 25);
		getContentPane().add(txtBuscar);

		btnAñadir.setText("AÑADIR");
		btnAñadir.setBounds(843, 241, 100, 40);
		getContentPane().add(btnAñadir);
		JSCrAlumnos.setBounds(560, 110, 383, 130);
		getContentPane().add(JSCrAlumnos);

		JScrIntegrantes.setBounds(560, 284, 383, 136);
		tblIntegrantes = new JTable(modelIntegrantes);
		JScrIntegrantes.setViewportView(tblIntegrantes);
		getContentPane().add(JScrIntegrantes);

		lblTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setText("DETALLES DEL PROYECTO");
		lblTitulo.setBounds(60, 30, 450, 40);
		getContentPane().add(lblTitulo);

		cmbAreas = new JComboBox();
		cmbAreas.setModel(modeloAreas);
		cmbAreas.setBackground(Color.WHITE);
		cmbAreas.setBounds(240, 290, 270, 30);
		getContentPane().add(cmbAreas);

		btnCerrar = new JButton("CERRAR");
		btnCerrar.setBounds(826, 467, 117, 29);
		getContentPane().add(btnCerrar);

		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(697, 467, 117, 29);
		getContentPane().add(btnEditar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(568, 467, 117, 29);
		getContentPane().add(btnBorrar);

		btnQuitar = new JButton();
		btnQuitar.setText("QUITAR");
		btnQuitar.setBounds(731, 241, 100, 40);
		getContentPane().add(btnQuitar);

		txtArea = new JTextField();
		txtArea.setBounds(240, 292, 270, 30);
		getContentPane().add(txtArea);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(826, 82, 117, 29);
		getContentPane().add(btnBuscar);

		JcmbCurso = new JComboBox();
		JcmbCurso.setModel(new DefaultComboBoxModel(new String[] { "PRIMERO", "SEGUNDO" }));
		JcmbCurso.setBounds(240, 193, 270, 27);
		getContentPane().add(JcmbCurso);

		modelIntegrantes.addColumn("ID alumno");
		modelIntegrantes.addColumn("Nombre alumno");
		modelIntegrantes.addColumn("Nº de Expediente");

	}// </editor-fold>

	// ------------------------------------------------- Getters y Setters
	// ----------------------------

	/**
	 * getter del BtnAñadir
	 * 
	 * @return btnAñadir
	 */
	public JButton getBtnAñadir() {
		return btnAñadir;
	}

	/**
	 * getter del BtnCerrar
	 * 
	 * @return btnCerrar
	 */
	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	/**
	 * getter del BtnEditar
	 * 
	 * @return btnEditar
	 */
	public JButton getBtnEditar() {
		return btnEditar;
	}

	/**
	 * getter del BtnBorrar
	 * 
	 * @return btnBorrar
	 */
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	/**
	 * getter del BtnQuitar
	 * 
	 * @return btnQuitar
	 */
	public JButton getBtnQuitar() {
		return btnQuitar;
	}

	/**
	 * getter del BtnBuscar
	 * 
	 * @return btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/**
	 * getter del JScrIntegrantes
	 * 
	 * @return JScrIntegrantes
	 */
	public JScrollPane getJScrIntegrantes() {
		return JScrIntegrantes;
	}

	/**
	 * getter del JScrAlumnos
	 * 
	 * @return JScrAlumnos
	 */
	public JScrollPane getJSCrAlumnos() {
		return JSCrAlumnos;
	}

	/**
	 * getter del LblArea
	 * 
	 * @return lblArea
	 */
	public JLabel getLblArea() {
		return lblArea;
	}

	/**
	 * getter del LblCurso
	 * 
	 * @return lblCurso
	 */
	public JLabel getLblCurso() {
		return lblCurso;
	}

	/**
	 * getter del LblGrupo
	 * 
	 * @return lblGrupo
	 */
	public JLabel getLblGrupo() {
		return lblGrupo;
	}

	/**
	 * getter del LblId
	 * 
	 * @return lblId
	 */
	public JLabel getLblId() {
		return lblId;
	}

	/**
	 * getter del LblNombrePr
	 * 
	 * @return lblNombrePr
	 */
	public JLabel getLblNombrePr() {
		return lblNombrePr;
	}

	/**
	 * getter del LblNota
	 * 
	 * @return lblNota
	 */
	public JLabel getLblNota() {
		return lblNota;
	}

	/**
	 * getter del LblTitulo
	 * 
	 * @return lblTitulo
	 */
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/**
	 * getter del LblUrl
	 * 
	 * @return lblUrl
	 */
	public JLabel getLblUrl() {
		return lblUrl;
	}

	/**
	 * getter del LblYear
	 * 
	 * @return lblYear
	 */
	public JLabel getLblYear() {
		return lblYear;
	}

	/**
	 * getter del TblAlumnos
	 * 
	 * @return tblAlumnos
	 */
	public JTable getTblAlumnos() {
		return tblAlumnos;
	}

	/**
	 * getter del TblIntegrantes
	 * 
	 * @return tblIntegrantes
	 */
	public JTable getTblIntegrantes() {
		return tblIntegrantes;
	}

	/**
	 * getter del TxtBuscar
	 * 
	 * @return txtBuscar
	 */
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	/**
	 * getter del TxtCurso
	 * 
	 * @return txtCurso
	 */
	public JTextField getTxtCurso() {
		return txtCurso;
	}

	/**
	 * getter del TxtGrupo
	 * 
	 * @return txtGrupo
	 */
	public JTextField getTxtGrupo() {
		return txtGrupo;
	}

	/**
	 * getter del TxtId
	 * 
	 * @return txtId
	 */
	public JTextField getTxtId() {
		return txtId;
	}

	/**
	 * getter del TxtNomnrePr
	 * 
	 * @return txtNombrePr
	 */
	public JTextField getTxtNomnrePr() {
		return txtNombrePr;
	}

	/**
	 * getter del TxtNota
	 * 
	 * @return txtNota
	 */
	public JTextField getTxtNota() {
		return txtNota;
	}

	/**
	 * getter del TxtUrl
	 * 
	 * @return txtUrl
	 */
	public JTextField getTxtUrl() {
		return txtUrl;
	}

	/**
	 * getter del TxtYear
	 * 
	 * @return txtYear
	 */
	public JTextField getTxtYear() {
		return txtYear;
	}

	/**
	 * getter del TxtArea
	 * 
	 * @return txtArea
	 */
	public JTextField getTxtArea() {
		return txtArea;
	}

	/**
	 * getter del CmbAreas
	 * 
	 * @return cmbAreas
	 */
	public JComboBox getCmbAreas() {
		return cmbAreas;
	}

	/**
	 * getter del CmbCurso
	 * 
	 * @return
	 */
	public JComboBox getCmbCurso() {
		return JcmbCurso;
	}

	/**
	 * getter del ModeloAreas
	 * 
	 * @return modeloAreas
	 */
	public DefaultComboBoxModel getModeloAreas() {
		return modeloAreas;
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
	 * Método para añadir los listener a los botones que lo requieran
	 * 
	 * @param miCoordinador
	 */
	public void setListeners(Coordinador miCoordinador) {

		txtBuscar.addKeyListener(miCoordinador);
		btnCerrar.addActionListener(miCoordinador);
		btnAñadir.addActionListener(miCoordinador);
		btnBorrar.addActionListener(miCoordinador);
		btnEditar.addActionListener(miCoordinador);
		btnQuitar.addActionListener(miCoordinador);
		btnBuscar.addActionListener(miCoordinador);

	}

	// ------------------ Métodos auxiliares

	/**
	 * Método para cambiar lo que se ve en la vista
	 */
	public void cambiarVistaAEdicion() {

		btnCerrar.setText("ACTUALIZAR");
		btnAñadir.setEnabled(true);
		btnQuitar.setEnabled(true);
		txtArea.setVisible(false);
		cmbAreas.setVisible(true);
		txtCurso.setVisible(false);
		JcmbCurso.setVisible(true);
		miCoordinador.cargarAlumnos();
		btnEditar.setText("CANCELAR");
		btnBorrar.setVisible(true);

	}

	/**
	 * Método para cambiar lo que se ve en la vista
	 */
	public void modoRegistro() {
		limpiarCampos();
		btnCerrar.setText("GUARDAR");
		btnEditar.setText("CANCELAR");
		btnBorrar.setVisible(false);
		txtArea.setVisible(false);
		cmbAreas.setVisible(true);
		txtCurso.setVisible(false);
		JcmbCurso.setVisible(true);
		btnAñadir.setEnabled(true);
		btnQuitar.setEnabled(true);

	}

	/**
	 * Método para cambiar lo que se ve en la vista
	 */
	public void cambiarVistaDetalle() {

		btnCerrar.setText("CERRAR");
		btnAñadir.setEnabled(false);
		btnQuitar.setEnabled(false);
		txtArea.setVisible(true);
		cmbAreas.setVisible(false);
		txtCurso.setVisible(true);
		JcmbCurso.setVisible(false);
		btnEditar.setText("EDITAR");
		btnBorrar.setVisible(false);

	}

	/**
	 * Método que añade un integrante al proyecto
	 * 
	 * @param integrante
	 */
	public void añadirIntegrante(UsuarioVO integrante) {

		modelIntegrantes = (DefaultTableModel) tblIntegrantes.getModel();
		modelIntegrantes.addRow(
				new Object[] { integrante.getUser_id() + "", integrante.getNombre(), integrante.getExpediente() });
		tblIntegrantes.setModel(modelIntegrantes);
		JScrIntegrantes.setViewportView(tblIntegrantes);

	}

	/**
	 * Método para añadir al ArrayList los items y que los muestre en el ComboBox
	 * 
	 * @param Areas
	 */
	public void rellenarComboAreas(ArrayList<String> Areas) {

		for (String area : Areas) {
			getCmbAreas().addItem(area);
		}

	}

	/**
	 * Método que enseña todos los datos del proyecto
	 * 
	 * @param proyecto
	 */
	public void mostrarProyecto(ProyectoVO proyecto) {
		String nombre_corto;
		txtNombrePr.setText(proyecto.getNombreProyecto());
		txtYear.setText(proyecto.getYear());
		txtCurso.setText(proyecto.getCurso());
		txtGrupo.setText(proyecto.getGrupo());
		nombre_corto = miCoordinador.devolverArea(proyecto.getArea());
		txtArea.setText(nombre_corto);
		txtNota.setText(proyecto.getNota() + "");
		txtUrl.setText(proyecto.getUrl());
		txtId.setText(proyecto.getIdProyecto() + "");

	}

	/**
	 * Método para que se rellene la tabla de los alumnos disponible para añadir al
	 * proyecto al crear un nuevo proyecto
	 * 
	 * @param resultadoBusqueda
	 */
	public void rellenarTabla(ArrayList<UsuarioVO> resultadoBusqueda) {

		Object[][] alumnos = new String[resultadoBusqueda.size()][3];

		for (int i = 0; i < resultadoBusqueda.size(); i++) {

			alumnos[i][0] = resultadoBusqueda.get(i).getUser_id() + "";
			alumnos[i][1] = resultadoBusqueda.get(i).getNombre();
			alumnos[i][2] = resultadoBusqueda.get(i).getExpediente();

		}

		tblAlumnos = new JTable(alumnos, cabeceraTabla);
		JSCrAlumnos.setViewportView(tblAlumnos);

	}

	/**
	 * para que cargue en la tabla de abajo los datos de los integrantes del grupo
	 * cuando los añades
	 * 
	 * @param cargarIntegrantes
	 */
	public void cargarIntegrantes(ArrayList<UsuarioVO> cargarIntegrantes) {

		Object[][] integrantes = new String[cargarIntegrantes.size()][3];
		limpiarTablaIntegrantes();

		for (int i = 0; i < cargarIntegrantes.size(); i++) {

			integrantes[i][0] = cargarIntegrantes.get(i).getUser_id() + "";
			integrantes[i][1] = cargarIntegrantes.get(i).getNombre();
			integrantes[i][2] = cargarIntegrantes.get(i).getExpediente();
			modelIntegrantes.addRow(integrantes[i]);

		}

		tblIntegrantes = new JTable(modelIntegrantes);
		JScrIntegrantes.setViewportView(tblIntegrantes);

	}

	/**
	 * Método para que se limpie la tabla de integrantes antes de que se cargue todo
	 * otra vez al abrirlo de nuevo
	 */
	private void limpiarTablaIntegrantes() {
		modelIntegrantes.setRowCount(0);
	}

	/**
	 * Método para eliminar un integrante
	 * 
	 * @param integranteSeleccionado
	 */
	public void quitarIntegrante(int integranteSeleccionado) {

		if (integranteSeleccionado >= 0) {

			modelIntegrantes.removeRow(integranteSeleccionado);
			tblIntegrantes.setModel(modelIntegrantes);
			JScrIntegrantes.setViewportView(tblIntegrantes);

		}

	}

	/**
	 * Método para limpiar todos los campos de un proyecto
	 */
	public void limpiarCampos() {

		this.getTxtBuscar().setText("");
		this.getTxtNomnrePr().setText("");
		this.getTxtCurso().setText("");
		this.getTxtGrupo().setText("");
		this.getTxtId().setText("");
		this.getTxtNota().setText("");
		this.getTxtUrl().setText("");
		this.getTxtYear().setText("");
		this.getTxtArea().setText("");
		limpiarTablaIntegrantes();

	}

	/**
	 * Método para saber a que alumno le hemos hecho click
	 * 
	 * @return prID
	 */
	public int alumnoSeleccionado() {

		int prID = 0;
		int filaSeleccionada = this.getTblAlumnos().getSelectedRow();
		if (filaSeleccionada >= 0) {
			prID = Integer.parseInt((String) this.getTblAlumnos().getModel().getValueAt(filaSeleccionada, 0));

		}
		return prID;
	}

	/**
	 * Método para poder seleccionar a un estudiante yque le programa sepa cual
	 * estamos seleccionando
	 * 
	 * @return filaSeleccionada
	 */
	public int integranteSeleccionado() {

		int filaSeleccionada = this.getTblIntegrantes().getSelectedRow();
		return filaSeleccionada;
	}

	/**
	 * Método para que nos devuelva los integrantes de un grupo
	 * 
	 * @return integrantes
	 */
	public int[] getIntegrantes() {
		int filas = getTblIntegrantes().getRowCount();
		int[] integrantes = new int[filas];
		for (int i = 0; i < filas; i++) {
			integrantes[i] = Integer.parseInt((String) getTblIntegrantes().getModel().getValueAt(i, 0));

		}
		return integrantes;
	}

	/**
	 * Método para que nos devuelva los campos del proyecto
	 * 
	 * @return proyecto
	 */
	public ProyectoVO getCampos() {
		ProyectoVO proyecto = new ProyectoVO();
		String nombre_corto = (String) getCmbAreas().getSelectedItem();
		int idArea = miCoordinador.devolverIdArea(nombre_corto);
		if (txtId.getText().isEmpty()) {
			proyecto.setIdProyecto(0);
		} else {
			proyecto.setIdProyecto(Integer.parseInt(getTxtId().getText()));
		}
		proyecto.setNombreProyecto(getTxtNomnrePr().getText());
		proyecto.setUrl(getTxtUrl().getText());
		if (txtNota.getText().isEmpty()) {
			proyecto.setNota(0);
		} else {
			try {
				proyecto.setNota(Double.parseDouble(getTxtNota().getText()));
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		proyecto.setYear(getTxtYear().getText());
		proyecto.setCurso((String) getCmbCurso().getSelectedItem());
		proyecto.setGrupo(getTxtGrupo().getText());
		proyecto.setArea(idArea);

		return proyecto;
	}

	/**
	 * Método para comprobar que todos los campos requeridos están llenos
	 * 
	 * @return true
	 */
	public boolean validarCampos() {

		// Comprobar que todos los campos requeridos están rellenos y poner el
		// background rojo a los que no lo están
		return true;

	}

	/**
	 * Método para comprobar si están llenos o vacios los campos que están dentro
	 * del método
	 * 
	 * @return !nombre && !año && !url
	 */
	public boolean estanCamposRellenos() {

		boolean nombre = txtNombrePr.getText().isEmpty();
		boolean año = txtYear.getText().isEmpty();
		boolean url = txtUrl.getText().isEmpty();

		return (!nombre && !año && !url);
	}

}
