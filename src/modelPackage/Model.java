/*
 * Database of the app.
 * listOfBoughtProducts stores all the bought products.
 */

// unify methods in terms of arguments and returning types 
// should they be static?  -> they cannot be static, right?!

package modelPackage;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import products.Category;
import products.Product;

public class Model {

	// list that stores all the bought items
	private ArrayList<Product> listOfBoughtProducts;

	public Model() {
		listOfBoughtProducts = new ArrayList<Product>();
	}

	public List<Product> getListOfBoughtProducts() {
		return listOfBoughtProducts;
	}

	/*
	 * main method, saves products to the list TODO API, niech informuje o zmianie
	 * controller TODO Controller niech poinformuje APIRepaintText
	 */

	public void nextPurchase(String selectedProduct, float cost, Date date1) {
		listOfBoughtProducts.add(new Product(selectedProduct, cost, date1));

		// for (Category item : Category.values()) {
		// if (selectedProduct.equals(item.getLabel())) {
		// listOfBoughtProducts.add(new Product(item.getLabel(), cost, date1));
		// }
		// }
	}

	/*
	 * prints all bought products
	 */
	public String printAllProducts() {
		String listOfAllProducts = "";
		for (Product item : listOfBoughtProducts) {
			listOfAllProducts += String.format("%d) %s", (listOfBoughtProducts.indexOf(item) + 1), item.toString());
		}
		return listOfAllProducts;
	}

	/*
	 * prints total cost of all products
	 * 
	 * TODO change it so it allows to save only 2 decimals
	 */
	public String sumExpenses(List<Product> list) {
		float sum = 0;
		for (Product item : list) {
			sum += item.getCost();
		}
		return String.format("\nTotal %.2f", sum);
	}

	/*
	 * print total of a chosen category
	 */
	public String sumChosenCategory(List<Product> list) {
		float sum = 0;
		for (Product item : list) {
			sum += item.getCost();
		}
		return String.format("\nTotal %.2f", sum);
	}

	/*
	 * prints total cost of each category
	 */
	public String sumCategories() {
		String s = "";
		float[] totals = new float[Category.values().length];
		for (Product item : listOfBoughtProducts) {
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
		s += sumExpenses(listOfBoughtProducts);
		return s;
	}

	/*
	 * prints all products from a chosen category
	 */
	public String printProductsFromChoosenCategory(List<Product> list) {
		String s = "";
		for (Product item : list) {
			s += (String.format("%d) %.2f\t%s\n", (list.indexOf(item) + 1), item.getCost(), item.printDate1(null)));
		}
		return s;
	}

	/*
	 * get all products from a category - selecetedProduct
	 */
	public List<Product> getProductsFromChoosenCategory(String selectedProduct) {
		List<Product> productsFromCategory = new ArrayList<Product>();
		for (Product item : listOfBoughtProducts) {
			if (item.getLabel().equals(selectedProduct)) {
				productsFromCategory.add(item);
			}
		}
		return productsFromCategory;
	}

	// creates 9*6 objects
	public void createListOf24RandomProducts()  {
			for (int i = 0; i < 4; i++) {
				for (Category item : Category.values()) {
					listOfBoughtProducts.add(new Product(item.getLabel()));	
				}
			}
	}
}
