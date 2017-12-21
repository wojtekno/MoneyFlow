package controllerPackage;

import java.util.Date;

import javax.swing.JFrame;

public interface MianControllerInterface {

	public void saveItem(String selectedCategory, float cost, Date date);
	public JFrame getWindow();
	
}