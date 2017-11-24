import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import products.Product;
import products.Category;

public class StartPanel extends JPanel {
	
	JButton startButton;
	public StartPanel() {

		startButton = new JButton("Start");
		startButton.setBounds(150, 150, 200, 200);

		
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Core.getInstance().mainPanel = new MainPanel();
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

			}
		});

		add(startButton);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
	}
	
	public void addStartButtonListener (ActionListener listenForStartButton) {
		startButton.addActionListener(listenForStartButton);
		
	}
}
