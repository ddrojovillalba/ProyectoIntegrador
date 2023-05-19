package mvc.modelo.vo;

/**
 * @author Mario
 *
 */
public class UsuarioVO {

	private int user_id;
	private String nombre;
	private String expediente;
	private String nick_name;
	private String password;
	private boolean is_teacher;

	/**
	 * getter del User_id
	 * 
	 * @return
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * setter del User_id
	 * 
	 * @param user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * getter de Nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * setter de nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getter de Expediente
	 * 
	 * @return expediente
	 */
	public String getExpediente() {
		return expediente;
	}

	/**
	 * setter de Expediente
	 * 
	 * @param expediente
	 */
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	/**
	 * getter de Nick_name
	 * 
	 * @return nick_name
	 */
	public String getNick_name() {
		return nick_name;
	}

	/**
	 * setter de Nick_name
	 * 
	 * @param nick_user
	 */
	public void setNick_name(String nick_user) {
		this.nick_name = nick_user;
	}

	/**
	 * getter de Password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter de Password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter de Is_teacher
	 * 
	 * @return is_teacher
	 */
	public boolean getIs_teacher() {

		return is_teacher;

	}

	/**
	 * setter de Is_teacher
	 * 
	 * @param valor
	 */
	public void setIs_teacher(String valor) {
		if (valor.equals("0")) {

			this.is_teacher = false;

		} else {

			this.is_teacher = true;

		}

	}

}
