package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ProductoDao;
import modelos.Producto;

/**
 * Servlet implementation class BajaProductoServlet
 */
@WebServlet("/BajaProducto")
public class BajaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductoDao produdao=new ProductoDao();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		
		String nombre = request.getParameter("nombre");
		
		String existe;
		
		Producto producto = produdao.leer(nombre);
		
		if(producto==null) {
			
			existe="¡PRODUCTO NO ENCONTRADO!<br> Por favor, introduce el nombre de nuevo";
			
			request.setAttribute("existe", existe);
			
			rd = request.getRequestDispatcher("bajaProducto.jsp");
			
			rd.forward(request, response);
			
		}else {
			
			existe = produdao.eliminar(nombre);
			
			request.setAttribute("existe", existe);
			
			rd = request.getRequestDispatcher("bajaProducto.jsp");
			
			rd.forward(request, response);
			
		}
		
		
	}

}
