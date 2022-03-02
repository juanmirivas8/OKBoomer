package interfaces;

import java.io.Serializable;
import model.MCRS;

public interface IProduct extends Serializable{

	String getTitle();
	void setTitle(String title)throws IllegalArgumentException;
	
	Integer getID();
	
	Integer getLength();
	void setLength(Integer length)throws IllegalArgumentException;
	
	Double getPrice();
	void setPrice(Double price)throws IllegalArgumentException;
	
	MCRS getRating();
	void setRating(MCRS rating)throws IllegalArgumentException;
	
}
