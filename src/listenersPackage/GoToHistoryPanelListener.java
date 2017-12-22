/*
 * TODO do wee need MainConrollerInterface or MainController?
 */

package listenersPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;
import controllerPackage.MainControllerInterface;
import other.Core;

public class GoToHistoryPanelListener implements ActionListener {

	MainController controller = (MainController) Core.getInstance().getMainController();

	public GoToHistoryPanelListener() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller.getHistoryPanel() == null) {
			controller.createHistoryPanel();
		}
		controller.getHistoryPanel().repaintTextArea(controller.getModel().printAllProducts(),
				controller.getModel().sumExpenses());
		controller.changePanel(controller.getHistoryPanel());
	}
}