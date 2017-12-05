/*
 * Panel printing products from chosen category, and its total cost
 */
import static modelPackage.Model.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import products.Category;


public class CategoriesPanel extends JPanel implements TextPanel {

	MainController controller;
	JTextArea textArea;
	JButton goBackButton;
	JComboBox<String> chooseCategoryCB;
	JScrollPane scroll;
	String selectedCategory;

	public CategoriesPanel(MainController controller) {
		this.controller = controller;

		goBackButton = new JButton("back");
		goBackButton.setAlignmentY(1);
		chooseCategoryCB = new JComboBox<String>(setChooseCategoryCB());
		selectedCategory = chooseCategoryCB.getItemAt(0).toString();
		textArea = new JTextArea(25, 25);

		Font font = textArea.getFont();
		textArea.setFont(font.deriveFont(Font.BOLD));
		textArea.setEditable(false);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		chooseCategoryCB.addActionListener(new ChooseCategoriyCBListener());
		goBackButton.addActionListener(new GoBackButtonListener());

		add(chooseCategoryCB);
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
		textArea.setText(sumCategories(controller.getModel().getListOfBoughtProducts()));
	}

	public String[] setChooseCategoryCB() {
		String[] categories = new String[Category.values().length + 1];
		categories[0] = "General";
		for (int i = 1; i < categories.length; i++) {
			categories[i] = Category.values()[i - 1].getLabel();
		}
		return categories;
	}

	class GoBackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.changePanel(controller.getHistoryPanel());
			chooseCategoryCB.setSelectedIndex(0);
		}

	}

	class ChooseCategoriyCBListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectedCategory = chooseCategoryCB.getSelectedItem().toString();
			if (selectedCategory.equals("General")) {
				textArea.setText(sumCategories(controller.getModel().getListOfBoughtProducts()));
			} else {
				textArea.setText("");
				printProductsFromChoosenCategory(textArea, getProductsFromChoosenCategory(selectedCategory, controller.getModel().getListOfBoughtProducts()));
				textArea.append(sumExpenses(getProductsFromChoosenCategory(selectedCategory, controller.getModel().getListOfBoughtProducts())));
			}
		}

	}
}
