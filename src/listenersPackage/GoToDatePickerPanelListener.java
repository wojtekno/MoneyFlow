package listenersPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;

public class GoToDatePickerPanelListener implements ActionListener {

	MainController controller;

	public GoToDatePickerPanelListener(MainController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller.getDatePickerPanel() == null) {
			controller.createDatePicker();
					}
		controller.changePanel(controller.getDatePickerPanel());
	}
}