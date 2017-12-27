package controllerPackage;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import modelPackage.Product;
import viewPackage.DatePickerPanel;

public interface MainControllerInterface {

	public void createStartPanel();
	public void createMainPanel();
	
	/*
	 * save item to the list(model)
	 */
	public void saveItem(String selectedCategory, float cost, LocalDate date);
	
	/*
	 * print list of all items
	 */
	public String printAllItems();
	
	/*
	 * print list of items from chosen category
	 * @param selectedCategory
	 */
	public String printCategoryItems(String selectedCategory);
	
	/*
	 * print general view of all categories
	 */
	public String printGeneralOverwiev();
	
	/*
	 * print sum of all items
	 */
	public String printSumOfAll();
	
	/*
	 * print sum of items from chosen category
	 * 
	 *  @param chosenCategory
	 */
	public String printCategorySum(String selectedCategory);
	
	
	
	public List<Product> getAllItems();
	public List<Product> getCategoryItems(String selectedCategory);
		
	public JFrame getWindow();

	public DatePickerPanel getDatePickerPanel();
	
}