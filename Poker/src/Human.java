import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/**
 * Klasa reprezentujaca gracza w grze
 * 
 * @author rafal
 * 
 */
public final class Human extends Player {

	Human(String name) {
		this.ilosc_kart = 0;
		this.karty_na_reku = new LinkedList();
		nazwa_gracza = name;
	}

/**
 * Funkcja odpowiedzialna za wymienianie kart od gracza 
 * @return jesli ilosc to wszystko w normie jesli -1 to blad wprowadzania danych
 */

	public int wymien_karty(){
		
		System.out.print("Czy chcesz wymienic karty y/n ");
		Scanner odczyt = new Scanner(System.in);
		String decyzja;
		decyzja = odczyt.next();
		int ilosc = 0;
		if (decyzja.startsWith("y")) {
			System.out.print("\nPodaj ile kart chcesz wymienic, 0-4: ");
			ilosc = odczyt.nextInt();
			int wybor = 0;
			for (int i = 0; i < ilosc; i++) {
				draw();
				System.out.print("\n\nKtora karte chesz wymienic: ");
				wybor = odczyt.nextInt();
				ilosc_kart--;
				karty_na_reku.remove(wybor - 1);
			}
		}
		else if(decyzja.startsWith("n")) return ilosc;
		else return -1;
		return ilosc;
	}

}
