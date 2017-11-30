//change date so if you choose the next time is again null

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import net.codejava.swing.DateLabelFormatter;

public class DatePickerPanel extends JPanel {
	
	MainController controller;
	
	JLabel label;
	JButton okButton;
	
	public DatePickerPanel(MainController controller) {
		this.controller = controller;
		// JPanel pickerPanel = new JPanel();
//		Core.getInstance().datePickerPanel = new JPanel();
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		// = selectedDate;

		label = new JLabel("Choose a date from the callendar");
		okButton = new JButton("OK");

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setDate((Date) datePicker.getModel().getValue());
				controller.changePanel(controller.getMainPanel());
				if (controller.getDate() == null) {
					controller.setDateFlag(false);
				} else {
					controller.setDateFlag(true);
				}
			}
		});

		label.setSize(200, 100);
		setSize(300, 300);
		add(okButton);
		add(label);
		add(datePicker);
		setLayout(new FlowLayout());
		setVisible(true);

	}

}
