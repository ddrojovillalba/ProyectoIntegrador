package mvc.modelo.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.controlador.Coordinador;
import mvc.modelo.conexion.ConexionDB;
import mvc.modelo.vo.AreaVO;


public class AreaDTO {

	private Coordinador miCoordinador;
	
	
	public ArrayList<String> rellenarComboAreas() {
		
		
		
		

		ArrayList<String> listaAreas;
		Connection connection=null;
		PreparedStatement prepStatement=null;
		ResultSet resultadoConsulta=null;
		ConexionDB conexion = new ConexionDB();
		String consulta="SELECT nombre_corto FROM areas";
		connection=conexion.establecerConexion();
		listaAreas = new ArrayList<String>();
		
		

		
		try {
			prepStatement=connection.prepareStatement(consulta);
			resultadoConsulta=prepStatement.executeQuery();
			
			while (resultadoConsulta.next()) {
				listaAreas.add(resultadoConsulta.getString(1));
				
				
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
		
		return listaAreas;
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}

	public int devolverIdArea(String area) {
		
		Connection connection=null;
		PreparedStatement prepStatement = null;
		ConexionDB conexion = new ConexionDB();
		String query = "SELECT area_id FROM areas WHERE nombre_corto = ?";
		int idArea=0;
		ResultSet rs=null;
		try {
			connection=conexion.establecerConexion();
			prepStatement = connection.prepareStatement(query);
			prepStatement.setString(1, area);
			rs=prepStatement.executeQuery();
			while (rs.next()){
				idArea=Integer.parseInt(rs.getString("area_id"));
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
			idArea=-1;
		} finally {
			
			try {
				
				rs.close();
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		return idArea;
	}
	
	public String devolverNombreCortoArea(int area) {
		
		Connection conn=null;
		PreparedStatement prepStatement = null;
		ConexionDB conexion = new ConexionDB();
		String query = "SELECT nombre_corto FROM areas WHERE area_id = ?";
		String nombreCorto="";
		ResultSet rs=null;
		try {
			conn=conexion.establecerConexion();
			prepStatement = conn.prepareStatement(query);
			prepStatement.setInt(1, area);
			rs=prepStatement.executeQuery();
			while (rs.next()){
				nombreCorto=rs.getString("nombre_corto");
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			nombreCorto="Error";
		} finally {
			
			try {
				
				rs.close();
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return nombreCorto;
	}

	public AreaVO devolverArea(String nombreCorto) {
		
		Connection conn=null;
		PreparedStatement prepStatement = null;
		ConexionDB conexion = new ConexionDB();
		String query = "SELECT * FROM areas WHERE nombre_corto = ?";
		AreaVO area = new AreaVO();
		ResultSet rs=null;
		try {
			conn=conexion.establecerConexion();
			prepStatement = conn.prepareStatement(query);
			prepStatement.setString(1, nombreCorto);
			rs=prepStatement.executeQuery();
			while (rs.next()){
				area.setId(rs.getInt("area_id"));
				area.setNombre(rs.getString("nombre_corto"));
				area.setDescripcion(rs.getString("descripcion"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				rs.close();
				prepStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return area;
		
		
	
	}


}
