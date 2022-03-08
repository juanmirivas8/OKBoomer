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
}
