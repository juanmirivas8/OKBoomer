package interfaces.products;

import java.util.Collection;
import model.Product;
import model.Item;

public interface IProductsUI {

	
	IProduct readProduct();
	IItem readItem();
	
	void modifyProduct(IProduct p);
	void modifyItem(IItem i);
	
	void printProduct(IProduct p);
	void printItem(IItem i);
		
	void printProductsMenu();
	
	void printProductsListMenu();
	void printItemsListMenu();
	
	void printProductList(Collection<Product> p);
	
	void printItemList(Collection<Item> p);

	void listItemsReserved();

	void listItemsAvailable();

}
