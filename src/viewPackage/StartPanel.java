package viewPackage;
/*
 * Start Panel is a panel with a start button.
 * After clicking start we go to the MainPanel of application
 */

import javax.swing.JButton;
import javax.swing.JPanel;

import controllerPackage.StartPanelController;
import listenersPackage.ClickStartListener;


public class StartPanel extends JPanel {
	
	StartPanelController controller;
	JButton startButton;

	public StartPanel(StartPanelController controller) {
		this.controller = controller;
		
		startButton = new JButton("Start");
		startButton.setBounds(150, 150, 200, 200);
		startButton.addActionListener(new ClickStartListener(controller));
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

	
}