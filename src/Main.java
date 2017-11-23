import java.util.ArrayList;



import products.Product;
import products.Category;

public class Main {

	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<Product>();
			// Methods Methods = new Methods();
		// Scanner scan = new Scanner(System.in);
		Core.getInstance().window = new Window(list);

		
	}

}
// tylko klasa tutaj - tylko wysoki przeplyw
// dwa przyciksi ktore torzą losowe obiekty, 3 przycik to yswietla te obiekty:
// swing biblioteka , dziedziczni i interfejsy
// wzorce projektowe 30/40 problemów

// okienko z przyciskiem start
// produkty w liscie rozwijanej, wybieram produkt, okienko do ceny, ok -> data w
// momentu klikniecia
// dolny lewy rog, - historia produktow -> wyswitlw okienku scrollowanym ->
// scrolllist - tez przycisk wstecz
// na dole suma wydanej kasy
// dodatkowo o sql relacyjne bazy danych - nie szukaj sql java!!! moze mysql?
// xampp -> stworz sobie baze