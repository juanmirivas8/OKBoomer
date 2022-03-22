package interfaces.products;

import model.Product;

import java.util.Collection;

public interface IProductsController {

	void productsMenu(Integer opcion);
	
	void registerProduct();
	
	void registerItem();
	
	void modifyProduct();
	
	void modifyItem();
	 
	void deleteProduct();
	
	void deleteItem();
	
	void searchProduct();
	
	void searchItem();
	
	void listProducts();
	
	void listItems();

	Collection<Product> listOfProductsWithActiveItems();
}
