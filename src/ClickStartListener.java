

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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