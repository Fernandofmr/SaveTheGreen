package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.CarritoDao;

/**
 * Controlador encargado de cancelar una compra en caso de que haya productos en el carrito
 */
@WebServlet("/cancelar")
public class CancelarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CarritoDao dao = new CarritoDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(); // si el usuario no ha iniciado sesion no puedo hacer las
		// operaciones.

		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito");

		if (idCarrito == null) {
			response.sendRedirect(request.getContextPath() + "/login"); // si no inició sesion,le mandamos a login.
		}

		boolean p = dao.leerProductos(idCarrito);

		if (p == true) { // si hay producto

			dao.eliminarProductosCarrito(idCarrito);
		} 
		
		response.sendRedirect(request.getContextPath()+ "/productos"); //Pasa el control al servlet productos

	}

}
