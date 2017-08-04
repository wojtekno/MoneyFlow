
public class Main {

	public static void main(String[] args) {
		
		Food food = new Food();
		Transport transport = new Transport ();
		Treats treats = new Treats();
		Edu edu = new Edu();
		Expenses expenses = new Expenses();
		Entertainment entertainment = new Entertainment();
		
		
		food.nextPurchase(15.55, "4.08");
		transport.nextPurchase(99, "1.08");
		treats.nextPurchase(33, "5/08");
		edu.nextPurchase(500, "26.07");
		expenses.nextPurchase(369, "30/07");
		entertainment.nextPurchase(35, "4/08");
		
		
	}

}
