package controller;

import interfaces.IClient;
import view.GUI;
import model.DDBB;

/**
 * Clase del controlador donde ejecuta los metodos
 *  de las clases llamadas
 *
 */
public class AppController extends interfaces.AbstractController{

	public AppController() {
		view = new GUI();
		db = DDBB.newInstance();
	}
	/**
	 * Metodo de arranque de la aplicacion
	 */
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
/**
 * Metodo del menu cliente
 */
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
/**
 * Metodo de registro de cliente
 */
	@Override
	protected void registerClient() {
		IClient c = view.readClient();
		db.addClient(c);
		
	}
/**
 * Metodo de borrado de cliente
 */
	@Override
	protected void deleteClient() {
		String dni = view.readDNI();
		Boolean res = db.deleteClient(dni);
		view.operationResult(res);
	}
/**
 * Metodo de modificacion de cliente
 */
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
/**
 * Metodo de busqueda de cliente
 */
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
/**
 * Metodo de lista de clientes 
 */
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
/**
 * Metodo de lista de clientes por edad
 */
	@Override
	protected void listClientsByAge() {
		
		view.printList(db.listOfClientsByAge());
	}
/**
 * Metodo de lista de clientes por nombre
 */
	@Override
	protected void listClientsByName() {
		view.printList(db.listOfClientsByName());
	}
/**
 * Metodo de lista de clientes por la clave
 */
	@Override
	protected void listClientsByKey() {
		view.printList(db.listOfClientsByKey());
	}
/**
 * Metodo d elista de clientes por numero de telefono
 */
	@Override
	protected void listClientsByPhoneNumber() {
		view.printList(db.listOfClientsByPhoneNumber());
	}
/**
 * Metodo de lista de clietnes por fecha de registro
 */
	@Override
	protected void listClientsByRegistrationDate() {
		view.printList(db.listOfClientsByRegistrationDate());
	}
/**
 * Metodo del menu Producto
 */
	@Override
	protected void productMenu() {
		
	}
/**
 * Metodo de menu Reserva
 */
	@Override
	protected void reservationsMenu() {
	
	}
/**
 * Metodo de salida del programa
 */
	@Override
	protected void exitProgram() {
		db.saveDataBase();
		view.printExitProgram();
	}
	
}
