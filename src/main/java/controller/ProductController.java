package controller;

import interfaces.API;
import interfaces.products.IItem;
import interfaces.products.IProduct;
import model.PreservationCondition;
import model.Product;
import model.Reservation;

import java.util.ArrayList;
import java.util.Collection;

public class ProductController extends API implements interfaces.products.IProductsController{

	private ProductController() {
		super();
	}
	
	private static ProductController instance = null;
	public static ProductController newInstance() {
		if(instance == null) {
			instance = new ProductController();
		}
		return instance;
	}
	@Override
	public void productsMenu(Integer opcion) {	
			switch (opcion) {		
				case 6 -> this.registerProduct();
				
				case 7 -> this.modifyProduct();
				
				case 8 -> this.deleteProduct();
				
				case 9 -> this.listProducts();
				
				case 10 -> this.searchProduct();
				
				case 11 -> this.registerItem();
				
				case 12 -> this.modifyItem();
				
				case 13 -> this.deleteItem();
				
				case 14 -> this.listItems();
				
				case 15->this.searchItem();	
			}
	}
	@Override
	public void registerProduct() {
		IProduct p = productView.readProduct();
		Boolean res = products.add(p);

		if(res){
			Integer nItems=0;
			nItems = sc.readIntBucle("Insert number of copies: ",0,Integer.MAX_VALUE);

			for (int i = 0; i < nItems;i++){
				IItem copy = new model.Item(p.getID(), PreservationCondition.EXCELLENT);
				items.add(copy);
			}
		}
		view.operationResult(res);
		
	}
	@Override
	public void registerItem() {
		productView.printProductList(products.listOfItemsByKey());
		IItem i = productView.readItem();
		if(products.search(i.getProductID())!=null) {
			Boolean res = items.add(i);
			
			view.operationResult(res);
		}else {
			view.operationResult(false);
		}
	}
	@Override
	public void modifyProduct() {
		productView.printProductList(products.listOfItemsByKey());
		Integer id = view.readID();
		IProduct p = products.search(id);
		if( p != null) {
			productView.modifyProduct(p);
			view.operationResult(true);
		}else {
			view.operationResult(false);
		}
	}
	@Override
	public void modifyItem() {
		productView.printItemList(items.listOfItemsByKey());
		Integer id = view.readID();
		IItem i = items.search(id);
		
		if( i != null ) {
			productView.modifyItem(i);
			view.operationResult(true);
		}else {
			view.operationResult(false);
		}
	}
	@Override
	public void deleteProduct() {
		productView.printProductList(products.listOfItemsByKey());
		Integer id = view.readID();
		Boolean finded = items.findProduct(id);
		
		IProduct p = null;
		if(!finded) {
			p = products.delete(id);
		}
		
		if( p != null ) {
			view.operationResult(true);
			productView.printProduct(p);
		}else {
			view.operationResult(false);
		}
		
	}
	@Override
	public void deleteItem() {
		productView.listItemsAvailable();
		Integer id = view.readID();
		IItem i = items.search(id);
		
		if( i != null && reservations.getReservations(i.getID()).size()==0) {
			i = items.delete(id);
			view.operationResult(true);
			productView.printItem(i);
		}else {
			view.operationResult(false);
		}
	}
	@Override
	public void searchProduct() {
		productView.printProductList(products.listOfItemsByKey());
		Integer id = view.readID();
		IProduct p = products.search(id);
		
		if(p != null) {
			productView.printProduct(p);
		}else {
			view.operationResult(false);
		}
		
	}
	@Override
	public void searchItem() {
		productView.printItemList(items.listOfItemsByKey());
		Integer id = view.readID();
		IItem i = items.search(id);
		
		if(i != null) {
			productView.printItem(i);
		}else {
			view.operationResult(false);
		}
	}
	@Override
	public void listProducts() {
		Integer opcion = 0;
		do {
			productView.printProductsListMenu();
			
			opcion = view.readOption(0, 6);
			
			switch (opcion) {
				case 0 -> view.printReturnBack();
				
				case 1 -> productView.printProductList(products.listOfItemsByTitle());
				
				case 2 -> productView.printProductList(products.listOfItemsByKey());
				
				case 3 -> productView.printProductList(products.listOfItemsByLength());
				
				case 4 -> productView.printProductList(products.listOfItemsByPrice());
				
				case 5 -> productView.printProductList(products.listOfItemsByRating());

				case 6 -> productView.printProductList(listOfProductsWithActiveItems());

			}
		}while(opcion != 0);
	}
	@Override
	public void listItems() {
		Integer opcion = 0;
		do {
			productView.printItemsListMenu();
			
			opcion = view.readOption(0, 5);
			
			switch (opcion) {
				case 0 -> view.printReturnBack();
				
				case 1 -> productView.printItemList(items.listOfItemsByKey());
				
				case 2 -> productView.printItemList(items.listOfItemsByProductKey());
				
				case 3 -> productView.printItemList(items.listOfItemsByCondition());

				case 4 -> productView.listItemsReserved();

				case 5 -> productView.listItemsAvailable();
			}
		}while(opcion != 0);
	}

	public Collection<Product> listOfProductsWithActiveItems(){
		Collection<Product> ret = new ArrayList<>();
		Product p;

			for(Reservation r:reservations.listOfReservationActive()){
				p = products.search(items.search(r.getItemID()).getProductID());
				if(!ret.contains(p)){
					ret.add(p);
				}
			}

		return ret;
	}

}
