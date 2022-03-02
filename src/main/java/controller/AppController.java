package controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
		this.cargarXML();
		int opcion = 0;
		
		do {
			view.printMainMenu();
			opcion = view.leeOpcion(0,1);
			
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
			view.printListMenu();
			opcion = view.leeOpcion(0,1);
			
			switch (opcion) {
				case 0 ->exitProgram();
			
				case 1 ->registerClient();

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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void modifyClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void searchClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listClients() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listClientsByAge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listClientsByName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listClientsByKey() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listClientsByPhoneNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listClientsByRegistrationDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void productMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void reservationsMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void exitProgram() {
		guardarXML();
		
	}
	@Override
	protected void cargarXML() {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(DDBB.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    DDBB newBBDD = (DDBB) um.unmarshal( new File("prueba.xml") );
		    db=newBBDD;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void guardarXML() {
		try {
			JAXBContext contexto = JAXBContext.newInstance(DDBB.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(db, new File("prueba.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
