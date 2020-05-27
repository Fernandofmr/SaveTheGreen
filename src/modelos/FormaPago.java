package modelos;

/**
 * 
 * Clase que se encarga de almacenar el método de pago vigente en la aplicación
 *
 */

public class FormaPago {
	
	private int id;
	private String nombre;
	
	public FormaPago(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return El id de la forma de pago
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return Un String con el nombre de la forma de pago
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param id El id a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param nombre El nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
