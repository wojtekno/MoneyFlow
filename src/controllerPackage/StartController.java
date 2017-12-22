package controllerPackage;


import modelPackage.Model;
import other.Core;
import viewPackage.StartPanel;
import viewPackage.Window;

public class StartController implements StartControllerInterface {
	Window window;
	StartPanel startPanel;
	
	
	public StartController () {
		Core.getInstance().setWindow(new Window());
		window = (Window) Core.getInstance().getWindow();	
	}
	
	
	@Override
	public void didClickStart() {
		System.out.println("2) Przed stworzeniem\nw StartPanelController. Core.getInstance().mainController : " + Core.getInstance().getMainController());
		Core.getInstance().setMainController(new MainController());
		Core.getInstance().getMainController().createMainPanel();
		System.out.println("3) w StartPanelController. Core.getInstance().mainController : " + Core.getInstance().getMainController());
	}


	@Override
	public void createStarPanel() {
		startPanel = new StartPanel();
		window.changePanel(startPanel);
		
	}
	
	
	
}


