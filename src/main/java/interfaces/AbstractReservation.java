package interfaces;

import java.util.Calendar;

import model.IDGenerator;

public abstract class AbstractReservation implements IReservation{

	protected static IDGenerator keygen = new IDGenerator();
	private String clientDNI;
	private String itemID;
	private Calendar withdrawalDate;
	private Calendar expectedReturnDate;
	private Calendar returnDate;
	private Boolean status;
	private Integer id;
	
	@Override
	public abstract boolean equals(Object obj);
	
	@Override
	public abstract String toString();
}
