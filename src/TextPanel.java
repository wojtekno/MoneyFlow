/*
 * interface for panels with JtextArea
 */

import javax.swing.JTextArea;


public interface TextPanel {
	JTextArea textArea = new JTextArea(25,25);
	
	public void repaintTextArea();
	
}
