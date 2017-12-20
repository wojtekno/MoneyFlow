package listenersPackage;
/*
 * for the purpose of testing, creates few products from each category, with a semi-random date and cost
 */

import static modelPackage.AutomaticMethod.createListOf24RandomProducts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;

public class GenerateRandomProductsListener implements ActionListener {

	MainController controller;

	public GenerateRandomProductsListener(MainController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		createListOf24RandomProducts(controller.getModel().getListOfBoughtProducts());
	}

}