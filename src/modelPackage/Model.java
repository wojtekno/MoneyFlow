// unify methods in terms of returning types and objects you put inside
// should they be static?

package modelPackage;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

import javax.swing.JTextArea;

import products.Product;
import products.Category;

public class Model {

	// list that stores all the bought items
	private ArrayList<Product> listOfBoughtProducts;
	public static int numberOfPurchaseFinger;

	public Model() {
		listOfBoughtProducts = new ArrayList<Product>();
	}

	public List<Product> getListOfBoughtProducts() {
		return listOfBoughtProducts;
	}

	/*
	 * main method which lets us save products to the list
	 */
	public void nextPurchase(String selectedProduct, float cost, Date date1) {
		for (Category item : Category.values()) {
			if (selectedProduct.equals(item.getLabel())) {
				listOfBoughtProducts.add(new Product(item.getLabel(), cost, date1));
			}
		}
	}

	/*
	 * prints all bought products
	 */
	public static void printAllProducts(JTextArea textArea, List<Product> list) {
		for (Product item : list) {
			// textArea.append(String.format("%d) %.2f\t%s\t%s\n"
			// ,(list.indexOf(item)+1), item.getCost(), item.getLabel(),
			// item.printDate1(null)));
			textArea.append(String.format("%d) %s", (list.indexOf(item) + 1), item.toString()));
		}
	}

	/*
	 * it prints total cost of all products
	 */
	// change it so it allows to save only 2 decimals
	public static String sumExpenses(List<Product> list) {
		float sum = 0;
		for (Product item : list) {
			sum += item.getCost();
		}
		// return "Total: " + String.valueOf(sum);
		return String.format("\nTotal %.2f", sum);
	}

	/*
	 * prints total cost of each category
	 */
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

	/*
	 * prints all products from a chosen category
	 */
	public static void printProductsFromChoosenCategory(JTextArea textArea, List<Product> list) {
		for (Product item : list) {
			textArea.append(
					String.format("%d) %.2f\t%s\n", (list.indexOf(item) + 1), item.getCost(), item.printDate1(null)));

		}
	}

	/*
	 * 
	 * whole list of methods I used to use before changes in the project
	 * 
	 */
	public void buyItemNew(float cost, String selectedProduct, Date date1) {
		for (Category item : Category.values()) {
			if (selectedProduct.equals(item.getLabel())) {
				listOfBoughtProducts.add(new Product(item.getLabel(), cost, date1));
			}
		}
	}

	public static void categoryPurchuse(List<Product> list, float cost, String selectedProduct) {
		for (Category item : Category.values()) {
			if (selectedProduct.equals(item.getLabel())) {
				list.add(new Product(item.getLabel(), cost));
			}
		}
	}

	// hot to do it smart, scallable?
	public static String sumCategoriesOld(List<Product> list) {
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

	/*
	 * prints all products from a category - selecetedProduct
	 */
	public static List<Product> getProductsFromChoosenCategory(String selectedProduct, List<Product> list) {
		List<Product> productsFromCategory = new ArrayList<Product>();
		for (Product item : list) {
			if (item.getLabel().equals(selectedProduct)) {
				productsFromCategory.add(item);
			}
		}
		return productsFromCategory;
	}

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
