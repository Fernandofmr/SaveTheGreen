package controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	String encuentra;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion=request.getSession();
		
		String email=request.getParameter("email");
		String nombre=request.getParameter("nombre");
		String frase="Cliente " + email + " encontrado";
		
		Usuario usuario=usudao.leer(email);
		
		String existe;
		RequestDispatcher rd;
		
		
		if(usuario==null) {
			
			existe=noEncuentra();
			
			request.setAttribute("existe", existe);
			
			rd=request.getRequestDispatcher("/buscaCliente.jsp");
			
			rd.forward(request, response);
			
			
		}else {
				
				existe=siEncuentra();
				
				request.setAttribute("existe", existe);
				
				request.setAttribute("frase", frase);
				
				String nombreArchivo=(email.substring(0, (email.length()-4))) + ".txt";
				
				File archivo=new File(nombreArchivo);
				
				request.setAttribute("archivo", archivo);
				
				rd=request.getRequestDispatcher("/buscaCliente.jsp"); 
				
				rd.forward(request, response);
				
			
			
		}
		
	}
	
	public String noEncuentra() {
		
		encuentra="El id cliente y/o el nombre no son correctos";
		
		return encuentra;
		
	}
	
	public String siEncuentra() {
		
		
		encuentra="Acceder al informe";
		
		return encuentra;
		
	}
	
	public void leeFichero() {
		
		try {
			
			FileReader entrada=new FileReader("archivoPrueba.txt");
			
			BufferedReader mibuffer=new BufferedReader(entrada);
			
			String linea="";
			
			String contenido="";
			
			while(linea!=null) {
				
				linea=mibuffer.readLine();
				
				if(linea!=null) {
					
					contenido+=linea;
					
				}
				
			}
			
			entrada.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
