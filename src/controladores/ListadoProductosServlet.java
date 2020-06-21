package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ProductoDao;
import modelos.Producto;

/**
 * Servlet implementation class ListadoProductosServlet
 */
@WebServlet("/ListadoProductos")
public class ListadoProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductoDao produdao=new ProductoDao();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		List<Producto> listaProductos=produdao.leerTodos();
		
		request.setAttribute("listaProductos", listaProductos);
		
		rd=request.getRequestDispatcher("/listadoProductos.jsp");
		
		rd.forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
