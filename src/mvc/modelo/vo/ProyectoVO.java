package mvc.modelo.vo;

/**
 * @author Mario
 *
 */
public class ProyectoVO {

	private int idProyecto;
	private String nombreProyecto;
	private String url;
	private double nota;
	private String year;
	private String año;
	private String curso;
	private String grupo;
	private int area;

	// ----------------------------------- Getter y Setters ----------------------

	/**
	 * getter del IdProyecto
	 * 
	 * @return idProyecto
	 */
	public int getIdProyecto() {
		return idProyecto;
	}

	/**
	 * setter del Idproyecto
	 * 
	 * @param idProyecto
	 */
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	/**
	 * getter del NombreProyecto
	 * 
	 * @return
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	/**
	 * setter del nombreProyecto
	 * 
	 * @param nombreProyecto
	 */
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	/**
	 * getter de la Url
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * setter de la Url
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * getter de Nota
	 * 
	 * @return nota
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * setter de Nota
	 * 
	 * @param nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * getter de Year
	 * 
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * setter de Year
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * getter de Año
	 * 
	 * @return año
	 */
	public String getAño() {
		return año;
	}

	/**
	 * setter de Año
	 * 
	 * @param año
	 */
	public void setAño(String año) {
		this.año = año;
	}

	/**
	 * getter de Curso
	 * 
	 * @return curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * setter de Curso
	 * 
	 * @param curso
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * getter de Grupo
	 * 
	 * @return
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * setter de Grupo
	 * 
	 * @param grupo
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * getter de Area
	 * 
	 * @return area
	 */
	public int getArea() {
		return area;
	}

	/**
	 * setter de Area
	 * 
	 * @param area
	 */
	public void setArea(int area) {
		this.area = area;
	}

	// añadir campos de la tabla proyectos y sus getters y setters
}
