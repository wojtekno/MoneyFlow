import static methods.MethodAutomatic.*;
import static methods.MethodUser.*;

import java.awt.Color;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;

import products.Product;
import products.Category;

public class WindowTryError extends JFrame {
	float cost;
	String date = "";
	String selectedProduct;
	JFrame f = new JFrame();
	// List<Product> list2 = new ArrayList<>();
	JDialog dateFrame;
	JTextArea area;
	boolean areaFlag = false;
	
	
	public WindowTryError(ArrayList<Product> list) {
		// why area, and areaFlag can't be initialized here(insideconstructor?)
//		Core.getInstance().mainPanel = new MainPanel(list);
		Core.getInstance().startPanel = new StartPanel(list);
//		add(Core.getInstance().mainPanel);
		add(Core.getInstance().startPanel);
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
