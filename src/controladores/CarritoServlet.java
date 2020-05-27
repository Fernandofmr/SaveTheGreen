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
import modelos.NuevoProductoCarrito;
import modelos.ProductoCarrito;


/**
 * 
 * Controlador encargado de gestionar los productos en el carrito
 *
 */

@WebServlet("/carrito") // parte fija de la direccion. (Es el servlet que estamos usando)
public class CarritoServlet extends HttpServlet { // /productos?idCategoria=, /productos?idCategoria=8 : la
													// interrogación indica "la acción" a realizar

	private static final long serialVersionUID = 1L;
	private CarritoDao dao = new CarritoDao(); // tenemos que importar clase productoDao pq tiene el metodo leer
												// productos(accede a la bbdd)

	// dentro las instrucciones_ una es la consulta en bbdd y la otra respuesta al
	// html

	// GET --> Todas las urls (enlaces) que se encarguen de mostrar datos sin
	// modificar la base de datos ej:mostrar lista de productos
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito"); // con getAttribute veo si ese idCarrito existe
																		// o no. integer es equivalente a int pero en
																		// forma de objeto. un objeto sí puede ser null:
																		// casteo para q no devuelva int.

		if (idCarrito == null) {// si el usuario borra cookies, se pierde la sesión e id del carrito
			response.sendRedirect(request.getContextPath() + "/login"); // redirige al inicio de sesión. La diferencia
																		// es que aqui no vamos a redirigirle a un jsp,
																		// sino a otro servlet, que es el que inicia
																		// sesion
																		// (por eso no usamos el RequestDispatcher). En
																		// este caso
			// cuidado porque hay que poner la dirección completa:
			// http://localhost:8080/nombreProyecto/.../login
			// o lo que es lo mismo, request.getContextPath()+ "/login" que es la ruta que
			// el servlet sabe que tiene que poner para q esto funcione.

		} else { // si tiene carrito,saca los productos de ese carrito y los "pinta" en el jsp

			List<ProductoCarrito> productos = dao.leerProductosCarrito(idCarrito); // saca la lista de ProductosCarrito
																					// de la BBDD

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Carrito.jsp"); // RequestDispatcher genera el
																							// jsp que le indicamos, en
																				// este caso, Carrito.jsp

			request.setAttribute("productos", productos);// para que jsp pueda usar esto,tiene que añadirse la lista
															// productos a
															// la request,con el metodo setAttribute,donde le ponemos un
															// nombre que luego vamos a usar en el jsp,en este caso,
															// "productos"(1er parametro..el2do es el nombre de la
															// lista)
			
			dispatcher.forward(request, response); // con esto se pasa el control al jsp para que se genere.
		}
	}

	// POST --> Cuando son operaciones que modifican el estado de la base de datos :
	// registro de usuario, añadir producto a carrito...
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(); // si el usuario no ha iniciado sesion no puedo hacer las
													// operaciones.

		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito");

		if (idCarrito == null) {
			response.sendRedirect(request.getContextPath() + "/login"); // si no inició sesion,le mandamos a login.
		} else {
			// /carrito?accion=agregar quitar vaciar -> la interrogacion se usa para indicar
			// en los servlets la accion a realizar
			String accion = request.getParameter("accion");

			int idProducto = Integer.parseInt(request.getParameter("idProducto")); // getParameter devuelve String.lo
																					// casteamos a int

			ProductoCarrito producto = dao.leer(idCarrito, idProducto); // queremos leer de un carrito determinado un
																		// producto, para saber si esta o no. llamamos a
																		// la funcion leer de Carrito.Dao . Esto me va a
																		// proporcionar ProductoCarrito
			switch (accion) {
			
			case "agregar":
				if (producto == null) {
					// El producto no está en el carrito, hay que añadirlo
					NuevoProductoCarrito nuevo = new NuevoProductoCarrito(idProducto, idCarrito, 1); // Instancia a
					// partir del constructor de NuevoProductoCarrito.java (que está en modelo), al
					// que le
					// pasamos, como indica el constructor: idProducto,idCarrito,y numUnidades.
					dao.crear(nuevo); // se guarda el producto en la BBDD.
				} else { // el producto ya existe: no lo creo de cero, sino que lo modifico:
					int numUds = producto.get_numUnidades() + 1;
					producto.set_numUnidades(numUds); // al prod que ya existe le incremento una unidad cada vez que
														// agrego.
					dao.actualizar(producto); // guardo el cambio en la BBDD
				}
				break;
			case "quitar":
				if (producto != null) { // si producto existe
					int numUds = producto.get_numUnidades() - 1; // quito uds de producto de 1 en 1
					if (numUds == 0) {
						dao.eliminar(idCarrito, producto.getId_producto()); // si reduzco uds a cero elimino producto
					} else { // si num uds es mayor que cero: simplemente actualizamos uds en BBDD
						producto.set_numUnidades(numUds);
						dao.actualizar(producto);
					}
				}
				break;
			
			}

		}

		// Cuando hacemos esto, llevamos al usuario al carrito otra vez para que vea los
		// cambios hechos:
		List<ProductoCarrito> productos = dao.leerProductosCarrito(idCarrito);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Carrito.jsp");

		request.setAttribute("productos", productos);

		dispatcher.forward(request, response);
	}
}
// DELETE, PATCH, ...

/*
 * HASTA AQUI TENEMOS LA PARTE DE , CUANDO NOS LLEGUE LA PETICIÓN, QUÉ VAMOS A
 * HACER. AHORA TENEMOS QUE IR AL JSP Y ESPECIFICAR CÓMO FUNCIONA ESTO, ES
 * DECIR, HACER LOS FORMULARIOS. ESTO VA A IR EN DOS JSP: Carrito.jsp y
 * tienda.jsp
 */
