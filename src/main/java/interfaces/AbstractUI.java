package interfaces;

import view.Escaner;

public abstract class AbstractUI {

	protected Escaner sc;
	
	public AbstractUI() {
		sc = Escaner.newInstance();
	}
	
	public Integer readOption(Integer inf, Integer sup) {
		return sc.readIntBucle("Insert option: ", inf, sup);
	}
	
	public void printReturnBack() {
		System.out.println("");
		System.out.println("Returning back ...");
		System.out.println("");
		
	}
	
	public void operationResult(Boolean res) {
		if(res) {
			System.out.println("Successfull operation");
		} else {
			System.out.println("Failed operation");
		}
	}
	
	public String readDNI() {
		return sc.readStringBucle("Insert DNI: ", "[0-9]{8}[A-Z]");
	}
	
	public Integer readID() {
		return sc.readIntBucle("Insert ID : ", 0, Integer.MAX_VALUE);
	}
}
