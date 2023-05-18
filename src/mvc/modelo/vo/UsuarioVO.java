package mvc.modelo.vo;

public class UsuarioVO {

	
	private int user_id;
	private String nombre;
	private String expediente;
	private String nick_name;
	private String password;
	private boolean is_teacher;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_user) {
		this.nick_name = nick_user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getIs_teacher() {

		return is_teacher;
		

	}
	public void setIs_teacher(String valor) {
		if (valor.equals("0")){
			
			this.is_teacher = false;

			
		}else {
			
			this.is_teacher = true;

		}
		
	}

}
