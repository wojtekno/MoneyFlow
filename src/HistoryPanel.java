
/*
 * HistoryPanel is used to print history of bought products.
 */

import static modelPackage.Model.*;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HistoryPanel extends JPanel implements TextPanel {

	MainController controller;
	JButton categoriesPanelButton;
	JButton goBackButton;
	public JTextArea textArea;
	JScrollPane scroll;
	boolean categoriesPanelFlag;

	public HistoryPanel(MainController conroller) {
		this.controller = conroller;

		goBackButton = new JButton("back");
		goBackButton.setAlignmentY(1);
		categoriesPanelButton = new JButton("Categories");
		categoriesPanelButton.setAlignmentY(TOP_ALIGNMENT);
		textArea = new JTextArea(25, 25);

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		Font font = textArea.getFont();
		textArea.setFont(font.deriveFont(Font.BOLD));
		textArea.setEditable(false);

		goBackButton.addActionListener(new GoToMainPanelListener(controller));
		categoriesPanelButton.addActionListener(new GoToCategoriesPanelListener(controller));

		add(categoriesPanelButton);
		add(goBackButton);
		add(scroll);
		setSize(300, 500);
		repaint();
		revalidate();
		setLayout(new FlowLayout());
		setVisible(true);

	}

	@Override
	public void repaintTextArea() {
		textArea.setText(controller.getModel().printAllProducts());
		textArea.append(controller.getModel().sumExpenses());
	}

}
