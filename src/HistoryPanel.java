
//resolve the list issue

import static methods.Model.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import products.Product;

public class HistoryPanel extends JPanel implements TextPanel {

	MainController controller;
	JPanel historyPanelThis;
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
		// textArea.setText("");
		// printHistoryPanel(textArea, list);

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		Font font = textArea.getFont();
		textArea.setFont(font.deriveFont(Font.BOLD));
		textArea.setEditable(false);

		goBackButton.addActionListener(new GoBackButtonListener());
		categoriesPanelButton.addActionListener(new CategoriesPanelButtonListener());

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
	public void repaintTextArea(List<Product> list) {
		textArea.setText("");
		printAllProducts(textArea, list);
		textArea.append(sumExpenses(list));
	}

	
	class GoBackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.changePanel(controller.getMainPanel());
		}
	}

	
	class CategoriesPanelButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!categoriesPanelFlag) {
				controller.createCategoriesPanel();
				categoriesPanelFlag = true;
			}
			controller.getCategoriesPanel().repaintTextArea(controller.getModel().list);
			controller.changePanel(controller.getCategoriesPanel());
		}
	}

}
