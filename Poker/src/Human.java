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

	Scanner odczyt = new Scanner(System.in);

	Human(String name, int casch) {
		this.ilosc_kart = 0;
		this.karty_na_reku = new LinkedList<Card>();
		nazwa_gracza = name;
		this.money = casch;
	}

	/**
	 * Funkcja odpowiedzialna za wymienianie kart od gracza (pomylko odporna)
	 * 
	 * @return jesli ilosc to wszystko w normie jesli -1 to blad wprowadzania
	 *         danych
	 */

	public int wymien_karty() {

		System.out.print("Czy chcesz wymienic karty y/n ");
		String decyzja;
		decyzja = odczyt.next();
		int ilosc = 0;
		if (decyzja.startsWith("y")) {
			try {
				System.out.print("\nPodaj ile kart chcesz wymienic, 0-4: ");
				ilosc = odczyt.nextInt();
			} catch (InputMismatchException zly_index) {
				System.out
						.println("Cos ci nie wyszlo, sprÃ³buj jeszcze raz\n ");
				// odczyt.close();
				return -1;

			}
			if (ilosc >= ilosc_kart) {
				// odczyt.close();
				return -1;
			}
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
			// odczyt.close();
			return -1;
		}
		return ilosc;
	}

	@Override
	public void make_move() throws Exception {
		System.out.println("Obecne zak³ady to:");
		Krupier.show_bets();
		System.out
				.println("\nPodaj jaki ruch chcesz wykonac\n1.Czekaj \n2.Zloz zaklad \n3."
						+ "Przebij zaklad \n4.Wyrownaj zaklad \n5.Poddaj sie \n6.Zagraj va-bank");
		int decision = odczyt.nextInt();
		switch (decision) {
		case 1:
			check();
			break;
		case 2:
			bet(1);
			break;
		case 3:
			raise(1);
			break;
		case 4:
			call();
			break;
		case 5:
			fold();
			break;
		case 6:
			all_in();
			break;
		}
	}

	@Override
	public Boolean zagrano_all_in() {
		System.out
				.println("Jeden z graczy zagra³ All-in. Czy chcesz wejsc do gry, ryzykuj¹c utratê wszystkich swoich ¿etonów, lub te¿ spasowaæ i straciæ swój"
						+ "ca³y zaklad, ktory postawiles w obecnym rozdaniu, dla przypomnienia to "
						+ this.bet.getMoney()
						+ ".Pamietaj ze w przypadku wygrania rozgrywki przez"
						+ "gracza z mniejsza iloscia srodkow stracisz tylko tyle ile on posiada. Jaka decyzja? Grasz, czy nie?"
						+ "\n1.GRAM!!! \n2.Jednak nie\n Wybor:");

		int wybor = odczyt.nextInt();
		if (wybor == 1)
			return true;
		return false;
	}

}
