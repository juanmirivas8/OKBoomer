package view;

import java.time.LocalDateTime;
import java.util.Collection;

import interfaces.AbstractUI;
import interfaces.reservations.IReservation;
import interfaces.reservations.IReservationUI;
import model.Reservation;

public class ReservationsUI extends AbstractUI implements IReservationUI{
		private ReservationsUI(){
			super();
			
		}
		private static ReservationsUI instance=null;
		
		public static ReservationsUI newInstance() {
			if(instance == null) {
				instance = new ReservationsUI();
			}
			return instance;
		}
	@Override
	public void printReservationList(Collection<Reservation> r) {
		r.forEach(x->printReservation(x));
		
	}

	@Override
	public IReservation readReservation() {
		LocalDateTime WithdrawalDate = sc.readDateBucle("Insert Withdrawal Date");
		LocalDateTime ExpectedReturnDate = sc.readDateBucle("Insert Expected Return Date");
		LocalDateTime ReturnDate = sc.readDateBucle("Insert Return Date");
		String DNI = sc.readStringBucle("Insert DNI: ", "[0-9]{8}[A-Z]");
		Integer ItemID = sc.readIntBucle("Isert item id");
		Integer ID = sc.readIntBucle("Isert reservation id");
		return new Reservation ();
	}

	@Override
	public void closeReservation(IReservation r) {
		
		 
	}

	@Override
	public void printReservation(IReservation r) {
		System.out.println("");
		System.out.println(r);
		System.out.println("");
		
	}

	@Override
	public void printReservationListMenu() {
		System.out.println("[0] -> Go back");
		System.out.println("[1] -> Show reservations by Withdrawal Date");
		System.out.println("[2] -> Show reservations by Expected Return Date");
		System.out.println("[3] -> Show reservations by Return Date");
		System.out.println("[4] -> Show reservations by DNI");
		System.out.println("[5] -> Show reservations by reservation id");
		
		
	}

	@Override
	public LocalDateTime readDate() {
		
		return sc.readDateBucle("Insert Date: ");
	}

}
