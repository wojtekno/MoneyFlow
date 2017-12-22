package controllerPackage;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import products.Product;
import viewPackage.DatePickerPanel;

public interface MainControllerInterface {

	public void createStartPanel();
	public void createMainPanel();
	
	/*
	 * save item to the list(model)
	 */
	public void saveItem(String selectedCategory, float cost, Date date);
	public List<Product> getAllItems();
	public List<Product> getCategoryItems(String selectedCategory);
	public String getSumOfExpenses(List<Product> list);
	public String printAllItems();
	
	
	public JFrame getWindow();

	public DatePickerPanel getDatePickerPanel();
	
}