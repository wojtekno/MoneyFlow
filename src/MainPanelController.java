import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import methods.Model;

public class MainPanelController {
	Window window;
	MainPanel mainPanel;
	Model model;
	
	public MainPanelController(Model model, Window window) {
		this.window = window;
		this.mainPanel = new MainPanel();
		this.model = model;
		
		window.changePanel(mainPanel);
		
//		this.mainPanel.addOkButtonListener(new OkButtonListener());
	}
	
	class OkButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			float cost = mainPanel.getCost();
//			model.buyItemNew(selectedProduct, cost date1);
			model.buyItemNew(cost);
			
		}
}


	
}
