import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import products.Product;
import products.ProductsEnum;

public class StartPanel extends JPanel {

	public StartPanel(ArrayList<Product> list, ArrayList<ProductsEnum> listE) {

		JButton start = new JButton("Start");
		start.setBounds(150, 150, 200, 200);

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Core.getInstance().mainPanel = new MainPanel(list, listE);
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

			}
		});

		add(start);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
	}
}
