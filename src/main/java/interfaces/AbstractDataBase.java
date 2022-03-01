package interfaces;

import java.util.HashMap;

public abstract class AbstractDataBase implements IDDBB{

	protected HashMap<String,IClient> clients;
	protected HashMap<Integer,IProduct> products;
	protected HashMap<Integer,IItem> items;
	protected HashMap<Integer,IReservation> reservations;

}
