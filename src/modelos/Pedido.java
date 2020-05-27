package modelos;

import java.util.List;

/**
 * 
 * Clase que se encarga de recoger los datos de un pedido metidos por el usuario para su posterior almacenamiento en la bbdd
 *
 */


public class Pedido {
	
	private int idPedido;
	private String direccionEnvio;
	private int idFormaPago;
	private int idCliente;
	private double total;
	private EstadoPedido estado;
	private List<ProductoPedido> productos;
	private String fecha;
	
	public Pedido(String direccionEnvio, int idFormaPago, double total, EstadoPedido estado, List<ProductoPedido> productos,
			int idCliente, String fecha) {
		this.direccionEnvio = direccionEnvio;
		this.idFormaPago = idFormaPago;
		this.total = total;
		this.estado = estado;
		this.idCliente = idCliente;
this.fecha = fecha;
		this.productos = productos;
	}

	public Pedido(int idPedido, String direccionEnvio, int idFormaPago, double total, EstadoPedido estado,
			List<ProductoPedido> productos,int idCliente, String fecha) {
		this.idPedido = idPedido;
		this.direccionEnvio = direccionEnvio;
		this.idFormaPago = idFormaPago;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
		this.productos = productos;
	}
	
	/**
	 * @return El id del pedido
	 */
	public int getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido Establece el id del pedido
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @return La direccion de envío
	 */
	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	/**
	 * @param direccionEnvio Establece la dirección de envío
	 */
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	/**
	 * @return El id de la forma de pago
	 */
	public int getIdFormaPago() {
		return idFormaPago;
	}

	/**
	 * @param idFormaPago Establece el id de la forma de pago, indicando cual de las
	 *                    que existen se quiere utilizar (en formato numérico)
	 */
	public void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
	}



	/**
	 * @return El id del cliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente Establece el id del cliente
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	

	/**
	 * @return El total en euros de dicho pedido
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total Establece el total en euros del pedido actual
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return El estado del pedido (en preparación, enviado, completado)
	 */
	public EstadoPedido getEstado() {
		return estado;
	}

	/**
	 * @param estado Establece el estado del pepdido actual
	 */
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}



	/**
	 * @return La fecha a la que se hizo un pedido concreto
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha Establece la fecha a la que se hizo un pedido
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return La lista de productos del cliente actual
	 */
	public List<ProductoPedido> getProductos() {
		return productos;
	}

	/**
	 * @param productos La lista de productos del cliente actual
	 */
	public void setProductos(List<ProductoPedido> productos) {
		this.productos = productos;
	}
	
	
	

}
