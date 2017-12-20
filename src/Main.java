import controllerPackage.StartPanelController;
import modelPackage.Model;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();
		StartPanelController startPanelController = new StartPanelController(model);

	}

}

// dodatkowo o sql relacyjne bazy danych - nie szukaj sql java!!! moze mysql?
// xampp -> stworz sobie baze