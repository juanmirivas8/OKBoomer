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
		System.out.println("");
		System.out.println("_________WELCOME TO SOGEVIC__________");
		System.out.println("[0] -> Exit program");
		System.out.println("[1] -> Client menu");
		System.out.println("[2] -> Products menu");
		System.out.println("[3] -> Reservations menu");
		System.out.println("");
	}

	@Override
	public void printExitProgram() {
		System.out.println("Program terminated successfully");
	}
	

}
