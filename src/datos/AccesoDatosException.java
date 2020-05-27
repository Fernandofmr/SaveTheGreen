package datos;


/**
 * Clase que se encarga de proporcionar un mensaje de error, en caso de que algo falle, en tiempo de ejecución al intentar conectar con la base de datos
 */

public class AccesoDatosException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public AccesoDatosException(String msg) {
		super(msg);
	}
}
