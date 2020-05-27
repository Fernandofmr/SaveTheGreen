package modelos;

/**
 * Clase que se encarga de almacenar 3 objetos finitos(En este caso lo usamos como constantes) con el objetivo de proporcionar el estado del pedido en cada momento,
 * sin dejar la posibilidad de que este se encuentre en dos estados a la vez 
 */

public enum EstadoPedido {      //enumerados
	
	
	EN_PREPARACION,
	ENVIADO,
	COMPLETADO
}
