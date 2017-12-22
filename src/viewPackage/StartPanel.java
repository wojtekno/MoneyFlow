package viewPackage;
/*
 * Start Panel is a panel with a start button.
 * After clicking start we go to the MainPanel of application
 */

import javax.swing.JButton;
import javax.swing.JPanel;

import controllerPackage.StartController;
import listenersPackage.ClickStartListener;
import listenersPackage.GoToMainPanelListener;


public class StartPanel extends JPanel {
	
	JButton startButton;

	public StartPanel() {
				
		startButton = new JButton("Start");
		startButton.setBounds(150, 150, 200, 200);
		startButton.addActionListener(new GoToMainPanelListener());
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