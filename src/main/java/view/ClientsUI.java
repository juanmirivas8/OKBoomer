package view;

import java.util.ArrayList;
import java.util.Collection;

import interfaces.API;
import interfaces.clients.IClient;
import model.Client;
import model.Reservation;

public class ClientsUI extends API implements interfaces.clients.IClientUI{

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

		System.out.println("\n"+c+" - Active reservations: "+reservations.getActiveReservations(c.getDNI()).size()
				+" - Closed reservations: "+reservations.getClosedReservations(c.getDNI()).size());
	}

	@Override
	public void printList(Collection<Client> c) {
		c.forEach(this::printClient);
	}

	@Override
	public void printListMenu() {
		System.out.println("\n[0] -> Go Back");
		System.out.println("[1] -> Show clients by name");
		System.out.println("[2] -> Show clients by DNI");
		System.out.println("[3] -> Show clients by age");
		System.out.println("[4] -> Show clients by phone number");
		System.out.println("[5] -> Show clients by membership time");
		System.out.println("[6] -> Show clients with active reservations");
	}

	@Override
	public void printClientMenu() {
		System.out.println("\n______CLIENT MENU______");
		System.out.println("[0] -> Return back");
		System.out.println("|[1] -> Insert new client");
		System.out.println("|[2] -> Modify existing client");
		System.out.println("|[3] -> Delete client");
		System.out.println("|[4] -> List clients");
		System.out.println("|[5] -> Find client\n");

	}

	@Override
	public void printClientWithReservations(IClient c) {
		this.printClient(c);
		System.out.println("-------------------Active Reservations--------------------");
		reservationView.printReservationList(reservations.getActiveReservations(c.getDNI()));
		System.out.println("-------------------Closed Reservations--------------------");
		reservationView.printReservationList(reservations.getClosedReservations(c.getDNI()));
	}

	@Override
	public void listClientsWithActiveReservations() {
		Collection<Client> cl = new ArrayList<>();
		Client c = null;
		for(Reservation r:reservations.listOfReservationActive()){
			c=clients.search(r.getDNI());
			if(!cl.contains(c)){
				cl.add(c);
			}
		}

		clientView.printList(cl);
	}

	@Override
	public void listClientsWithClosedReservations() {
		Collection<Client> cl = new ArrayList<>();
		for(Client client:clients.listOfClientsByKey()){
			if(reservations.getActiveReservations(client.getDNI()).size()==0){
				cl.add(client);
			}
		}
		clientView.printList(cl);
	}

}
