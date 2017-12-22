package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllerPackage.MainController;
import other.Core;
import viewPackage.CategoriesPanel;

public class GoToCategoriesPanelListener implements ActionListener, GoToListenerInterface {

	MainController controller = (MainController) Core.getInstance().getMainController();
	CategoriesPanel categoriesPanel;

	public GoToCategoriesPanelListener() {
		categoriesPanel = Core.getInstance().getCategoriesPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (categoriesPanel == null) {
			Core.getInstance().setCategoriesPanel(new CategoriesPanel());
			categoriesPanel = Core.getInstance().getCategoriesPanel();
		}
		categoriesPanel.repaintTextArea(null, null);
		changePanel(categoriesPanel);
	}

	@Override
	public void changePanel(JPanel panel) {
		Core.getInstance().getWindow().changePanel(panel);

	}
}