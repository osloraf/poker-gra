import java.util.InputMismatchException;
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
		this.karty_na_reku = new LinkedList<Card>();
		nazwa_gracza = name;
	}

	/**
	 * Funkcja odpowiedzialna za wymienianie kart od gracza (pomylko odporna)
	 * 
	 * @return jesli ilosc to wszystko w normie jesli -1 to blad wprowadzania
	 *         danych
	 */

	public int wymien_karty() {

		System.out.print("Czy chcesz wymienic karty y/n ");
		Scanner odczyt = new Scanner(System.in);
		String decyzja;
		decyzja = odczyt.next();
		int ilosc = 0;
		if (decyzja.startsWith("y")) {
			try {
				System.out.print("\nPodaj ile kart chcesz wymienic, 0-4: ");
				ilosc = odczyt.nextInt();
			} catch (InputMismatchException zly_index) {
				System.out.println("Cos ci nie wyszlo, spróbuj jeszcze raz\n ");
				odczyt.close();
				return -1;

			}
			if (ilosc >= ilosc_kart){
				odczyt.close();
				return -1;}
			int wybor = 0;
			for (int i = 0; i < ilosc; i++) {
				draw();
				try {
					System.out.print("\n\nKtora karte chesz wymienic, 1 do: "
							+ ilosc_kart);
					wybor = odczyt.nextInt();
					if ((wybor > ilosc_kart) || (wybor <= 0)) {
						System.out.println("Nie masz karty o tym indeksie");
						i--;
					} else {
						ilosc_kart--;
						karty_na_reku.remove(wybor - 1);
					}
				} catch (InputMismatchException zly_index2) {
					System.out
							.println("To nie jest index karty, sprobuj od 0 do"
									+ ilosc_kart);
					i--;
					odczyt.nextLine();
				}
				
			}
			odczyt.close();
		} else if (decyzja.startsWith("n")) {
			odczyt.close();
			return ilosc;
		} else {
			odczyt.close();
			return -1;
		}
		return ilosc;
	}

}
