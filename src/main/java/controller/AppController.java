package controller;

public class AppController extends interfaces.AbstractController implements interfaces.IAppController{

	private AppController() {
		super();
	}
	
	private static AppController instance = null;
	public static AppController newInstance() {
		if(instance == null) {
			instance = new AppController();
		}
		return instance;
	}
	@Override
	public void run() {
		int opcion = 0;
		do {
			view.printMainMenu();
			opcion = view.readOption(0,15);
			if(opcion > 0 && opcion <= 5) {
				clientController.clientMenu(opcion);
			}else if(opcion > 5 && opcion <= 15) {
				productController.productsMenu(opcion);
			}else {
				exitProgram();
			}
		}while(opcion!=0);
	}
	@Override
	public void exitProgram() {
		save();
		view.printExitProgram();
	}
	

}
