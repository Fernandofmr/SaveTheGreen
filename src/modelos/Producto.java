package modelos;

/**
 * 
 *  Contiene los atributos de un producto. 
 *
 */

public class Producto {

		

		private int id;
		private String _ref;/* Referencia del producto */
		private String _nombreP;/* Nombre del producto */
		private double _precioP;/* Precio del producto */
		private String imagen;

		
		
		public Producto() {
			
			
		}
		
		public Producto(String ref, String nombre, double precio,  String imagen) { //al crear prod desde codigo no tiene id, solo se le asigna al insertarlo en la bbdd
			_ref = ref;
			_nombreP = nombre;
			this.imagen = imagen;
			_precioP = precio;
			id = 0;
		}
		
		public Producto(int id, String ref, String nombre, double precio, String imagen) { //alhacer select sí que tiene id y llama a este constructor
			_ref = ref;
			_nombreP = nombre;
			_precioP = precio;
			this.id = id;
			this.imagen = imagen;
		
		}

		/**
		 * @return El id de un producto
		 */
		public int getId() {
			return id;
		}

		/**
		 * @return La referencia de un producto
		 */
		public String getReferenciaProducto() {
			return _ref;
		}

		/**
		 * @return El nombre de un producto
		 */
		public String getNombreProducto() {
			return _nombreP;
		}

		/**
		 * @return El precio de un producto
		 */
		public double getPrecioProducto() {
			return _precioP;
		}

		/**
		 * @return El nombre de la imagen de un producto, para luego localizarlo en la carpeta imagenes correspondientes
		 */
		public String getImagen() {
			return imagen;
		}

		/**
		 * @param id El id del producto a establecer
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @param _ref La referencia del producto a establecer
		 */
		public void set_ref(String _ref) {
			this._ref = _ref;
		}

		/**
		 * @param _nombreP El nombre del producto a establecer
		 */
		public void set_nombreP(String _nombreP) {
			this._nombreP = _nombreP;
		}

		/**
		 * @param _precioP El precio del producto actual
		 */
		public void set_precioP(double _precioP) {
			this._precioP = _precioP;
		}

		/**
		 * @param imagen El nombre de la imagen a establecer
		 */
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}
		
		
		
		

	}
