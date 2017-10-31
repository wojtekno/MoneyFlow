package products;

import java.util.Date;

public class Expense extends Product {

	public Expense(float cost) {
		super(cost);
	}

	public Expense(float cost, Date date1) {
		super(cost, date1);
	}

	public Expense() {
		super();
	}

}
