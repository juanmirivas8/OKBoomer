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
import controller.ClientController;

public class AbstractController {
	protected IClientDAO clients;
	protected IProductDAO products;
	protected IItemDAO items;
	protected IReservationDAO reservations;
	
	protected IClientUI clientView;
	protected IProductsUI productView;
	protected IReservationUI reservationView;
	
	protected IClientController clientController;
	protected IProductsController productController;
	protected IReservationController reservationController;
	
	public AbstractController() {
		clients = ClientDAO.newInstance();
		clientController = ClientController.newInstance();
	}
	
}
