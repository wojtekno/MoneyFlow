/*
 *
 */

package modelPackage;

import java.security.PrivilegedExceptionAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Database {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:moneyflow.db";

	private Connection conn;
	private Statement stat;

	public Database() {
		try {
			Class.forName(Database.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem polaczenia");
			e.printStackTrace();
		}

		createTables();
	}

	public boolean createTables() {
		String createListOfAllItems = "CREATE TABLE IF NOT EXISTS ListOfItems (id_purchase INTEGER PRIMARY KEY AUTOINCREMENT, category varchar(255), cost FLOAT, date DATE)";

		try {
			stat.execute(createListOfAllItems);

		} catch (SQLException e) {
			System.err.println("Blad przy tworzeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertItem(String category, float cost, LocalDate date) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into ListOfItems values (NULL, ?, ?, ?);");
			prepStmt.setString(1, category);
			prepStmt.setFloat(2, cost);
			prepStmt.setDate(3, java.sql.Date.valueOf(date));
			prepStmt.execute();
			System.out.println(date);

		} catch (SQLException e) {
			System.err.println("Error when inserting Item");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * Select all items
	 */
	public ArrayList<Product> selectList() {
		ArrayList<Product> list = new ArrayList<Product>();
		int id;
		String category;
		float cost;
		LocalDate date;
		try {
			ResultSet result = stat.executeQuery("select * from ListOfItems");
			while (result.next()) {
				id = result.getInt("id_purchase");
				category = result.getString("category");
				cost = result.getFloat("cost");
				date = result.getDate("date").toLocalDate();
				list.add(new Product(category, cost, date));
//				System.out.println(list.size());
//				System.out.println(list.indexOf(null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	/*
	 * get list of items from a category
	 * 
	 * @param selectedCategory
	 */
	public List<Product> selectCategory(String selectedCategory) {
		List<Product> list = new ArrayList<Product>();
		int id;
		String category;
		float cost;
		LocalDate date;
		try {
			PreparedStatement prepStat = conn.prepareStatement("select * from ListOfItems where category = ?");
			prepStat.setString(1, selectedCategory);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				id = result.getInt("id_purchase");
				category = result.getString("category");
				cost = result.getFloat("cost");
				date = result.getDate("date").toLocalDate();
				list.add(new Product(category, cost, date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * get the sum of expenses
	 */
	public float getSum() {
		ResultSet result = null;
		try {
			PreparedStatement prepStat = conn.prepareStatement("select sum(cost) from ListOfItems");
			result = prepStat.executeQuery();
			return result.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 000;
	}
	
	/*
	 * get sum of chosen category
	 */
	public float getCategorySum(String selectedCategory) {
		ResultSet result = null;
		try {
			PreparedStatement prepStat = conn.prepareStatement("select sum(cost) from ListOfItems where category = ?");
			prepStat.setString(1, selectedCategory);
			result = prepStat.executeQuery();
			return result.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 000;
	}

	/*
	 * select items between date1 and date2
	 */
	public List<Product> selectListDate() {
		List<Product> list = new ArrayList<Product>();
		int id;
		String category;
		float cost;
		LocalDate date;
		try {
			PreparedStatement prepStat = conn.prepareStatement("select * from ListOfItems where date between ? and ?");
			prepStat.setDate(1, java.sql.Date.valueOf("2017-12-01"));
			prepStat.setDate(2, java.sql.Date.valueOf("2017-12-27"));
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				id = result.getInt("id_purchase");
				category = result.getString("category");
				cost = result.getFloat("cost");
				date = result.getDate("date").toLocalDate();
				list.add(new Product(category, cost, date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}