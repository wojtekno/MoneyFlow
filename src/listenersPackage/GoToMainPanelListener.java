package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllerPackage.MainController;
import modelPackage.Core;
import viewPackage.MainPanel;
import viewPackage.MainPanelInterface;

public class GoToMainPanelListener implements ActionListener, GoToListenerInterface {

	MainPanelInterface mainPanel;

	public GoToMainPanelListener() {
		mainPanel = Core.getInstance().getMainPanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (mainPanel == null) {
			Core.getInstance().setMainPanel(new MainPanel());
			mainPanel = Core.getInstance().getMainPanel();
		}
		changePanel((JPanel) mainPanel);
	}

	@Override
	public void changePanel(JPanel panel) {
		Core.getInstance().getWindow().changePanel(panel);

	}

}
