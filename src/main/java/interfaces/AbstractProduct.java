package interfaces;

import model.IDGenerator;
import model.MCRS;

public abstract class AbstractProduct implements IProduct{

	protected static IDGenerator keygen = new IDGenerator();
	private String title;
	private Integer id;
	private Enum<MCRS> rating;
	private Integer length;
	private Double price;
	
	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object obj);
	
	@Override
	public abstract String toString();
}
