import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import products.Product;
import products.Category;

public class StartPanel extends JPanel {

	public StartPanel(ArrayList<Product> list) {

		JButton start = new JButton("Start");
		start.setBounds(150, 150, 200, 200);

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Core.getInstance().mainPanel = new MainPanel(list);
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

			}
		});

		add(start);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
	}
}
