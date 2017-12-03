import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelPackage.Model;

public class StartPanelController {
	Window window;
	StartPanel startPanel;
	Model model;
	
	public StartPanelController (Model model) {
		this.model = model;
//		Core.getInstance().window = new Window();
		window = new Window();
		startPanel = new StartPanel(this);
//		Core.getInstance().window.changePanel(startPanel);		
		window.changePanel(startPanel);		
	}
	
	public void didClickStart() {
		MainController mainPanelController = new MainController(model, window);
	}
	
	
	
}


