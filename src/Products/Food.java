package Products;

import java.text.ParseException;
import java.util.Date;

public class Food extends Product{
	
	

	public Food(float cost) {
		super(cost);
		// TODO Auto-generated constructor stub
	}

	public Food() {
		// TODO Auto-generated constructor stub
	}
	public Food(float cost, String date) {
		super(cost, date);
	}
	
	public Food(float cost, Date date1) {
		super(cost, date1);
	}
	
}
