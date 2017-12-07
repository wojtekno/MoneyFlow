//create and define date, and to string

package products;

import java.util.Date;

public enum Category {
	FOOD ("Food"),
	TRANSPORT ("Transportation"),
	TRREATS ("Treats"),
	EDU ("Education"),
	ENTERTAIN ("Entertainment"),
	EXPENSES ("Expenses"),
	CLOTHES ("Clothes");
	
	private String label;

	private Category(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}

