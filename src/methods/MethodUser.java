// create enumPurch which runs all the enumtypes


package methods;

import java.util.Date;

import java.util.Iterator;
import java.util.List;

import products.Edu;
import products.Entertainment;
import products.Expense;
import products.Food;
import products.Product;
import products.ProductsEnum;
import products.Transport;
import products.Treat;

public class MethodUser {
	public static int numberOfPurchaseFinger;
	
	public static void enumPurch(List<ProductsEnum> listE, float cost, String selectedProduct) {
		ProductsEnum item = ProductsEnum.Entertainment;
		item.setCost(cost);
		System.out.println(item.getCost());
		listE.add(item);
		
		System.out.println(item);
		
		item = ProductsEnum.Edu;
		item.setCost(66);
		System.out.println(item);
		listE.add(item);
		
		System.out.println(listE);
		
	}
	
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
		case "Edu":
			list.add(new Edu(cost));
			numberOfPurchaseFinger++;
			break;
		case "Entertainment":
			list.add(new Entertainment(cost));
			break;
		case "Expense":
			list.add(new Expense(cost));
			break;
		case "Transport":
			list.add(new Transport(cost));
			break;

		}
	}

	public static void nextPurchase(List<Product> list, float cost, String selectedProduct, Date date1) {
		switch (selectedProduct) {
		case "Treats":
			list.add(new Treat(cost, date1));
			numberOfPurchaseFinger++;
			break;
		case "Food":
			list.add(new Food(cost, date1));
			numberOfPurchaseFinger++;
			break;
		// why do I have to import Edu?
		case "Edu":
			list.add(new Edu(cost, date1));
			numberOfPurchaseFinger++;
			break;
		case "Entertainment":
			list.add(new Entertainment(cost, date1));
			break;
		case "Expense":
			list.add(new Expense(cost, date1));
			break;
		case "Transport":
			list.add(new Transport(cost, date1));
			break;

		}
	}

	// change it so it allows to save only 2 decimals
	public static String sumExpenses(List<Product> list) {
		float sum = 0;

		for (Product item : list) {
			sum += item.getCost();
		}

		// return "Total: " + String.valueOf(sum);
		return String.format("Total %.2f", sum);
	}

	public static String sumCategories(List<Product> list) {
		float foodSum = 0, eduSum = 0, expenseSum = 0, treatsSum = 0;
		float transportSum = 0, entertainmentSum = 0;
		Iterator<Product> itr = list.iterator();
		while (itr.hasNext()) {
			Product item = itr.next();
			if (item.getClass().getSimpleName().equals("Food")) {
				foodSum += item.getCost();
			} else if (item.getClass().getSimpleName().equals("Treat")) {
				treatsSum += item.getCost();
			} else if (item.getClass().getSimpleName().equals("Edu")) {
				eduSum += item.getCost();
			} else if (item.getClass().getSimpleName().equals("Expense")) {
				expenseSum += item.getCost();
			} else if (item.getClass().getSimpleName().equals("Transport")) {
				transportSum += item.getCost();
			} else if (item.getClass().getSimpleName().equals("Entertainment")) {
				entertainmentSum += item.getCost();
			}
		}
		return String.format(
				"Food: %.2f\nTreats: %.2f\nEdu: %.2f\nExpenses: %.2f\nTransport: %.2f\nEntertainment: %.2f\n\n" + sumExpenses(list), foodSum,
				treatsSum, eduSum, expenseSum, transportSum, entertainmentSum );

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

//	public static void nextPurchuseOfTreat(List<Product> list, float cost, Date date1) {
//		list.add(new Treat(cost, date1));
//		numberOfPurchaseFinger++;
//	}

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
