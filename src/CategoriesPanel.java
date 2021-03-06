
/*
 * Panel printing products from chosen category, and its total cost
 * TODO implement PrintCategoryListener
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

		chooseCategoryCB.addActionListener(new PrintCategoryListener(controller, this));
		goBackButton.addActionListener(new GoToHistoryPanelListener(controller));

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
		chooseCategoryCB.setSelectedIndex(0);
		// textArea.setText(sumCategories(controller.getModel().getListOfBoughtProducts()));
	}

	/*
	 * Assigns values to the chooseCategoryCB.
	 */
	public String[] setChooseCategoryCB() {
		String[] categories = new String[Category.values().length + 1];
		categories[0] = "General";
		for (int i = 1; i < categories.length; i++) {
			categories[i] = Category.values()[i - 1].getLabel();
		}
		return categories;
	}

}
