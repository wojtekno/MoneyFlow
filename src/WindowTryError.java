import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

public class WindowTryError extends JFrame {
	JFrame f = new JFrame();
	List<Product> list2 = new ArrayList<>();

	public WindowTryError() {
		JButton food = new JButton("Food");
		JButton treat = new JButton("Treat");
		JButton print = new JButton("Print");
		JButton close = new JButton("Close");
		JLabel label = new JLabel();

		food.setBounds(80, 100, 100, 40);
		treat.setBounds(220, 100, 100, 40);
		print.setBounds(150, 180, 100, 40);
		close.setBounds(150, 240, 100, 40);
		label.setBounds(50, 40, 300, 40);
		food.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 1.how to opreate on List<Product> list from Main.class?
				// 2. how to put values/referenses of clicked button in
				// Method.User.nextPurchase?
				MethodUser.nextPurchaseOfFood(list2);
				label.setText(MethodUser.printBoughtItem(MethodUser.numberOfPurchaseFinger, list2));
			}

		});

		treat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MethodUser.nextPurchuseOfTreat(list2);
				label.setText(MethodUser.printBoughtItem(MethodUser.numberOfPurchaseFinger, list2));
			}
		});
			// for some reason you have to click and drag the mouse to the textArea apperas
		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextArea area = new JTextArea(String.format("You bought\n %s",
						MethodUser.printListOfItems2(MethodUser.numberOfPurchaseFinger, list2)));

				area.setBounds(20, 280, 300, 300);
				area.setSize(400, 400);
				add(area);
				
			}
		});
		close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();

			}

		});

		add(food);// adding button on frame
		add(treat);
		add(print);
		add(close);
		add(label);

		setSize(400, 500);
		setLayout(null);
		setVisible(true);
	}

}
