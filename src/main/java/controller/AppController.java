package controller;

import interfaces.IUI;
import interfaces.clients.IClientController;


public class AppController implements interfaces.IAppController{

	private IClientController c;
	private IUI view;
	public AppController() {
		c = new ClientController();
	}
	@Override
	public void run() {
		int opcion = 0;
		do {
			view.printMainMenu();
			opcion = view.readOption(0,3);
			
			switch (opcion) {
				case 0 ->exitProgram();
			
				case 1 ->c.clientMenu();
			}
		}while(opcion!=0);
	}
	@Override
	public void exitProgram() {
		c.save();
		view.printExitProgram();
	}

}
