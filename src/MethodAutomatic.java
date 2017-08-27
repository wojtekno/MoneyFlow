
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MethodAutomatic {
	static Product products;
	// Food food;
	// Transport transport;
	// Treats treats;
	// Edu edu = new Edu();
	// Expenses expenses;
	// Entertainment entertainment;
	// List<Products> listOfPurchases = new ArrayList<>();
	// Scanner scan;
	static int numberOfPurchaseFinger;

	MethodAutomatic() {
		// scan = new Scanner(System.in);
	}

	// put interactive methods in another class
	static void nextPurchase(List<Product> list, Scanner scan) {
		int choice = 1;

		System.out.println("choose what you bought\n1-food 2treats\n0-close");
		do {
			choice = scan.nextInt();

			if (choice == 1) {
				list.add(new Food());
			}
			if (choice == 2) {
				list.add(new Treat());
			}
			if (choice != 0) {
				numberOfPurchaseFinger++;
			}
			System.out.println("anything else?");
			
			// System.out.println(numberOfPurchaseFinger);
		} while (choice != 0);
		//scan.close;

	}

	// creates 9*6 objects
	static void createListOf18RandomProducts(List<Product> list) {
		for (int i = 0; i < 3; i++) {
			list.add(new Food());
			list.add(new Edu());
			list.add(new Treat());
			list.add(new Entertainment());
			list.add(new Expense());
			list.add(new Transport());
		}

	}

	static void printListOfXItems(int x, List<Product> list) {
		for (int i = 0; i < x; i++) {
			System.out.println(list.get(i));
		}
	}

	static void printListMoreExpansiveThanX(int x, List<Product> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCost() > x) {
				System.out.println(list.get(i).getCost());
			}
		}
	}

	static void printNumberOfPurchases(List<Product> list) {
		System.out.println("You made " + list.size() + " of purchases");
	}

	// how to print items from food/treats separately?
	static void printProductsIterator(List<Product> list) {
		Iterator<Product> i = list.iterator();
		while (i.hasNext()) {
			if (i instanceof Food) {
				System.out.println(i.next());
			}

		}
	}

	static void printProductsForEach(List<Product> list) {
		for (Product p : list) {
			if (p instanceof Food) {
				System.out.println(p);
			}
		}

	}

	static void printProductsFor(List<Product> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Food) {
				System.out.println(list.get(i));
			}
		}

	}
}
