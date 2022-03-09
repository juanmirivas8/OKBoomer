package interfaces.products;

import java.util.Collection;

import model.Product;

public interface IProductDAO {
	Collection<Product> listOfItemsByTitle();
	Collection<Product> listOfItemsByKey();
	Collection<Product> listOfItemsByLength();
	Collection<Product> listOfItemsByPrice();
	Collection<Product> listOfItemsByRating();
	
}
