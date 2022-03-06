package interfaces.reservations;

import java.time.LocalDateTime;

public interface IReservation {

	LocalDateTime getWithdrawalDate();
	void setWithdrawalDate(LocalDateTime date)throws IllegalArgumentException;
	
	LocalDateTime getExpectedReturnDate();
	void setExpectedDevolutionDate(LocalDateTime date)throws IllegalArgumentException;
	
	LocalDateTime getReturnDate();
	void setDevolutionDate(LocalDateTime date)throws IllegalArgumentException;
	
	String getClientDNI();
	void setClientDNI(String DNI)throws IllegalArgumentException; 
	
	String getItemID();
	void setItemID(Integer id)throws IllegalArgumentException;
	
	Boolean getStatus();
	void setStatus(Boolean status)throws IllegalArgumentException;
	
	Integer getID();
	
	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object e);
}
