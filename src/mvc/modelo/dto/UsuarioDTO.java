package mvc.modelo.dto;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mvc.controlador.Coordinador;
import mvc.vistas.VentanaLogin;
import mvc.modelo.conexion.*;
import mvc.modelo.vo.UsuarioVO;

public class UsuarioDTO {
	
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
		
	}
	
	
	// Método que comprueba las credenciales del usuario intentando acceder

	public String comprobarUsuario(UsuarioVO usuarioVO) {
		
		String respuesta="";
		Connection connection=null;
		PreparedStatement prepStatement=null;
		ResultSet resultadoConsulta=null;
		String consulta="SELECT user_id, name, es_profesor FROM users WHERE nick_name = ? AND password = ?; ";
		
		ConexionDB conexion = new ConexionDB();
		
		
		if (validarCampos(usuarioVO)) {
			
			try {
				connection=conexion.establecerConexion();
				prepStatement=connection.prepareStatement(consulta);
				prepStatement.setString(1, usuarioVO.getNick_name());
				prepStatement.setString(2, usuarioVO.getPassword());
				resultadoConsulta=prepStatement.executeQuery();
				if (resultadoConsulta.next()) {
					
					if (resultadoConsulta.getString("es_profesor").equals("1")) {   // Almacenamos si el usuario loggeado es o no profesor
						Coordinador.esProfesor=true;					// para variar las vistas de las ventanas en función de ello
					}else if (resultadoConsulta.getString("es_profesor").equals("0")){
						Coordinador.esProfesor=false;
					}
					
					Coordinador.usuarioLoggeado=(int) resultadoConsulta.getInt("user_id"); // Almacenamos el user_id del usuario Loggeado
					
					respuesta="Logged";
					
				}else {
					
					System.out.println("Los datos no coinciden");
					respuesta="Credenciales";
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				respuesta = "Error";
				
			} finally {
				
				try {
					
					resultadoConsulta.close();
					prepStatement.close();
					conexion.desconectar();
					
				} catch (SQLException e) {

					e.printStackTrace();
				}
				
			}
						
		}
		else {
			respuesta="faltan campos";
		}
	
		return respuesta;
		
	}


	
	
	// Metodo que devuelve un ArryList con los usuarios que coinciden con la búsueda
	
	public ArrayList<UsuarioVO> miListaUsuariosFiltada (String busqueda){
		
		UsuarioVO usuario;
		ArrayList<UsuarioVO>resultado = new ArrayList<>() ;
		Connection connection=null;
		PreparedStatement prepStatement=null;
		ResultSet resultadoConsulta=null;
		ConexionDB conexion = new ConexionDB();
		String consulta;
		if (busqueda.equals("")){
			consulta="SELECT user_id, name, expediente FROM users";  // Devuelveme todos los usuarios
		}else {
			consulta="SELECT user_id, name, expediente FROM users WHERE name REGEXP ? OR expediente REGEXP ? ORDER BY name"; // Devuelveme los usuarios buscados
		}
		connection=conexion.establecerConexion();
		
		
		
		System.out.println(busqueda+", "+ consulta);
		
		try {
			prepStatement=connection.prepareStatement(consulta);
			if (!busqueda.equals("")){
				prepStatement.setString(1, busqueda + "");
				prepStatement.setString(2, busqueda + "");
			}
			System.out.println(consulta + "despues del setString");
			resultadoConsulta=prepStatement.executeQuery();
			
			while (resultadoConsulta.next()) {
				
				usuario=new UsuarioVO();
				usuario.setUser_id(Integer.parseInt(resultadoConsulta.getString("user_id")));
				System.out.println(resultadoConsulta.getString("user_id"));
				usuario.setNombre(resultadoConsulta.getString("name"));
				System.out.println(resultadoConsulta.getString("name"));
				usuario.setExpediente(resultadoConsulta.getString("expediente"));
				System.out.println(resultadoConsulta.getString(3));
				resultado.add(usuario);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				resultadoConsulta.close();
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
		return resultado;	
		
	}



	public UsuarioVO mostrarDetalle(int userID) {
		
		UsuarioVO usuario=null;
		Connection connection=null;
		PreparedStatement prepStatement=null;
		ResultSet resultadoConsulta=null;
		ConexionDB conexion = new ConexionDB();
		String consulta="SELECT user_id, name, expediente, password, nick_name, es_profesor FROM users WHERE user_id LIKE ? ";
		connection=conexion.establecerConexion();
		
			
		try {
			prepStatement=connection.prepareStatement(consulta);
			prepStatement.setInt(1, userID);
			resultadoConsulta=prepStatement.executeQuery();
			
			while (resultadoConsulta.next()) {
				
				usuario=new UsuarioVO();
				usuario.setUser_id(Integer.parseInt(resultadoConsulta.getString("user_id")));
				System.out.println(resultadoConsulta.getString("user_id"));
				usuario.setNombre(resultadoConsulta.getString("name"));
				System.out.println(resultadoConsulta.getString("name"));
				usuario.setExpediente(resultadoConsulta.getString("expediente"));
				usuario.setNick_name(resultadoConsulta.getString("nick_name"));
				usuario.setPassword(resultadoConsulta.getString("password"));
				usuario.setIs_teacher(resultadoConsulta.getString("es_profesor"));					
						
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				resultadoConsulta.close();
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
		return usuario;
	}


	public String actualizarUsuario(UsuarioVO usuario) {
		
		String resultado = "";
		System.out.println("Conectado para actualizar");
		Connection connection=null;
		PreparedStatement prepStatement=null;
		
		ConexionDB conexion = new ConexionDB();
		String consulta="UPDATE users SET name = ?, expediente=?, password=?, nick_name=?, es_profesor=? WHERE user_id = ?";
		connection=conexion.establecerConexion();
		
			
		try {
			prepStatement=connection.prepareStatement(consulta);
			prepStatement.setString(1, usuario.getNombre());
			prepStatement.setString(2, usuario.getExpediente());
			prepStatement.setString(3, usuario.getPassword());
			prepStatement.setString(4, usuario.getNick_name());
			prepStatement.setBoolean(5, usuario.getIs_teacher());
			prepStatement.setInt(6, usuario.getUser_id());
			prepStatement.executeUpdate();
		
			resultado="OK";		
	
		}catch (Exception e) {
			
			e.printStackTrace();
			resultado="Error";
			
		}finally {
			
			try {
				
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
		return resultado;
	}


	public String registrarUsuario(UsuarioVO usuario) {
		
		String resultado = "";
		Connection connection=null;
		PreparedStatement prepStatement=null;
		
		ConexionDB conexion = new ConexionDB();
		String consulta="INSERT INTO users (name, expediente, password, nick_name, es_profesor) VALUES (?, ?, ?, ?, ?)";
		connection=conexion.establecerConexion();
		
			
		try {
			prepStatement=connection.prepareStatement(consulta);
			prepStatement.setString(1, usuario.getNombre());
			prepStatement.setString(2, usuario.getExpediente());
			prepStatement.setString(3, usuario.getPassword());
			prepStatement.setString(4, usuario.getNick_name());
			prepStatement.setBoolean(5, usuario.getIs_teacher());
			prepStatement.executeUpdate();
		
			resultado="OK";
		
				
	
		}catch (Exception e) {
			
			e.printStackTrace();
			resultado="Error";
			
		}finally {
			
			try {
				
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
		System.out.println(resultado);
		return resultado;
	}


	public String borrarUsuario(UsuarioVO usuario) {
		
		String resultado = "";
		Connection connection=null;
		PreparedStatement prepStatement=null;
		
		ConexionDB conexion = new ConexionDB();
		String consulta="DELETE FROM users WHERE user_id = ?";
		connection=conexion.establecerConexion();
		
			
		try {
			prepStatement=connection.prepareStatement(consulta);
			prepStatement.setInt(1, usuario.getUser_id());
			prepStatement.executeUpdate();
		
			resultado="OK";
		
				
	
		}catch (Exception e) {
			e.printStackTrace();
			resultado="Error";
		} finally {
			
			try {
				
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(resultado);
		return resultado;
		
		
	}


	public ArrayList<UsuarioVO> cargarAlumnos (){
		
		UsuarioVO usuario;
		ArrayList<UsuarioVO>listaUsuarios = new ArrayList<>() ;
		Connection connection=null;
		PreparedStatement prepStatement=null;
		ResultSet resultadoConsulta=null;
		ConexionDB conexion = new ConexionDB();
		String consulta;
		
		consulta="SELECT user_id, name, expediente FROM users WHERE es_profesor = 0"; // Devuelveme los usuarios buscados
		
		connection=conexion.establecerConexion();
		
		
		
			
		try {
			prepStatement=connection.prepareStatement(consulta);
			resultadoConsulta=prepStatement.executeQuery();
			
			while (resultadoConsulta.next()) {
				
				usuario=new UsuarioVO();
				usuario.setUser_id(Integer.parseInt(resultadoConsulta.getString("user_id")));
				System.out.println(resultadoConsulta.getString("user_id"));
				usuario.setNombre(resultadoConsulta.getString("name"));
				System.out.println(resultadoConsulta.getString("name"));
				usuario.setExpediente(resultadoConsulta.getString("expediente"));
				System.out.println(resultadoConsulta.getString(3));
				listaUsuarios.add(usuario);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				resultadoConsulta.close();
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return listaUsuarios;
		
		
	}
	
	
	// --------------------------------- Métodos auxiliares ---------
	
	

	private boolean validarCampos(UsuarioVO usuario) {
		
		boolean validUser=true;
		boolean validPass=true;
		
		
		if (usuario.getNick_name().isEmpty()){
			validUser=false;
		}
		if (usuario.getPassword().isEmpty()){
			validPass=false;
		}
		
		return validPass && validUser;
	}
		
}



	
	
	


