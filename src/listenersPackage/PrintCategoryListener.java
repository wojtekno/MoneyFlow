package listenersPackage;

/*
 * TODO implement this one
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;
import viewPackage.CategoriesPanel;

public class PrintCategoryListener implements ActionListener {

	MainController controller;
	CategoriesPanel panel;

	public PrintCategoryListener(MainController controller, CategoriesPanel panel) {
		this.controller = controller;
		this.panel = panel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedCategory = panel.chooseCategoryCB.getSelectedItem().toString();
		if (selectedCategory.equals("General")) {
			panel.textArea.setText(controller.getModel().sumCategories());
		} else {
			panel.textArea.setText(controller.getModel().printProductsFromChoosenCategory(
					controller.getModel().getProductsFromChoosenCategory(selectedCategory)));
			panel.textArea.append(controller.getModel()
					.sumChosenCategory(controller.getModel().getProductsFromChoosenCategory(selectedCategory)));
		}
	}

}