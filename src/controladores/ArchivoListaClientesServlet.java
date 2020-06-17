package controladores;

import java.io.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.PedidoDao;
import datos.UsuariosDao;
import modelos.Pedido;
import modelos.Usuario;
import modelos.FicheroClientes;

/**
 * Servlet implementation class ArchivoListaClientesServlet
 */
@WebServlet("/ArchivoListaClientes")
public class ArchivoListaClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuariosDao usudao=new UsuariosDao();
	private PedidoDao pedidao=new PedidoDao();
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		FicheroClientes archivo=new FicheroClientes();
		
		archivo.escribeArchivo("archivoDetallesClientes.txt");
		
		List<Usuario> listadoClientes=usudao.leerTodos();
		
		request.setAttribute("listadoClientes", listadoClientes);
		
		List<Pedido> listadoPedidos=pedidao.leerTodos();
		
		request.setAttribute("listadoPedidos", listadoPedidos);
		
		rd=request.getRequestDispatcher("/clientesGerente.jsp");
		
		rd.forward(request, response);
		
		/*for(int i=0; i<listadoClientes.size(); i++) {
			
			Usuario usuario=listadoClientes.get(i);
			Pedido pedido=listadoPedidos.get(i);
			
			if(usuario.getTipo()==2) {
			
				contenido="----------LISTA CLIENTES----------\n"
						+ "NOMBRE\t APELLIDO 1\t APELLIDO 2\t ID CLIENTE\t EMAIL\t TELÉFONO\t ID PEDIDO\n" 
						+ usuario.getNombre() + "\t" + usuario.getApellido1() + "\t" + usuario.getApellido2() + "\t" 
						+ usuario.getId() + "\t" + usuario.getEmail() + "\t" + usuario.getTelefono() + "\t" + pedido.getIdPedido();
			
			}
			
		}*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
