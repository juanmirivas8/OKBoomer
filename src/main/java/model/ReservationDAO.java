package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import interfaces.AbstractDAO;
import interfaces.reservations.IReservation;
import interfaces.reservations.IReservationDAO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Reservation.class)
public class ReservationDAO extends AbstractDAO<Integer,Reservation> implements IReservationDAO {

	private static final long serialVersionUID = 1L;
	private static ReservationDAO instance = null;
	private IDGenerator keygen;
	
	private ReservationDAO() {
		keygen = new IDGenerator();
	}
	
	public static ReservationDAO newInstance() {
		if (instance == null) {
			instance = new ReservationDAO();
			ReservationDAO aux = load();
			instance.ddbb = aux.ddbb;
			instance.keygen = aux.keygen;
		}
		return instance;
	}

	@Override
	public Collection<Reservation> listOfReservationByDNI() {
		// TODO Auto-generated method stub
		ArrayList<Reservation> r = new ArrayList<>(ddbb.values());
		r.sort( (r1,r2)-> r1.getClientDNI().compareToIgnoreCase(r2.getClientDNI()) );
		return r;
	}

	@Override
	public Collection<Reservation> listOfReservationByID() {
		// TODO Auto-generated method stub
		ArrayList<Reservation> r = new ArrayList<>(ddbb.values());
		r.sort( (r1,r2)-> r1.getID().compareTo(r2.getID()) );
		return r;
	}

	@Override
	public Collection<Reservation> listOfReservationByStatus() {
		// TODO Auto-generated method stub
		ArrayList<Reservation> r = new ArrayList<>(ddbb.values());
		r.sort( (r1,r2)-> r1.getStatus().compareTo(r2.getStatus()) );
		return r;
	}

	@Override
	public Collection<Reservation> listOfReservationByItemID() {
		// TODO Auto-generated method stub
		ArrayList<Reservation> r = new ArrayList<>(ddbb.values());
		r.sort( (r1,r2)-> r1.getItemID().compareToIgnoreCase(r2.getItemID()) );
		return r;
	}

	@Override
	public Boolean add(IReservation r) {
		// TODO Auto-generated method stub
		Integer key = keygen.generateKey();
		r.setID();
		return super.add((Reservation)r, key);
	}
	
	@Override
	public Reservation delete(Integer k) {
		// TODO Auto-generated method stub
		if (ddbb.containsKey(k)) {
			keygen.eliminateKey(k);
		}
		return super.delete(k);
	}
	
	@Override
	public Reservation search(Integer k) {
		// TODO Auto-generated method stub
		return super.search(k);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			JAXBContext c = JAXBContext.newInstance(ReservationDAO.class);
			Marshaller m = c.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(instance, new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/reservation.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static ReservationDAO load() {
		// TODO Auto-generated method stub
		JAXBContext c;
		ReservationDAO newDDBB = null;
		try {
			c = JAXBContext.newInstance(ReservationDAO.class);
		    Unmarshaller um = c.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    newDDBB = (ReservationDAO) um.unmarshal( new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/reservation.xml") );
	
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDDBB;
	}

}
