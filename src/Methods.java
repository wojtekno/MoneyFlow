
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Methods {
	static Products products;
	// Food food;
	// Transport transport;
	// Treats treats;
	// Edu edu = new Edu();
	// Expenses expenses;
	// Entertainment entertainment;
	// List<Products> listOfPurchases = new ArrayList<>();
	// Scanner scan;
	static int numberOfPurchaseFinger;

	Methods() {
		// scan = new Scanner(System.in);
	}

	static void nextPurchase(List<Products> list, Scanner scan) {
		int choice;
		// do {
		System.out.println("choose what you bought\n1-food\n2treats\n\n0-close");
		choice = scan.nextInt();
		while (choice != 0) {
			if (choice == 1) {
				list.add(new Food());
			}
			if (choice == 2) {
				list.add(new Treats());
			}
			choice = scan.nextInt();
			numberOfPurchaseFinger++;
			System.out.println(numberOfPurchaseFinger);
		}
		// } while (choice != 0);

	}

	// creates 9*6 objects
	static void createListOf54(List<Products> list) {
		for (int i = 0; i < 9; i++) {
			list.add(new Food());
			list.add(new Edu());
			list.add(new Treats());
			list.add(new Entertainment());
			list.add(new Expenses());
			list.add(new Transport());
		}

	}

	static void printListOfXItems(int x, List<Products> list) {
		for (int i = 0; i < x; i++) {
			System.out.println(list.get(i));
		}
	}

	static void printListMoreExpansiveThanX(int x, List<Products> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCost() > x) {
				System.out.println(list.get(i).getCost());
			}
		}
	}

	static void printNumberOfPurchases(List<Products> list) {
		System.out.println("You made " + list.size() + " of purchases");
	}
	//how to print items from food/treats separately?
	static void printProducts(List <Products> list) {
		Iterator <Food> i = list.iterator();
		while (i.hasNext()) {
		i.next();
		
		}
	}
}
