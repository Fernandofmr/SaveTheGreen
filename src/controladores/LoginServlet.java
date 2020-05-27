package controladores;

import java.io.IOException;

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
 * Controlador encargado de gestionar el acceso a la aplicación web
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PassUtils passUtils = new PassUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/* Si llega un get significa que están queriendo ver el formulario de login. Si quiero ver el formulario, lo que hago
	* es mandarle al jsp dónde esta el formulario de login con un RequestDispatcher. Por lo tanto,
	* si llega un get: Mostramos formulario de inicio de sesion.
	*/
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(); // Obtiene la sesion, Si tiene sesion,porque es un visitante que entro en otra ocasion a la web, que use la que tiene. Y sino se la creamos.
		
		Integer tipoUsuario = (Integer) sesion.getAttribute("tipoUsuario");  //Integer es equivalente a int, pero en forma de objeto.
		
		if(tipoUsuario != null) { //Ya tenia la sesión iniciada anteriormente, redirigimos a la pag principal

			switch(tipoUsuario) {
			case 1: //Gerente
				/*
				 * // LLAMA AL MENU DEL GERENTE (ESTA PARTE QUEDA PARA EL AVANCE 3, NO HACE FALTA
				// TOCAR MÁS DE MOMEENTO)
				RequestDispatcher rd = request.getRequestDispatcher("/indexGerente.jsp");

				// ejecutamos el jsp
				rd.forward(request, response);
				 */
				break;
			case 2: //Normal
				response.sendRedirect(request.getContextPath()+"/productos"); //getContextPath se refiere a http://localhost:8080/SaveTheGreen
				break;
			}
			return;
		}

		request.setAttribute("error", ""); // No hay errores en el caso normal: ponemos el mensaje VACÍO.
		/*Antes de hacer nada ya estamos haciendo un getAttribute de algo que luego puede ser null. Tenemos que presumir
		 * q no hay errores en ppio para que no ponga "null" de entrada debajo del formulario. Hacer la línea anterior 
		 * es un "truco" para evitarlo.
		*/

		RequestDispatcher dispatcher = request.getRequestDispatcher("/inicioSesion.jsp"); //mando al jsp dónde está el formulario de login
		
		dispatcher.forward(request, response);
	}

	
	/* Cuando alguien hace post a login, significa que ya se rellenó el formulario y tenemos que comprobar el usuario
	 * y la contraseña. Entonces necesitamos usuariosDao (para poder comprobar si existe el usuario o no). En lugar de 
	 * sacar todos los usuarios, hacemos una consulta a la bbdd que nos diga si ese usuario concreto existe o no (se busca un usuario
	 * en la bbdd dado el email). Usamos un método que nos permita localizar el usuario por su email, porque
	 * los emails son únicos.
	 */
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuariosDao daoUsuario = new UsuariosDao();  
		
		String email = request.getParameter("email"); //estos datos los toma de inicioSesion.jsp
		String passIntroducida = request.getParameter("contrasenia");
		
		Usuario usuario = daoUsuario.leer(email);

		if(usuario == null) {  //Usuario es nuevo, nunca se ha registrado.
			request.setAttribute("error", "El email y/o contraseña no son correctos"); // muestra el error debajo del
																						// formulario. El 1er parámtro
																						// es el atributo(error) y el
																						// segundo el mensaje a mostrar.
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/inicioSesion.jsp"); //te redirige al .jsp de inicio sesion

			dispatcher.forward(request, response);
			return;  //nos salimos. Forzamos la salida con return
		}
		
		//El usuario existe : email existe
		String hashUsuario = usuario.getClave();  //en este caso hay que comprobar que password sea correcto.
		if(!passUtils.comprobar(passIntroducida.trim(), hashUsuario)) {
			request.setAttribute("error", "El email y/o contraseña no son correctos");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/inicioSesion.jsp"); // si pass introducida es
																								// distinta de la que
																								// tiene el usuario para
																								// ese email, te
																								// redirige al .jsp de
																								// inicio de sesion para
																								// que se vuelva a
																								// loguear

			dispatcher.forward(request, response);
			return;
		}
		
		//El usuario existe y la pass es correcta:
		HttpSession sesion = request.getSession(); // metemos en su sesion los datos del carrito y los otros datos que
													// interesan.
		sesion.setAttribute("idCarrito", usuario.getIdCarrito()); // idCarrito lo sacamos de nuestro usuario y lo
																	// mandaremos al otro servlet que hemos hecho
		sesion.setAttribute("idUsuario", usuario.getId());
		sesion.setAttribute("tipoUsuario", usuario.getTipo()); // es interesante guardar tb el tipo de usuario, ej_ un
																// administrador que pueda acceder a agregar productos.
																// segun el tipo, tengo que saber si te permito acceder
																// o te rechazo y redirijo al inicio.

					// Sabiendo que dejo al usuario iniciar sesion, redirijo a la pag
					// correspondiente,segun el tipo de usuario:

		switch(usuario.getTipo()) {
			case 1: //Caso del Gerente
				/*
				 * // LLAMA AL MENU DEL GERENTE (ESTA PARTE QUEDA PARA EL AVANCE 3, NO HACE FALTA
					// TOCAR MÁS DE MOMENTO)
					RequestDispatcher rd = request.getRequestDispatcher("/indexGerente.jsp");

					// ejecutamos el jsp
					rd.forward(request, response);
				 */
				break;
			case 2: // Caso del Cliente..
				RequestDispatcher rd = request.getRequestDispatcher("/indexCliente.jsp");

				// ejecutamos el jsp
				rd.forward(request, response);
				break;
			}

		}

}
