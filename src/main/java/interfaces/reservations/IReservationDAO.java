package interfaces.reservations;

import java.util.Collection;
import model.Reservation;

public interface IReservationDAO {
	Collection<Reservation> listOfReservationByDNI();
	Collection<Reservation> listOfReservationByID();
	Collection<Reservation> listOfReservationByStatus();
	Collection<Reservation> listOfReservationByItemID();
	
	Boolean add(IReservation r);
	
	IReservation delete(Integer key);
	
	IReservation search(Integer id);
	
	void save();

}
