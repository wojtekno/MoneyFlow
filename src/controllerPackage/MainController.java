/*
 * TODO do wee need MainPanel or MainPanelInterface here?
 */

package controllerPackage;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

import modelPackage.Category;
import modelPackage.Core;
import modelPackage.Model;
import modelPackage.Product;
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
	public void createStartPanel() {
		startPanel = new StartPanel();
		window.changePanel(startPanel);
	}

	@Override
	public DatePickerPanel getDatePickerPanel() {
		return datePickerPanel;
	}

	public void changePanel(JPanel panel) {
		window.changePanel(panel);
	}

	@Override
	/*
	 * Get all the needed values (selectedCategory, cost, date) create the product
	 * and store it in Model
	 */
	public void saveItem(String selectedCategory, float cost, LocalDate date) {
		model.saveItem(selectedCategory, cost, date);
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
		String print = "";
		List<Product> list = model.getListOfAllItems();
		float[] sumOfCategories = new float[Category.values().length];
		for (Product item : list) {
			int i = 0;
			for (Category cat : Category.values()) {
				if (item.getLabel().equals(cat.getLabel())) {
					sumOfCategories[i] += item.getCost();
				}
				i++;
			}
		}
		int j = 0;
		for (Category cat : Category.values()) {
			print += String.format("%s\t%.2f\n", cat.getLabel(), sumOfCategories[j]);
			j++;
		}
		print += printSumOfAll();
		return print;
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
