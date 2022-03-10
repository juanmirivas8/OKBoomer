package interfaces.products;

import java.util.Collection;

import model.Item;
import model.Product;

public interface IItemDAO {

	Collection<Item> listOfItemsByKey();
	Collection<Item> listOfItemsByProductKey();
	Collection<Item> listOfItemsByCondition();
	
	public Boolean add(IItem i);
	
	public IItem delete(Integer key);
}
