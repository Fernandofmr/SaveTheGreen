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

import datos.*;
import modelos.*;

/**
 * Controlador encargado de gestionar y mostrar el listado de clientes de la parte del gerente
 */
@WebServlet("/listadoClientes")
public class listadoClientesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuariosDao usu=new UsuariosDao();
	private PedidoDao pedidao=new PedidoDao();
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		
			
			List<Usuario> listadoClientes=usu.leerTodos();
			
			request.setAttribute("listadoClientes", listadoClientes);
			
			for(int i=0; i<listadoClientes.size(); i++) {
				
				Usuario u=listadoClientes.get(i);
				
				int j=u.getIdCarrito();
				
				List<Pedido> listadoPedidos=pedidao.leerPedidosCliente(j);
				
				request.setAttribute("listadoPedidos", listadoPedidos);
				
			}
			
			rd=request.getRequestDispatcher("/clientesGerente.jsp");
			
			rd.forward(request, response);
			
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion=request.getSession();
		
		
		
	}

}
