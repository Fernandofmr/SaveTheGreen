package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Carrito;
import modelos.NuevoProductoCarrito;
import modelos.ProductoCarrito;


/**
 * Gestiona toda la conexión con la base de datos relacionados con un carrito/cesta de la compra
 *
 */
public class CarritoDao {

	/**
	 * Estabece la conexión con la base de datos
	 */
	public CarritoDao() {
		try {
			Class.forName("org.sqlite.JDBC"); // Class.forName Se usa en el constructor para que reconozca el JAR en el
												// buildPath del proyecto.Con MYSQL no es necesario,con SQLite sí.

		} catch (ClassNotFoundException e) {

			throw new AccesoDatosException(e.getMessage());
		} // sentencia para que cargue el jar de jdbc en el proyecto(no solo vale con
			// aÃ±adirlo en libreria. con el drive de mysql no hace falta, en sqlite sÃ­)
	}

	// CRUD (Create-Read-Update-Delete)

	/**
	 *  Crear carrito (asignándole un id):
	 * @param carrito El carrito del cliente actual
	 * @return El id generado de dicho carrito
	 */
	public int crear(Carrito carrito) {
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Carrito (id) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS); // RETURN_GENERATED_KEYS le decimos que devuelva la clave generada
														// durante la sentencia.

			ps.setNull(1, java.sql.Types.INTEGER); // Null para que se genere un id por la propiedad autoincremental
													// (nosotros no lo tecleamos, lo genera automáticamente el
													// autoincrement)

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys(); // getGeneratedKeys() devuelve el id generado,pq el update anterior no
													// lo hace. Lo devuelve en forma de ResultSet

			if (rs.next()) {
				int id = rs.getInt(1); // obtenemos el id de la primera columna
				return id;
			} else { // No se ha encontrado ningun producto con ese id
				throw new AccesoDatosException("Error al obtener el id de la base de datos"); // Esta opción no debería
																								// ocurrir.
			}
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 *  Mostrar todos los productos de un carrito:
	 * @param idCarrito id del carrito del cual queremos mirar los productos
	 * @return Una lista con todos los productos de dicho carrito
	 */
	public List<ProductoCarrito> leerProductosCarrito(int idCarrito) {
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement(
					"SELECT producto.nombre, producto.precio, producto.id AS id_producto, producto_carrito.id_carrito, producto.imagen,producto_carrito.unidades FROM "
							+ "	producto JOIN producto_carrito " + "	ON producto.id = producto_carrito.id_producto "
							+ "WHERE producto_carrito.id_carrito = ?");
			ps.setInt(1, idCarrito);

			ResultSet rs = ps.executeQuery();
			List<ProductoCarrito> productos = new ArrayList<>(); // creamos lista para poder guardar todos los prod que
																	// se saquen
			while (rs.next()) { // como tenemos que sacar todos los productos(muchas filas) usamos while.
				String nombre = rs.getString("nombre");
				String imagen = rs.getString("imagen");
				double precio = rs.getDouble("precio");
				int id = rs.getInt("id_producto");
				int unidades = rs.getInt("unidades");
				// idCarrito no se usa porque ya se pasó como parámetro al método.

				ProductoCarrito producto = new ProductoCarrito(id, nombre, precio, unidades, imagen, idCarrito); // instancia
																													// prod.
				productos.add(producto); // añade producto a la lista
			}

			return productos;
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}
	
	/**
	 * Verifica si existen productos en un carrito concreto
	 * @param idCarrito carrito del cual queremos saber si hay productos
	 * @return El estado de dicho carrito (verdadero o falso)
	 */
	public boolean leerProductos(int idCarrito) {
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement(
					"SELECT id_producto FROM producto_carrito WHERE id_carrito = ?");
			ps.setInt(1, idCarrito);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) { 
				
				return true; //hay productos
			}

