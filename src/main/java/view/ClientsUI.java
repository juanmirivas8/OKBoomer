package view;

import java.util.Collection;

import interfaces.clients.IClient;
import model.Client;

public class ClientsUI extends interfaces.AbstractUI implements interfaces.clients.IClientUI{

	private ClientsUI(){
		super();
	}
	
	private static ClientsUI instance = null;
	
	public static ClientsUI newInstance() {
		if(instance == null) {
			instance = new ClientsUI();
		}
		
		return instance;
	}
	
	
	@Override
	public IClient readClient() {
		String dni = sc.readStringBucle("Insert DNI: ", "[0-9]{8}[A-Z]");
		String name = sc.readString("Insert name: ");
		Integer age = sc.readIntBucle("Insert age: ", 0, 120);
		String phone = sc.readStringBucle("Insert phone: ", "[0-9]{9}");
		
		return new Client(dni, name, age, phone);
	}
	
	@Override
	public void modifyClient(IClient c) {
		String name = sc.readString("Insert name: ");
		Integer age = sc.readIntBucle("Insert age: ", 0, 120);
		String phone = sc.readStringBucle("Insert phone: ", "[0-9]{9}");
		
		c.setName(name);
		c.setAge(age);
		c.setPhoneNumber(phone);
	}
	
	@Override
	public void printClient(IClient c) {
		System.out.println("");
		System.out.println(c);
		System.out.println("");
	}

	@Override
	public void printList(Collection<Client> c) {
		c.forEach(x->printClient(x));
	}

	@Override
	public void printListMenu() {
		System.out.println("");
		System.out.println("[0] -> Go Back");
		System.out.println("[1] -> Show clients by name");
		System.out.println("[2] -> Show clients by DNI");
		System.out.println("[3] -> Show clients by age");
		System.out.println("[4] -> Show clients by phone number");
		System.out.println("[5] -> Show clients by membership time");
	}

	@Override
	public void printClientMenu() {
		System.out.println("");
		System.out.println("______CLIENT MENU______");
		System.out.println("[0] -> Return back");
		System.out.println("|[1] -> Insert new client");
		System.out.println("|[2] -> Modify existing client");
		System.out.println("|[3] -> Delete client");
		System.out.println("|[4] -> List clients");
		System.out.println("|[5] -> Find client");
		System.out.println("");
	}

}
