package interfaces;

import model.IDGenerator;
import model.PreservationCondition;
/**
 *Clase abstracta de la clase item donde se definen las condiciones de la clase  
 *
 */
public abstract class AbstractItem implements IItem{

	protected static IDGenerator keygen = new IDGenerator();
	private Integer productID;
	private String ID;
	private PreservationCondition preservationCondition;
	
	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object obj);
	
	@Override 
	public abstract String toString();
}
