package modelos;

/**
 * Clase que se encarga de almacenar los datos relativos a la introducción de un producto nuevo en un carrito
 */

public class NuevoProductoCarrito { 
	
	
	
	private int id_producto;
	private int idCarrito;
	private int _numUnidades;
	
	
	public NuevoProductoCarrito( int id_producto, int idCarrito,
			int _numUnidades) {
		this.id_producto = id_producto;
		this.idCarrito = idCarrito;
		this._numUnidades = _numUnidades;
	}


	/**
	 * @return El id del producto 
	 */
	public int getId_producto() {
		return id_producto;
	}


	/**
	 * @return El id del carrito
	 */
	public int getIdCarrito() {
		return idCarrito;
	}


	/**
	 * @return El número de unidades actuales
	 */
	public int get_numUnidades() {
		return _numUnidades;
	}


	/**
	 * @param id_producto El id del producto a establecer
	 */
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	/**
	 * @param idCarrito El id del carrito a establecer
	 */
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}


	/**
	 * @param _numUnidades El número de unidades actuales a establecer
	 */
	public void set_numUnidades(int _numUnidades) {
		this._numUnidades = _numUnidades;
	}


	

}
