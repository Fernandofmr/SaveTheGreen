package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.FormaPago;

/**
 * 
 * Gestiona toda la conexión con la base de datos relacionados con el/los métodos de pago
 *
 */

public class FormaPagoDao {
	
	
	/**
	 * Se encarga de leer todos los métodos de pagos almacenados en la base de datos
	 * @return Un listado con todos los métodos de pagos
	 */
	public List<FormaPago> leerTodas() {
		try(Connection conn = DriverManager.getConnection(DataBaseConfiguration.URL)) {
			//Statement o PreparedStatement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM forma_pago");
			
			ArrayList<FormaPago> formasPago = new ArrayList<>();
			
			while(rs.next()) {
				int id = rs.getInt("id"); //como aqui estamos leyendo todos los prod, necesitamos ponr el id
				String nombre = rs.getString("nombre");
				
				
				FormaPago forma = new FormaPago(id, nombre);
				
				formasPago.add(forma);
			}
			
			return formasPago;
		}
		catch(SQLException e) { //reconvierte la sql exception a la personalizada que hemos creado, para relanzar a la web
			throw new AccesoDatosException(e.getMessage());
		}
	}

}
