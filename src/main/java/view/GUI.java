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
	//Modifica el cliente
	@Override
	public void modifyClient(IClient c) {
		
		
	}
	//Imprime el cliente
	@Override
	public void printClient(IClient c) {
		System.out.println("El cliente ->  "+c);
		
	}

	@Override
	public void printList() {
		
		
	}
	//Imprime el menú
	@Override
	public void printMainMenu() {
		System.out.println("______BIENVENIDO A OKBOOMER______");
		System.out.println(" pulse [0] para -> Salir del programa.");
		System.out.println(" pulse [1] para -> Ir hacia el  Menu Clientes.");
		System.out.println(" pulse [2] para -> Mostrar la lista.");
		
		
	}
	//Muestra por el cliente por atributo en especifico
	@Override
	public void printListMenu() {
		System.out.println("____¿Por cual atributo quieres mostras la lista?____");
		System.out.println(" pulse [0] para -> Volver hacia atrás.");
		System.out.println(" pulse [1] para -> Mostrarla por nombre.");
		System.out.println(" pulse [2] para -> Mostrarla por DNI.");
		System.out.println(" pulse [3] para -> Mostrarla por phone.");
		
	}
	//Imprime salir del programa
	@Override
	public void printExitProgram() {
		System.out.println("A salido correctamente del programa");
		
	}
	//Imprime si la operación es correcta
	@Override
	public void operationResult(Boolean res) {
		
		if(res) {
			System.out.println("la operación ha sido exitosa");
		} else {
			System.out.println("la operación no ha sido exitosa");
		}
			
		
	}
	
	@Override
	public void printClientList(Collection<IClient> l) {
		
		
	}
	//Lee la opcion entre ciertos valores
	@Override
	public int leeOpcion(int inf, int sup) {
		
		return sc.readIntBucle("Introduce opcion: ", inf, sup);
	}
	//Menu del cliente 
	@Override
	public void printClientMenu() {
		System.out.println("______MENÚ CLIENTE______");
		System.out.println(" Pulse [0] para -> volver hacia atrás.");
		System.out.println(" Pulse [1] para -> Introducir un nuevo Cliente.");
		System.out.println(" Pulse [2] para -> Modificar el Cliente.");
		
		
	}

}
