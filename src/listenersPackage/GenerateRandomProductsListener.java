package listenersPackage;
/*
 * for the purpose of testing, creates few products from each category, with a semi-random date and cost
 */

import static modelPackage.AutomaticMethod.createListOf24RandomProducts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;
import other.Core;

public class GenerateRandomProductsListener implements ActionListener {

	MainController controller = (MainController) Core.getInstance().getMainController();

	public GenerateRandomProductsListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Core.getInstance().getModel().createListOf24RandomProducts();
		// createListOf24RandomProducts(controller.getModel().getListOfBoughtProducts());
	}

}