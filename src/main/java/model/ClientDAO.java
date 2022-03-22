package model;

import interfaces.DAO;

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

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Client.class)
public class ClientDAO extends DAO<String,Client> implements interfaces.clients.IClientDAO{

	private static ClientDAO instance= null;
	private static final long serialVersionUID = 1L;
	
	private ClientDAO() {
	
	}
	
	public static ClientDAO newInstance() {
		if(instance == null) {
			instance = new ClientDAO();
			ClientDAO aux = load();
			instance.ddbb = aux.ddbb;
		}
		
		return instance;
	}
	
	@Override
	public void save() {
		try {
			JAXBContext contexto = JAXBContext.newInstance(ClientDAO.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(instance, new File("src/main/resources/clients.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static ClientDAO load() {
		JAXBContext contexto;
		ClientDAO newDDBB = null;
		try {
			contexto = JAXBContext.newInstance(ClientDAO.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    newDDBB = (ClientDAO) um.unmarshal( new File("src/main/resources/clients.xml") );
	
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDDBB;
	}

	@Override
	public Collection<Client> listOfClientsByName() {
		ArrayList<Client> c = new ArrayList<>(ddbb.values()); 
		c.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
		return c;
	}

	@Override
	public Collection<Client> listOfClientsByKey() {
		ArrayList<Client> c = new ArrayList<>(ddbb.values());
		c.sort((c1,c2)->c1.getDNI().compareToIgnoreCase(c2.getDNI()));
		return c;
	}

	@Override
	public Collection<Client> listOfClientsByPhoneNumber() {
		ArrayList<Client> c = new ArrayList<>(ddbb.values());
		c.sort((c1,c2)->c1.getPhoneNumber().compareToIgnoreCase(c2.getPhoneNumber()));
		return c;
	}

	@Override
	public Collection<Client> listOfClientsByAge() {
		ArrayList<Client> c = new ArrayList<>(ddbb.values());
		c.sort((c1,c2)->c1.getAge().compareTo(c2.getAge()));
		return c;
	}

	@Override
	public Collection<Client> listOfClientsByRegistrationDate() {
		ArrayList<Client> c = new ArrayList<>(ddbb.values());
		c.sort((c1,c2)->c1.getRegisterTime().compareTo(c2.getRegisterTime()));
		return c;
	}
	
	

}
