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
import viewPackage.DatePickerPanel;
import viewPackage.HistoryPanel;
import viewPackage.MainPanel;
import viewPackage.MainPanelInterface;
import viewPackage.StartPanel;
import viewPackage.Window;

public class Core {
	
	private Model model;
	private StartControllerInterface startController;
	private Window window;
	private MainControllerInterface mainController;
	private MainPanelInterface mainPanel;
	private DatePickerPanel datePickerPanel;
	private HistoryPanel historyPanel;
	private CategoriesPanel categoriesPanel;
	
	public JPanel panel;
	public StartPanel startPanel;
	
	
//	public JPanel datePickerPanel;
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

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
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

	public DatePickerPanel getDatePickerPanel() {
		return datePickerPanel;
	}

	public void setDatePickerPanel(DatePickerPanel datePickerPanel) {
		this.datePickerPanel = datePickerPanel;
	}

	public HistoryPanel getHistoryPanel() {
		return historyPanel;
	}

	public void setHistoryPanel(HistoryPanel historyPanel) {
		this.historyPanel = historyPanel;
	}

	public CategoriesPanel getCategoriesPanel() {
		return categoriesPanel;
	}

	public void setCategoriesPanel(CategoriesPanel categoriesPanel) {
		this.categoriesPanel = categoriesPanel;
	}

		
	
}
