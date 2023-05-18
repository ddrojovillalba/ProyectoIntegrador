package main;


import mvc.controlador.Coordinador;
import mvc.modelo.Logica;
import mvc.modelo.dto.*;
import mvc.vistas.BuscarProyectos;
import mvc.vistas.BusquedaEdicionAlumnos;
import mvc.vistas.DetalleAlumno;
import mvc.vistas.DetallesAreas;
import mvc.vistas.DetallesProyecto;
import mvc.vistas.VentanaLogin;
import mvc.vistas.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {

	// Creamos las instancias únicas de las distintas clases
		
		// Vistas
		
		Coordinador miCoordinador=new Coordinador();
		Logica miLogica=new Logica();
		UsuarioDTO miUsuarioDTO=new UsuarioDTO();
		AreaDTO miAreaDTO = new AreaDTO();
		ProyectoDTO miProyectoDTO = new ProyectoDTO();
		IntegrantesDTO miIntengrantesDTO = new IntegrantesDTO();
		
		VentanaPrincipal miVentanaAplicacion = new VentanaPrincipal();
		VentanaLogin miVentanaLogin= new VentanaLogin(miVentanaAplicacion, true);
		BusquedaEdicionAlumnos miBuscarAlumnos = new BusquedaEdicionAlumnos(miVentanaAplicacion, true);
		DetalleAlumno miDetalleAlumno = new DetalleAlumno(miBuscarAlumnos);
		BuscarProyectos miBuscarProyectos = new BuscarProyectos(miVentanaAplicacion, true);
		DetallesProyecto miDetallesProyectos = new DetallesProyecto(miBuscarProyectos);
		DetallesAreas miDetallesAreas = new DetallesAreas(miVentanaAplicacion, true);
		
		
		
		
		
		// Mandamos copia de miCoordinador a cada clase
		
		miVentanaAplicacion.setCoordinador(miCoordinador);
		miVentanaLogin.setCoordinador(miCoordinador);
		miBuscarAlumnos.setCoordinador(miCoordinador);
		miDetalleAlumno.setCoordinador(miCoordinador);
		miBuscarProyectos.setCoordinador(miCoordinador);
		miDetallesProyectos.setCoordinador(miCoordinador);
		miDetallesAreas.setCoordinador(miCoordinador);
		
		miLogica.setCoordinador(miCoordinador);
		miUsuarioDTO.setCoordinador(miCoordinador);
		miAreaDTO.setCoordinador(miCoordinador);
		miProyectoDTO.setCoordinador(miCoordinador);
		miIntengrantesDTO.setCoordinador(miCoordinador);
		
			
		// Mandamos una copia de cada instancia al Coordinador
				
		miCoordinador.setVentanaAplicacion(miVentanaAplicacion);
		miCoordinador.setVentanaLogin(miVentanaLogin);
		miCoordinador.setLogica(miLogica);
		miCoordinador.setUsuarioDTO(miUsuarioDTO);
		miCoordinador.setVentanaBusqueda(miBuscarAlumnos);
		miCoordinador.setVentanaDetalle(miDetalleAlumno);
		miCoordinador.setBuscarProyectos(miBuscarProyectos);
		miCoordinador.setDetallesProyecto(miDetallesProyectos);
		miCoordinador.setAreaDTO(miAreaDTO);
		miCoordinador.setProyectoDTO(miProyectoDTO);
		miCoordinador.setIntegrantesDTO(miIntengrantesDTO);
		miCoordinador.setDetallesAreas(miDetallesAreas);
		 
				
		miVentanaAplicacion.setListener(miCoordinador);		
		miVentanaAplicacion.setVisible(true);
		miVentanaLogin.setListener(miCoordinador);
		miVentanaLogin.setVisible(true);
		miBuscarAlumnos.setListeners(miCoordinador);
		miDetalleAlumno.setListeners(miCoordinador);
		miBuscarProyectos.setListeners(miCoordinador);
		miDetallesProyectos.setListeners(miCoordinador);
		miDetallesProyectos.rellenarTabla(miUsuarioDTO.cargarAlumnos());
		miDetallesProyectos.rellenarComboAreas(miCoordinador.rellenarComboAreas());
		miDetallesAreas.rellenarComboAreas(miCoordinador.rellenarComboAreas());
		miDetallesAreas.SetListener();
	}

}
