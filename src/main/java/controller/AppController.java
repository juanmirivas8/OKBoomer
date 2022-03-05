package controller;

import interfaces.IClient;
import view.GUI;
import model.DDBB;


public class AppController extends interfaces.AbstractController{

	public AppController() {
		view = new GUI();
		db = DDBB.newInstance();
	}
	@Override
	public void run() {
		int opcion = 0;
		do {
			view.printMainMenu();
			opcion = view.leeOpcion(0,3);
			
			switch (opcion) {
				case 0 ->exitProgram();
			
				case 1 ->clientMenu();
			}
		}while(opcion!=0);
		
	}

	@Override
	protected void clientMenu() {
		int opcion = 0;
		
		do {
			view.printClientMenu();
			opcion = view.leeOpcion(0,5);
			
			switch (opcion) {
				case 0 ->view.printReturnBack();
			
				case 1 ->registerClient();
				
				case 2 ->modifyClient();
				
				case 3 ->deleteClient();
				
				case 4 ->listClients();
				
				case 5 ->searchClient();

			}
		}while(opcion!=0);
		
	}

	@Override
	protected void registerClient() {
		IClient c = view.readClient();
		db.addClient(c);
		
	}

	@Override
	protected void deleteClient() {
		String dni = view.readDNI();
		Boolean res = db.deleteClient(dni);
		view.operationResult(res);
	}

	@Override
	protected void modifyClient() {
		String dni = view.readDNI();
		IClient c = db.searchClient(dni);
		if(c != null) {
			view.modifyClient(c);
			view.operationResult(true);
		}else {
			view.operationResult(false);
		}
	
	}

	@Override
	protected void searchClient() {
		String dni = view.readDNI();
		IClient c = db.searchClient(dni);
		
		if(c!=null) {
			view.printClient(c);
		}else {
			view.operationResult(false);
		}
	}

	@Override
	protected void listClients() {
		int opcion = 0;
		
		do {
			view.printListMenu();
			opcion = view.leeOpcion(0,5);
			
			switch (opcion) {
				case 0 ->view.printReturnBack();
			
				case 1 ->listClientsByName();
				
				case 2 ->listClientsByKey();
				
				case 3 ->listClientsByAge();
				
				case 4 ->listClientsByPhoneNumber();
				
				case 5 ->listClientsByRegistrationDate();

			}
		}while(opcion!=0);
	}

	@Override
	protected void listClientsByAge() {
		
		view.printList(db.listOfClientsByAge());
	}

	@Override
	protected void listClientsByName() {
		view.printList(db.listOfClientsByName());
	}

	@Override
	protected void listClientsByKey() {
		view.printList(db.listOfClientsByKey());
	}

	@Override
	protected void listClientsByPhoneNumber() {
		view.printList(db.listOfClientsByPhoneNumber());
	}

	@Override
	protected void listClientsByRegistrationDate() {
		view.printList(db.listOfClientsByRegistrationDate());
	}

	@Override
	protected void productMenu() {
		
	}

	@Override
	protected void reservationsMenu() {
	
	}

	@Override
	protected void exitProgram() {
		db.saveDataBase();
		view.printExitProgram();
	}
	
}
