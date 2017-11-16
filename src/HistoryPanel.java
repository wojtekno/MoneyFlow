
//scroll doesnt work

import static methods.MethodUser.sumExpenses;

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

	JPanel historyPanelThis;
	JButton categoriesPanelButton;
	JButton goBack;
	public JTextArea textArea;
	JScrollPane scroll;
	boolean categoriesPanelFlag;

	public HistoryPanel(List<Product> list) {
		
		goBack = new JButton("back");
		goBack.setAlignmentY(1);
		categoriesPanelButton = new JButton("Categories");
		categoriesPanelButton.setAlignmentY(TOP_ALIGNMENT);
		textArea = new JTextArea(25, 25);
		textArea.setText(String.format("You bought\n %s \n", list));
		
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		Font font = textArea.getFont();
		textArea.setFont(font.deriveFont(Font.BOLD));
		textArea.append(sumExpenses(list));
		textArea.setEditable(false);

		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);

			}
		});

		categoriesPanelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!categoriesPanelFlag) {
					Core.getInstance().categoriesPanel = new CategoriesPanel(list);
					categoriesPanelFlag = true;
				}
				Core.getInstance().categoriesPanel.repaintTextArea(list);
				Core.getInstance().window.changePanel(Core.getInstance().categoriesPanel);

			}
		});

		add(categoriesPanelButton);
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
		textArea.setText(String.format("You bought\n %s \n", list));
		textArea.append(sumExpenses(list));
	}

}
