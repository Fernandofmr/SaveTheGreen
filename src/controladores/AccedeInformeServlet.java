package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import datos.*;

/**
 * Servlet implementation class AccedeInformeServlet
 */
@WebServlet("/AccedeInforme")
public class AccedeInformeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuariosDao usudao=new UsuariosDao();
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion=request.getSession();
		
		/*String email=request.getParameter("email");
		
		String nombreArchivo=email.substring(0, (email.length()-4));
		
		FileReader archivo=new FileReader(nombreArchivo + ".txt");*/
		
		FileReader archivo=new FileReader("archivoPrueba.txt");
		
		BufferedReader br=new BufferedReader(archivo);
		
		String cadena;
		String contenido="";
		
		while((cadena=br.readLine()) !=null ){
			
			contenido+=cadena;
			
			request.setAttribute("contenido", contenido);
			
			RequestDispatcher rd=request.getRequestDispatcher("/buscaCliente.jsp");
			
			rd.forward(request, response);
			
		}
		
	}

}
