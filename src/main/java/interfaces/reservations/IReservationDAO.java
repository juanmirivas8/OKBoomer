package interfaces.reservations;

import java.util.Collection;
import model.Reservation;

public interface IReservationDAO {
	Collection<Reservation> listOfReservationByDNI();
	Collection<Reservation> listOfReservationByID();
	Collection<Reservation> listOfReservationActive();
	Collection<Reservation> listOfReservationClosed();
	Collection<Reservation> listOfReservationByItemID();
	Collection<Reservation> getReservations(String dni);
	Collection<Reservation> getReservations(Integer idItem);
	Collection<Reservation> getClosedReservations(String dni);
	Collection<Reservation> getActiveReservations(String dni);
	Reservation getOpenReservation(Integer idItem);
	Boolean add(IReservation r);
	
	IReservation delete(Integer key);
	
	IReservation search(Integer id);
	
	void save();

}