			return false; //no hay productos
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}
	
	
	

	/**
	 * Mete un nuevo producto en la cesta
	 * @param producto datos del Producto a introducir al carrito
	 * @return el id del  producto 
	 */
	public int crear(NuevoProductoCarrito producto) { // cuando no tenemos ningun producto en el carrito
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO producto_carrito (id_producto,id_carrito,unidades) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, producto.getId_producto());
			ps.setInt(2, producto.getIdCarrito());
			ps.setInt(3, producto.get_numUnidades());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				int id = rs.getInt(1);
				return id;
			} else { // No se ha encontrado ningun producto con ese id
				throw new AccesoDatosException("Error al obtener el id de la base de datos");
			}
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 *  Modificar un producto concreto existente en un carrito (actualizar uds):
	 * @param producto producto a modificar
	 * @return verdadero si se ha actualizado, falso en caso contrario
	 */
	public boolean actualizar(ProductoCarrito producto) { // Cuando queremos añadir o quitar de un producto existente en
															// el carrito
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			// Aqui lo que hacemos es cambiar las unidades:
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE producto_carrito SET unidades = ? WHERE id_carrito = ? AND id_producto = ?");
			ps.setInt(1, producto.get_numUnidades());
			ps.setInt(2, producto.getIdCarrito());
			ps.setInt(3, producto.getId_producto());
			int filasActualizadas = ps.executeUpdate();
			return filasActualizadas == 1; // estamos actualizando un producto concreto
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 * Eliminar todos los productos de un carrito concreto:
	 * @param idCarrito carrito del cual queremos eliminar los productos
	 * @return Verdadero si se lleva a cabo la eliminación, falso en caso contrario
	 */
	public boolean eliminarProductosCarrito(int idCarrito) { // eliminar todos los productos (todas las filas) de un
																// carrito determinado (con un id determinado)
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("DELETE FROM producto_carrito WHERE id_carrito = ?");
			ps.setInt(1, idCarrito);
			int filasEliminadas = ps.executeUpdate();
			return filasEliminadas > 0; // para saber si se ha borrado alguna fila o no.
		} // esto no va a fallar salvo un fallo de conexión a la BBDD o algo así.
		catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 * Eliminar un producto concreto de un carrito concreto:
	 * @param idCarrito carrito del cual queremos eliminar un producto concreto
	 * @param idProducto producto que queremos eliminar de un carrito concreto
	 * @return Verdadero si ha efectuado la eliminación, falso en caso contrario
	 */
	public boolean eliminar(int idCarrito, int idProducto) { // con los id ya lo puedo eliminar
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM producto_carrito WHERE id_carrito = ? AND id_producto = ?");
			ps.setInt(1, idCarrito);
			ps.setInt(2, idProducto);
			int filasEliminadas = ps.executeUpdate();
			return filasEliminadas > 0;
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

	/**
	 *  Mostrar un producto concreto de un carrito concreto:
	 * @param idCarrito Carrito del cual queremos saber un producto concreto
	 * @param idProducto Producto buscado
	 * @return Todos los atributos del producto que estamos buscando
	 */
	public ProductoCarrito leer(int idCarrito, int idProducto) {
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement(
					"SELECT producto.nombre, producto.precio, producto.id AS id_producto, producto_carrito.id_carrito, producto.imagen,producto_carrito.unidades FROM "
							+ "	producto JOIN producto_carrito " + "	ON producto.id = producto_carrito.id_producto "
							+ "WHERE producto_carrito.id_carrito = ? AND producto_carrito.id_producto = ?");
			ps.setInt(1, idCarrito);
			ps.setInt(2, idProducto);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String imagen = rs.getString("imagen");
				double precio = rs.getDouble("precio");
				int unidades = rs.getInt("unidades");

				ProductoCarrito producto = new ProductoCarrito(idProducto, nombre, precio, unidades, imagen, idCarrito);
				return producto;
			}

			return null;
		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}
	
	
	/**
	 * Cantidad de productos en un carrito concreto
	 * @param idCarrito Carrito del cual queremos saber la cantidad de productos
	 * @return Cantidad de producto de dicho carrito
	 */
	public int cantidadProductosCesta(Integer idCarrito) {

		try {
			int unidad = 0;
			Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL);

			PreparedStatement ps = conn
					.prepareStatement("SELECT unidades FROM " + " producto_carrito WHERE id_carrito = ?");
			ps.setInt(1, idCarrito);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				unidad = unidad + rs.getInt("unidades");

			}
			if (unidad != 0) {
				return unidad;
			} else {
				return 0;
			}

		} catch (SQLException e) { // reconvierte la sql exception a la personalizada que hemos creado, para
									// relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}

	}

}
