import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToCategoriesPanelListener implements ActionListener {

	MainController controller;

	public GoToCategoriesPanelListener(MainController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller.getCategoriesPanel() == null) {
			controller.createCategoriesPanel();
		}
		controller.getCategoriesPanel().repaintTextArea();
		controller.changePanel(controller.getCategoriesPanel());
	}
}