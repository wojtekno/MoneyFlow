import controllerPackage.MainController;
import controllerPackage.StartController;
import modelPackage.Core;
import modelPackage.Model;

public class Main {

	public static void main(String[] args) {

		Core.getInstance().setModel(new Model());
		Core.getInstance().setMainController(new MainController());
		Core.getInstance().getMainController().createStartPanel();
		
//		Core.getInstance().setStartController(new StartController());
//		Core.getInstance().getStartController().createStarPanel();
//		System.out.println("1) w Main. print Core.getInstance().getController()): " + Core.getInstance().getMainController());

	}

}

// dodatkowo o sql relacyjne bazy danych - nie szukaj sql java!!! moze mysql?
// xampp -> stworz sobie baze