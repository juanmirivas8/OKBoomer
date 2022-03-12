package controller;

import interfaces.AbstractController;
import interfaces.products.IItem;
import interfaces.products.IProduct;

public class ProductController extends AbstractController implements interfaces.products.IProductsController{

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
	public void productsMenu() {
		Integer opcion = 0;
		do {
			productView.printProductsMenu();
			
			opcion = productView.readOption(0, 10);
			
			switch (opcion) {
				case 0 -> productView.printReturnBack();
				
				case 1 -> this.registerProduct();
				
				case 2 -> this.modifyProduct();
				
				case 3 -> this.deleteProduct();
				
				case 4 -> this.listProducts();
				
				case 5 -> this.searchProduct();
				
				case 6 -> this.registerItem();
				
				case 7 -> this.modifyItem();
				
				case 8 -> this.deleteItem();
				
				case 9 -> this.listItems();
				
				case 10->this.searchItem();
			
			}
		}while(opcion != 0);

	}
	@Override
	public void registerProduct() {
		IProduct p = productView.readProduct();
		Boolean res = products.add(p);
		
		productView.operationResult(res);
		
	}
	@Override
	public void registerItem() {
		IItem i = productView.readItem();
		if(products.search(i.getProductID())!=null) {
			Boolean res = items.add(i);
			
			productView.operationResult(res);
		}else {
			productView.operationResult(false);
		}
	}
	@Override
	public void modifyProduct() {
		Integer id = productView.readID();
		IProduct p = products.search(id);
		if( p != null) {
			productView.modifyProduct(p);
			productView.operationResult(true);
		}else {
			productView.operationResult(false);
		}
	}
	@Override
	public void modifyItem() {
		Integer id = productView.readID();
		IItem i = items.search(id);
		
		if( i != null ) {
			productView.modifyItem(i);
			productView.operationResult(true);
		}else {
			productView.operationResult(false);
		}
	}
	@Override
	public void deleteProduct() {
		Integer id = productView.readID();
		IProduct p = products.delete(id);
		
		if( p != null ) {
			productView.operationResult(true);
		}else {
			productView.operationResult(false);
		}
		
	}
	@Override
	public void deleteItem() {
		Integer id = productView.readID();
		IItem i = items.delete(id);
		
		if( i != null ) {
			products.delete(id);
			productView.operationResult(true);
		}else {
			productView.operationResult(false);
		}
	}
	@Override
	public void searchProduct() {
		Integer id = productView.readID();
		IProduct p = products.search(id);
		
		if(p != null) {
			productView.printProduct(p);
		}else {
			productView.operationResult(false);
		}
		
	}
	@Override
	public void searchItem() {
		Integer id = productView.readID();
		IItem i = items.search(id);
		
		if(i != null) {
			productView.printItem(i);
		}else {
			productView.operationResult(false);
		}
	}
	@Override
	public void listProducts() {
		Integer opcion = 0;
		do {
			productView.printProductsListMenu();
			
			opcion = productView.readOption(0, 5);
			
			switch (opcion) {
				case 0 -> productView.printReturnBack();
				
				case 1 -> productView.printProductList(products.listOfItemsByTitle());
				
				case 2 -> productView.printProductList(products.listOfItemsByKey());
				
				case 3 -> productView.printProductList(products.listOfItemsByLength());
				
				case 4 -> productView.printProductList(products.listOfItemsByPrice());
				
				case 5 -> productView.printProductList(products.listOfItemsByPrice());
			}
		}while(opcion != 0);
	}
	@Override
	public void listItems() {
		Integer opcion = 0;
		do {
			productView.printItemsListMenu();
			
			opcion = productView.readOption(0, 3);
			
			switch (opcion) {
				case 0 -> productView.printReturnBack();
				
				case 1 -> productView.printItemList(items.listOfItemsByKey());
				
				case 2 -> productView.printItemList(items.listOfItemsByProductKey());
				
				case 3 -> productView.printItemList(items.listOfItemsByCondition());
			}
		}while(opcion != 0);
	}
	
}
