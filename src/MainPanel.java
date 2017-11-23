//implement note - so when you click ok notes is incorporated to the product

import static methods.MethodAutomatic.createListOf24RandomProducts;
import static methods.MethodUser.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;

import products.Product;
import products.Category;

public class MainPanel extends JPanel {

	float cost;
	String date = "";
	static Date date1;
	static boolean date1Flag;
	String selectedProduct;
	String note;
	// List<Product> list2 = new ArrayList<>();
	
	JButton okButton;
	JButton history;
	JButton close;
	JButton random;
	JButton changeDate;
	JLabel label;
	JComboBox productChoiceCB;
	JTextField giveCostTF;
	JTextField noteTF;
	
	private boolean historyPanelFlag; 
	private boolean datePickerPanelFlag;

	public MainPanel(List<Product> list) {

		history = new JButton("History");
		close = new JButton("Close");
		label = new JLabel();
		
		String[] products = new String[Category.values().length];
		Category[] labels = Category.values();
		for (int i = 0; i < Category.values().length; i++) {
			products[i] = labels[i].getLabel();
		}

		productChoiceCB = new JComboBox<>(products);
		noteTF = new JTextField("quick note");
		giveCostTF = new JTextField("give a price");
		okButton = new JButton("OK");
		changeDate = new JButton("Not today?");
		random = new JButton("Gen.Rand");
		
		

		history.setBounds(10, 300, 100, 40);
		close.setBounds(150, 200, 100, 40);
		label.setBounds(150, 40, 300, 40);
//		productChoiceCB.setBounds(150, 140, 100, 20);
		productChoiceCB.setBounds(40, 80, 100, 40);
		giveCostTF.setBounds(150, 80, 100, 40);
		changeDate.setBounds(270, 140, 100, 40);
		okButton.setBounds(270, 80, 100, 40);
		random.setBounds(300, 10, 100, 20);
		noteTF.setBounds(150, 140, 100, 40);
		okButton.addActionListener(new ActionListener() {
			// jak rozwiazac kiedy nic nie jest wpisane w givescost
			@Override
			public void actionPerformed(ActionEvent e) {
				note = noteTF.getText();
				// do {
				try {
					cost = Float.parseFloat(giveCostTF.getText());
				}

				catch (java.lang.NumberFormatException a) {
					label.setText("You didn't give a price");
					cost = 0;
				}
				// // } while (cost == 0);

				if (cost != 0) {

					if (!date1Flag) {
						try {
							categoryPurchuse(list, cost, selectedProduct, note);

						} catch (java.lang.NullPointerException e1) {
							selectedProduct = "Food";
							categoryPurchuse(list, cost, selectedProduct, note);
						}
						label.setText("you bought " + selectedProduct + " for " + giveCostTF.getText());

					} else {
						try {
							nextPurchase(list, cost, selectedProduct, date1, note);
						} catch (java.lang.NullPointerException e1) {
							selectedProduct = "Food";
							nextPurchase(list, cost, selectedProduct, date1, note);
							// System.out.println("when you buy date is " +
							// date1);
						}
						label.setText("you bought " + selectedProduct + " for " + giveCostTF.getText());
					}
				}
				noteTF.setText("");
				giveCostTF.setText("");
				// date1 = null;
				date1Flag = false;
				date = "";
				cost = 0;

			}

		});

		productChoiceCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedProduct = (String) productChoiceCB.getItemAt(productChoiceCB.getSelectedIndex());
				// label.setText(selectedProduct);
				// label.setText("You bought " +
				// productChoice.getItemAt(productChoice.getSelectedIndex()));
			}
		});

		// take example from this panel switsh :)
		changeDate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// take example from this panelSWIthch
				if (!datePickerPanelFlag) {
					Core.getInstance().datePickerPanel = new DatePickerPanel();
					datePickerPanelFlag = true;
				}
				Core.getInstance().window.changePanel(Core.getInstance().datePickerPanel);

			}

		});

		history.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!historyPanelFlag) {
					Core.getInstance().historyPanel = new HistoryPanel(list);
					historyPanelFlag = true;
				} 
				Core.getInstance().historyPanel.repaintTextArea(list);
				Core.getInstance().window.changePanel((JPanel) Core.getInstance().historyPanel);
				
			}
		});
		close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// garbage collector
				// dispose();
				System.exit(0);
			}

		});

		random.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createListOf24RandomProducts(list);

			}

		});
		
		add(noteTF);
		add(random);
		add(history);
		add(close);
		add(label);
		add(productChoiceCB);
		add(giveCostTF);
		add(okButton);
		add(changeDate);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);

	}

}
