package interfaces;
import java.io.Serializable;

import model.PreservationCondition;
/**
 *Interfaz de la clase Item donde se definen las condiciones de la clase
 *Getters y Setters  
 *
 */
public interface IItem extends Serializable{
	String getID();
	
	Integer getProductID();
	void setProductID()throws IllegalArgumentException;
	
	PreservationCondition getPreservationCondition();
	void setPreservationCondition(PreservationCondition condition)throws IllegalArgumentException;
	
}
