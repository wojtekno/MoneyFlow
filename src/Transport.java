
public class Transport {

	double cost;
	String date;

	void nextPurchase(double cost, String date) {
		this.cost = cost;
		this.date = date;
		// System.out.println("You paid: " + cost + " on " + date );
	}
	double getCost() {
		return this.cost;
	}
	void setCost(double cost) {
		this.cost = cost;
	}
	String getDate() {
		return date;
	}
	void setDate(String date) {
		this.date = date;
	}

}
