
public class Main {

	public static void main(String[] args) {

		Food food = new Food();
		Transport transport = new Transport();
		Treats treats = new Treats();
		Edu edu = new Edu();
		Expenses expenses = new Expenses();
		Entertainment entertainment = new Entertainment();

		// food.nextPurchase(15.55, "4.08");
		// transport.nextPurchase(99, "1.08");
		// treats.nextPurchase(33, "5/08");
		// edu.nextPurchase(500, "26.07");
		// expenses.nextPurchase(369, "30/07");
		// entertainment.nextPurchase(35, "4/08");

		// tutaj jest dwa razy wiecej pisania ;P
		food.setCost(15.50);
		food.setDate("13/12");
		edu.setDateAndCost("12.07", 133.13);

		//nie moge zwrocic w metodzie dwoch wartosci
		System.out.println("On " + food.getDate() + " you paid: " + food.getCost() + " for food");
		System.out.println("On " + transport.date + " you paid: " + transport.cost);
		System.out.println("On " + treats.date + " you paid: " + transport.cost);
		System.out.println("On " + edu.getDate() + " you paid: " + edu.getCost() + " for edu");
		System.out.println("On " + expenses.date + " you paid: " + expenses.cost);
		System.out.println("On " + entertainment.date + " you paid: " + entertainment.cost);

	}

}
