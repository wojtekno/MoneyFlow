package controllerPackage;

import java.util.Date;
import javax.swing.JFrame;
import viewPackage.DatePickerPanel;

public interface MainControllerInterface {

	public void createMainPanel();
	
	/*
	 * save item to the list(model)
	 */
	public void saveItem(String selectedCategory, float cost, Date date);
	
	public JFrame getWindow();

	public DatePickerPanel getDatePickerPanel();
	
}