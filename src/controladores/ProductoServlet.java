package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.CarritoDao;
import datos.ProductoDao;
import modelos.NuevoProductoCarrito;
import modelos.Producto;
import modelos.ProductoCarrito;

/**
 *  Controlador encargado de gestionar y mostrar los productos de la aplicaciÛn web
 */

@WebServlet("/productos") // parte fija de la direccion
public class ProductoServlet extends HttpServlet { // /productos?idCategoria=, /productos?idCategoria=8

	private static final long serialVersionUID = 1L;
	private ProductoDao dao = new ProductoDao(); // tenemos que importar clase productoDao pq tiene el metodo leer
													// productos(accede a la bbdd)
	private CarritoDao carritoDao = new CarritoDao();

	// dentro las instrucciones_ una es la consulta en bbdd y la otra respuesta al
	// html

	// GET --> Todas las urls (enlaces) que se encarguen de mostrar datos sin
	// modificar la base de datos ej:mostrar lista de productos
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");// ?accion=AgregarCesta
		if (accion == null) {
			accion = "listar"; // La idea es que el switch nunca llegue a estar nulo,sino nos puede dar muchos
								// problemas.
		}

		switch (accion) {
		case "Cesta":
			response.sendRedirect(request.getContextPath() + "/carrito");
			break;
		case "listar":
		default:
			listarProductos(request, response);
			break;

		}

	}

// POST --> Cuando son operaciones que modifican el estado de la base de datos :
// registro de usuario, a√±adir producto a carrito...

// DELETE, PATCH, ...

	private void listarProductos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(); // rescata la session del usuario
		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito"); // recupera el carrito del usuario actual

		int num = carritoDao.cantidadProductosCesta(idCarrito);

		List<Producto> productosTienda = dao.leerTodos(); // Obtener la lista de productos desde el modelo

		if (idCarrito == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}

		// agregar lista de productos al request
		request.setAttribute("productos", productosTienda);
		request.setAttribute("cestaCantidadProd", num);

		// El request dispatcher es el lugar donde esta petici√≥n va a ser 'redigirida'
		// para ser tratada (por ejemplo, con un jsp que generar el HTML y lo devolvamos
		// al navegador)
		RequestDispatcher rd = request.getRequestDispatcher("/tienda.jsp");

		// ejecutamos el request
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession sesion = request.getSession();

		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito");

		if (idCarrito == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}

		int idProducto = Integer.parseInt(request.getParameter("idProducto"));

		String accion = request.getParameter("accion");
		
		ProductoCarrito producto = carritoDao.leer(idCarrito, idProducto);
		

		switch (accion) {
		
		case "agregar":
			if (producto == null) {
				// El producto no est· en el carrito, hay que aÒadirlo
				NuevoProductoCarrito nuevo = new NuevoProductoCarrito(idProducto, idCarrito, 1); // Instancia a
				// partir del constructor de NuevoProductoCarrito.java (que est· en modelo), al
				// que le
				// pasamos, como indica el constructor: idProducto,idCarrito,y numUnidades.
				carritoDao.crear(nuevo); // se guarda el producto en la BBDD.
			} else { // el producto ya existe: no lo creo de cero, sino que lo modifico:
				int numUds = producto.get_numUnidades() + 1;
				producto.set_numUnidades(numUds); // al prod que ya existe le incremento una unidad cada vez que
													// agrego.
				carritoDao.actualizar(producto); // guardo el cambio en la BBDD
			}
			break;
		case "quitar":
			if (producto != null) { // si producto existe
				int numUds = producto.get_numUnidades() - 1; // quito uds de producto de 1 en 1
				if (numUds == 0) {
					carritoDao.eliminar(idCarrito, producto.getId_producto()); // si reduzco uds a cero elimino producto
				} else { // si num uds es mayor que cero: simplemente actualizamos uds en BBDD
					producto.set_numUnidades(numUds);
					carritoDao.actualizar(producto);
				}
			}
			break;
		
		}
		listarProductos(request, response); // llama al metodo de listar productos
	}

		

}
