package products;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public abstract class Product {
	private float cost;
//	private String date;
	private Date date1;
	private String time = "";
	Random generator;
	Scanner scan;
	DateTimeFormatter formatter;
	Calendar calendar = Calendar.getInstance();
	String dateFormat = "dd-MM-yy";
	SimpleDateFormat sformat = new SimpleDateFormat(dateFormat);

	protected Product() {
		generator = new Random();
		int year = generator.nextInt(2) + 2016;
		int dayOfYear = generator.nextInt(365) + 1;

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		this.date1 = calendar.getTime();
		this.cost = (30 * generator.nextFloat());

		// this.time = "";
		// this.date = String.valueOf(generator.nextInt(11) + 1) + "/" +
		// String.valueOf((generator.nextInt(30) + 1));
		// this.date1 = (Date) stringToObject(date);
	}

	public Product(float cost) {
		this.cost = cost;
		LocalDateTime dateNow = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("MMM/dd");
//		this.date = dateNow.format(formatter);
		formatter = DateTimeFormatter.ofPattern("hh:mm");
		//convert time without formatter
		this.time = dateNow.format(formatter);
		this.date1 = calendar.getTime();
	}

//	public Product(float cost, String date) {
//		this.cost = cost;
//		formatter = DateTimeFormatter.ofPattern("MMM/dd");
//		this.date = date;
//		// formatter = DateTimeFormatter.ofPattern("hh:mm");
//		// this.time = dateNow.format(formatter);
//	}

	public Product(float cost, Date date1) {
		this.cost = cost;
		this.date1 = date1;
	}

	public String printDate1(Date date1) {
		return sformat.format(date1);
	}

	public Object stringToObject(String date) throws ParseException {
		return sformat.parseObject(date);
	}
	// void nextPurchase() {
	// generator = new Random();
	// this.cost = 30 * generator.nextFloat();
	// this.date = (generator.nextInt(11) + 1) + ":" + (generator.nextInt(30) +
	// 1);
	// // System.out.println("You paid: " + cost + " on " + date );
	// }

	public String toString() {
		if (this.time.equals("")) {
			return String.format(" %.2f pln\t" + this.getClass().getSimpleName() + "\t" + printDate1(date1) + "\n",
					cost);
		} else {
			return String.format(
					" %.2f pln\t" + this.getClass().getSimpleName() + "\t" + printDate1(date1) + " - " + time + "\n",
					cost);
		}
	}

	public float getCost() {
		return this.cost;
	}

	void setCost(float cost) {
		this.cost = cost;
	}

	Date getDate() {
		return date1;
	}

	void setDate(Date date1) {
		this.date1 = date1;
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