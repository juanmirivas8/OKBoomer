package interfaces;
import java.io.Serializable;

import model.PreservationCondition;

public interface IItem extends Serializable{
	String getID();
	
	Integer getProductID();
	void setProductID()throws IllegalArgumentException;
	
	Enum<PreservationCondition> getPreservationCondition();
	void setPreservationCondition(Enum<PreservationCondition> condition)throws IllegalArgumentException;
	
}
