package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ProductoDao;
import modelos.Producto;

/**
 * Servlet implementation class AltaProductoServlet
 */
@WebServlet("/AltaProducto")
public class AltaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductoDao produdao=new ProductoDao();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		String nombre=request.getParameter("nombre");
		String referencia=request.getParameter("referencia");
		String imagen=request.getParameter("imagen");
		String precios=request.getParameter("precio");
		double precio=Double.parseDouble(precios);
		
		String alta="¡Se ha dado de alta al producto " + nombre + " satisfactoriamente!";
		
		Producto p=new Producto(referencia, nombre, precio, imagen);
		
		produdao.crear(p);
		
		request.setAttribute("alta", alta);
		
		rd=request.getRequestDispatcher("/altaProducto.jsp");
		
		rd.forward(request, response);
		
	}

}
