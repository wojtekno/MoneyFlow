package viewPackage;
/*
 * interface for panels with JtextArea
 */

import javax.swing.JTextArea;


public interface TextPanel {
	JTextArea textArea = new JTextArea(25,25);
	
	public void repaintTextArea(String text1, String text2);
	public void setText(String text);
	public void appendText(String text);
}
