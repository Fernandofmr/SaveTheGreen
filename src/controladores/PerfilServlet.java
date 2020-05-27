package controladores;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.PassUtils;
import datos.UsuariosDao;
import modelos.Usuario;

/**
 * Controlador encargado de recoger todos los datos de un usuario que intenta registrarse por primera vez a la aplicación web
 */
@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuariosDao usuarioDao = new UsuariosDao();
	private PassUtils passUtils = new PassUtils();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();

		Integer idUsuario = (Integer) sesion.getAttribute("idUsuario"); // con getAttribute veo si ese idCarrito existe
																		// o no. integer es equivalente a int pero en
																		// forma de objeto. un objeto sí puede ser null:
																		// casteo para q no devuelva int.
		

		if (idUsuario == null) {// si el usuario borra cookies, se pierde la sesión e id del carrito
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		// El request dispatcher es el lugar donde esta petición va a ser 'redigirida'
		// para ser tratada (por ejemplo, con un jsp que generar el HTML y lo devolvamos
		// al navegador)
		
		Usuario u = usuarioDao.leer(idUsuario);
		
		request.setAttribute("usuario", u);

		RequestDispatcher rd = request.getRequestDispatcher("/formularioPerfil.jsp");
		
		
		// ejecutamos el jsp
		rd.forward(request, response);
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		Integer idUsuario = (Integer) sesion.getAttribute("idUsuario"); // con getAttribute veo si ese idCarrito existe
																		// o no. integer es equivalente a int pero en
																		// forma de objeto. un objeto sí puede ser null:
																		// casteo para q no devuelva int.
		Integer idCarrito = (Integer) sesion.getAttribute("idCarrito");

		if (idUsuario == null) {// si el usuario borra cookies, se pierde la sesión e id del carrito
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		UsuariosDao usuario = new UsuariosDao();

		// leer información del usuario que viene del formulario

		String login = request.getParameter("login");
		String contr = request.getParameter("confirma").trim(); //"        ho la      " --> "ho la"
		String passHash = passUtils.hash(contr);
		String nombre = new String( request.getParameter("nombre").getBytes(), StandardCharsets.UTF_8);
		String apell1 = new String( request.getParameter("apellido1").getBytes(), StandardCharsets.UTF_8);
		String apell2 = new String( request.getParameter("apellido2").getBytes(), StandardCharsets.UTF_8);
		String DNI = request.getParameter("dni");
		String email = request.getParameter("email2");
		String telef = request.getParameter("telefono");

		// SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/aa"); se coloca
		// aquí por si tenemos que implementar la fecha en fomato DATE
		// Date fecha = null;
		// Fecha = formatoFecha.parse(request.getParameter("fecha_nacimiento"))

		String fNacimiento = request.getParameter("fecha_nacimiento");
		String comunidad_autonoma = new String(request.getParameter("ccaa").getBytes(), StandardCharsets.UTF_8);
		String direccion = new String(request.getParameter("direccion").getBytes(),StandardCharsets.UTF_8);
		System.out.println(direccion);

		// crear objeto de tipo usuario

		Usuario E = new Usuario(idUsuario,2, login, passHash, nombre, apell1, apell2, DNI, email, telef, fNacimiento, direccion, comunidad_autonoma,  idCarrito
				);

		// Enviar el objeto a modelo y después insertar el objeto USUARIOS en la bbdd

		usuario.actualizar(E);//llamada a método que introduce usuarios a la bbdd
	
		response.sendRedirect(request.getContextPath() + "/perfil");
	}

}
