package interfaces.reservations;

import java.util.Collection;

import model.Reservation;

public interface IReservationDAO {
	Collection<Reservation> listOfReservationByDate();
	Collection<Reservation> listOfReservationByName();
	Collection<Reservation> listOfReservationById();

}
