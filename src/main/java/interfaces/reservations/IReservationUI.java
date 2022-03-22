package interfaces.reservations;

import java.time.LocalDateTime;
import java.util.Collection;

import model.Item;
import model.Reservation;

public interface IReservationUI {

	void printReservationList(Collection<Reservation> r);
	
	IReservation readReservation();
	
	void printReservation(IReservation r);

	void printReservationListMenu();

	Collection<Item> reservedItems();

	Collection<Item> unreservedItems();
}
