package interfaces.reservations;

public interface IReservationController {
	void reservationsMenu(Integer opcion);
	
	void makeReservation();
	
	void closeReservation();
	
	void deleteReservation();
	
	void searchReservation();
	
	void listReservations();
	
}
