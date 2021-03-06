/*
 * I used to hold here references to the all panels
 * before I implemented MVC pattern
 */

import javax.swing.JPanel;

public class Core {
	
	public Window window;
	public MainPanel mainPanel;
	public JPanel panel;
	public StartPanel startPanel;
	public HistoryPanel historyPanel;
	public CategoriesPanel categoriesPanel;
	public JPanel datePickerPanel;
	private Core() {
		
	}
	
	private static class CoreHandler {
		private final static  Core instance = new Core();
	}
	
	public static Core getInstance() {
		return CoreHandler.instance;
	}
}
