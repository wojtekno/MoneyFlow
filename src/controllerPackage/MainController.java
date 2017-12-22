/*
 * TODO do wee need MainPanel or MainPanelInterface here?
 */

package controllerPackage;

import java.util.Date;

import javax.swing.JPanel;
import modelPackage.Model;
import other.Core;
import viewPackage.CategoriesPanel;
import viewPackage.DatePickerPanel;
import viewPackage.HistoryPanel;
import viewPackage.MainPanel;
import viewPackage.Window;

public class MainController implements MainControllerInterface {

	// references to different panels
	private Window window = (Window) Core.getInstance().getWindow();
	private MainPanel mainPanel;
	private Model model = Core.getInstance().getModel();
	private DatePickerPanel datePickerPanel;
	private HistoryPanel historyPanel = null;
	private CategoriesPanel categoriesPanel;
	
	String selectedCategory;
	float cost;
	Date date1;
	

	public MainController() {
		
		System.out.println("window i model w constructor MainController(): " + window + model);
//		window.changePanel(mainPanel);

	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	@Override
	public void createMainPanel() {
		Core.getInstance().setMainPanel(new MainPanel());
		this.mainPanel = (MainPanel) Core.getInstance().getMainPanel();
		((Window) window).changePanel(mainPanel);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public DatePickerPanel getDatePickerPanel() {
		return datePickerPanel;
	}

	public void setDatePickerPanel(DatePickerPanel panel) {
		this.datePickerPanel = panel;
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

	
	/*
	 * methods creating Panels
	 */
	public void createDatePicker() {
		this.datePickerPanel = new DatePickerPanel();
	}

	public void createHistoryPanel() {
		this.historyPanel = new HistoryPanel();
	}

	public void createCategoriesPanel() {
		this.categoriesPanel = new CategoriesPanel();
	}

	public void changePanel(JPanel panel) {
		window.changePanel(panel);
	}

	@Override
	/*
	 * Gets all the needed values (selectedCategory, cost, date) and invokes
	 * method which creates the product and stores it on the listOfProducts
	 */
	public void saveItem(String selectedCategory, float cost, Date date) {
		model.nextPurchase(selectedCategory, cost, date);
	}
}
