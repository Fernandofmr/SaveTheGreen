package modelos;


/**
 * Clase que se encarga de almacenar las propiedades de un carrito
 */

public class Carrito {
	
	
	private int  id;
	private int num_productos;
	private float importe;
	
	/**
	 * @return El id del carrito
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id  Proporciona un valor al id del carrito
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return Número de productos que contiene un carrito
	 */
	public int getNum_productos() {
		return num_productos;
	}
	/**
	 * @param num_productos Establece el número de productos de un carrito
	 */
	public void setNum_productos(int num_productos) {
		this.num_productos = num_productos;
	}
	/**
	 * @return El importe total del carrito
	 */
	public float getImporte() {
		return importe;
	}
	/**
	 * @param importe Establece el importe total del carrito
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}
		
	



	
	

}
