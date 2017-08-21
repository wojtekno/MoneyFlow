import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

//		Products products = new Products();
//		Food food = new Food();
//		Transport transport = new Transport();
//		Treats treats = new Treats();
//		Edu edu = new Edu();
//		Expenses expenses = new Expenses();
//		Entertainment entertainment = new Entertainment();
		Methods m = new Methods();

		m.printProducts();
//		System.out.println(products);
//		System.out.println(products.getCost());
		m.nextPurchase();
		m.printListOfXItems(m.numberOfPurchaseFinger);
		m.createListOf54();
		m.printListOfXItems(5);
//		System.out.println(products);
		m.printListMoreExpansiveThanX(10);
		m.printNumberOfPurchases();
		m.printListOfXItems(m.numberOfPurchaseFinger);
	}

}
