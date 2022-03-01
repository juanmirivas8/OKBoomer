package interfaces;

import java.util.Calendar;

public interface IReservation {

	Calendar getWithdrawalDate();
	void setWithdrawalDate(Calendar date)throws IllegalArgumentException;
	
	Calendar getExpectedReturnDate();
	void setExpectedDevolutionDate(Calendar date)throws IllegalArgumentException;
	
	Calendar getReturnDate();
	void setDevolutionDate(Calendar date)throws IllegalArgumentException;
	
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
