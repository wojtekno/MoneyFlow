package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JOptionPane;

import controllerPackage.MainController;
import controllerPackage.MainControllerInterface;
import modelPackage.Core;
import modelPackage.Model;
import viewPackage.MainPanelInterface;
import viewPackage.Window;

public class BuyProductListener implements ActionListener {

	MainPanelInterface mainPanel;
	MainControllerInterface controller;
	Window window = Core.getInstance().getWindow();

	public BuyProductListener(MainPanelInterface mainPanel) {
		this.mainPanel = mainPanel;
		// System.out.println("4) przed konstruktorem - hereController: " + controller);
		this.controller = Core.getInstance().getMainController();
		// System.out.println("5) po konstruktorze - hereController: " + controller);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// this.hereController = Core.getInstance().mainController;
		// checkObjects();
		if (costOK()) {
			controller.saveItem(getSelectedCategory(), getCost(), getDate());
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
			JOptionPane.showMessageDialog(window, "Wrog price format, put decimal, different than 0");
			mainPanel.setLabel("Enter a price, no letters or zero");
			mainPanel.setCostTextField("");
			return false;
		}
		if (cost == 0) {
			JOptionPane.showMessageDialog(window, "Wrog price format, put decimal, different than 0");
			mainPanel.setLabel("Enter a price different than 0");
			mainPanel.setCostTextField("");
			return false;
		} else if (cost < 0) {
			JOptionPane.showMessageDialog(window, "Wrong price format: can't be negative");
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
	private LocalDate getDate() {
		if (Core.getInstance().getDatePickerPanel() != null) {
			Date input = (Date) Core.getInstance().getDatePickerPanel().datePicker.getModel().getValue();
			if(input != null) {
				return input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
		}
		return LocalDate.now();
	}

	/*
	 * set date in DatePickerPanel to null
	 */
	private void resetDate() {
		if (Core.getInstance().getDatePickerPanel() != null) {
			Core.getInstance().getDatePickerPanel().refreshDatePickerPanel();
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
		// System.out.println("Core.getInstance().mainController.getModel(): " +
		// Core.getInstance().getMainController().getModel());
		System.out.println("hereController: " + controller);

		System.out.println("Core.getInstance().mainController): " + Core.getInstance().getMainController());
		System.out.println("hereController.getDatePickerPanel(): " + controller.getDatePickerPanel());

	}
}
