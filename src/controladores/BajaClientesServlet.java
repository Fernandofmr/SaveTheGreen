package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.UsuariosDao;
import modelos.Usuario;

/**
 * Servlet implementation class BajaClientesServlet
 */
@WebServlet("/BajaClientes")
public class BajaClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuariosDao usudao=new UsuariosDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		
		RequestDispatcher rd;
		
		String existe;
		
		Usuario usuario=usudao.leer(email);
		
		if(usuario==null) {
			
			existe="¡CLIENTE NO ENCONTRADO!<br> por favor, introduzca el email de nuevo";
			
			request.setAttribute("existe", existe);
			
			rd=request.getRequestDispatcher("bajaCliente.jsp");
			
			rd.forward(request, response);
			
		}else {
			
			existe=usudao.borrarUsuario(email);
			
			request.setAttribute("existe", existe);
			
			rd=request.getRequestDispatcher("bajaCliente.jsp");
			
			rd.forward(request, response);
			
		}
		
	}

}
