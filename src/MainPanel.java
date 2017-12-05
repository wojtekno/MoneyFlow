
/* 
 * Main  Panel
 */
import static modelPackage.AutomaticMethod.createListOf24RandomProducts;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import products.Category;

public class MainPanel extends JPanel {

	MainController controller;

	// inform if Panels have been already created
	private boolean datePickerPanelFlag;
	private boolean historyPanelFlag;

	/* variables describing products */
	private float cost;
	private Date date1;
	private String selectedCategory;

	JButton okButton;
	JButton changeDateButton;
	JButton genRandomButton;
	JButton historyButton;
	JButton closeButton;
	JLabel label;
	JComboBox<String> chooseCategoryCB;
	JTextField costTF;

	public MainPanel(MainController controller) {

		this.controller = controller;

		historyButton = new JButton("History");
		closeButton = new JButton("Close");
		label = new JLabel();
		chooseCategoryCB = new JComboBox<>(setChooseCategoryCB());

		costTF = new JTextField();
		okButton = new JButton("OK");
		changeDateButton = new JButton("Not today?");
		genRandomButton = new JButton("Gen.Rand");

		// assigning variable to the first item from the list
		selectedCategory = chooseCategoryCB.getItemAt(0).toString();

		historyButton.setBounds(10, 300, 100, 40);
		closeButton.setBounds(150, 180, 100, 40);
		label.setBounds(150, 40, 300, 40);
		chooseCategoryCB.setBounds(150, 140, 100, 20);
		costTF.setBounds(150, 80, 100, 40);
		changeDateButton.setBounds(40, 80, 100, 40);
		okButton.setBounds(270, 80, 100, 40);
		genRandomButton.setBounds(300, 10, 100, 20);

		okButton.addActionListener(new OkButtonListener());
		chooseCategoryCB.addActionListener(new ChooseCategoryCBListener());
		closeButton.addActionListener(new CloseButtonListener());
		changeDateButton.addActionListener(new ChangeDateButtonListener());
		historyButton.addActionListener(new HistoryButtonListener());
		genRandomButton.addActionListener(new GenRandomButtonListener());

		//
		// ok.addActionListener(new ActionListener() {
		// // jak rozwiazac kiedy nic nie jest wpisane w givescost
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // do {
		// try {
		// cost = Float.parseFloat(givesCost.getText());
		// }
		//
		// catch (java.lang.NumberFormatException a) {
		// label.setText("You didn't give a price");
		// cost = 0;
		// }
		// // // } while (cost == 0);
		//
		// if (cost != 0) {
		//
		// if (!date1Flag) {
		// try {
		// categoryPurchuse(list, cost, selectedProduct);
		//
		// } catch (java.lang.NullPointerException e1) {
		// selectedProduct = "Food";
		// categoryPurchuse(list, cost, selectedProduct);
		// }
		// label.setText("you bought " + selectedProduct + " for " +
		// givesCost.getText());
		//
		// } else {
		// try {
		// nextPurchase(list, cost, selectedProduct, date1);
		// } catch (java.lang.NullPointerException e1) {
		// selectedProduct = "Food";
		// nextPurchase(list, cost, selectedProduct, date1);
		// // System.out.println("when you buy date is " +
		// // date1);
		// }
		// label.setText("you bought " + selectedProduct + " for " +
		// givesCost.getText());
		// }
		// }
		//
		// givesCost.setText("");
		// // date1 = null;
		// date1Flag = false;
		// date = "";
		// cost = 0;
		//
		// }
		//
		// });
		//
		// productChoice.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// selectedProduct = (String)
		// productChoice.getItemAt(productChoice.getSelectedIndex());
		// // label.setText(selectedProduct);
		// // label.setText("You bought " +
		// // productChoice.getItemAt(productChoice.getSelectedIndex()));
		// }
		// });
		//
		// // take example from this panel switsh :)
		// changeDate.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // take example from this panelSWIthch
		// if (!datePickerPanelFlag) {
		// Core.getInstance().datePickerPanel = new DatePickerPanel();
		// datePickerPanelFlag = true;
		// }
		// Core.getInstance().window.changePanel(Core.getInstance().datePickerPanel);
		//
		// }
		//
		// });
		//
		// history.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// if (!historyPanelFlag) {
		// Core.getInstance().historyPanel = new HistoryPanel(list);
		// historyPanelFlag = true;
		// }
		// Core.getInstance().historyPanel.repaintTextArea(list);
		// Core.getInstance().window.changePanel((JPanel)
		// Core.getInstance().historyPanel);
		//
		// }
		// });
		// close.addActionListener(new ActionListener() {
		//
		// public void actionPerformed(ActionEvent e) {
		// // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// // garbage collector
		// // dispose();
		// System.exit(0);
		// }
		//
		// });
		//
		// random.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// createListOf24RandomProducts(list);
		//
		// }
		//
		// });
		//

		add(genRandomButton);
		add(historyButton);
		add(closeButton);
		add(label);
		add(chooseCategoryCB);
		add(costTF);
		add(okButton);
		add(changeDateButton);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);

	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public float getCost() {
		return Float.parseFloat(costTF.getText());
	}

	// assigning values to the ComboBox
	private String[] setChooseCategoryCB() {
		String[] products = new String[Category.values().length];
		Category[] labels = Category.values();
		for (int i = 0; i < Category.values().length; i++) {
			products[i] = labels[i].getLabel();
		}
		return products;
	}

	/*
	 * making sure that all the variables date, cost, selectedItem hold proper
	 * values and passing them to the controller and then to the list
	 */
	class OkButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				cost = Float.parseFloat(costTF.getText());

			} catch (java.lang.NumberFormatException a) {
				JOptionPane.showMessageDialog(controller.getWindow(),
						"Wrog price format, put decimal, different than 0");
				label.setText("Enter a price");
			}

			// System.out.println("cost: " + cost);
			// System.out.println("date: " + date1);

			if (cost > 0) {
				controller.saveItem(selectedCategory, cost, date1);
				label.setText(String.format("You bought %s for %.2f", selectedCategory, cost));
			} else if (cost == 0) {
			} else if (cost < 0) {
				JOptionPane.showMessageDialog(controller.getWindow(), "Wrong proce format: can't be negative");
			}
			// setting fields and variables to the desired state
			label.setText("");
			date1 = null;
			cost = 0;
			costTF.setText("");

		}
	}

	class ChooseCategoryCBListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectedCategory = chooseCategoryCB.getSelectedItem().toString();
		}
	}

	class CloseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class ChangeDateButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!datePickerPanelFlag) {
				controller.createDatePicker();
				datePickerPanelFlag = true;
			}
			controller.changePanel(controller.getDatePickerPanel());
		}
	}

	class HistoryButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!historyPanelFlag) {
				controller.createHistoryPanel();
				historyPanelFlag = true;
			}
			controller.getHistoryPanel().repaintTextArea();
			controller.changePanel(controller.getHistoryPanel());
		}
	}
//	for the purpose of testing, creates few products from each category, with a semi-random date and cost
	class GenRandomButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			createListOf24RandomProducts(controller.getModel().getListOfBoughtProducts());

		}

	}
}
