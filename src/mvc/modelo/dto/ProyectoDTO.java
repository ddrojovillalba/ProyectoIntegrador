package mvc.modelo.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mvc.controlador.Coordinador;
import mvc.modelo.conexion.ConexionDB;
import mvc.modelo.vo.ProyectoVO;
import mvc.modelo.vo.UsuarioVO;

/**
 * @author Mario
 *
 */
public class ProyectoDTO {

	private Coordinador miCoordinador;
	private Connection connection;
	private ConexionDB conexionProyectoDTO = new ConexionDB();

	public ProyectoDTO() {
		connection = conexionProyectoDTO.establecerConexion();
	}

	/**
	 * Constructor para los test
	 * 
	 * @param conn
	 */
	public ProyectoDTO(Connection conn) {
		connection = conn;
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
	 * getter de la conexion de la clase a la BD
	 * 
	 * @return connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Método para meter en un arrayList proyectos filtrados por una busqueda
	 * realizada
	 * 
	 * @param busqueda
	 * @return listaFiltrada
	 */
	public ArrayList<ProyectoVO> miListaProyectosFiltrada(String busqueda) {

		ProyectoVO proyecto;
		ArrayList listaFiltrada = new ArrayList<>();
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta = "SELECT proyecto_id, nombre_proyecto, area_id, curso FROM proyectos WHERE nombre_proyecto REGEXP ? OR grupo REGEXP ? OR año REGEXP ? OR curso REGEXP ? ORDER BY nombre_proyecto"; // CAMBIAR
																																																			// POR
																																																			// QUERY
																																																			// MULTIPLE
																																																			// PARA
																																																			// PROYECTOS
		if (busqueda.equals("")) {
			consulta = "SELECT proyecto_id, nombre_proyecto, area_id, curso FROM proyectos";
		}

		System.out.println(busqueda + ", " + consulta);

		try {
			prepStatement = connection.prepareStatement(consulta);
			if (!busqueda.equals("")) {
				prepStatement.setString(1, busqueda);
				prepStatement.setString(2, busqueda);
				prepStatement.setString(3, busqueda);
				prepStatement.setString(4, busqueda);
			}

			resultadoConsulta = prepStatement.executeQuery();

			while (resultadoConsulta.next()) {

				proyecto = new ProyectoVO();
				proyecto.setIdProyecto(Integer.parseInt(resultadoConsulta.getString("proyecto_id")));
				proyecto.setNombreProyecto(resultadoConsulta.getString("nombre_proyecto"));
				proyecto.setArea(resultadoConsulta.getInt("area_id"));
				proyecto.setCurso(resultadoConsulta.getString("curso"));
				listaFiltrada.add(proyecto);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				resultadoConsulta.close();
				prepStatement.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return listaFiltrada;

	}

	/**
	 * Método para mostrar todo los datos de proyecto en base a el id que se
	 * introduzca
	 * 
	 * @param prID
	 * @return proyecto
	 */
	public ProyectoVO mostrarDetalle(int prID) {
		ProyectoVO proyecto = new ProyectoVO();
		PreparedStatement prepStatement = null;
		ResultSet resultadoConsulta = null;
		String consulta = "SELECT * FROM proyectos WHERE proyecto_id = ?";

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setInt(1, prID);

			resultadoConsulta = prepStatement.executeQuery();

			while (resultadoConsulta.next()) {

				proyecto.setIdProyecto(resultadoConsulta.getInt("proyecto_id"));
				proyecto.setNombreProyecto(resultadoConsulta.getString("nombre_proyecto"));
				proyecto.setUrl(resultadoConsulta.getString("url"));
				proyecto.setNota(resultadoConsulta.getDouble("nota"));
				proyecto.setYear(resultadoConsulta.getString("año"));
				proyecto.setCurso(resultadoConsulta.getString("curso"));
				proyecto.setGrupo(resultadoConsulta.getString("grupo"));
				proyecto.setArea(resultadoConsulta.getInt("area_id"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				resultadoConsulta.close();
				prepStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return proyecto;
	}

	/**
	 * Método para actualizar un proyecto
	 * 
	 * @param proyecto
	 * @param integrantes
	 * @param idPR
	 * @return resultado
	 */
	public String actualizarProyecto(ProyectoVO proyecto, int[] integrantes, int idPR) {
		String resultado = "";
		PreparedStatement prepStProyecto = null;
		PreparedStatement prepStBorrarIntegrantes = null;
		PreparedStatement prepStAñadirIntegrantes = null;

		String sqlInsertarProyecto = "UPDATE proyectos SET nombre_proyecto = ?, url=?, nota=?, año=?, curso=?, grupo=?, area_id=? WHERE proyecto_id = ?";
		String sqlBorrarIntegrantes = "DELETE FROM integrantes WHERE proyecto_id = ?";
		String sqlInsetarIntegrantes = "INSERT INTO integrantes (proyecto_id, user_id) VALUES (?, ?)";

		try {
			connection.setAutoCommit(false);
			prepStProyecto = connection.prepareStatement(sqlInsertarProyecto);
			prepStProyecto.setString(1, proyecto.getNombreProyecto());
			prepStProyecto.setString(2, proyecto.getUrl());
			prepStProyecto.setDouble(3, proyecto.getNota());
			prepStProyecto.setString(4, proyecto.getYear());
			prepStProyecto.setString(5, proyecto.getCurso());
			prepStProyecto.setString(6, proyecto.getGrupo());
			prepStProyecto.setInt(7, proyecto.getArea());
			prepStProyecto.setInt(8, proyecto.getIdProyecto());

			prepStProyecto.executeUpdate();

			prepStBorrarIntegrantes = connection.prepareStatement(sqlBorrarIntegrantes);
			prepStBorrarIntegrantes.setInt(1, proyecto.getIdProyecto());

			prepStBorrarIntegrantes.executeUpdate();

			prepStAñadirIntegrantes = connection.prepareStatement(sqlInsetarIntegrantes);
			for (int id_usuario : integrantes) {
				prepStAñadirIntegrantes.setInt(1, proyecto.getIdProyecto());
				prepStAñadirIntegrantes.setInt(2, id_usuario);
				prepStAñadirIntegrantes.executeUpdate();
			}
			connection.commit();
			resultado = "OK";
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();

			}
			resultado = "Error";
			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			try {
				if (prepStProyecto != null) {
					prepStProyecto.close();
				}
				if (prepStAñadirIntegrantes != null) {
					prepStAñadirIntegrantes.close();
				}
				if (prepStBorrarIntegrantes != null) {
					prepStBorrarIntegrantes.close();
				}

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return resultado;
	}

	/**
	 * Método que ñade un proyecto
	 * 
	 * @param proyecto
	 * @param integrantes
	 * @return resultado
	 */
	public String añadirProyecto(ProyectoVO proyecto, int[] integrantes) {
		String resultado = "";
		PreparedStatement prepStProyecto = null;
		PreparedStatement prepStIntegrantes = null;
		ResultSet rs = null;

		String sqlInsertarProyecto = "INSERT INTO proyectos (nombre_proyecto, url, nota, año, curso, grupo, area_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		String consultaID = "SELECT LAST_INSERT_ID()";

		try {
			connection.setAutoCommit(false);
			prepStProyecto = connection.prepareStatement(sqlInsertarProyecto, Statement.RETURN_GENERATED_KEYS);
			prepStProyecto.setString(1, proyecto.getNombreProyecto());
			prepStProyecto.setString(2, proyecto.getUrl());
			prepStProyecto.setDouble(3, proyecto.getNota());
			prepStProyecto.setString(4, proyecto.getYear());
			prepStProyecto.setString(5, proyecto.getCurso());
			prepStProyecto.setString(6, proyecto.getGrupo());
			prepStProyecto.setInt(7, proyecto.getArea());

			int filasDevueltas = prepStProyecto.executeUpdate();

			rs = prepStProyecto.getGeneratedKeys();
			int idProyectoAñadido = 0;
			if (rs.next()) {
				idProyectoAñadido = rs.getInt(1);
			}
			if (filasDevueltas == 1) {
				String sqlInsetarIntegrantes = "INSERT INTO integrantes (proyecto_id, user_id) VALUES (?, ?)";
				prepStIntegrantes = connection.prepareStatement(sqlInsetarIntegrantes);
				for (int id_usuario : integrantes) {
					prepStIntegrantes.setInt(1, idProyectoAñadido);
					prepStIntegrantes.setInt(2, id_usuario);
					prepStIntegrantes.executeUpdate();
				}
				connection.commit();
				resultado = "OK";
			} else {
				connection.rollback();
				resultado = "Error";
			}

		} catch (SQLException e) {

			try {
				if (connection != null) {
					connection.rollback();
					resultado = "Error";
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(e.getMessage());
			}
			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (prepStProyecto != null) {
					prepStProyecto.close();
				}
				if (prepStIntegrantes != null) {
					prepStIntegrantes.close();
				}

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return resultado;

	}

	/**
	 * Método para borrar un proyecto
	 * 
	 * @param idPR
	 * @return resultado
	 */
	public String borrarProyecto(int idPR) {

		String resultado = "";

		PreparedStatement prepStatement = null;
		String consulta = "DELETE FROM proyectos WHERE proyecto_id = ?";

		try {
			prepStatement = connection.prepareStatement(consulta);
			prepStatement.setInt(1, idPR);
			prepStatement.execute();

			resultado = "OK";

		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}

		System.out.println(resultado);
		return resultado;

	}

}