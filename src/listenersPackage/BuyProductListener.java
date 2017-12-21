package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import controllerPackage.MainController;
import modelPackage.Model;
import other.Core;
import viewPackage.MainPanelInterface;

public class BuyProductListener implements ActionListener {

	MainPanelInterface mainPanel;
	MainController hereController = Core.getInstance().mainController;
	Model hereModel = Core.getInstance().model;

	public BuyProductListener(MainPanelInterface mainPanel) {
		this.mainPanel = mainPanel;
//		this.hereController = Core.getInstance().getController();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		checkObjects();
		if (costOK()) {
			Core.getInstance().mainController.saveItem(getSelectedCategory(), getCost(), getDate());
			resetDate();
			resetMainPanel();
		}
	}

	/*
	 * check if the cost is a non zero positive float
	 */
	private boolean costOK() {
		float cost = 0;
		try {
			cost = Float.parseFloat(mainPanel.getCostTextField());

		} catch (java.lang.NumberFormatException a) {
			JOptionPane.showMessageDialog(hereController.getWindow(), "Wrog price format, put decimal, different than 0");
			mainPanel.setLabel("Enter a price, no letters or zero");
			mainPanel.setCostTextField("");
			return false;
		}
		if (cost == 0) {
			JOptionPane.showMessageDialog(hereController.getWindow(), "Wrog price format, put decimal, different than 0");
			mainPanel.setLabel("Enter a price different than 0");
			mainPanel.setCostTextField("");
			return false;
		} else if (cost < 0) {
			JOptionPane.showMessageDialog(hereController.getWindow(), "Wrong price format: can't be negative");
			mainPanel.setLabel("Enter a non-negative price");
			mainPanel.setCostTextField("");
			return false;
		}
		return true;
	}

	/*
	 * get cost from mainPanel.cost
	 */
	public float getCost() {
		return Float.parseFloat(mainPanel.getCostTextField());
	}

	/*
	 * get selectedCategory from chooseCategoryCB
	 */
	public String getSelectedCategory() {
		return mainPanel.getSelectedCategory();
	}

	/*
	 * get date from DatePickerPanel
	 */
	private Date getDate() {
		
		if (Core.getInstance().mainController.getDatePickerPanel() != null) {
			return (Date) hereController.getDatePickerPanel().datePicker.getModel().getValue();
		}
		return null;
	}

	/*
	 * set date in DatePickerPanel to null
	 */
	private void resetDate() {
		if (Core.getInstance().mainController.getDatePickerPanel() != null) {
			Core.getInstance().mainController.getDatePickerPanel().refreshDatePickerPanel();
		}
	}

	/*
	 * set mainPanel's labels and textFields to ""
	 */
	private void resetMainPanel() {
		mainPanel.setLabel("");
		mainPanel.setCostTextField("");

	}
	
	/*
	 * for sake of debbuging, prints some objects
	 */
	private void checkObjects() {
		System.out.println("Sprawdzam jak zachowuja sie poszczegolne obiekty/referencje:\nw BuyProductListener: ");
		System.out.println("Core.getInstance().mainController.getModel(): " + Core.getInstance().mainController.getModel());
		System.out.println("hereController: " + hereController);
		System.out.println("hereModel: " + hereModel);
		System.out.println("hereController.getModel(): " + hereController.getModel());
		System.out.println("Core.getInstance().mainController): " + Core.getInstance().mainController);
		System.out.println("hereController.getDatePickerPanel(): " + hereController.getDatePickerPanel());
		
	}
}
