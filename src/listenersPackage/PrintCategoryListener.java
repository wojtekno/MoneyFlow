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
			panel.setText(controller.getModel().sumCategories());
		} else {
			panel.setText(controller.getModel().printProductsFromChoosenCategory(
					controller.getModel().getProductsFromChoosenCategory(selectedCategory)));
			panel.appendText(controller.getModel()
					.sumChosenCategory(controller.getModel().getProductsFromChoosenCategory(selectedCategory)));
		}
	}

}