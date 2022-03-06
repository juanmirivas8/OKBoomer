package interfaces;

import java.util.Collection;

import model.Client;

public interface IClientDAO extends CRUD<String,Client>{

	public Collection<Client> listOfClientsByName();
	
	public Collection<Client> listOfClientsByKey();
	
	public Collection<Client> listOfClientsByPhoneNumber();
	
	public Collection<Client> listOfClientsByAge();
	
	public Collection<Client> listOfClientsByRegistrationDate();
}
