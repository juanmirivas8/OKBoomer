package interfaces;

import java.util.Collection;

public interface IGUI {

	IClient readClient();
	
	void modifyClient(IClient c);
	
	void printClient(IClient c);
	
	void printList();
	
	void printMainMenu();
	
	void printListMenu();
	
	void printExitProgram();
	
	void operationResult(Boolean res);
	
	void printClientList(Collection<IClient> l);
}
