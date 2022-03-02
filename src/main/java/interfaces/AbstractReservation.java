package interfaces;

import java.time.LocalDateTime;

import model.IDGenerator;

public abstract class AbstractReservation implements IReservation{

	protected static IDGenerator keygen = new IDGenerator();
	private String clientDNI;
	private String itemID;
	private LocalDateTime withdrawalDate;
	private LocalDateTime expectedReturnDate;
	private LocalDateTime returnDate;
	private Boolean status;
	private Integer id;
	
	@Override
	public abstract boolean equals(Object obj);
	
	@Override
	public abstract String toString();
}
