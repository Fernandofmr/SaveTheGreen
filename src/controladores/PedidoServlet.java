package controladores;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.CarritoDao;
import datos.FormaPagoDao;
import datos.PedidoDao;
import modelos.DetallePedido;
import modelos.EstadoPedido;
import modelos.FormaPago;
import modelos.Pedido;
import modelos.ProductoCarrito;
import modelos.ProductoPedido;


/**
 * Controlador encargado de gestionar todos los datos relacionados con el pedido de un cliente
 * 
 */

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FormaPagoDao formaPagoDao = new FormaPagoDao();
	private CarritoDao carritoDao = new CarritoDao();
	private PedidoDao pedidoDao = new PedidoDao();
	private DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(); // si el usuario no ha iniciado sesion no puedo hacer las
		// operaciones.

		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito");
		Integer idCliente = (Integer) sesion.getAttribute("idUsuario");

		if (idCarrito == null) {
			response.sendRedirect(request.getContextPath() + "/login"); // si no inició sesion,le mandamos a login.
			return;
		}

		

		String accion = request.getParameter("accion"); // ?accion=realizar
		if (accion == null) { // en caso de intentar acceder directamente a la URL de Pedido,sin iniciar antes
								// sesion.
			accion = "realizar"; // Se puede definir ésta o cualquier otra acción,por ej: Mostrar un mensaje de
									// ERROR 404. Elegimos realizar para no cortar el flujo del programa.
		}
		
	

			RequestDispatcher rd;
			switch (accion) {

			case "realizar":
				List<FormaPago> formasPago = formaPagoDao.leerTodas();
				// agregar lista de productos al request
				request.setAttribute("formasPago", formasPago);

				// El request dispatcher es el lugar donde esta peticiÃ³n va a ser 'redigirida'
				// para ser tratada (por ejemplo, con un jsp que generar el HTML y lo devolvamos
				// al navegador)
				rd = request.getRequestDispatcher("/formularioPago.jsp");

				// ejecutamos el request
				rd.forward(request, response);
				break;
			case "ver": // ?accion=ver&pedido=2
				int pedido = Integer.parseInt(request.getParameter("pedido"));

				DetallePedido detalle = pedidoDao.leerDetalle(pedido);

				if (detalle == null) {
					response.sendRedirect(request.getContextPath() + "/");
					return;
				}

				String fechaBd = detalle.getFecha();

				LocalDateTime fecha = LocalDateTime.parse(fechaBd);

				String fechaFormateada = formateadorFecha.format(fecha);

				detalle.setFecha(fechaFormateada);

				request.setAttribute("detalle", detalle);

				rd = request.getRequestDispatcher("/factura.jsp");

				// ejecutamos el request
				rd.forward(request, response);
				break;
			case "historial":
				List<Pedido> pedidosCliente = pedidoDao.leerPedidosCliente(idCliente);
				
				for(Pedido p : pedidosCliente) {
					String fechaPedido = p.getFecha();

					LocalDateTime fechaP = LocalDateTime.parse(fechaPedido);

					String fechaPedidoFormateada = formateadorFecha.format(fechaP);

					p.setFecha(fechaPedidoFormateada);
				}
				
				request.setAttribute("pedidosCliente", pedidosCliente);
				
				rd = request.getRequestDispatcher("/mostrarExtracto.jsp");

				// ejecutamos el request
				rd.forward(request, response);
				
				
				break;
			}

		}

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(); // si el usuario no ha iniciado sesion no puedo hacer las
		// operaciones.

		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito");

		if (idCarrito == null) {
			response.sendRedirect(request.getContextPath() + "/login"); // si no inició sesion,le mandamos a login.
			return;
		}

		// Extraer datos formulario
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String codPostal = request.getParameter("c_postal");
		String ciudad = request.getParameter("ciudad");
		String com_aut = new String(request.getParameter("ccaa").getBytes(), StandardCharsets.UTF_8); //introducimos los caracteres uno a uno en formato UTF-8 en la bbdd
		// A continuación, Forma en que se soluciona posibilidad de que un usuario meta
		// en formulario un dato en formulario editando el value tras hacer:
		// "Inspeccionar elemento" en la pagina web:
		String idFormaPagoTxt = request.getParameter("forma_pago");
		boolean idFormaPagoValida;
		try {
			Integer.parseInt(idFormaPagoTxt);
			idFormaPagoValida = true;
		} catch (NumberFormatException e) {
			idFormaPagoValida = false;
		}

		if (!idFormaPagoValida) {
			response.sendRedirect(request.getContextPath() + "/"); // si no inició sesion,le mandamos a login.
			return;
		}

		int idFormaPago = Integer.parseInt(idFormaPagoTxt);

		String direccionEnvio = nombre + "," + direccion + "," + codPostal + "," + ciudad + "(" + com_aut + ")";
		int idCliente = (int) sesion.getAttribute("idUsuario");

		// Extraer productos carrito
		List<ProductoCarrito> productosCarrito = carritoDao.leerProductosCarrito(idCarrito);

		// Calcular total
		double total = 0;
		List<ProductoPedido> productosPedido = new ArrayList<>();
		for (ProductoCarrito pc : productosCarrito) {
			total += pc.getPrecioProducto() * pc.get_numUnidades(); // variable que acumula la suma de subtotales de los
																	// prod del carrito

			int idProducto = pc.getId_producto();
			double precio = pc.getPrecioProducto();
			int uds = pc.get_numUnidades();

			ProductoPedido p = new ProductoPedido(idProducto, precio, uds);
			productosPedido.add(p);
		}

		// Crear pedido
		LocalDateTime ahora = LocalDateTime.now();
		Pedido nuevoPedido = new Pedido(direccionEnvio, idFormaPago, total, EstadoPedido.EN_PREPARACION,
				productosPedido, idCliente, ahora.toString());

		int id = pedidoDao.crear(nuevoPedido);

		// Vacio carrito
		carritoDao.eliminarProductosCarrito(idCarrito);

		response.sendRedirect(request.getContextPath() + "/pedido?accion=ver&pedido=" + id);
	}
}
