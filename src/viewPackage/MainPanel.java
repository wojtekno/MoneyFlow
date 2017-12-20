package viewPackage;

/* 
 * Main  Panel
 */
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllerPackage.MainController;
import listenersPackage.BuyProductListener;
import listenersPackage.CloseButtonListener;
import listenersPackage.GenerateRandomProductsListener;
import listenersPackage.GoToDatePickerPanelListener;
import listenersPackage.GoToHistoryPanelListener;
import products.Category;

public class MainPanel extends JPanel {

	MainController controller;

	JButton okButton;
	JButton changeDateButton;
	JButton genRandomButton;
	JButton historyButton;
	JButton closeButton;
	public JLabel label;
	public JComboBox<String> chooseCategoryCB;
	public JTextField costTF;

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

		historyButton.setBounds(10, 300, 100, 40);
		closeButton.setBounds(150, 180, 100, 40);
		label.setBounds(150, 40, 300, 40);
		chooseCategoryCB.setBounds(150, 140, 100, 20);
		costTF.setBounds(150, 80, 100, 40);
		changeDateButton.setBounds(40, 80, 100, 40);
		okButton.setBounds(270, 80, 100, 40);
		genRandomButton.setBounds(300, 10, 100, 20);

		okButton.addActionListener(new BuyProductListener(this, controller));
		closeButton.addActionListener(new CloseButtonListener());
		changeDateButton.addActionListener(new GoToDatePickerPanelListener(controller));
		historyButton.addActionListener(new GoToHistoryPanelListener(controller));
		genRandomButton.addActionListener(new GenerateRandomProductsListener(controller));

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

	public float getCost() {
		return Float.parseFloat(costTF.getText());
	}

	/*
	 * assigning values to the ComboBox
	 */
	private String[] setChooseCategoryCB() {
		String[] products = new String[Category.values().length];
		Category[] labels = Category.values();
		for (int i = 0; i < Category.values().length; i++) {
			products[i] = labels[i].getLabel();
		}
		return products;
	}

}
