package viewPackage;

/*
 * Panel used to choose a date if it's different than today.
 */

import java.awt.FlowLayout;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controllerPackage.MainController;
import listenersPackage.GoToMainPanelListener;
import net.codejava.swing.DateLabelFormatter;

public class DatePickerPanel extends JPanel {

	MainController controller;
	public JDatePickerImpl datePicker;
	JLabel label;
	JButton okButton;

	public DatePickerPanel(MainController controller) {
		this.controller = controller;
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		label = new JLabel("Choose a date from the callendar");
		okButton = new JButton("OK");
		okButton.addActionListener(new GoToMainPanelListener(controller));

		label.setSize(200, 100);
		setSize(300, 300);
		add(okButton);
		add(label);
		add(datePicker);
		setLayout(new FlowLayout());
		setVisible(true);

	}

	/*
	 * set date to null
	 */
	public void refreshDatePickerPanel() {
		datePicker.getModel().setValue(null);
		datePicker.getJFormattedTextField().setText("");
	}

}
