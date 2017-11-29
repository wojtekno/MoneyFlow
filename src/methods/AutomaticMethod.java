// create method which prints list of items from shoosen category

package methods;

import java.text.ParseException;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import products.Category;
import products.Product;

public class AutomaticMethod {
	static Product products;
	static int numberOfPurchaseFinger;

	AutomaticMethod() {
		// scan = new Scanner(System.in);
	}
	
	// creates 9*6 objects
	public static void createListOf24RandomProducts(List<Product> list)  {
		for (int i = 0; i < 4; i++) {
			for (Category item : Category.values()) {
				list.add(new Product(item.getLabel()));	
			}
			
			
		}

	}
	
	// put interactive methods in another class
	static void nextPurchase(List<Product> list, Scanner scan) throws ParseException {
		int choice = 1;

		System.out.println("choose what you bought\n1-food 2treats\n0-close");
		do {
			choice = scan.nextInt();

			if (choice == 1) {
				list.add(new Product(Category.values()[0].getLabel()));
			}
			if (choice == 2) {
				list.add(new Product(Category.values()[2].getLabel()));
			}
			if (choice != 0) {
				numberOfPurchaseFinger++;
			}
			System.out.println("anything else?");
			
			// System.out.println(numberOfPurchaseFinger);
		} while (choice != 0);
		//scan.close;

	}



	static void printListOfXItems(int x, List<Product> list) {
		for (int i = 0; i < x; i++) {
			System.out.println(list.get(i));
		}
	}

//	public static void printListMoreExpansiveThanX(int x, List<Product> list) {
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getCost() > x) {
//				System.out.println(list.get(i).getCost());
//			}
//		}
//	}

	static void printNumberOfPurchases(List<Product> list) {
		System.out.println("You made " + list.size() + " of purchases");
	}

	// how to print items from food/treats separately?
	static void printProductsIterator(List<Product> list) {
		Iterator<Product> i = list.iterator();
		while (i.hasNext()) {
			if (i.next().getLabel().equals("Food")) {
				System.out.println(i.next());
			}

		}
	}

	static void printProductsForEach(List<Product> list) {
		for (Product p : list) {
			if (p.getLabel().equals("Food")) {
				System.out.println(p);
			}
		}

	}

	static void printProductsFor(List<Product> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLabel().equals("Food")) {
				System.out.println(list.get(i));
			}
		}

	}
}
