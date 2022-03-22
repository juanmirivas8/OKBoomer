package view;

import interfaces.API;
import interfaces.IUI;

public class UI extends API implements interfaces.IUI{

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
		System.out.println("|___________̣____̣_______________̣____̣____̣____̣_______WELCOME TO SOGEVIC ---[0] -> Exit program________________________________________________|");
		System.out.println("|---------CLIENTS MENU----------|-----------PRODUCT MENU---------|------------ITEMS MENU-----------|-----------RESERVATIONS MENU-----------|");
		System.out.println("|[1] -> Insert new client       |[6] -> Insert new product       |[11] -> Insert new Item          |[16] -> Make reservation               |");
		System.out.println("|[2] -> Modify existing client  |[7] -> Modify existing product  |[12] -> Modify existing item     |[17] -> Close reservation              |");
		System.out.println("|[3] -> Delete client           |[8] -> Delete product           |[13] -> Delete item              |[18] -> Delete reservation             |");
		System.out.println("|[4] -> List clients            |[9] -> List product             |[14] -> List items               |[19] -> List reservations              |");
		System.out.println("|[5] -> Show client info        |[10] -> Show product info       |[15] -> Show item info           |[20] -> Show reservation info          |");
		System.out.println("|____________________________________________________________̣_______________̣____̣____̣____̣____̣____̣___________________________________________|\n");
	}

	@Override
	public void printExitProgram() {
		System.out.println("Program terminated successfully");
	}

	@Override
	public Integer readOption(Integer inf, Integer sup) {
		return sc.readIntBucle("Insert option: ",inf,sup);
	}

	@Override
	public void printReturnBack() {
		System.out.println("Returning back...");
	}

	@Override
	public void operationResult(Boolean res) {
		if(res){
			System.out.println("Operation successful");
		}else{
			System.out.println("Operation failed");
		}
	}

	@Override
	public Integer readID() {
		return sc.readIntBucle("\nInsert id: ",1,Integer.MAX_VALUE);
	}

	@Override
	public String readDNI() {
		return sc.readStringBucle("\nInsert DNI: ", "[0-9]{8}[A-Z]");
	}
}
