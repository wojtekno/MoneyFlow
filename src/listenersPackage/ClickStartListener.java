package listenersPackage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllerPackage.StartControllerInterface;
import other.Core;


public class ClickStartListener implements ActionListener {

	private StartControllerInterface controller;	
	
	public ClickStartListener() {
		this.controller = Core.getInstance().getStartController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
					controller.didClickStart();
					
//		Core.getInstance().mainPanel = new MainPanel();
//		Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

	}
}