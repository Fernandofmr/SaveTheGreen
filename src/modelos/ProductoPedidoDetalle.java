package modelos;

/**
 * 
 * Clase que contiene los detalles del pedido de un producto 
 *
 */

public class ProductoPedidoDetalle {
	
	private int idProducto;
	private int idPedido;
	private String nombre;
	private String imagen;
	private double precioUd;
	private int uds;
	
	public ProductoPedidoDetalle(int idProducto, int idPedido, String nombre, String imagen, double precioUd, int uds) {
		this.idProducto = idProducto;
		this.idPedido = idPedido;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precioUd = precioUd;
		this.uds = uds;
	}

	/**
	 * @return El id del producto del pedido actual
	 */
	public int getIdProducto() {
		return idProducto;
	}

	/**
	 * @return El id del pedido
	 */
	public int getIdPedido() {
		return idPedido;
	}

	/**
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return El nombre de la imagen del producto
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @return El precio unitario del producto 
	 */
	public double getPrecioUd() {
		return precioUd;
	}

	/**
	 * @return El número de unidades del producto
	 */
	public int getUds() {
		return uds;
	}

	/**
	 * @param idProducto El id del producto a establecer
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @param idPedido El id del pedido actual a establecer
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @param nombre El nombre del producto a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param imagen El nombre de la imágen a establecer
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @param precioUd El precio unitario del producto a establecer
	 */
	public void setPrecioUd(double precioUd) {
		this.precioUd = precioUd;
	}

	/**
	 * @param uds El número de unidades del producto a establecer
	 */
	public void setUds(int uds) {
		this.uds = uds;
	}
	
	
	
	
	

}
