package listenersPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllerPackage.MainController;
import other.Core;
import viewPackage.DatePickerPanel;

public class GoToDatePickerPanelListener implements ActionListener, GoToListenerInterface {

	// MainController controller = (MainController)
	// Core.getInstance().getMainController();
	private DatePickerPanel datePickerPanel;

	public GoToDatePickerPanelListener() {
		datePickerPanel = Core.getInstance().getDatePickerPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (datePickerPanel == null) {
			Core.getInstance().setDatePickerPanel(new DatePickerPanel());
			datePickerPanel = Core.getInstance().getDatePickerPanel();
		}
		changePanel(datePickerPanel);
	}

	@Override
	public void changePanel(JPanel panel) {
		Core.getInstance().getWindow().changePanel(panel);

	}
}