package interfaces.products;

import java.util.Collection;

import model.Item;

public interface IItemDAO {

	Collection<Item> listOfItemsByKey();
	Collection<Item> listOfItemsByProductKey();
	Collection<Item> listOfItemsByCondition();
}
