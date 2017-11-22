import static methods.MethodUser.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import products.Category;
import products.Product;

public class CategoriesPanel extends JPanel implements TextPanel {

	JTextArea textArea;
	JButton goBack;
	JComboBox chooseCategory;
	JScrollPane scroll;
	String[] categories;
	String selectedCategory;

	public CategoriesPanel(List<Product> list) {
		goBack = new JButton("back");
		goBack.setAlignmentY(1);
		categories = new String[Category.values().length + 1];
		categories[0] = "General";
		for (int i = 1; i < categories.length; i++) {
			categories[i] = Category.values()[i - 1].getLabel();
		}

		chooseCategory = new JComboBox(categories);

		textArea = new JTextArea(25, 25);
		
		Font font = textArea.getFont();
		textArea.setFont(font.deriveFont(Font.BOLD));
		textArea.setEditable(false);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		chooseCategory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedCategory = chooseCategory.getSelectedItem().toString();
				if (selectedCategory.equals("General")) {
					textArea.setText(sumCategories(list));
				} else {
					textArea.setText("");
					printProductsFromChoosenCategory(textArea, getProductsFromChoosenCategory(selectedCategory, list));
				}
			}
		});
		
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Core.getInstance().window.changePanel((JPanel) Core.getInstance().historyPanel);
			}
		});

		add(chooseCategory);
		add(goBack);
		add(scroll);
		setSize(300, 500);
		repaint();
		revalidate();
		setLayout(new FlowLayout());
		setVisible(true);

	}

	@Override
	public void repaintTextArea(List<Product> list) {
		textArea.setText(sumCategories(list));

	}
}
