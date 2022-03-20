package view;

import java.util.Collection;

import interfaces.products.IItem;
import interfaces.products.IProduct;
import model.Item;
import model.MCRS;
import model.PreservationCondition;
import model.Product;

public class ProductsUI extends interfaces.API implements interfaces.products.IProductsUI {
	
	private ProductsUI(){
		super();
	}
	
	private static ProductsUI instance= null;
	
	public static ProductsUI newInstance(){
		if(instance == null) {
			instance = new ProductsUI();
		}
			return instance;
	}

	@Override
	public IProduct readProduct() {
		String Title = sc.readString("Insert Title: ");
		Integer length = sc.readIntBucle("Insert length: ", 0, Integer.MAX_VALUE);
		Double price = sc.readDoubleBucle("Insert price: ", 0.0, Double.MAX_VALUE );
		MCRS rating = (MCRS)sc.readEnumBucle("Insert rating: ", MCRS.class);
		
		return new Product(Title, length, price, rating);
	}

	@Override
	public IItem readItem() {
		Integer ProductID = sc.readIntBucle("Insert ProductID");
		PreservationCondition condition = (PreservationCondition)sc.readEnumBucle("Enter a PreservationCondition", PreservationCondition.class);
		return new Item(ProductID, condition);
	}

	@Override
	public void modifyProduct(IProduct p) {
		String Title = sc.readString("Insert Title: ");
		Integer length = sc.readIntBucle("Insert length: ", 0, Integer.MAX_VALUE);
		Double  price = sc.readDoubleBucle("Insert price: ", 0.0, Double.MAX_VALUE );
		MCRS rating = (MCRS)sc.readEnumBucle("Insert rating: ",  MCRS.class);
		p.setTitle(Title);
		p.setLength(length);
		p.setPrice(price);
		p.setRating(rating);
	}

	@Override
	public void modifyItem(IItem i) {
		Integer ProductID = sc.readIntBucle("Insert Product ID: ");
		PreservationCondition condition = (PreservationCondition)sc.readEnumBucle("Enter the preservation condition: ", PreservationCondition.class);
		i.setID(ProductID);
		i.setPreservationCondition(condition);
	}

	@Override
	public void printProduct(IProduct p) {
		System.out.println("");
		System.out.println(p);
		System.out.println("");
		
	}

	@Override
	public void printItem(IItem i) {
		System.out.println("");
		System.out.println("Title: "+products.search(i.getProductID()).getTitle() +" - "+ i);
		System.out.println("");
		
	}

	@Override
	public void printProductsMenu() {
		System.out.println("|____________________________________________________________̣______________|");
		System.out.println("|-------------PRODUCT MENU-------------|------------ITEMS MENU-------------|");
		System.out.println("|[0] -> Return back                    |[6] -> Insert new Item             |");
		System.out.println("|[1] -> Insert new product             |[7] -> Modify existing item        |");
		System.out.println("|[2] -> Modify existing product        |[8] -> Delete item                 |");
		System.out.println("|[3] -> Delete product                 |[9] -> List items                  |");
		System.out.println("|[4] -> List product                   |[10] -> Find item                  |");
		System.out.println("|[5] -> Find product                   |                                   |");
		System.out.println("|____________________________________________________________̣______________|");
		
	}

	@Override
	public void printProductsListMenu() {
		System.out.println("[0] -> Go back");
		System.out.println("[1] -> Show products by title");
		System.out.println("[2] -> Show products by id");
		System.out.println("[3] -> Show products by length");
		System.out.println("[4] -> Show products by price");
		System.out.println("[5] -> Show products by rating");
		
	}

	@Override
	public void printItemsListMenu() {
		System.out.println("[0] -> Go back");
		System.out.println("[1] -> Show items by id");
		System.out.println("[2] -> Show items by ProductID");
		System.out.println("[3] -> Show items by condition");
		
	}

	@Override
	public void printProductList(Collection<Product> p) {
		p.forEach(x->printProduct(x));
		
	}

	@Override
	public void printItemList(Collection<Item> i) {
		i.forEach(x->printItem(x));
		
	}

}
