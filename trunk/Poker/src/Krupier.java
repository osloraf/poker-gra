import java.util.Random;

/**
 * Klasa Krupier odpowiada za tasowanie, rozdawanie i przyjmowanie kart od
 * graczy
 * 
 * 
 */
public class Krupier extends Deck {
	public Boolean remis = false;
	/**
	 * @param random
	 *            obiekt odpowiedzialny za losowanie
	 */
	Random random;
	/**
	 * @param ilosc_kart_wydanych
	 *            liczba kart wsrod graczy
	 */
	short ilosc_kart_wydanych;
	/**
	 * @param rozmiar
	 *            rozmiar talii
	 */
	int rozmiar = 52;
	public static int minimal_raise;
	public static Bet[] bets;

	Krupier(int gracze) {
		reset();
		ilosc_kart_wydanych = 0;
		random = new Random();
		minimal_raise = 5;
		bets = new Bet[Table.ilosc_graczy];
		for (int i = 0; i < bets.length; i++) {
			bets[i].gamer = Table.get_players()[i];
			bets[i].money = minimal_raise;
		}

		// rozmiar=52;
	}

	public void reset() {
		create_Deck();
		ilosc_kart_wydanych=0;
		
		for (int i = 0; i < Table.ilosc_graczy; i++) {
			try {
				Table.players[i].clear_cards();
			} catch (java.lang.NullPointerException e) {

			}
		}
	}

	/**
	 * Funkcja losujaca karte z talii
	 * 
	 * @return zwraca wylosowaną kartę
	 */
	public Card wydaj_karte() {
		int karta = random.nextInt(rozmiar - ilosc_kart_wydanych);

		ilosc_kart_wydanych++;
		Card help = null;
		help = Deck.deck_of_cards.get(karta);
		Deck.deck_of_cards.remove(karta);
		return help;

	}

	/**
	 * Krupier przyjmuje karte i wymienia ja na inna z talii
	 * 
	 * @param poz
	 * @return
	 */
	public Card zamien_karte(short poz) {

		return null;

	}

	public void sprawdz_konf(Player players[]) {
		for (int i = 0; i < Table.ilosc_graczy; i++) {
			players[i].weight_conf = Check_conf.check_conf(players[i]
					.get_cards());
			players[i].weight_card = Check_conf.weight_of_card;
		}
	}

	public Player ustal_zwyciezce(Player players[]) {

		sprawdz_konf(players);
		sort_on_configuration(players);
		int wygrywajacy = ilosc_zwyciezcow(players);
		if (wygrywajacy > 1) {
			sort_on_card(players, wygrywajacy);
		}

		return players[0];
	}

	private void sort_on_configuration(Player[] players) {
		int size = players.length;

		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if (players[j - 1].get_conf_weight() < players[j]
						.get_conf_weight()) {
					Player temp = players[j - 1];
					players[j - 1] = players[j];
					players[j] = temp;
				}
			}

		}
	}

	private void sort_on_card(Player[] players, int ilosc_wygrywajacych) {
		int size = ilosc_wygrywajacych;

		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if (players[j - 1].get_card_weight() < players[j]
						.get_card_weight()) {
					Player temp = players[j - 1];
					players[j - 1] = players[j];
					players[j] = temp;
				}
			}

		}
	}

	private int ilosc_zwyciezcow(Player[] players) {
		int ilosc = 1;
		for (int i = 0; i < players.length - 1; i++) {
			if (players[i].get_conf_weight() == players[i + 1]
					.get_conf_weight()) {
				ilosc++;
			} else {
				return ilosc;
			}
		}
		return ilosc;
	}

	public void przyjmij_karte(Card card) {
		Deck.deck_of_cards.addLast(card);

	}

}
