package modelos;

/**
 * 
 *Contiene los atributos de un producto de la cesta
 *
 */

public class ProductoCarrito { 
	
	private int id_producto;
	private int idCarrito;
	private String nombre_producto;
	private double precioProducto;
	private int _numUnidades;
	private String imagen;  //porque en el carrito tb mostramos la imagen del producto.
	
	
	public ProductoCarrito( int id_producto, String nombre_producto, double precioProducto,
			int _numUnidades, String imagen,
			int idCarrito) {
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.precioProducto = precioProducto;
		this._numUnidades = _numUnidades;
		this.imagen = imagen;
		this.idCarrito = idCarrito;
	}
	
	







	/**
	 * @return El id del producto de la cesta actual
	 */
	public int getId_producto() {
		return id_producto;
	}

	/**
	 * @return El nombre del producto de la cesta actual
	 */
	public String getNombre_producto() {
		return nombre_producto;
	}

	/**
	 * @return El precio del producto de la cesta actual
	 */
	public double getPrecioProducto() {
		return precioProducto;
	}


	/**
	 * @return El número de unidades del producto de la cesta actual
	 */
	public int get_numUnidades() {
		return _numUnidades;
	}

	/**
	 * @return El nombre de la imagen del producto de la cesta actual
	 */
	public String getImagen() {
		return imagen;
	}


	/**
	 * @param id_producto El id del producto a establecer de la cesta actual
	 */
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	/**
	 * @param nombre_producto el nombre del producto a establecer de la cesta actual
	 */
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}


	/**
	 * @param precioProducto El precio del producto a establecer de la cesta actual
	 */
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}



	/**
	 * @param _numUnidades el número de unidades del producto a establecer de la cesta actual
	 */
	public void set_numUnidades(int _numUnidades) {
		this._numUnidades = _numUnidades;
	}


	/**
	 * @param imagen El nombre de la imagen del producto a establecer de la cesta actual
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	/**
	 * 
	 * @return El id del carrito/cesta actual
	 */

	public int getIdCarrito() {
		// TODO Auto-generated method stub
		return idCarrito;
	}


	
	

}
