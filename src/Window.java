import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import products.Product;

public class Window extends JFrame {
	
	JFrame f = new JFrame();
	JDialog dateFrame;
	JTextArea area;
	boolean areaFlag = false;

	public Window() {
		// why area, and areaFlag can't be initialized here(insideconstructor?)
		// Core.getInstance().mainPanel = new MainPanel(list);
//		Core.getInstance().startPanel = new StartPanel();
		// add(Core.getInstance().mainPanel);
//		add(Core.getInstance().startPanel);
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

	public void repaintPanelTextArea(TextPanel panel) {
		panel.textArea.repaint();
	}
}
