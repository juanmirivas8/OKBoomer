package controller;

import java.time.LocalDateTime;

import interfaces.reservations.IReservation;
import model.Reservation;

public class ReservationController extends interfaces.AbstractController implements interfaces.reservations.IReservationController {
	
	private ReservationController() {
		super();
	}
	
	private static ReservationController instance = null;
	public static ReservationController newInstance() {
		if (instance == null) {
			instance = new ReservationController();
		}
		return instance;
	}
	@Override
	public void productsMenu(Integer opcion) {
		switch (opcion) {
			case 1 ->makeReservation();
			
			case 2 ->closeReservation();
			
			case 3 ->deleteReservation();
			
			case 4 ->searchReservation();
			
			case 5 ->listReservations();
		}
	}

	@Override
	public void makeReservation() {
		IReservation r = reservationView.readReservation();
		Boolean res = reservations.add((Reservation)r);
		reservationView.operationResult(res);
	}

	@Override
	public void closeReservation() {
		Integer id = reservationView.readID();
		IReservation r = reservations.search(id);
		LocalDateTime t = reservationView.readDate();

		if (r.getReturnDate() == null) {
			r.setWithdrawalDate(t);
		} else {
			reservationView.operationResult(false);
		}
	}

	@Override
	public void deleteReservation() {
		Integer id = reservationView.readID();
		IReservation r = reservations.delete(id);
		
		if (r==null) {
			reservationView.operationResult(false);
		} else {
			reservationView.operationResult(true);
			reservationView.printReservation(r);
		}
	}

	@Override
	public void searchReservation() {
		Integer id = reservationView.readID();
		IReservation r = reservations.search(id);
		
		if(r!=null) {
			reservationView.printReservation(r);
		} else {
			reservationView.operationResult(false);
		}
	}

	@Override
	public void listReservations() {
		Integer opcion = 0;
		do {
			reservationView.printReservationListMenu();
			
			opcion = reservationView.readOption(opcion, opcion);
			
			switch (opcion) {
				case 0 -> reservationView.printReturnBack();
				
				case 1 -> reservationView.printReservationList(reservations.listOfReservationByDNI());
				
				case 2 -> reservationView.printReservationList(reservations.listOfReservationByID());
				
				case 3 -> reservationView.printReservationList(reservations.listOfReservationByItemID());
				
				case 4 -> reservationView.printReservationList(reservations.listOfReservationByStatus());
			}
		} while(opcion != 0);
	}

}
