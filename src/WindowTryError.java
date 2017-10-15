import java.awt.Color;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;

import static Methods.MethodUser.*;
import static Methods.MethodAutomatic.*;
import Products.Product;

public class WindowTryError extends JFrame {
	float cost;
	String date = "";
	String selectedProduct;
	JFrame f = new JFrame();
	// List<Product> list2 = new ArrayList<>();
	JDialog dateFrame;
	JTextArea area;
	boolean areaFlag = false;

	public WindowTryError(List<Product> list) {
		System.out.println("ost =" + cost);
		// why area, and areFlag can't be initialized here(insideconstructor?)

		
		JButton history = new JButton("Hisory");
		JButton close = new JButton("Close");
		JLabel label = new JLabel();
		String[] products = { "Food", "Treats", "Edu", "Entertainment", "Expenses", "Transport" };
		JComboBox productChoice = new JComboBox<>(products);
		JTextField givesCost = new JTextField();
		JButton ok = new JButton("OK");
		JButton changeDate = new JButton("Not today?");
		JButton random = new JButton("Gen.Rand");
		
		history.setBounds(10, 300, 100, 40);
		close.setBounds(150, 180, 100, 40);
		label.setBounds(150, 40, 300, 40);
		productChoice.setBounds(150, 140, 100, 20);
		givesCost.setBounds(150, 80, 100, 40);
		changeDate.setBounds(40, 80, 100, 40);
		ok.setBounds(270, 80, 100, 40);
		random.setBounds(350, 10, 50, 20);

		ok.addActionListener(new ActionListener() {
			// jak rozwiazac kiedy nic nie jest wpisane w givescost
			@Override
			public void actionPerformed(ActionEvent e) {
				// do {
				try {
					cost = Float.parseFloat(givesCost.getText());
				}

				catch (java.lang.NumberFormatException a) {
					label.setText("You didn't give a price");
					cost = 0;
				}
				// } while (cost == 0);

				if (cost != 0) {

					if (date.isEmpty()) {
						try {
							nextPurchase(list, cost, selectedProduct);
						} catch (java.lang.NullPointerException e1) {
							selectedProduct = "Food";
							nextPurchase(list, cost, selectedProduct);
						}
						label.setText("you bought " + selectedProduct + " for " + givesCost.getText());

					} else {
						try {
							nextPurchase(list, cost, selectedProduct, date);
						} catch (java.lang.NullPointerException e1) {
							selectedProduct = "Food";
							nextPurchase(list, cost, selectedProduct, date);
							System.out.println("when you buy date is " + date);
						}
						label.setText("you bought " + selectedProduct + " for " + givesCost.getText());
					}

					givesCost.setText("");
					date = "";
					cost = 0;
				}
			}
		});

		productChoice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedProduct = (String) productChoice.getItemAt(productChoice.getSelectedIndex());
				// label.setText(selectedProduct);
				// label.setText("You bought " +
				// productChoice.getItemAt(productChoice.getSelectedIndex()));
			}
		});

		// posprzataj
		// zmien na okreslony format daty
		// zeby sie nie drukowala godzina "null"

		changeDate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				showDialog(list, label);
			}

		});
		//create new window with histry
		history.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!areaFlag) {
					area = new JTextArea();
					add(area);
					areaFlag = true;
				}
				historyDialog(area, list);

				// area.setText((String.format("You bought\n %s",
				// printListOfItems(numberOfPurchaseFinger, list))));
				area.setText(String.format("You bought\n %s \n", list));
				area.setBounds(20, 280, 450, 300);
				// area.setSize(400, 400);
				repaint();

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

		add(random);
		add(history);
		add(close);
		add(label);
		add(productChoice);
		add(givesCost);
		add(ok);
		add(changeDate);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
	}

	void showDialog(List<Product> list, JLabel label) {
		dateFrame = new JDialog(f, "Set a date", true);
		JTextField t1;
		JLabel l1;
		JButton b1;
		JButton b2;

		t1 = new JTextField();
		l1 = new JLabel("Put a date");
		b1 = new JButton("OK");
		b2 = new JButton("Today");

		dateFrame.setBounds(40, 80, 420, 340);
		dateFrame.setBackground(Color.red);
		t1.setBounds(150, 80, 100, 40);
		l1.setBounds(150, 40, 100, 40);
		b1.setBounds(150, 120, 100, 40);
		b2.setBounds(260, 80, 100, 40);
		dateFrame.add(t1);
		dateFrame.add(l1);
		dateFrame.add(b1);
		dateFrame.add(b2);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				l1.setText("blabla");
				dateFrame.repaint();
				date = t1.getText();
				System.out.println(date);

				dateFrame.setVisible(false);
			//	dateFrame.dispose();

				if (cost != 0) {
					nextPurchase(list, cost, selectedProduct, date);
				} else {
					label.setText("You didn't give a price");
				}
			}

		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				date = "";
				dateFrame.dispose();
				if (cost != 0) {
					nextPurchase(list, cost, selectedProduct);
				} else {
					label.setText("You didn't give a price");
				}
			}
		});

		dateFrame.setLayout(null);
		dateFrame.setVisible(true);

		// dateFrame.setVisible(false);
		// dateFrame.dispose();

	}
	
	// create new window with hosotiry
	void historyDialog(JTextArea area, List<Product> list) {
		
		
		JDialog historyDialog = new JDialog(f, "History:", true);
		JButton goBack = new JButton("back");
		area.setBounds(20, 20, 270, 400 );
		
		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		historyDialog.setBounds(10, 10, 300, 500);
		
		goBack.setBounds(20, 420, 100, 40);
		
		area.setText(String.format("You bought\n %s \n", list));
		
		historyDialog.add(scroll);	
//		historyDialog.add(area);
		historyDialog.add(goBack);
		
		repaint();
		historyDialog.setLayout(null);
		historyDialog.setVisible(true);
		
		
	}
}
