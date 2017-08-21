import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Methods {
	Food food;
	Transport transport = new Transport();
	Treats treats;
	Edu edu = new Edu();
	Expenses expenses = new Expenses();
	Entertainment entertainment = new Entertainment();
	List<Products> listOfPurchases = new ArrayList<>();
	Scanner scan;
	Random generator;
	Products products;
	int numberOfPurchaseFinger;
	Methods() {
		scan = new Scanner(System.in);
		generator = new Random();
	}

	void nextPurchase() {
		int choice;
		do {
			System.out.println("choose what you bought\n1-food\n2treats\n\n0-close");
			 choice = scan.nextInt();
		while (choice != 0) {
			if (choice == 1) {
				food = new Food();
				// food.setCost(generator.nextFloat()) ;
				// food.setDate((generator.nextInt(11) + 1) + ":" +
				// (generator.nextInt(30) + 1));
				listOfPurchases.add(food);
			}
			if (choice == 2) {
				treats = new Treats();
				// food.setCost(generator.nextFloat()) ;
				// food.setDate((generator.nextInt(11) + 1) + ":" +
				// (generator.nextInt(30) + 1));
				listOfPurchases.add(treats);
			}
			choice = scan.nextInt();
			numberOfPurchaseFinger ++;
		}
		} while (choice != 0);
		// System.out.println("You paid: " + cost + " on " + date );
	}

	 //tworzy tylko 6 objektow, czy 6*9 tylko takie same?
	 void createListOf54() {
	 for (int i = 0; i < 9; i++) {
		 food = new Food();
		 treats = new Treats();
	 listOfPurchases.add(new Food());
	 listOfPurchases.add(edu);
	 listOfPurchases.add(treats);
	 listOfPurchases.add(entertainment);
	 listOfPurchases.add(expenses);
	 listOfPurchases.add(transport);
	 }
	
	 }

	void printListOfXItems(int x) {
		for (int i = 0; i < x; i++) {
			System.out.println(listOfPurchases.get(i));
		}
	}

	void printListMoreExpansiveThanX(int x) {
		for (int i = 0; i < listOfPurchases.size(); i++) {
			if (listOfPurchases.get(i).getCost() > x) {
				System.out.println(listOfPurchases.get(i).getCost());
			}
		}
	}

	void printNumberOfPurchases() {
		System.out.println("You made " + listOfPurchases.size() + " of purchases");
	}

	void printProducts() {
		System.out.println(products);
	}
}
