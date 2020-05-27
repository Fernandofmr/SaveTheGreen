package modelos;

/**
 * 
 *Contiene los atributos de un usuario. 
 *
 */

public class Usuario {

	 

	private int id_usuario;
	private int _tipo;/* tipo de usuario: 1 - gerente , 2 - cliente */
	private String _login, // login usuario
			_clave, // contraseña usuario
			nombre, 
			apellido1, 
			apellido2, 
			dni, email, 
			telefono, 
			fecha_nacimiento, 
			direccion, 
			ccaa;
	private int id_carrito; //cada vez que creamos un usuario le asignamos un carrito

	public Usuario() { // al crear al usuario no tiene id

		this.id_usuario = 0;
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

	public Usuario(int id, int tipo, String login, String clave, String nombre, String apellido1, String apellido2,
			String dni, String email, String telefono, String fecha_nacimiento, String direccion, int id_carrito) { //recoge los datos cuando se van a meter a la base de datos 

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
	
	public Usuario(int id, int tipo, String login, String clave, String nombre, String apellido1, String apellido2,
			String dni, String email, String telefono, String fecha_nacimiento, String direccion, String comunidad, int id_carrito) { //recoge los datos cuando se van a meter a la base de datos 

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
		this.ccaa = comunidad;
		this.id_carrito = id_carrito;

	}

	public Usuario(int tipo, String login, String clave, String nombre, String apellido1, String apellido2,
			String dni, String email, String telefono, String fecha_nacimiento, String direccion, String comunidad) { //recoge los datos del usuario cuando los mete por la web

		
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
		this.ccaa = comunidad;

	}

	// getters y setters
	


	/**
	 * 
	 * @param login El login del usuario a establecer
	 */
	public void setLogin(String login) {
		_login = login;
	}
	
	/**
	 * 
	 * @param clave La contraseña del usuario a establecer
	 */
	public void setClave(String clave) {

		_clave = clave;
	}
	
	/**
	 * 
	 * @param tipo El tipo de usuario que accede a la tienda
	 */
	public void setTipo(int tipo) {
		_tipo = tipo;
	}
	
	/**
	 * 
	 * @param nombre El nombre de usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**
	 * @param apell1 El primer apellido del usuario a establecer
	 */
	public void setApellido1(String apell1) {
		this.apellido1 = apell1;
	}
	
	/**
	 * 
	 * @param apell2 El segundo apellido del usuario
	 */
	public void setApellido2(String apell2) {
		this.apellido2 = apell2;
	}

	/**
	 * 
	 * @param dnie El dni del usuario
	 */
	public void setDni(String dnie) {
		this.dni = dnie;
	}

	/**
	 * 
	 * @param email El email del usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @param telefono El telefono del usuario
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * 
	 * @param fecha_nac La fecha de nacimiento del usuario
	 */
	public void setFechaNacimiento(String fecha_nac) {
		this.fecha_nacimiento = fecha_nac;
	}
	
	/**
	 * 
	 * @param ccaa Proporciona la comunidad autónoma del cliente
	 */
	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}
	
	/**
	 * 
	 * @return El login de un usuario
	 */
	public String getLogin() {

		return _login;
	}
	
	/**
	 * 
	 * @return La contraseña de un usuario
	 */
	public String getClave() {

		return _clave;
	}
	
	
	/**
	 * 
	 * @return El tipo de usuario que intenta acceder a la tienda
	 */
	public int getTipo() {

		return _tipo;
	}
	
	
	/**
	 * 
	 * @return El nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * 
	 * @return El primer apellido del usuario
	 */
	public String getApellido1() {
		return apellido1;
	}
	
	/**
	 * 
	 * @return El segundo apellido del usuario
	 */
	public String getApellido2() {
		return apellido2;
	}
	
	/**
	 * 
	 * @return el dni del usuario
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * 
	 * @return El email del usuario
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return El telefono del usuario
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * 
	 * @return La fecha de nacimeinto del usuario
	 */
	public String getFechaNacimiento() {
		return fecha_nacimiento;
	}
	
	/**
	 * 
	 * @return La dirección del usuario
	 */
	public String getDireccion() {
		return direccion;
	}
	
		
	/**
	 * 
	 * @param direccion La direccion del usuario
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * @return El id del usuario
	 */
	public int getId() {
		return id_usuario;
	}
	
	/**
	 * 
	 * @return El id del carrito/cesta
	 */
	public int getIdCarrito() {
		return id_carrito;
	}
	
	/**
	 * 
	 * @param idCarrito Proporciona un id al carrio
	 */
	public void setIdCarrito(int idCarrito) {
		this.id_carrito = idCarrito;
	}
	
	
	/**
	 * 
	 * @return La comunidad autónoma del cliente
	 */
	public String getCcaa() {
		return ccaa;
	}
	
	
	
	

}
