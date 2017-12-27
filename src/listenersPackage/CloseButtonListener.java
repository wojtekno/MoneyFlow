package listenersPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import other.Core;

public class CloseButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Core.getInstance().getModel().getDatabase().closeConnection();
		System.exit(0);
	}
}

