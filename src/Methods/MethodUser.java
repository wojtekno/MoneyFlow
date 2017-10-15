package Methods;

import java.util.List;

import Products.Edu;
import Products.Food;
import Products.Product;
import Products.Treat;

public class MethodUser {
	public static int numberOfPurchaseFinger;

	public static void nextPurchase(List<Product> list, float cost, String selectedProduct) {
		switch (selectedProduct) {
		case "Treats":
			list.add(new Treat(cost));
			numberOfPurchaseFinger++;
			break;
		case "Food":
			list.add(new Food(cost));
			numberOfPurchaseFinger++;
			break;
			// why do I have to import Edu?
			 case "Edu" :
			 list.add(new Edu(cost));
			 numberOfPurchaseFinger++;
			 break;

		}
	}
	public static void nextPurchase(List<Product> list, float cost, String selectedProduct, String date) {
		switch (selectedProduct) {
		case "Treats":
			list.add(new Treat(cost, date));
			numberOfPurchaseFinger++;
			break;
		case "Food":
			list.add(new Food(cost, date));
			numberOfPurchaseFinger++;
			break;
			// why do I have to import Edu?
			 case "Edu" :
			 list.add(new Edu(cost, date));
			 numberOfPurchaseFinger++;
			 break;

		}
	}

	public static void nextPurchaseOfFood(List<Product> list, float cost) {

		list.add(new Food(cost));
		numberOfPurchaseFinger++;
	}

	public static void nextPurchaseOfFood(List<Product> list, float cost, String date) {

		list.add(new Food(cost, date));
		numberOfPurchaseFinger++;
	}

	public static void nextPurchuseOfTreat(List<Product> list, float cost) {
		list.add(new Treat(cost));
		numberOfPurchaseFinger++;
	}

	public static void nextPurchuseOfTreat(List<Product> list, float cost, String date) {
		list.add(new Treat(cost, date));
		numberOfPurchaseFinger++;
	}

	void printName() {
		String name = this.getClass().getName();
	}

	public static String printListOfItems(int numberOfPurchaseFinger, List<Product> list2) {
		for (int i = 0; i < numberOfPurchaseFinger; i++) {
			// System.out.println(list2.get(i));
			// return String.valueOf(list2.get(i));
		}
		return String.format("you %s", printListOfItems2(numberOfPurchaseFinger, list2));
	}

	public static Object printListOfItems2(int numberOfPurchaseFinger, List<Product> list2) {
		for (int i = 0; i < numberOfPurchaseFinger; i++) {
			// System.out.print(list2.get(i));
			// return list2;
		}
		return list2;
		// how to overrides toString for list2?
	}

	public static String printBoughtItem(int numberOfPurchaseFinger, List<Product> list2) {

		return String.valueOf(list2.get(numberOfPurchaseFinger - 1));
	}
}
