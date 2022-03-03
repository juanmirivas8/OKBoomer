package model;


import java.util.Collection;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import interfaces.IClient;
import interfaces.IDDBB;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DDBB extends interfaces.AbstractDataBase{

	private DDBB() {
		clients = new HashMap<String,Client>();
	}
	
	private static DDBB instance = null;
	
	public static IDDBB newInstance() {
		if(instance == null) {
			instance = new DDBB();
		}
		
		return instance;
	}
	
	@Override
	public Boolean addClient(IClient c) {
		 boolean exists = false;
	        if (c != null && !clients.containsKey(c.getDNI())) {
	            exists = true;
	            clients.put(c.getDNI(), (Client)c);
	        }
	        return exists;
	}

	@Override
	public IClient searchClient(String dni) {
		// TODO Auto-generated method stub
		return clients.get(dni);
	}

	@Override
	public Collection<IClient> listOfClientsByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IClient> listOfClientsByKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IClient> listOfClientsByPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IClient> listOfClientsByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IClient> listOfClientsByRegistrationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteClient(String dni) {
		// TODO Auto-generated method stub
		boolean delete = false;
		if (clients.containsKey(dni)) {
			delete = true;
			clients.remove(dni);
		}
		return delete;
	}

	@Override
	public void saveDataBase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadDataBase() {
		// TODO Auto-generated method stub
		
	}

}
