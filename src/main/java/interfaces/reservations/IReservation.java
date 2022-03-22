package interfaces.reservations;

import java.time.LocalDateTime;

public interface IReservation {

	LocalDateTime getWithdrawalDate();
	void setWithdrawalDate(LocalDateTime date)throws IllegalArgumentException;
	
	LocalDateTime getExpectedReturnDate();
	void setExpectedDevolutionDate(LocalDateTime date)throws IllegalArgumentException;
	
	LocalDateTime getReturnDate();
	void setReturnDate(LocalDateTime date)throws IllegalArgumentException;
	
	String getDNI();
	void setDNI(String DNI)throws IllegalArgumentException;
	
	Integer getItemID();
	void setItemID(Integer id)throws IllegalArgumentException;
	
	Boolean getStatus();
	void setStatus(Boolean status)throws IllegalArgumentException;
	
	Integer getID();
	void setID(Integer id)throws IllegalArgumentException;
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object e);
	
	@Override
	String toString();
}
