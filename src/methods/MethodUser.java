// create enumPurch which runs all the enumtypes

package methods;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

import javax.swing.JTextArea;

import products.Product;
import products.Category;

public class MethodUser {
	public static int numberOfPurchaseFinger;

	public static void categoryPurchuse(List<Product> list, float cost, String selectedProduct) {
		for (Category item : Category.values()) {
			if (selectedProduct.equals(item.getLabel())) {
				list.add(new Product(item.getLabel(), cost));
			}
			;

		}

	}

	// public static void nextPurchase(List<Product> list, float cost, String
	// selectedProduct) {
	// switch (selectedProduct) {
	// case "Treats":
	// list.add(new Treat(cost));
	// numberOfPurchaseFinger++;
	// break;
	// case "Food":
	// list.add(new Food(cost));
	// numberOfPurchaseFinger++;
	// break;
	// // why do I have to import Edu?
	// case "Edu":
	// list.add(new Edu(cost));
	// numberOfPurchaseFinger++;
	// break;
	// case "Entertainment":
	// list.add(new Entertainment(cost));
	// break;
	// case "Expense":
	// list.add(new Expense(cost));
	// break;
	// case "Transport":
	// list.add(new Transport(cost));
	// break;
	//
	// }
	// }
	//
	public static void nextPurchase(List<Product> list, float cost, String selectedProduct, Date date1) {
		for (Category item : Category.values()) {
			if (selectedProduct.equals(item.getLabel())) {
				list.add(new Product(item.getLabel(), cost, date1));
			}
			;

		}
	}

	// change it so it allows to save only 2 decimals
	public static String sumExpenses(List<Product> list) {
		float sum = 0;

		for (Product item : list) {
			sum += item.getCost();
		}

		// return "Total: " + String.valueOf(sum);
		return String.format("\nTotal %.2f", sum);
	}

	public static String sumCategories(List<Product> list) {
		String s = "";
		float[] totals = new float[Category.values().length];
		for (Product item : list) {
			int i = 0;
			for (Category cat : Category.values()) {
				if (item.getLabel().equals(cat.getLabel())) {
					totals[i] += item.getCost();
				}
				i++;
			}
		}
		
		int j = 0;
		for (Category cat : Category.values()) {

			s += String.format("%s\t%.2f\n", cat.getLabel(), totals[j]);
			j++;
		}
		s += sumExpenses(list);
		return s;
	}

	// hot to do it smart, scallable?
	public static String sumCategories1(List<Product> list) {
		float foodSum = 0, eduSum = 0, expenseSum = 0, treatsSum = 0;
		float transportSum = 0, entertainmentSum = 0;
		Iterator<Product> itr = list.iterator();
		while (itr.hasNext()) {
			Product item = itr.next();
			if (item.getLabel().equals(Category.FOOD.getLabel())) {
				foodSum += item.getCost();
			} else if (item.getLabel().equals(Category.TRREATS.getLabel())) {
				treatsSum += item.getCost();
			} else if (item.getLabel().equals(Category.EDU.getLabel())) {
				eduSum += item.getCost();
			} else if (item.getLabel().equals(Category.EXPENSES.getLabel())) {
				expenseSum += item.getCost();
			} else if (item.getLabel().equals(Category.TRANSPORT.getLabel())) {
				transportSum += item.getCost();
			} else if (item.getLabel().equals(Category.ENTERTAIN.getLabel())) {
				entertainmentSum += item.getCost();
			}
		}
		return String
				.format("Food: %.2f\nTreats: %.2f\nEdu: %.2f\nExpenses: %.2f\nTransport: %.2f\nEntertainment: %.2f\n\n"
						+ sumExpenses(list), foodSum, treatsSum, eduSum, expenseSum, transportSum, entertainmentSum);

	}

	public static List<Product> getProductsFromChoosenCategory(String selectedProduct, List<Product> list) {
		List<Product> productsFromCategory = new ArrayList<Product>();
		for (Product item : list) {
			if (item.getLabel().equals(selectedProduct)) {
				productsFromCategory.add(item);
			}
		}
		return productsFromCategory;
	}

	public static void printProductsFromChoosenCategory(JTextArea textArea, List<Product> list) {
		for (Product item : list) {
			textArea.append(
					String.format("%d) %.2f\t%s\n", (list.indexOf(item) + 1), item.getCost(), item.printDate1(null)));

		}
	}

	public static void printHistoryPanel(JTextArea textArea, List<Product> list) {
		for (Product item : list) {
			// textArea.append(String.format("%d) %.2f\t%s\t%s\n"
			// ,(list.indexOf(item)+1), item.getCost(), item.getLabel(),
			// item.printDate1(null)));
			textArea.append(String.format("%d) %s", (list.indexOf(item) + 1), item.toString()));
		}
	}

	// public static void nextPurchaseOfFood(List<Product> list, float cost) {
	//
	// list.add(new Food(cost));
	// numberOfPurchaseFinger++;
	// }
	//
	// public static void nextPurchaseOfFood(List<Product> list, float cost,
	// String date) {
	//
	// list.add(new Food(cost, date));
	// numberOfPurchaseFinger++;
	// }
	//
	// public static void nextPurchuseOfTreat(List<Product> list, float cost) {
	// list.add(new Treat(cost));
	// numberOfPurchaseFinger++;
	// }

	// public static void nextPurchuseOfTreat(List<Product> list, float cost,
	// Date date1) {
	// list.add(new Treat(cost, date1));
	// numberOfPurchaseFinger++;
	// }

	public String printName() {
		// String name = this.getClass().getName();
		return this.getClass().getName();
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
