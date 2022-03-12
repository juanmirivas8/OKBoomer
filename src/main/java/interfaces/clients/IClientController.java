package interfaces.clients;

public interface IClientController {

	void clientMenu(Integer opcion);

	void registerClient();

	void deleteClient();

	void modifyClient();

	void searchClient();

	void listClients();

	void listClientsByAge();

	void listClientsByName();

	void listClientsByKey();

	void listClientsByPhoneNumber();

	void listClientsByRegistrationDate();

}
