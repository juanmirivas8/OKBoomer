package model;

import java.util.Collection;

import interfaces.DAO;
import interfaces.reservations.IReservation;
import interfaces.reservations.IReservationDAO;

public class ReservationDAO extends DAO<Integer,Reservation> implements IReservationDAO{

	@Override
	public Collection<Reservation> listOfReservationByDNI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Reservation> listOfReservationByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Reservation> listOfReservationByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Reservation> listOfReservationByItemID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(IReservation r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
