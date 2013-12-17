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

	Scanner odczyt;
	Human(String name, int casch) {
		this.ilosc_kart = 0;
		this.karty_na_reku = new LinkedList<Card>();
		nazwa_gracza = name;
		this.money=casch;
	}

	/**
	 * Funkcja odpowiedzialna za wymienianie kart od gracza (pomylko odporna)
	 * 
	 * @return jesli ilosc to wszystko w normie jesli -1 to blad wprowadzania
	 *         danych
	 */

	public int wymien_karty() {

		System.out.print("Czy chcesz wymienic karty y/n ");
		odczyt = new Scanner(System.in);
		String decyzja;
		decyzja = odczyt.next();
		int ilosc = 0;
		if (decyzja.startsWith("y")) {
			try {
				System.out.print("\nPodaj ile kart chcesz wymienic, 0-4: ");
				ilosc = odczyt.nextInt();
			} catch (InputMismatchException zly_index) {
				System.out.println("Cos ci nie wyszlo, spróbuj jeszcze raz\n ");
				//odczyt.close();
				return -1;

			}
			if (ilosc >= ilosc_kart){
				//odczyt.close();
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
			
		} else if (decyzja.startsWith("n")) {
			
			return ilosc;
		} else {
			//odczyt.close();
			return -1;
		}
		return ilosc;
	}

	@Override
	public int make_move() {
		Krupier.show_bets();
		System.out.println("\nPodaj jaki ruch chcesz wykonac\n1.Czekaj \n2.Zloz zaklad \n3.Przebij zaklad \n4.Wyrownaj zaklad \n5.Poddaj sie \n6.Zagraj va-bank");
		int decision=odczyt.nextInt();
		switch (decision)
		{
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		}
		
		return 0;
	}

}
