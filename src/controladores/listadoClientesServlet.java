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
		
		String contenido;
		
		FicheroClientes archivo=new FicheroClientes();
		
		List<Usuario> listadoClientes=usu.leerTodos();
		
		request.setAttribute("listadoClientes", listadoClientes);
		
		List<Pedido> listadoPedidos=pedidao.leerTodos();
		
		request.setAttribute("listadoPedidos", listadoPedidos);
		
		contenido=dameListado(listadoClientes, listadoPedidos);
		
		archivo.escribeArchivo("archivoDetallesClientes.txt", contenido);
		
		rd=request.getRequestDispatcher("/clientesGerente.jsp");
		
		rd.forward(request, response);
			
	}	
	
	
	public String dameListado(List<Usuario> listUsu, List<Pedido> listPed) {
		
		String contenido="					----------LISTA CLIENTES----------\n\n\n"
				+ "NOMBRE\t\t\t ID CLIENTE\t\t\t EMAIL\t\t\t TELÉFONO\t\t\t ID PEDIDO\n\n";
		
		for(int i=0; i<listUsu.size(); i++) {
			
			Usuario usuario=listUsu.get(i);
			Pedido pedido=listPed.get(i);
			
			if(usuario.getTipo()==2) {
			
				contenido += usuario.getNombre() + "\t\t\t" + usuario.getId() + "\t\t\t" + usuario.getEmail() + "\t\t\t" + usuario.getTelefono() + "\t\t\t" + pedido.getIdPedido() + "\n\n";
			
			}
			
		}
		
		return contenido;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion=request.getSession();
		
		
		
	}

}
