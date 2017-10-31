//create and define date, and to string

package products;

import java.util.Date;

public enum ProductsEnum {
	FOOD ("Food"),
	TRANSPORT ("Transportation");
//	Treats,
//	Edu,
//	Entertainment,
//	Expenses;
	
	private String label;

	public String getLabel() {
		return label;
	}

	private ProductsEnum(String label) {
		this.label = label;
	}
	
	
}

