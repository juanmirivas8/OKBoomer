package interfaces;

import java.util.Collection;

public interface IDDBB {

	Boolean addClient(IClient c);
	
	IClient searchClient(String dni);
	
	Collection<IClient> listOfClientsByName();
	
	Collection<IClient> listOfClientsByKey();
	
	Collection<IClient> listOfClientsByPhoneNumber();
	
	Collection<IClient> listOfClientsByAge();
	
	Collection<IClient> listOfClientsByRegistrationDate();
	
	Boolean deleteClient(String dni);
	
	void saveDataBase();
	
	void loadDataBase();
}
