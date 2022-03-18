package interfaces;

import java.util.Collection;

import model.Client;

/**
 *Interfaz de la clase DDBB donde se definen las condiciones de la clase
 *Colecciones de Clientes y Listas de estos segun el atributo a buscar  
 *
 */

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
