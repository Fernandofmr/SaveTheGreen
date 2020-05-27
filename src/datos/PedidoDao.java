package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.DetallePedido;
import modelos.EstadoPedido;
import modelos.Pedido;
import modelos.ProductoPedido;
import modelos.ProductoPedidoDetalle;

/**
 * Gestiona toda la conexión con la base de datos relacionados con los pedidos realizados en la tienda
 * 
 */
public class PedidoDao {
	
	/**
	 * Estabece la conexión con la base de datos
	 */
	
	public PedidoDao() {
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
	 * Introduce un nuevo pedido en la base de datos 
	 * @param pedido Pedido a introducir
	 * @return El id del nuevo pedido
	 */
	//Crear pedido (asignándole un id):
	public int crear(Pedido pedido) {
		try (Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			// Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("INSERT INTO pedido (estado,id_cliente,direccion_envio,forma_pago_id,total,fecha) VALUES (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS); // RETURN_GENERATED_KEYS le decimos que devuelva la clave generada
														// durante la sentencia.
			
			ps.setString(1, pedido.getEstado().toString());
			ps.setInt(2, pedido.getIdCliente());
			ps.setString(3, pedido.getDireccionEnvio());
			ps.setInt(4, pedido.getIdFormaPago());
			ps.setDouble(5, pedido.getTotal());
			ps.setString(6, pedido.getFecha());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys(); // getGeneratedKeys() devuelve el id generado,pq el update anterior no
													// lo hace. Lo devuelve en forma de ResultSet

			if (rs.next()) {
				int idPedido = rs.getInt(1);  //obtenemos el id de la primera columna
				
				ps.close();
				
				ps = conn.prepareStatement("INSERT INTO producto_pedido (id_producto,id_pedido,unidades, precio_ud) VALUES (?,?,?,?)");
				
				for(ProductoPedido p : pedido.getProductos()) {
					ps.setInt(1, p.getIdProducto());
					ps.setInt(2, idPedido);
					ps.setInt(3, p.getUds());
					ps.setDouble(4, p.getPrecioUd());
					
					ps.execute();
				}
				
				return idPedido;
			}
			else { //No se ha encontrado ningun producto con ese id
				throw new AccesoDatosException("Error al obtener el id de la base de datos"); //Esta opción no debería ocurrir.
			}
		}
		catch(SQLException e) { //reconvierte la sql exception a la personalizada que hemos creado, para relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}
	
	
	/**
	 * Gestiona un pedido a través de su id y retorna todos los detalles de dicho pedido
	 * @param id El id del pedido buscado
	 * @return Todos los detalles del pedido
	 */
	public DetallePedido leerDetalle(int id) {
		try(Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			//Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("SELECT p.id AS id_pedido, p.fecha, pp.id_producto AS id_producto," + 
					"p.id_cliente, du.nombre AS cliente, pr.imagen AS producto_imagen, " + 
					"direccion_envio, total,unidades, precio_ud, forma_pago_id, " + 
					"pr.nombre AS producto, fp.nombre AS forma_pago, p.estado AS estado_pedido  FROM pedido p JOIN producto_pedido pp " + 
					"ON p.id = pp.id_pedido " + 
					"JOIN producto pr " + 
					"ON pr.id = pp.id_producto " + 
					"JOIN forma_pago fp " + 
					"ON fp.id = p.forma_pago_id " + 
					"JOIN usuario_datos du " + 
					"ON du.id_usuario = p.id_cliente " + 
					"WHERE p.id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			int formaPagoId = 0;
			String formaPago = null;
			double total = 0;
			String nombreCliente = null;
			String fecha = null;
			EstadoPedido estado = null;
			int clienteId = 0;
			String direccionEnvio = null;
		
			List<ProductoPedidoDetalle> productos = new ArrayList<>();
			while(rs.next()) {
				formaPagoId = rs.getInt("forma_pago_id");
				formaPago = rs.getString("forma_pago");
				total = rs.getDouble("total");
				fecha = rs.getString("fecha");
				nombreCliente = rs.getString("cliente");
				estado = EstadoPedido.valueOf(rs.getString("estado_pedido"));
				clienteId = rs.getInt("id_cliente");
				direccionEnvio = rs.getString("direccion_envio");
				
				int idProducto = rs.getInt("id_producto");
				int uds = rs.getInt("unidades");
				double precioUd = rs.getDouble("precio_ud");
				String imagen = rs.getString("producto_imagen");
				String nombre = rs.getString("producto");
			
				ProductoPedidoDetalle producto = new ProductoPedidoDetalle(idProducto, id, nombre, imagen, precioUd, uds);
				productos.add(producto);
			}
			
			if(productos.isEmpty())
				return null;
			
			DetallePedido pedido = new DetallePedido(id, direccionEnvio,formaPagoId, formaPago, clienteId, nombreCliente,total,
					estado, productos, fecha);
			
			return pedido;
			
		}
		catch(SQLException e) { //reconvierte la sql exception a la personalizada que hemos creado, para relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}
	
	public List<Pedido> leerPedidosCliente(int idCliente) {
		try(Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			//Statement o PreparedStatement
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM pedido WHERE id_cliente = ?");
			ps.setInt(1, idCliente);
			
			ResultSet rs = ps.executeQuery();
		
			List<Pedido> pedidos = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int formaPagoId = rs.getInt("forma_pago_id");
				double total = rs.getDouble("total");
				String fecha = rs.getString("fecha");
				EstadoPedido estado = EstadoPedido.valueOf(rs.getString("estado"));
				int clienteId = rs.getInt("id_cliente");
				String direccionEnvio = rs.getString("direccion_envio");

				Pedido pedido = new Pedido(id, direccionEnvio,formaPagoId, total,estado,null, clienteId, fecha);
				pedidos.add(pedido);
			}

			return pedidos;
		}
		catch(SQLException e) { //reconvierte la sql exception a la personalizada que hemos creado, para relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

}
