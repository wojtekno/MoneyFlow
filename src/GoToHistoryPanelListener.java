import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToHistoryPanelListener implements ActionListener {

	MainController controller;

	public GoToHistoryPanelListener(MainController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller.getHistoryPanel() == null) {
			controller.createHistoryPanel();
		}
		controller.getHistoryPanel().repaintTextArea();
		controller.changePanel(controller.getHistoryPanel());
	}
}