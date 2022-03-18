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
import interfaces.IClient;
import interfaces.IDDBB;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DDBB extends interfaces.AbstractDataBase{

	private DDBB() {
		
	}
	
	private static DDBB instance = null;
	/**
	 * Creacion de la instancia para la base de datos
	 * @return
	 */
	public static IDDBB newInstance() {
		if(instance == null) {
			DDBB aux = loadDataBase();
			instance = new DDBB();
			instance.clients=aux.clients;
		}
		
		return instance;
	}
/**
 * Metodo para añadir un cliente 
 */
	@Override
	public Boolean addClient(IClient c) {
		 boolean exists = false;
	        if (c != null && !clients.containsKey(c.getDNI())) {
	            exists = true;
	            clients.put(c.getDNI(), (Client)c);
	        }
	        return exists;
	}
/**
 * Metodo para buscar un cliente 
 */
	@Override
	public IClient searchClient(String dni) {
		return clients.get(dni);
	}
/**
 * Coleccion de clientes por nombre
 */
	@Override
	public Collection<Client> listOfClientsByName() {
		ArrayList<Client> c = new ArrayList<>(clients.values()); 
		c.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
		return c;
	}
/*
 * Coleccion de clientes por DNI
 */
	@Override
	public Collection<Client> listOfClientsByKey() {
		ArrayList<Client> c = new ArrayList<>(clients.values());
		c.sort((c1,c2)->c1.getDNI().compareToIgnoreCase(c2.getDNI()));
		return c;
	}
/**
 * Coleccion de clientes por numero de telefono
 */
	@Override
	public Collection<Client> listOfClientsByPhoneNumber() {
		ArrayList<Client> c = new ArrayList<>(clients.values());
		c.sort((c1,c2)->c1.getPhoneNumber().compareToIgnoreCase(c2.getPhoneNumber()));
		return c;
	}
/*
 * Coleccion de clientes por edad
 */
	@Override
	public Collection<Client> listOfClientsByAge() {
		ArrayList<Client> c = new ArrayList<>(clients.values());
		c.sort((c1,c2)->c1.getAge().compareTo(c2.getAge()));
		return c;
	}
/**
 * Coleccion de clientes por fecha de registro
 */
	@Override
	public Collection<Client> listOfClientsByRegistrationDate() {
		ArrayList<Client> c = new ArrayList<>(clients.values());
		c.sort((c1,c2)->c1.getRegisterTime().compareTo(c2.getRegisterTime()));
		return c;
	}
/**
 * Metodo para eliminar un cliente 
 */
	@Override
	public Boolean deleteClient(String dni) {
		boolean delete = false;
		if (clients.containsKey(dni)) {
			delete = true;
			clients.remove(dni);
		}
		return delete;
	}
	/**
	 * Metodo para cargar la base de datos
	 * @return
	 */
	private static DDBB loadDataBase() {
		JAXBContext contexto;
		DDBB newDDBB = null;
		try {
			contexto = JAXBContext.newInstance(DDBB.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    newDDBB = (DDBB) um.unmarshal( new File("prueba.xml") );
	
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDDBB;
	}
	/**
	 * Metodo para guardar la base de datos
	 */
	public void saveDataBase() {
		try {
			JAXBContext contexto = JAXBContext.newInstance(DDBB.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(instance, new File("prueba.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
