package listenersPackage;

/*
 * TODO implement this one
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;
import other.Core;
import viewPackage.CategoriesPanel;
import viewPackage.TextPanel;

public class PrintCategoryListener implements ActionListener {

	MainController controller = (MainController) Core.getInstance().getMainController();
	CategoriesPanel panel;

	public PrintCategoryListener(TextPanel panel) {
		this.panel = (CategoriesPanel) panel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedCategory = panel.chooseCategoryCB.getSelectedItem().toString();
		if (selectedCategory.equals("General")) {
			panel.setText(controller.printGeneralOverwiev());
		} else {
			panel.setText(controller.printCategoryItems(selectedCategory));
			panel.appendText(controller.printCategorySum(selectedCategory));
		}
	}

}