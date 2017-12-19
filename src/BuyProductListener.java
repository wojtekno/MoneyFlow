import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class BuyProductListener implements ActionListener {

	MainPanel mainPanel;
	MainController controller;

	public BuyProductListener(MainPanel mainPanel, MainController controller) {
		this.mainPanel = mainPanel;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
			cost = Float.parseFloat(mainPanel.costTF.getText());

		} catch (java.lang.NumberFormatException a) {
			JOptionPane.showMessageDialog(controller.getWindow(), "Wrog price format, put decimal, different than 0");
			mainPanel.label.setText("Enter a price, no letters or zero");
			mainPanel.costTF.setText("");
			return false;
		}
		if (cost == 0) {
			JOptionPane.showMessageDialog(controller.getWindow(), "Wrog price format, put decimal, different than 0");
			mainPanel.label.setText("Enter a price different than 0");
			mainPanel.costTF.setText("");
			return false;
		} else if (cost < 0) {
			JOptionPane.showMessageDialog(controller.getWindow(), "Wrong price format: can't be negative");
			mainPanel.label.setText("Enter a non-negative price");
			mainPanel.costTF.setText("");
			return false;
		}
		return true;
	}

	/*
	 * get cost from mainPanel.cost
	 */
	public float getCost() {
		return Float.parseFloat(mainPanel.costTF.getText());
	}

	/*
	 * get selectedCategory from chooseCategoryCB
	 */
	public String getSelectedCategory() {
		return mainPanel.chooseCategoryCB.getSelectedItem().toString();
	}

	/*
	 * get date from DatePickerPanel
	 */
	private Date getDate() {
		if (controller.getDatePickerPanel() != null) {
			return (Date) controller.getDatePickerPanel().datePicker.getModel().getValue();
		}
		return null;
	}

	/*
	 * set date in DatePickerPanel to null
	 */
	private void resetDate() {
		if (controller.getDatePickerPanel() != null) {
			controller.getDatePickerPanel().refreshDatePickerPanel();
		}
	}

	/*
	 * set mainPanel's labels and textFields to ""
	 */
	private void resetMainPanel() {
		mainPanel.label.setText("");
		mainPanel.costTF.setText("");

	}
}
