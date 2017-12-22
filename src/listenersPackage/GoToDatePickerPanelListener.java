package listenersPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllerPackage.MainController;
import other.Core;

public class GoToDatePickerPanelListener implements ActionListener {

	MainController controller = (MainController) Core.getInstance().getMainController();

	public GoToDatePickerPanelListener() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller.getDatePickerPanel() == null) {
			controller.createDatePicker();
					}
		controller.changePanel(controller.getDatePickerPanel());
	}
}