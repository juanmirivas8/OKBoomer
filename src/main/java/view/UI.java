package view;

import interfaces.IUI;

public class UI extends interfaces.AbstractUI implements interfaces.IUI{

	private UI() {
		super();
	}
	
	private static UI instance = null;
	
	public static IUI newInstance() {
		if (instance == null) {
			instance = new UI();
		}
		
		return instance;
	}
	
	@Override
	public void printMainMenu() {
		
		System.out.println("|___________̣____̣____________WELCOME TO SOGEVIC ---[0] -> Exit program__________̣____̣____̣____̣________|");
		System.out.println("|---------CLIENTS MENU----------|-----------PRODUCT MENU---------|------------ITEMS MENU-----------|");
		System.out.println("|[1] -> Insert new client       |[6] -> Insert new product       |[11] -> Insert new Item          |");
		System.out.println("|[2] -> Modify existing client  |[7] -> Modify existing product  |[12] -> Modify existing item     |");
		System.out.println("|[3] -> Delete client           |[8] -> Delete product           |[13] -> Delete item              |");
		System.out.println("|[4] -> List clients            |[9] -> List product             |[14] -> List items               |");
		System.out.println("|[5] -> Find client             |[10] -> Find product            |[15] -> Find item                |");
		System.out.println("|____________________________________________________________̣_______________̣____̣____̣____̣____̣____̣___|");
		System.out.println("");
	}

	@Override
	public void printExitProgram() {
		System.out.println("Program terminated successfully");
	}
	
}
