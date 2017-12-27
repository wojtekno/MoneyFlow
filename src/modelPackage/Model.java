/*
 * Database of the app.
 * listOfBoughtProducts stores all the bought products.
 */

// unify methods in terms of arguments and returning types 
// should they be static?  -> they cannot be static, right?!

package modelPackage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Model {

	// list that stores all the bought items
	private ArrayList<Product> listOfBoughtProducts;
	private Database database;

	public Model() {
		listOfBoughtProducts = new ArrayList<Product>();
		database = new Database();
	}
	
	public Database getDatabase() {
		return database;
	}

	/*
	 * get all products
	 */
	public ArrayList<Product> getListOfAllItems() {
		// return listOfBoughtProducts;
		// return database.selectListDate();
		listOfBoughtProducts = database.selectList();
		return database.selectList();
	}

	/*
	 * get all products from a category - selecetedProduct
	 */
	public List<Product> getListOfCategoryItems(String selectedCategory) {
		// List<Product> productsFromCategory = new ArrayList<Product>();
		// for (Product item : listOfBoughtProducts) {
		// if (item.getLabel().equals(selectedProduct)) {
		// productsFromCategory.add(item);
		// }
		// }
		// return productsFromCategory;
		return database.selectCategory(selectedCategory);
	}

	/*
	 * save products to the list TODO API, niech informuje o zmianie controller TODO
	 * Controller niech poinformuje APIRepaintText
	 */

	public void saveItem(String selectedProduct, float cost, LocalDate date) {
		// listOfBoughtProducts.add(new Product(selectedProduct, cost, date1));
		database.insertItem(selectedProduct, cost, date);
	}

	/*
	 * get sum of all items
	 */
	public float getSumOfAll() {
		return database.getSum();
	}

	/*
	 * get sum of chosen category
	 */
	public float getCategorySum(String selectedCategory) {
		return database.getCategorySum(selectedCategory);
	}

	/*
	 * prints all bought products
	 */
	public String printAllProducts() {
		String listOfAllProducts = "";
		List<Product> list = getListOfAllItems();
		for (Product item : list) {
			listOfAllProducts += String.format("%d) %s", (list.indexOf(item) + 1), item.toString());
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

	public String sumDatabase() {
		return String.format("\nTotal %.2f,", database.getSum());
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
			System.out.println(list.indexOf(item));
		}
		return s;
	}

	// creates 9*6 objects
	public void createListOf24RandomProducts() {
		for (int i = 0; i < 4; i++) {
			for (Category item : Category.values()) {
				listOfBoughtProducts.add(new Product(item.getLabel()));
			}
		}
	}
}
