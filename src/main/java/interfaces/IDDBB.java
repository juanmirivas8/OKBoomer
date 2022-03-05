package interfaces;

import java.util.Collection;

import model.Client;


public interface IDDBB {

	Boolean addClient(IClient c);
	
	IClient searchClient(String dni);
	
	Collection<Client> listOfClientsByName();
	
	Collection<Client> listOfClientsByKey();
	
	Collection<Client> listOfClientsByPhoneNumber();
	
	Collection<Client> listOfClientsByAge();
	
	Collection<Client> listOfClientsByRegistrationDate();
	
	Boolean deleteClient(String dni);
	
	public void saveDataBase();
	
}
