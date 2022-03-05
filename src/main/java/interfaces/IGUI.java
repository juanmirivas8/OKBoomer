package interfaces;

import java.util.Collection;

import model.Client;

public interface IGUI {

	IClient readClient();
	
	void modifyClient(IClient c);
	
	void printClient(IClient c);
	
	void printMainMenu();
	
	void printClientMenu();
	
	void printListMenu();
	
	void printExitProgram();
	
	void operationResult(Boolean res);
	
	int leeOpcion(int inf, int sup);

	void printList(Collection<?> c);

	void printReturnBack();
	
	String readDNI();
}
