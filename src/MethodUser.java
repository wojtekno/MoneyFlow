import java.util.List;

public class MethodUser {
	static int numberOfPurchaseFinger;

	static void nextPurchaseOfFood(List<Product> list2) {

		list2.add(new Food());
		numberOfPurchaseFinger++;
	}

	static void nextPurchuseOfTreat(List<Product> list2) {
		list2.add(new Treat());
		numberOfPurchaseFinger++;
	}

	static String printListOfItems(int numberOfPurchaseFinger, List<Product> list2) {
		for (int i = 0; i < numberOfPurchaseFinger; i++) {
			// System.out.println(list2.get(i));
			// return String.valueOf(list2.get(i));
		}
		return String.format("you %s", printListOfItems2(numberOfPurchaseFinger, list2));
	}

	static Object printListOfItems2(int numberOfPurchaseFinger, List<Product> list2) {
		for (int i = 0; i < numberOfPurchaseFinger; i++) {
			System.out.print(list2.get(i));
			// return list2;
		}
		return list2;
		//how to overrides toString for list2?
	}

	static String printBoughtItem(int numberOfPurchaseFinger, List<Product> list2) {

		return String.valueOf(list2.get(numberOfPurchaseFinger - 1));
	}
}
