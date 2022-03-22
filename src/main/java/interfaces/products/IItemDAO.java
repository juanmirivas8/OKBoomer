package interfaces.products;

import java.util.Collection;

import model.Item;

public interface IItemDAO {

	Collection<Item> listOfItemsByKey();
	Collection<Item> listOfItemsByProductKey();
	Collection<Item> listOfItemsByCondition();
	Boolean add(IItem i);
	
	IItem delete(Integer key);
	
	void save();
	
	Item search(Integer id);
	
	Boolean findProduct(Integer id);
	
}
