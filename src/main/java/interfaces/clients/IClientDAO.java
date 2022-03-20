package interfaces.clients;

import java.util.Collection;

import interfaces.CRUD;
import model.Client;

public interface IClientDAO extends CRUD<String,Client>{

	Collection<Client> listOfClientsByName();
	
	Collection<Client> listOfClientsByKey();
	
	Collection<Client> listOfClientsByPhoneNumber();
	
	Collection<Client> listOfClientsByAge();
	
	Collection<Client> listOfClientsByRegistrationDate();
}
