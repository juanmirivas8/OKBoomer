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
			opcion = view.readOption(0,3);
			
			switch (opcion) {
				case 0 ->exitProgram();
			
				case 1 ->clientController.clientMenu();
				
				case 2 ->productController.productsMenu();
			}
		}while(opcion!=0);
	}
	@Override
	public void exitProgram() {
		save();
		view.printExitProgram();
	}
	

}
