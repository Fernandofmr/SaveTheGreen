package modelos;

/**
 * 
 * Clase que contiene los datos del pedido de un producto
 *
 */

public class ProductoPedido {
	
	private int idProducto;
	private int idPedido;
	private double precioUd;
	private int uds;
	
	public ProductoPedido(int idProducto, int idPedido, double precioUd, int uds) {
		super();
		this.idProducto = idProducto;
		this.idPedido = idPedido;
		this.precioUd = precioUd;
		this.uds = uds;
	}
	
	public ProductoPedido(int idProducto, double precioUd, int uds) {
		super();
		this.idProducto = idProducto;
		this.idPedido = 0;
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
	 * @return El id del pedido actual
	 */
	public int getIdPedido() {
		return idPedido;
	}

	/**
	 * @return El precio del producto del pedido actual
	 */
	public double getPrecioUd() {
		return precioUd;
	}

	/**
	 * @return El número de unidades del producto del pedido actual
	 */
	public int getUds() {
		return uds;
	}

	/**
	 * @param idProducto El id del producto del pedido actual a establecer
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @param idPedido id del pedido actual a establecer
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @param precioUd El precio unitario del producto del pedido actual a establecer
	 */
	public void setPrecioUd(double precioUd) {
		this.precioUd = precioUd;
	}

	/**
	 * @param uds El número de unidades del producto del pedido actual a establecer
	 */
	public void setUds(int uds) {
		this.uds = uds;
	}
	
	
	
	

}
