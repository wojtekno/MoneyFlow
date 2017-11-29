import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import products.Product;
import products.Category;

public class StartPanel extends JPanel {
	
	StartPanelController controller;
	JButton startButton;

	public StartPanel(StartPanelController controller) {
		this.controller = controller;
		
		startButton = new JButton("Start");
		startButton.setBounds(150, 150, 200, 200);
		startButton.addActionListener(new StartButtonListener());
		// startButton.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// Core.getInstance().mainPanel = new MainPanel();
		// Core.getInstance().window.changePanel(Core.getInstance().mainPanel);
		//
		// }
		// });

		add(startButton);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
	}

	class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			controller.didClickStart();
//			Core.getInstance().mainPanel = new MainPanel();
//			Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

		}
	}
}