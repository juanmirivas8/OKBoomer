package model;

import java.io.Serializable;
/**
 * Creacion de la clase enum para obligar a usuario a 
 * elegir una condicion de reserva evitando excepciones 
 *
 */
public enum PreservationCondition implements Serializable{

	EXCELLENT(5),GOOD(4),USED(3),BAD(2),TERMINAL(1);
	
	private final Integer order;
	
	private PreservationCondition(Integer order) {
		this.order=order;
	}
	
	Integer getOrder() {
		return this.order;
	}
}
