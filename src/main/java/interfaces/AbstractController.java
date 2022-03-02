package interfaces;

public abstract class AbstractController implements IAppController{

	protected IGUI view;
	protected IDDBB db;
	
	protected abstract void clientMenu();
	
	protected abstract void registerClient();
	
	protected abstract void deleteClient();
	
	protected abstract void modifyClient();
	
	protected abstract void searchClient();
	
	protected abstract void listClients();
	
	protected abstract void listClientsByAge();
	
	protected abstract void listClientsByName();
	
	protected abstract void listClientsByKey();
	
	protected abstract void listClientsByPhoneNumber();
	
	protected abstract void listClientsByRegistrationDate();
	
	protected abstract void productMenu();
	
	protected abstract void reservationsMenu();
	
	protected abstract void exitProgram();
	
	protected abstract void cargarXML();
	
	protected abstract void guardarXML();
	
	
}
