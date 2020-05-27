package modelos;

import java.util.List;

/**
 * Clase que se encarga de almacenar los datos relativos a los detalles de un pedido completo  (datos de cliente, datos del producto y datos del pedido)
 * utilizados para mostrarlo en formato factura
 */

public class DetallePedido {

	private int idPedido;
	private String direccionEnvio;
	private int idFormaPago;
	private String formaPago;
	private int idCliente;
	private String cliente;
	private double total;
	private EstadoPedido estado;
	private List<ProductoPedidoDetalle> productos;
	private String fecha;

	public DetallePedido(int idPedido, String direccionEnvio, int idFormaPago, String formaPago, int idCliente,
			String cliente, double total, EstadoPedido estado, List<ProductoPedidoDetalle> productos, String fecha) {
		this.idPedido = idPedido;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
		this.idFormaPago = idFormaPago;
		this.formaPago = formaPago;
		this.idCliente = idCliente;
		this.cliente = cliente;
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
	 * @return La forma de pago seleccionada
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago Establece la forma de pago de pago que se desea utilizar (en
	 *                  formato cadena de caracteres)
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
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
	 * @return Todos los datos del clientes
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente Establece todos los datos del cliente actual
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
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
	 * @return Una lista con todos los detalles de los productos en la factura
	 */
	public List<ProductoPedidoDetalle> getProductos() {
		return productos;
	}

	/**
	 * @param productos Establece un conjunto de detalles para cada producto
	 */
	public void setProductos(List<ProductoPedidoDetalle> productos) {
		this.productos = productos;
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

}
