package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.CarritoDao;
import datos.PassUtils;
import datos.UsuariosDao;
import modelos.Carrito;
import modelos.Usuario;

/**
 * Controlador encargado de recoger todos los datos de un usuario que intenta registrarse por primera vez a la aplicación web
 */
@WebServlet("/usuario")
public class UsuarioFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		agregarUsuario(request, response); // llamamos a agregar usuarios

		// El request dispatcher es el lugar donde esta petición va a ser 'redigirida'
		// para ser tratada (por ejemplo, con un jsp que generar el HTML y lo devolvamos
		// al navegador)
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

		// ejecutamos el jsp
		rd.forward(request, response);

	}

	private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
		
		CarritoDao daoCarrito = new CarritoDao(); //conexion con paquete datos 
		PassUtils passUtils = new PassUtils(); //conexion paquete modelo
		UsuariosDao usuario = new UsuariosDao(); //conexion con paquete datos
		Carrito nuevoCarrito = new Carrito(); //conexion con paquete modelo
		
		// leer información del usuario que viene del formulario

		String login = request.getParameter("login");
		String contr = request.getParameter("confirma").trim(); //"        ho la      " --> "ho la"
		String passHash = passUtils.hash(contr);
		String nombre = request.getParameter("nombre");
		String apell1 = request.getParameter("apellido1");
		String apell2 = request.getParameter("apellido2");
		String DNI = request.getParameter("dni");
		String email = request.getParameter("email2");
		String telef = request.getParameter("telefono");

		// SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/aa"); se coloca aquí por si tenemos que implementar la fecha en fomato DATE
		// Date fecha = null;
		// Fecha = formatoFecha.parse(request.getParameter("fecha_nacimiento"))

		String fNacimiento = request.getParameter("fecha_nacimiento");
		String direccion = request.getParameter("direccion");
		String comunidad_autonoma = request.getParameter("ccaa");

		// crear objeto de tipo usuario

		Usuario E = new Usuario(2, login, passHash, nombre, apell1, apell2, DNI, email, telef, fNacimiento, direccion, comunidad_autonoma); //conexion con modelo

		// Enviar el objeto a modelo y después insertar el objeto USUARIO en la bbdd

		try {
			
			int idCarrito = daoCarrito.crear(nuevoCarrito);  //Crea un carrito vacío y le proporciona un id
			E.setIdCarrito(idCarrito); // proporciona un id de carrito al usuario recien creado
			usuario.crear(E);//llamada a método que introduce usuarios a la bbdd
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
