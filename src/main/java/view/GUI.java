package view;

import java.util.Collection;

import interfaces.IClient;
import model.Client;

public class GUI extends interfaces.AbstractView{

	public GUI(){
		super();
		sc = Escaner.newInstance();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printClient(IClient c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMainMenu() {
		System.out.println("[0] - Salir del programa");
		System.out.println("[1] - Menu Clientes");
		
	}

	@Override
	public void printListMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printExitProgram() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationResult(Boolean res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printClientList(Collection<IClient> l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int leeOpcion(int inf, int sup) {
		
		return sc.readIntBucle("Introduce opcion: ", inf, sup);
	}
	@Override
	public void printClientMenu() {
		System.out.println("[0] - Atras");
		System.out.println("[1] - Introducir Cliente");
		
	}

}
