import java.util.List;

import javax.swing.JTextArea;

import products.Product;

public interface TextPanel {
	JTextArea textArea = new JTextArea(25,25);
	
	public void repaintTextArea(List<Product> list);
	
}
