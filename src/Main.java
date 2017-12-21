import controllerPackage.StartPanelController;
import modelPackage.Model;
import other.Core;

public class Main {

	public static void main(String[] args) {

		Core.getInstance().model = new Model();
		new StartPanelController(Core.getInstance().model);
		System.out.println("w Main. print Core.getInstance().getController()): " + Core.getInstance().getController());

	}

}

// dodatkowo o sql relacyjne bazy danych - nie szukaj sql java!!! moze mysql?
// xampp -> stworz sobie baze