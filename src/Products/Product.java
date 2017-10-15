package Products;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Product {
	private float cost;
	private String date;
	String time;
	Random generator;
	Scanner scan;
	DateTimeFormatter formatter;
	
	public Product() {
//		scan = new Scanner(System.in);
		generator = new Random();
		this.cost = 30 * generator.nextFloat();
		this.date = (generator.nextInt(11) + 1) + "/" + (generator.nextInt(30) + 1);

	}
	public Product(float cost) {
		this.cost = cost;
		LocalDateTime dateNow = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("MMM/dd");
		this.date = dateNow.format(formatter);
		formatter = DateTimeFormatter.ofPattern("hh:mm");
		this.time = dateNow.format(formatter);
			
	}
	public Product(float cost, String date) {
		this.cost = cost;
		formatter = DateTimeFormatter.ofPattern("MMM/dd");
		this.date = date;
//		formatter = DateTimeFormatter.ofPattern("hh:mm");
//		this.time = dateNow.format(formatter);
	}

//	void nextPurchase() {
//		generator = new Random();
//		this.cost = 30 * generator.nextFloat();
//		this.date = (generator.nextInt(11) + 1) + ":" + (generator.nextInt(30) + 1);
//		// System.out.println("You paid: " + cost + " on " + date );
//	}

	public String toString() {
		return  date + " - " + time + " you paid " + cost + " pln for " + this.getClass().getSimpleName() +"\n";
	}

	public float getCost() {
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