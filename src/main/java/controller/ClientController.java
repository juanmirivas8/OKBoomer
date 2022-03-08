package controller;

import interfaces.clients.IClient;
import model.Client;

public class ClientController extends interfaces.AbstractController implements interfaces.clients.IClientController{

	private static ClientController instance = null;
	
	private ClientController() {
		super();
	}
	
	public static ClientController newInstance() {
		if(instance == null) {
			instance = new ClientController();			
		}
		
		return instance;
	}

	@Override
	public void clientMenu() {
		int opcion = 0;
		
		do {
			clientView.printClientMenu();
			opcion = clientView.readOption(0,5);
			
			switch (opcion) {
				case 0 ->clientView.printReturnBack();
			
				case 1 ->registerClient();
				
				case 2 ->modifyClient();
				
				case 3 ->deleteClient();
				
				case 4 ->listClients();
				
				case 5 ->searchClient();

			}
		}while(opcion!=0);
		
	}

	@Override
	public void registerClient() {
		IClient c = clientView.readClient();
		clients.add((Client)c, c.getDNI());
	}

	@Override
	public void deleteClient() {
		String dni = clientView.readDNI();
		IClient c = clients.delete(dni);
		
		if(c == null) {
			clientView.operationResult(false);
		}else {
			clientView.operationResult(true);
			clientView.printClient(c);
		}
	}

	@Override
	public void modifyClient() {
		String dni = clientView.readDNI();
		IClient c = clients.search(dni);
		if(c != null) {
			clientView.modifyClient(c);
			clientView.operationResult(true);
		}else {
			clientView.operationResult(false);
		}
	}

	@Override
	public void searchClient() {
		String dni = clientView.readDNI();
		IClient c = clients.search(dni);
		
		if(c!=null) {
			clientView.printClient(c);
		}else {
			clientView.operationResult(false);
		}
	}

	@Override
	public void listClients() {
		int opcion = 0;
		
		do {
			clientView.printListMenu();
			opcion = clientView.readOption(0,5);
			
			switch (opcion) {
				case 0 ->clientView.printReturnBack();
			
				case 1 ->listClientsByName();
				
				case 2 ->listClientsByKey();
				
				case 3 ->listClientsByAge();
				
				case 4 ->listClientsByPhoneNumber();
				
				case 5 ->listClientsByRegistrationDate();

			}
		}while(opcion!=0);
	}

	@Override
	public void listClientsByAge() {
		clientView.printList(clients.listOfClientsByAge());
	}

	@Override
	public void listClientsByName() {
		clientView.printList(clients.listOfClientsByName());
	}

	@Override
	public void listClientsByKey() {
		clientView.printList(clients.listOfClientsByKey());
	}

	@Override
	public void listClientsByPhoneNumber() {
		clientView.printList(clients.listOfClientsByPhoneNumber());
	}

	@Override
	public void listClientsByRegistrationDate() {
		clientView.printList(clients.listOfClientsByRegistrationDate());
	}

	@Override
	public void save() {
		clients.save();
	}
	
}
