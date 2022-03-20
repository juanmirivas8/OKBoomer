package interfaces.reservations;

import java.time.LocalDateTime;
import java.util.Collection;

import model.Reservation;

public interface IReservationUI {

	void printReservationList(Collection<Reservation> r);
	
	IReservation readReservation();
	
	void closeReservation(IReservation r);
	
	void printReservation(IReservation r);

	void printReservationListMenu();

}
