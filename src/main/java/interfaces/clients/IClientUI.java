package interfaces.clients;

import java.util.Collection;

import model.Client;

public interface IClientUI {

	IClient readClient();
	
	void modifyClient(IClient c);
	
	void printClient(IClient c);
	
	void printClientMenu();
	
	void printListMenu();

	void printList(Collection<Client> c);

}
