package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Producto;


/**
 * Clase que gestiona la conexiÛn a la base de datos relacionados a los productos de la tienda
 */

public class ProductoDao {

	/**
	 * Estabece la conexiÛn con la base de datos
	 */
	public ProductoDao() {
		try {
			Class.forName("org.sqlite.JDBC");
			
		} catch (ClassNotFoundException e) {
			
			throw new AccesoDatosException(e.getMessage());
		} //sentencia para que cargue el jar de jdbc en el proyecto(no solo vale con a√±adirlo en libreria. con el drive de mysql no hace falta, en sqlite s√≠)
	}
	
	
	/**
	 * Inserta un producto en la base de datos
	 * @param prod el producto a insertar
	 * @return el id del producto insertado
	 */
	//CRUD (Create-Read-Update-Delete)
	public int crear(Producto prod) {
		// Codigo para insertar producto en la tabla productos
		return 0; //Devolver√° el id generado por base de datos
	}
	
	public Producto leer(int idProducto) {
		try(Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			//Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM producto WHERE id = ?");
			ps.setInt(1, idProducto);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String ref = rs.getString("ref");
				double precio = rs.getDouble("precio");
				String nombre = rs.getString("nombre");
				String imagen = rs.getString("imagen");
				
				
				Producto producto = new Producto(idProducto, ref, nombre, precio, imagen);
				
				return producto;
			}
			else { //No se ha encontrado ningun producto con ese id
				return null;
			}
		}
		catch(SQLException e) { //reconvierte la sql exception a la personalizada que hemos creado, para relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}
	
	/**
	 *Lee todos los productos que existen en la base de datos 
	 * @return Un listado con todos los productos existente
	 */
	public List<Producto> leerTodos() {
		try(Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			//Statement o PreparedStatement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM producto");
			
			ArrayList<Producto> productos = new ArrayList<>();
			
			while(rs.next()) {
				int idProducto = rs.getInt("id"); //como aqui estamos leyendo todos los prod, necesitamos ponr el id
				String ref = rs.getString("ref");
				double precio = rs.getDouble("precio");
				String nombre = rs.getString("nombre");
				String imagen = rs.getString("imagen");
				
				
				Producto producto = new Producto(idProducto, ref, nombre, precio, imagen);
				
				productos.add(producto);
			}
			
			return productos;
		}
		catch(SQLException e) { //reconvierte la sql exception a la personalizada que hemos creado, para relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}
	

	/**
	 * Actualiza cualquier cambio en un producto de la base de datos
	 * @param prod el producto a actualizar
	 * @return Verdadero si ha ido todo bien, falso en caso contrario
	 */
	public boolean actualizar(Producto prod) { //producto _ necesito todos sus datos
		//UPDATE Producto...
		
		//Devuelve si ha sido actualizado o no
		return false;
	}
	
	/**
	 * Elimina un producto de la base de datos
	 * @param idProducto Id del producto a borrar
	 * @return Verdadero si se ha eliminado el producto, falso en caso contrario
	 */
	public boolean eliminar(int idProducto) { //con el id ya lo puedo eliminar
		//DELETE FROM Producto ... WHERE id = ...
		
		//Devuelve si ha sido eliminado o no
		return false;
	}

}
