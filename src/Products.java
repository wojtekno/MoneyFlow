import java.util.Random;
import java.util.Scanner;

public class Products {
	private float cost;
	private String date;
	Random generator;
	Scanner scan;

	Products() {
		scan = new Scanner(System.in);
		generator = new Random();
		this.cost = 30 * generator.nextFloat();
		this.date = (generator.nextInt(11) + 1) + "/" + (generator.nextInt(30) + 1);

	}

	void nextPurchase() {
		generator = new Random();
		this.cost = 30 * generator.nextFloat();
		this.date = (generator.nextInt(11) + 1) + ":" + (generator.nextInt(30) + 1);
		// System.out.println("You paid: " + cost + " on " + date );
	}

	public String toString() {
		return date + " you paid " + cost + " pln for " + this.getClass();
	}

	float getCost() {
		return this.cost;
	}

	void setCost(float cost) {
		this.cost = cost;
	}

	String getDate() {
		return date;
	}

	void setDate(String date) {
		this.date = date;
	}

}
// tworzysz liste, 50 obiektow, sprawdzic kazdy obiekt, czy koszt wiekszy niz 5
// rob klase abstrakcyjna/ interface zeby jaknajkrocej, zrob liste do ktorej
// powrzucasz te obiekty,
// metode - ktora dostaje obiekt wyciagniety z listy, i wypisuje, wypisywanie w
// petli
// niech ta metoda bedzie bedzie w nowej klasie
// for robi liste i nie wypisuje
// metoda bierze wobiekt i wypiuje
// przyjmuje rodzica
// zminiejszyc ilosc kodu + wykorzystac dziedziczeni zeby obiekty jako jeden typ