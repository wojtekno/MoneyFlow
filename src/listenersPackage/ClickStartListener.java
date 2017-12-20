package listenersPackage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.StartPanelController;


public class ClickStartListener implements ActionListener {

	StartPanelController controller;
	
	public ClickStartListener(StartPanelController controller) {
		this.controller = controller; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
					controller.didClickStart();
					
//		Core.getInstance().mainPanel = new MainPanel();
//		Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

	}
}