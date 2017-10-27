import static Methods.MethodAutomatic.createListOf24RandomProducts;
import static Methods.MethodUser.nextPurchase;
import static Methods.MethodUser.sumExpenses;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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

import Products.Product;

public class MainPanel extends JPanel {
	
	float cost;
	String date = "";
	static Date date1;
	static boolean date1Flag;
	String selectedProduct;
//	JPanel panel = new JPanel();
	// List<Product> list2 = new ArrayList<>();
	JPanel datePanel;
	private boolean datePanelFlag;
	JTextArea area;
	private boolean areaFlag = false;
	JPanel historyPanel;
	private boolean historyPanelFlag;
	JEditorPane jep;
	PickerPanel pickerPanel;
	DatePicker datePicker;
	
	public MainPanel(List<Product> list) {

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

					if (!date1Flag) {
						try {
							nextPurchase(list, cost, selectedProduct);
						} catch (java.lang.NullPointerException e1) {
							selectedProduct = "Food";
							nextPurchase(list, cost, selectedProduct);
						}
						label.setText("you bought " + selectedProduct + " for " + givesCost.getText());

					} else {
						try {
							nextPurchase(list, cost, selectedProduct, date1);
						} catch (java.lang.NullPointerException e1) {
							selectedProduct = "Food";
							nextPurchase(list, cost, selectedProduct, date1);
							System.out.println("when you buy date is " + date1);
						}
						label.setText("you bought " + selectedProduct + " for " + givesCost.getText());
					}

					givesCost.setText("");
//					date1 = null;
					date1Flag = false;
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
				pickerPanel = new PickerPanel();
				Core.getInstance().window.changePanel(pickerPanel);
//				changeDatePanel(list, label);
			}

		});

		history.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!areaFlag) {
					area = new JTextArea(25, 25);
					// add(area);
					areaFlag = true;
					historyPanel(area, list);
				} else {
					area.setText(String.format("You bought\n %s \n", list));
					area.append(sumExpenses(list));
					historyPanel.repaint();
					historyPanel.revalidate();
					Core.getInstance().window.changePanel(historyPanel);
				}

				// area.setText((String.format("You bought\n %s",
				// printListOfItems(numberOfPurchaseFinger, list))));
				// area.setText(String.format("You bought\n %s \n", list));
				// area.setBounds(20, 280, 450, 300);
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
		setSize(400, 400);
		setLayout(null);
		setVisible(true);

	}

	void changeDatePanel(List<Product> list, JLabel label) {
		if (!datePanelFlag) {
			datePanel = new JPanel();
			datePanelFlag = true;
			datePicker = new DatePicker();
		}

		JTextField t1;
		JLabel l1;
		JButton bOK;
		JButton bToday;

		t1 = new JTextField();
		l1 = new JLabel("Put a date");
		bOK = new JButton("OK");
		bToday = new JButton("Today");
		
		datePanel.add(datePicker);
		datePanel.setBounds(40, 80, 420, 340);
		datePanel.setBackground(Color.red);
		t1.setBounds(150, 80, 100, 40);
		l1.setBounds(150, 40, 100, 40);
		bOK.setBounds(150, 120, 100, 40);
		bToday.setBounds(260, 80, 100, 40);
		datePanel.add(t1);
		datePanel.add(l1);
		datePanel.add(bOK);
		datePanel.add(bToday);

		bOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				date = t1.getText();
				System.out.println(date);

				datePanel.setVisible(false);
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);
				// dateFrame.dispose();

				if (cost != 0) {
					nextPurchase(list, cost, selectedProduct, date1);
				} else {
					label.setText("You didn't give a price");
				}
			}

		});

		bToday.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				date = "";
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);
				if (cost != 0) {
					nextPurchase(list, cost, selectedProduct);
				} else {
					label.setText("You didn't give a price");
				}
			}
		});

		datePanel.setLayout(null);
		datePanel.setVisible(true);
		Core.getInstance().window.changePanel(datePanel);
		// dateFrame.setVisible(false);
		// dateFrame.dispose();

	}

	// I want sum to be bold
	void historyPanel(JTextArea area, List<Product> list) {

		if (!historyPanelFlag) {
			historyPanel = new JPanel();
			jep = new JEditorPane();
			historyPanelFlag = true;

		}

		JButton goBack = new JButton("back");
		// area.setSize(270, 400);
		// jep.setText(String.format("You bought\n %s \n", list));

		area.setText(String.format("You bought\n %s \n", list));
		Font font = area.getFont();
		area.setFont(font.deriveFont(Font.BOLD));
		area.append(String.valueOf(MainPanel.date1));
//		area.append(String.valueOf(obj));
		area.append(sumExpenses(list));
		area.setEditable(false);

		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// scroll.setSize(200, 100);
		// goBack.setBounds(260, 280, 100, 40);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);
				// historyPanel.setVisible(false);

			}
		});
		historyPanel.add(goBack);
		historyPanel.add(scroll);
		// historyPanel.add(area);

		historyPanel.setSize(300, 500);
		historyPanel.repaint();
		historyPanel.revalidate();
		historyPanel.setLayout(new FlowLayout());
		historyPanel.setVisible(true);

		Core.getInstance().window.changePanel(historyPanel);

	}

	// to ogarniamy!!!
	void startPanel() {

	}
}
