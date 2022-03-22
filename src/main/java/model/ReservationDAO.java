package model;

import java.io.File;
import java.util.*;

import interfaces.DAO;
import interfaces.reservations.IReservation;
import interfaces.reservations.IReservationDAO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Reservation.class)
public class ReservationDAO extends DAO<Integer,Reservation> implements IReservationDAO{

	private static final long serialVersionUID = 1L;
	private static ReservationDAO instance = null;
	private IDGenerator keygen;

	public static ReservationDAO newInstance() {
		if (instance == null) {
			instance = new ReservationDAO();
			ReservationDAO aux = load();
			instance.ddbb = aux.ddbb;
			instance.keygen = aux.keygen;
		}
		return instance;
	}

	private ReservationDAO(){
		keygen = new IDGenerator();
	}

	@Override
	public Collection<Reservation> listOfReservationByDNI() {
		ArrayList<Reservation> c = new ArrayList<>(ddbb.values());
		c.sort(Comparator.comparing(Reservation::getDNI));
		return c;
	}

	@Override
	public Collection<Reservation> listOfReservationByID() {
		ArrayList<Reservation> c = new ArrayList<>(ddbb.values());
		c.sort(Comparator.comparing(Reservation::getID));
		return c;
	}

	@Override
	public Collection<Reservation> listOfReservationActive() {
		Collection<Reservation> c = ddbb.values();

		Collection<Reservation> res = new ArrayList<>();

		Iterator<Reservation> it = c.iterator();

		while(it.hasNext()){
			Reservation r = it.next();
			if(r.getStatus()){
				res.add(r);
			}
		}

		return res;
	}

	@Override
	public Collection<Reservation> listOfReservationClosed() {
		Collection<Reservation> c = ddbb.values();

		Collection<Reservation> res = new ArrayList<>();

		Iterator<Reservation> it = c.iterator();

		while(it.hasNext()){
			Reservation r = it.next();
			if(!r.getStatus()){
				res.add(r);
			}
		}

		return res;
	}

	@Override
	public Collection<Reservation> listOfReservationByItemID() {
		ArrayList<Reservation> c = new ArrayList<>(ddbb.values());
		c.sort(Comparator.comparing(Reservation::getItemID));
		return c;
	}

	@Override
	public Collection<Reservation> getActiveReservations(String dni) {
		Collection<Reservation> c = ddbb.values();

		Collection<Reservation> res = new ArrayList<>();

		Iterator<Reservation> it = c.iterator();

		while(it.hasNext()){
			Reservation r = it.next();
			if(r.getDNI().equals(dni) && r.getStatus()==true){
				res.add(r);
			}
		}

		return res;
	}

	@Override
	public Collection<Reservation> getReservations(Integer idItem) {
		Collection<Reservation> c = ddbb.values();

		Collection<Reservation> res = new ArrayList<>();

		Iterator<Reservation> it = c.iterator();

		while(it.hasNext()){
			Reservation r = it.next();
			if(r.getItemID()==idItem){
				res.add(r);
			}
		}

		return res;
	}



	@Override
	public Collection<Reservation> getClosedReservations(String dni) {
		Collection<Reservation> c = ddbb.values();

		Collection<Reservation> res = new ArrayList<>();

		Iterator<Reservation> it = c.iterator();

		while(it.hasNext()){
			Reservation r = it.next();
			if(r.getDNI().equals(dni) && r.getStatus()==false){
				res.add(r);
			}
		}

		return res;
	}

	@Override
	public Collection<Reservation> getReservations(String dni) {
		Collection<Reservation> c = ddbb.values();

		Collection<Reservation> res = new ArrayList<>();

		Iterator<Reservation> it = c.iterator();

		while(it.hasNext()){
			Reservation r = it.next();
			if(r.getDNI().equals(dni)){
				res.add(r);
			}
		}

		return res;
	}

	@Override
	public Reservation getOpenReservation(Integer idItem) {
		Collection<Reservation> c = ddbb.values();

		Collection<Reservation> res = new ArrayList<>();

		Iterator<Reservation> it = c.iterator();

		while(it.hasNext()){
			Reservation r = it.next();
			if(r.getItemID()==idItem && r.getStatus()==true){
				return r;
			}
		}
		return null;
	}

	@Override
	public Boolean add(IReservation r) {
		Integer key = keygen.generateKey();
		r.setID(key);
		return super.add((Reservation) r,key);
	}

	@Override
	public Reservation delete(Integer integer) {
		if(ddbb.containsKey(integer)) {
			keygen.eliminateKey(integer);
		}
		return super.delete(integer);
	}

	@Override
	public void save() {
		try {
			JAXBContext c = JAXBContext.newInstance(ReservationDAO.class);
			Marshaller m = c.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(instance, new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/reservations.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static ReservationDAO load(){
		JAXBContext c;
		ReservationDAO newDDBB = null;

		try {
			c = JAXBContext.newInstance(ReservationDAO.class);
			Unmarshaller um = c.createUnmarshaller();

			newDDBB = (ReservationDAO) um.unmarshal(new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/reservations.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newDDBB;
	}
}
