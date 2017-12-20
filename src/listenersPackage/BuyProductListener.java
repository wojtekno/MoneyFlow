package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import controllerPackage.MainController;
import other.Core;
import viewPackage.MainPanel;
import viewPackage.MainPanelInterface;

public class BuyProductListener implements ActionListener {

	MainPanelInterface mainPanel;
	MainController controller;

	public BuyProductListener(MainPanelInterface mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
			JOptionPane.showMessageDialog(controller.getWindow(), "Wrog price format, put decimal, different than 0");
			mainPanel.setLabel("Enter a price, no letters or zero");
			mainPanel.setCostTextField("");
			return false;
		}
		if (cost == 0) {
			JOptionPane.showMessageDialog(controller.getWindow(), "Wrog price format, put decimal, different than 0");
			mainPanel.setLabel("Enter a price different than 0");
			mainPanel.setCostTextField("");
			return false;
		} else if (cost < 0) {
			JOptionPane.showMessageDialog(controller.getWindow(), "Wrong price format: can't be negative");
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
		System.out.println("core.maincontrol" + Core.getInstance().mainController);
//		System.out.println("buyProd:" + controller);
//		System.out.println(controller.getDatePickerPanel());
		if (Core.getInstance().mainController.getDatePickerPanel() != null) {
			return (Date) controller.getDatePickerPanel().datePicker.getModel().getValue();
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
}
