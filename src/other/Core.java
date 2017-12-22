package other;
/*
 * I used to hold here references to the all panels
 * before I implemented MVC pattern
 */

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllerPackage.MainController;
import controllerPackage.MainControllerInterface;
import controllerPackage.StartControllerInterface;
import modelPackage.Model;
import viewPackage.CategoriesPanel;
import viewPackage.HistoryPanel;
import viewPackage.MainPanel;
import viewPackage.MainPanelInterface;
import viewPackage.StartPanel;

public class Core {
	
	private Model model;
	private StartControllerInterface startController;
	private JFrame window;
	private MainControllerInterface mainController;
	private MainPanelInterface mainPanel;
	
	public JPanel panel;
	public StartPanel startPanel;
	public HistoryPanel historyPanel;
	public CategoriesPanel categoriesPanel;
	public JPanel datePickerPanel;
//	
	
	
	private Core() {
		
	}
	
	private static class CoreHandler {
		private final static  Core instance = new Core();
	}
	
	public static Core getInstance() {
		return CoreHandler.instance;
	}
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public StartControllerInterface getStartController() {
		return startController;
	}
	
	public void setStartController (StartControllerInterface startController) {
		this.startController = startController;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}

	public MainControllerInterface getMainController() {
		return mainController;
	}

	public void setMainController(MainControllerInterface mainControllerInterface) {
		this.mainController = mainControllerInterface;
	}

	public MainPanelInterface getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanelInterface mainPanel) {
		this.mainPanel = mainPanel;
	}

		
	
}
