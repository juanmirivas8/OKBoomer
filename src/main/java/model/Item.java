package model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements interfaces.products.IItem {

	private static final long serialVersionUID = 1L;
	private Integer ID;
    private Integer productID;
    private PreservationCondition PreservationCondition;


    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer id) {
       this.ID = id;
    }

    public Integer getProductID()
    {
        return this.productID;
    }

    public void setProductID(Integer id) throws IllegalArgumentException{
    	this.productID = id;
    }
          
    public PreservationCondition getPreservationCondition() {
        return PreservationCondition;
    }

    public void setPreservationCondition(PreservationCondition condition) throws IllegalArgumentException {
        this.PreservationCondition= condition;

    }

	@Override
	public String toString() {
		return "ID = " + ID + ", product ID = " + productID + ", Preservation Condition = " + PreservationCondition + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(ID, other.ID);
	}
    
	
    
}