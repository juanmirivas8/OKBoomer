package interfaces;

public interface IUI {
	void printMainMenu();
	
	void printExitProgram();
	
	Integer readOption(Integer inf, Integer sup);

	void printReturnBack();

	void operationResult(Boolean res);

	Integer readID();

	String readDNI();
}
