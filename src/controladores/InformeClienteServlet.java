package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.UsuariosDao;
import datos.PedidoDao;
import modelos.Usuario;
import modelos.DetallePedido;

/**
 * Servlet implementation class InformeClienteServlet
 */
@WebServlet("/InformeClientes")
public class InformeClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuariosDao usudao=new UsuariosDao();
	private PedidoDao pedidao=new PedidoDao();
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd;
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idUsuario=request.getParameter("idCliente");
		String nombre=request.getParameter("nombre");
		
		Usuario usuario=usudao.leer(idUsuario);
		request.setAttribute("usuario", usuario);
		
		if(usuario==null) {
			request.setAttribute("error", "El id cliente y/o el nombre no son correctos");
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/buscaCliente.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		HttpSession sesion=request.getSession();
		
		sesion.setAttribute("idCliente", usuario.getId());
		sesion.setAttribute("nombre", usuario.getNombre());
		sesion.setAttribute("apellido1", usuario.getApellido1());
		sesion.setAttribute("direccion", usuario.getDireccion());
		
		RequestDispatcher rd=request.getRequestDispatcher("/buscaCliente.jsp");
		
		
		
	}

}
