import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToMainPanelListener implements ActionListener {
	
	MainController controller;
	public GoToMainPanelListener (MainController controller) {
		this.controller = controller;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.changePanel(controller.getMainPanel());
	}
	

}
