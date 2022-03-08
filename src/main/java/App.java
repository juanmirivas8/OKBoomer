import controller.AppController;

public class App {

	public static void main(String[] args) {
		AppController app = AppController.newInstance();
		app.run();
	}
}
