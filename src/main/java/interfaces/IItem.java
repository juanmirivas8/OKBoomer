package interfaces;
import java.io.Serializable;

import model.PreservationCondition;

public interface IItem extends Serializable{
	String getID();
	
	Integer getProductID();
	void setProductID()throws IllegalArgumentException;
	
	PreservationCondition getPreservationCondition();
	void setPreservationCondition(PreservationCondition condition)throws IllegalArgumentException;
	
}
