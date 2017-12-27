/*
 * TODO do wee need MainConrollerInterface or MainController?
 */

package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllerPackage.MainController;
import controllerPackage.MainControllerInterface;
import other.Core;
import viewPackage.HistoryPanel;

public class GoToHistoryPanelListener implements ActionListener, GoToListenerInterface {

	MainController controller = (MainController) Core.getInstance().getMainController();
	HistoryPanel historyPanel;

	public GoToHistoryPanelListener() {
		historyPanel = Core.getInstance().getHistoryPanel();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (historyPanel == null) {
			Core.getInstance().setHistoryPanel(new HistoryPanel());
			historyPanel = Core.getInstance().getHistoryPanel();
		}
		historyPanel.repaintTextArea(controller.printAllItems(), controller.printSumOfAll());
		changePanel(historyPanel);

	}

	@Override
	public void changePanel(JPanel panel) {
		Core.getInstance().getWindow().changePanel(panel);

	}
}