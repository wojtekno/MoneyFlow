//create and define date, and to string

package products;

import java.util.Date;

public enum ProductsEnum {
	Food, 
	Transport,
	Treats,
	Edu,
	Entertainment,
	Expenses;
	
	float cost;
	Date date;
	
		
	public void setCost(float cost) {
		this.cost = cost;
	}
	public float getCost() {
		return this.cost;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return "\n" + name() + "  " + String.valueOf(this.cost);
	}
	
	
}

