import javax.swing.JPanel;

public class Core {
	
	public WindowTryError window;
	public MainPanel mainPanel;
	public JPanel panel;
	public JPanel startPanel;
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
