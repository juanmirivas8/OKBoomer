package interfaces.products;
import java.io.Serializable;

import model.PreservationCondition;

public interface IItem extends Serializable{
	String getID();
	void setID(Integer id);
	
	Integer getProductID();
	void setProductID()throws IllegalArgumentException;
	
	PreservationCondition getPreservationCondition();
	void setPreservationCondition(PreservationCondition condition)throws IllegalArgumentException;
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object e);
	
	@Override
	String toString();
}
