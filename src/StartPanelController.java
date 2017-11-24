import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import methods.Model;

public class StartPanelController {
	StartPanel startPanel;
	Model model;
	
	public StartPanelController (StartPanel startPanel, Model model) {
		this.startPanel = startPanel;
		this.model = model;
		this.startPanel.addStartButtonListener(new StartButtonListener());
	}
	
	
}

class StartButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Core.getInstance().mainPanel = new MainPanel();
		Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

		
	}
	
	
}
