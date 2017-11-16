import static methods.MethodUser.sumCategories;

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

import products.Product;

public class CategoriesPanel extends JPanel implements TextPanel {

	JTextArea textArea;
	JButton goBack;
	JComboBox chooseCategory;
	JScrollPane scroll;

	public CategoriesPanel(List<Product> list) {
		goBack = new JButton("back");
		goBack.setAlignmentY(1);
		textArea = new JTextArea(25, 25);
		// textArea.setSize(270, 400);
		// jep.setText(String.format("You bought\n %s \n", list));
		textArea.setText(sumCategories(list));

		Font font = textArea.getFont();
		textArea.setFont(font.deriveFont(Font.BOLD));
		textArea.setEditable(false);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Core.getInstance().window.changePanel((JPanel) Core.getInstance().historyPanel);
				// Core.getInstance().window.changePanel(historyPanel);
				// historyPanel.setVisible(false);

				// textArea.setText(String.format("You bought\n %s \n", list));
				// textArea.append(sumExpenses(list));
				// historyPanel.add(scroll);
				// historyPanel.repaint();
				// historyPanel.revalidate();
				//// Core.getInstance().window.changePanel(Core.getInstance().historyPanel);
				// Core.getInstance().window.changePanel(historyPanel);
			}
		});

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
