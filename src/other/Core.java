package other;
/*
 * I used to hold here references to the all panels
 * before I implemented MVC pattern
 */

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllerPackage.MainController;
import modelPackage.Model;
import viewPackage.CategoriesPanel;
import viewPackage.HistoryPanel;
import viewPackage.MainPanel;
import viewPackage.StartPanel;
import viewPackage.Window;

public class Core {
	
	public Model model;
	public JFrame window;
	public MainPanel mainPanel;
	public JPanel panel;
	public StartPanel startPanel;
	public HistoryPanel historyPanel;
	public CategoriesPanel categoriesPanel;
	public JPanel datePickerPanel;
//	public MainControllerInterface mainControllerInterface;
	public MainController mainController;
	private Core() {
		
	}
	
	private static class CoreHandler {
		private final static  Core instance = new Core();
	}
	
	public static Core getInstance() {
		return CoreHandler.instance;
	}
	public MainController getController() {
		return mainController;
	}
}
