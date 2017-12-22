package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;
import other.Core;

public class GoToCategoriesPanelListener implements ActionListener {

	MainController controller = (MainController) Core.getInstance().getMainController();

	public GoToCategoriesPanelListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller.getCategoriesPanel() == null) {
			controller.createCategoriesPanel();
		}
		controller.getCategoriesPanel().repaintTextArea(null, null);
		controller.changePanel(controller.getCategoriesPanel());
	}
}