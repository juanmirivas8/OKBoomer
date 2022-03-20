package interfaces.reservations;

import java.time.LocalDateTime;
import java.util.Collection;

import model.Reservation;

public interface IReservationUI {
	Integer readOption(Integer inf, Integer sup);
	
	void printReservationList(Collection<Reservation> r);
	
	IReservation readReservation();
	
	void closeReservation(IReservation r);
	
	void printReservation(IReservation r);
	
	void printReturnBack();
	
	void operationResult(Boolean res);
	
	void printReservationListMenu();
	
	Integer readID();
	
	String readDNI();
	
	LocalDateTime readDate();
}
