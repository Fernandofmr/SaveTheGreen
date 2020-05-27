package modelos;

public class Usuarios {
	
/* Contiene los atributos de un usuario. */
	
	
	
	private int id_usuario;
	private int _tipo;/* tipo de usuario: 1 - gerente , 2 - cliente */
	private String _login, //login usuario
	_clave, //contraseña usuario
	nombre, 
	apellido1,
	apellido2, 
	dni, 
	email,
	telefono, 
	fecha_nacimiento,
	direccion;
	private int id_carrito;
	
	
	public Usuarios() { //al crear al usuario no tiene id
		
		this.id_usuario =0;
		this._login = null;
		this._login = null;
		this._clave = null;
		this._tipo = 0;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.dni = null;
		this.email = null;
		this.telefono = null;
		this.fecha_nacimiento = null;
		this.direccion = null;
		this.id_carrito = 0;

	}
	
	
	public Usuarios(int id,int tipo, String login, String clave,  String nombre, String apellido1, String apellido2, String dni, String email, 
					String telefono, String fecha_nacimiento, String direccion, int id_carrito) {
		
		this.id_usuario = id;
		this._login = login;
		this._clave = clave;
		this._tipo = tipo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.id_carrito = id_carrito;
		
	}
	
	//getters y setters
	
	public void setLogin(String login) {
		_login = login;
	}
	
	public void setClave(String clave) {
		
		_clave = clave;
	}
	
	public void setTipo(int tipo) {
		_tipo = tipo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido1(String apell1) {
		this.apellido1 = apell1;
	}
	
	public void setApellido2(String apell2) {
		this.apellido2 = apell2;
	}
	
	public void setDni(String dnie) {
		this.dni= dnie;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelefono(String telefono) {
		this.telefono =  telefono;
	}
	
	public void setFechaNacimiento(String fecha_nac) {
		this.fecha_nacimiento =  fecha_nac;
	}
	

	public String getLogin() {

		return _login;
	}

	public String getClave() {

		return _clave;
	}

	public int getTipo() {

		return _tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getFechaNacimiento() {
		return fecha_nacimiento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
