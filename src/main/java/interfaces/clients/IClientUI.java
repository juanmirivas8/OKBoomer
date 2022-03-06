package interfaces.clients;

import java.util.Collection;

public interface IClientUI {

	IClient readClient();
	
	void modifyClient(IClient c);
	
	void printClient(IClient c);
	
	void printClientMenu();
	
	void printListMenu();
	
	void operationResult(Boolean res);

	void printList(Collection<?> c);

	void printReturnBack();
	
	String readDNI();
	
	Integer readOption(Integer inf, Integer sup);
}
