package view;

import java.util.Collection;

import interfaces.clients.IClient;
import model.Client;

public class ClientsUI extends interfaces.AbstractUI implements interfaces.clients.IClientUI{

	public ClientsUI(){
		super();
	}
	
	@Override
	public IClient readClient() {
		String dni = sc.readStringBucle("Introduce dni: ", "[0-9]{8}[A-Z]");
		String name = sc.readString("Introduce nombre: ");
		Integer age = sc.readIntBucle("Introduce edad: ", 0, 120);
		String phone = sc.readStringBucle("Introduce phone: ", "[0-9]{9}");
		
		return new Client(dni, name, age, phone);
	}
	
	@Override
	public void modifyClient(IClient c) {
		String name = sc.readString("Introduce nombre: ");
		Integer age = sc.readIntBucle("Introduce edad: ", 0, 120);
		String phone = sc.readStringBucle("Introduce phone: ", "[0-9]{9}");
		
		c.setName(name);
		c.setAge(age);
		c.setPhoneNumber(phone);
	}
	
	@Override
	public void printClient(IClient c) {
		System.out.println("\n######################\n");
		System.out.println(c);
		System.out.println("\n######################\n");
	}

	@Override
	public void printList(Collection<?> c) {
		c.forEach(System.out::println);
		
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
	public void operationResult(Boolean res) {
		if(res) {
			System.out.println("Successfull operation");
		} else {
			System.out.println("Failed operation");
		}
	}

	@Override
	public void printClientMenu() {
		System.out.println("");
		System.out.println("______CLIENT MENU______");
		System.out.println("[0] -> Return back");
		System.out.println("[1] -> Insert new client");
		System.out.println("[2] -> Modify existing client");
		System.out.println("[3] -> Delete client");
		System.out.println("[4] -> List clients");
		System.out.println("[5] -> Find client");
		System.out.println("");
	}
	@Override
	public void printReturnBack() {
		System.out.println("");
		System.out.println("Returning back ...");
		System.out.println("");
		
	}
	@Override
	public String readDNI() {
		return sc.readStringBucle("Insert DNI: ", "[0-9]{8}[A-Z]");
	}

}
