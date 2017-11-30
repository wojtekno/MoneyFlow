import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;

import methods.Model;

public class MainController {
	private Window window;
	private MainPanel mainPanel;
	private Model model;
	private DatePickerPanel datePickerPanel;
	private HistoryPanel historyPanel;
	private CategoriesPanel categoriesPanel;
	
	public MainController(Model model, Window window) {
		this.window = window;
		this.mainPanel = new MainPanel(this);
		this.model = model;
		
		window.changePanel(mainPanel);
		
	}
	
	public Window getWindow() {
		return window;
	}


	public void setWindow(Window window) {
		this.window = window;
	}


	public MainPanel getMainPanel() {
		return mainPanel;
	}


	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}


	public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}


	public DatePickerPanel getDatePickerPanel() {
		return datePickerPanel;
	}

		
	public void setDatePickerPanel(DatePickerPanel panel) {
		this.datePickerPanel = panel;
	}
	
	
	public HistoryPanel getHistoryPanel() {
		return historyPanel;
	}

	public void setHistoryPanel(HistoryPanel historyPanel) {
		this.historyPanel = historyPanel;
	}

	public CategoriesPanel getCategoriesPanel() {
		return categoriesPanel;
	}

	public void setCategoriesPanel(CategoriesPanel categoriesPanel) {
		this.categoriesPanel = categoriesPanel;
	}

		
	public void setDate(Date date1) {
		mainPanel.setDate1(date1);
	}
	
	
	public Date getDate() {
		return mainPanel.getDate1();
	}
	
	
	public boolean isDateFlag () {
		return mainPanel.isDate1Flag();
	}
	
	
	public void setDateFlag (boolean dateFlag) {
		mainPanel.setDate1Flag(dateFlag);
	}
	
	
	public void createDatePicker() {
		this.datePickerPanel = new DatePickerPanel(this);
	}
	
	
	public void createHistoryPanel() {
		this.historyPanel = new HistoryPanel(this);
	}
	
	
	public void createCategoriesPanel() {
		this.categoriesPanel = new CategoriesPanel(this, model.list);
	}
	
	
	public void changePanel(JPanel panel) {
		window.changePanel(panel);
	}
	
	
}

