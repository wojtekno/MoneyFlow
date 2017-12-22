package listenersPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;
import other.Core;

public class GoToMainPanelListener implements ActionListener {
	
	MainController controller = (MainController) Core.getInstance().getMainController();
	
	public GoToMainPanelListener () {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.changePanel(controller.getMainPanel());
	}
	

}
