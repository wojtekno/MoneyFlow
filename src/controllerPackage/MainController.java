/*
 * TODO do wee need MainPanel or MainPanelInterface here?
 */

package controllerPackage;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

import modelPackage.Category;
import modelPackage.Model;
import modelPackage.Product;
import other.Core;
import viewPackage.CategoriesPanel;
import viewPackage.DatePickerPanel;
import viewPackage.HistoryPanel;
import viewPackage.MainPanel;
import viewPackage.StartPanel;
import viewPackage.Window;

public class MainController implements MainControllerInterface {

	// references to different panels
	private Window window;
	private StartPanel startPanel;
	private MainPanel mainPanel;
	private Model model = Core.getInstance().getModel();
	private DatePickerPanel datePickerPanel;
	private HistoryPanel historyPanel = null;
	private CategoriesPanel categoriesPanel;

	String selectedCategory;
	float cost;
	Date date1;

	public MainController() {
		Core.getInstance().setWindow(new Window());
		window = Core.getInstance().getWindow();
	}

	@Override
	public Window getWindow() {
		return window;
	}

	@Override
	public void createMainPanel() {
		Core.getInstance().setMainPanel(new MainPanel());
		this.mainPanel = (MainPanel) Core.getInstance().getMainPanel();
		window.changePanel(mainPanel);
	}

	@Override
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
	 * Gets all the needed values (selectedCategory, cost, date) and invokes method
	 * which creates the product and stores it on the listOfProducts
	 */
	public void saveItem(String selectedCategory, float cost, LocalDate date) {
		model.saveItem(selectedCategory, cost, date);
	}

	@Override
	public void createStartPanel() {
		startPanel = new StartPanel();
		window.changePanel(startPanel);

	}

	@Override
	public List<Product> getAllItems() {
		return model.getListOfAllItems();
	}

	@Override
	public List<Product> getCategoryItems(String selectedCategory) {
		return model.getListOfCategoryItems(selectedCategory);
	}

	@Override
	public String printAllItems() {
		String listOfAllProducts = "";
		List<Product> list = model.getListOfAllItems();
		for (Product item : list) {
			listOfAllProducts += String.format("%d) %s", list.indexOf(item) + 1, item.toString());
		}
		return listOfAllProducts;

	}

	@Override
	public String printCategoryItems(String selectedCategory) {
		String printList = "";
		List<Product> list = model.getListOfCategoryItems(selectedCategory);
		for (Product item : list) {
			printList += String.format("%d) %.2f\t%s\n", (list.indexOf(item) + 1), item.getCost(),
					item.printDate1(null));

		}
		return printList;
	}

	@Override
	public String printGeneralOverwiev() {
		String s = "";
		List<Product> list = model.getListOfAllItems();
		float[] totals = new float[Category.values().length];
		for (Product item : list) {
			int i = 0;
			for (Category cat : Category.values()) {
				if (item.getLabel().equals(cat.getLabel())) {
					totals[i] += item.getCost();
				}
				i++;
			}
		}

		int j = 0;
		for (Category cat : Category.values()) {

			s += String.format("%s\t%.2f\n", cat.getLabel(), totals[j]);
			j++;
		}
		s += printSumOfAll();
		return s;
	}

	@Override
	public String printSumOfAll() {
		float sum = 0;
		List<Product> list = getAllItems();
		for (Product item : list) {
			sum += item.getCost();
		}
		return String.format("\nTotal %.2f", sum);
	}

	@Override
	public String printCategorySum(String selectedCategory) {
		float sum = 0;
		List<Product> list = getCategoryItems(selectedCategory);
		for (Product item : list) {
			sum += item.getCost();
		}
		return String.format("\nTotal %.2f", sum);
	}
}
