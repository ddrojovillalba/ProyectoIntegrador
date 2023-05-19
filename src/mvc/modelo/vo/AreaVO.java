package mvc.modelo.vo;

/**
 * @author Mario
 *
 */
public class AreaVO {

	private int id;
	private String nombre;
	private String descripcion;

	/**
	 * getter del id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter del id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter del nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * setter del nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getter de la descripcion
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * setter de la descripcion
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
