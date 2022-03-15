package interfaces;

import interfaces.clients.IClientController;
import interfaces.clients.IClientDAO;
import interfaces.clients.IClientUI;
import interfaces.products.IItemDAO;
import interfaces.products.IProductDAO;
import interfaces.products.IProductsController;
import interfaces.products.IProductsUI;
import interfaces.reservations.IReservationController;
import interfaces.reservations.IReservationDAO;
import interfaces.reservations.IReservationUI;
import model.ClientDAO;
import model.ItemDAO;
import model.ProductDAO;
import controller.ClientController;
import view.ClientsUI;
import view.ProductsUI;
import view.UI;
import controller.AppController;
import controller.ProductController;

public abstract class AbstractController {
	protected static IClientDAO clients;
	protected static IProductDAO products;
	protected static IItemDAO items;
	protected static IReservationDAO reservations;
	
	protected static IClientUI clientView;
	protected static IProductsUI productView;
	protected static IReservationUI reservationView;
	protected static IUI view;
	
	protected static IClientController clientController;
	protected static IProductsController productController;
	protected static IReservationController reservationController;
	protected static IAppController appController;
	
	protected AbstractController() {
		if(!instanciated) {
			instanciated = true;
			view = UI.newInstance();
			appController = AppController.newInstance();
			
			clients = ClientDAO.newInstance();
			clientController = ClientController.newInstance();
			clientView = ClientsUI.newInstance();	
			
			products = ProductDAO.newInstance();
			items = ItemDAO.newInstance();
			productController = ProductController.newInstance();
			productView = ProductsUI.newInstance();
			
		}	
	}
	
	private static Boolean instanciated = false;
	
	public void save() {
		clients.save();
		products.save();
		items.save();
	}
	
}
