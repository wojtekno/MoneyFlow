package viewPackage;
/*
 * Frame which is used throughout the application 
 * - just changing Panels
 */

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window() {

		setSize(500, 500);
		setLayout(null);
		setVisible(true);
		revalidate();
		repaint();
	}

	public void changePanel(JPanel panel) {
		getContentPane().removeAll();
		add(panel);
		revalidate();
		repaint();
	}

}
