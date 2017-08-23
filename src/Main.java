import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList <Products> list = new ArrayList<>();
//		Products products = new Products();
//		Food food = new Food();
//		Transport transport = new Transport();
//		Treats treats = new Treats();
//		Edu edu = new Edu();
//		Expenses expenses = new Expenses();
//		Entertainment entertainment = new Entertainment();
//		Methods Methods = new Methods();
		Scanner scan = new Scanner(System.in);

		
		Methods.printProducts();
//		System.out.println(products);
//		System.out.println(products.getCost());
		Methods.nextPurchase(list, scan);
		Methods.printListOfXItems(Methods.numberOfPurchaseFinger, list);
		Methods.createListOf54(list);
		Methods.printListOfXItems(9, list);
//		System.out.println(products);
		Methods.printListMoreExpansiveThanX(20, list);
		Methods.printNumberOfPurchases(list);
		Methods.printListOfXItems(Methods.numberOfPurchaseFinger, list);
		Methods.printProducts(list);
	}

}
//tylko klasa tutaj - tylko wysoki przeplyw
// dwa przyciksi ktore torzą losowe obiekty, 3 przycik to yswietla te obiekty: swing biblioteka , dziedziczni i interfejsy
//wzorce projektowe 30/40 problemów