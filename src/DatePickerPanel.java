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

	public DatePickerPanel() {
		// JPanel pickerPanel = new JPanel();
//		Core.getInstance().datePickerPanel = new JPanel();
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		// = selectedDate;

		JLabel label1 = new JLabel("Choose a date from the callendar");
		JButton okButton = new JButton("OK");

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.date1 = (Date) datePicker.getModel().getValue();
				Core.getInstance().window.changePanel(Core.getInstance().mainPanel);
				if (MainPanel.date1 == null) {
					MainPanel.date1Flag = false;
				} else {
					MainPanel.date1Flag = true;
				}
			}
		});

		label1.setSize(200, 100);
		setSize(300, 300);
		add(okButton);
		add(label1);
		add(datePicker);
		setLayout(new FlowLayout());
		setVisible(true);

	}

}
