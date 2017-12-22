import controllerPackage.StartController;
import modelPackage.Model;
import other.Core;

public class Main {

	public static void main(String[] args) {

		Core.getInstance().setModel(new Model());
		Core.getInstance().setStartController(new StartController());
		Core.getInstance().getStartController().createStarPanel();
		System.out.println("1) w Main. print Core.getInstance().getController()): " + Core.getInstance().getMainController());

	}

}

// dodatkowo o sql relacyjne bazy danych - nie szukaj sql java!!! moze mysql?
// xampp -> stworz sobie baze