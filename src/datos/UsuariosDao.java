package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Usuario;

/**
 * Clase que establece la conexión con la base de datos relacionados con el
 * usurio que accede a la web
 *
 */

public class UsuariosDao {

	/**
	 * Estabece la conexión con la base de datos
	 */
	public UsuariosDao() {

		try {
			Class.forName(DataBaseConfiguration.DRIVER_CLASS);

		} catch (ClassNotFoundException e) {

			throw new AccesoDatosException(e.getMessage());
		} // sentencia para que cargue el jar de jdbc en el proyecto(no solo vale con
			// aÃ±adirlo en libreria. con el drive de mysql no hace falta, en sqlite sÃ­)
	}

	// CRUD (Create-Read-Update-Delete)

	/**
	 * Introduce un nuevo usuario en la base de datos
	 * 
	 * @param usuario Datos del usuario a introducir
	 * @return El id que genera dicho usuario
	 */
	public int crear(Usuario usuario) throws SQLException {
		// Codigo para insertar usuario en la tabla usuario

		Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL);

		try (PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO usuario_datos (rol, nombre_usuario, contrasenia, nombre, apellido1, apellido2, dni, email, telefono, fecha_nacimiento,direccion, ccaa, id_carrito) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);) {

			// BCrypt
			// MD5, SHA-128, SHA-256
			// SHA-512
			ps.setInt(1, usuario.getTipo());// El cliente siempre tiene numero 2 asociado cuando se da de alta
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getClave());
			ps.setString(4, usuario.getNombre());
			ps.setString(5, usuario.getApellido1());
			ps.setString(6, usuario.getApellido2());
			ps.setString(7, usuario.getDni());
			ps.setString(8, usuario.getEmail());
			ps.setString(9, usuario.getTelefono());
			ps.setString(10, usuario.getFechaNacimiento());
			ps.setString(11, usuario.getDireccion());
			ps.setString(12, usuario.getCcaa());
			ps.setInt(13, usuario.getIdCarrito()); // le asigna un id de carrito automático al nuevo cliente

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int idGenerado = rs.getInt(1); // obtiene el id generado automaticamente por la bbdd

			conn.close();
			return idGenerado;

		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage());
		}

	}

	/**
	 * Busca y lee todos los datos de un usuario de la base de datos
	 * 
	 * @param idUsuario Id del usuario buscar
	 * @return El usuario buscado
	 */
	public Usuario leer(int idUsuario) {
		
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL);) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuario_datos WHERE id_usuario = ?");
			ps.setInt(1, idUsuario);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				int rol = rs.getInt("rol");
				String loginUsuario = rs.getString("nombre_usuario");
				String pass = rs.getString("contrasenia");
				String nombrePersonal = rs.getString("nombre");
				String apell1 = rs.getString("apellido1");
				String apell2 = rs.getString("apellido2");
				String dni = rs.getString("dni");
				String email = rs.getString("email");
				String tel = rs.getString("telefono");
				String fecha_nac = rs.getString("fecha_nacimiento");
				String direccion = rs.getString("direccion");
				String com_aut = rs.getString("ccaa");
				int id_carrito = rs.getInt("id_carrito");

				Usuario usuario = new Usuario(idUsuario, rol, loginUsuario, pass, nombrePersonal, apell1, apell2, dni,
						email, tel, fecha_nac, direccion, com_aut,  id_carrito);

				return usuario;
			} else { // No se ha encontrado ningun usuario con ese id
				return null;
			}
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 * Busca y lee todos los usuarios que existen la base de datos
	 * 
	 * @return Una lista con todos los usuarios
	 */
	public List<Usuario> leerTodos() {
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL);) {
			// Statement o PreparedStatement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuario_datos");

			ArrayList<Usuario> Usu = new ArrayList<>();

			while (rs.next()) {

				int idUsuario = rs.getInt("id_usuario"); // como aqui estamos leyendo todos los Usuarios, necesitamos
															// poner el id
				int rol = rs.getInt("rol");
				String login = rs.getString("nombre_usuario");
				String contrasenia = rs.getString("contrasenia");
				String nombrePersonal = rs.getString("nombre");
				String ap1 = rs.getString("apellido1");
				String ap2 = rs.getString("apellido2");
				String dni = rs.getString("dni");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				String fecha_nacimiento = rs.getString("fecha_nacimiento");
				String direccion = rs.getString("direccion");
				String ccaa = rs.getString("ccaa");
				int idCarrito = rs.getInt("id_carrito");

				Usuario E = new Usuario(idUsuario, rol, login, contrasenia, nombrePersonal, ap1, ap2, dni, email,
						telefono, fecha_nacimiento, direccion, ccaa, idCarrito);

				Usu.add(E);
			}

			return Usu;
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 * Actualiza los datos relativos a un usuario de la base de datos
	 * 
	 * @param usuario El usuario a modificar
	 * @return Verdadero si todo ha ido correctamente, falso en caso contrario
	 */
	public boolean actualizar(Usuario usuario) { // usuarios
		// Codigo para insertar usuario en la tabla usuario
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL);) {

			PreparedStatement ps = conn.prepareStatement("UPDATE usuario_datos SET rol = ?, nombre_usuario = ?,"
					+ " contrasenia = ?, nombre = ?, apellido1= ?, apellido2 = ?, dni = ?, email = ?, "
					+ "telefono = ?, fecha_nacimiento = ?,direccion = ?, ccaa = ?, id_carrito = ? WHERE id_usuario = ?");

			// BCrypt
			// MD5, SHA-128, SHA-256
			// SHA-512
			ps.setInt(1, usuario.getTipo());// El cliente siempre tiene numero 2 asociado cuando se da de alta
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getClave());
			ps.setString(4, usuario.getNombre());
			ps.setString(5, usuario.getApellido1());
			ps.setString(6, usuario.getApellido2());
			ps.setString(7, usuario.getDni());
			ps.setString(8, usuario.getEmail());
			ps.setString(9, usuario.getTelefono());
			ps.setString(10, usuario.getFechaNacimiento());
			ps.setString(11, usuario.getDireccion());
			ps.setString(12, usuario.getCcaa());
			ps.setInt(13, usuario.getIdCarrito()); // le asigna un id de carrito automático al nuevo cliente
			ps.setInt(14, usuario.getId());

			int filasAfectadas = ps.executeUpdate();

			return filasAfectadas == 1;

		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 * Elimina un usuario de la base de datos
	 * 
	 * @param idUsuario Id del usuario buscado
	 * @return Verdadero si se ha eliminado el usuario, falso en caso contrario
	 */
	public boolean eliminar(int idUsuario) { // con el id ya lo puedo eliminar
		// DELETE FROM usuario_datos ... WHERE id = ...

		// Devuelve si ha sido eliminado o no
		return false;
	}

	/**
	 * Localiza un usuario que está tratando de acceder a la aplicación con su
	 * email,que es único. si el email existe, podemos saber si el usuario está ya
	 * registrado.
	 * 
	 * @param email El email del usuario a buscar
	 * @return El usuario buscado
	 */

	public Usuario leer(String email) {
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL);) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuario_datos WHERE email = ?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				int rol = rs.getInt("rol");
				String loginUsuario = rs.getString("nombre_usuario");
				String pass = rs.getString("contrasenia");
				String nombrePersonal = rs.getString("nombre");
				String apell1 = rs.getString("apellido1");
				String apell2 = rs.getString("apellido2");
				String dni = rs.getString("dni");
				int idUsuario = rs.getInt("id_usuario");
				String tel = rs.getString("telefono");
				String fecha_nac = rs.getString("fecha_nacimiento");
				String direccion = rs.getString("direccion");
				String ccaa = rs.getString("ccaa");
				int id_carrito = rs.getInt("id_carrito");

				Usuario usuario = new Usuario(idUsuario, rol, loginUsuario, pass, nombrePersonal, apell1, apell2, dni,
						email, tel, fecha_nac, direccion, ccaa, id_carrito);

				return usuario;
			} else { // No se ha encontrado ningun producto con ese id
				return null;
			}
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

}
