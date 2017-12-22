package viewPackage;

/*
 * HistoryPanel is used to print history of bought products.
 */

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controllerPackage.MainController;
import listenersPackage.GoToCategoriesPanelListener;
import listenersPackage.GoToMainPanelListener;

public class HistoryPanel extends JPanel implements TextPanel {


	JButton categoriesPanelButton;
	JButton goBackButton;
	public JTextArea textArea;
	JScrollPane scroll;
	boolean categoriesPanelFlag;

	public HistoryPanel() {
		
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

		goBackButton.addActionListener(new GoToMainPanelListener());
		categoriesPanelButton.addActionListener(new GoToCategoriesPanelListener());

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
	public void repaintTextArea(String allProducts, String sumExpenses) {
		textArea.setText(allProducts);
		textArea.append(sumExpenses);
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendText(String text) {
		// TODO Auto-generated method stub
		
	}

}
