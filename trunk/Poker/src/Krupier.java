import java.util.Random;

/**
 * Klasa Krupier odpowiada za tasowanie, rozdawanie i przyjmowanie kart od
 * graczy
 * 
 * 
 */
public class Krupier extends Deck {
	/**
	 * @param deck
	 *            obiekt reprezentujacy talie kart
	 */
	Deck deck;
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

	Krupier() {
		deck = new Deck();
		ilosc_kart_wydanych = 0;
		random = new Random();
		// rozmiar=52;
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
		help = deck.deck_of_cards.get(karta);
		deck.deck_of_cards.remove(karta);
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

	public Player ustal_zwyciezce(Player players[]) {
		int size = players.length - 1;
		System.out.println("ilosc graczy"+size);
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size-i; j++) {
				if (players[j-1].get_conf_weight() > players[j].get_conf_weight()) {
					Player temp = players[j-1];
					players[j-1] = players[j];
					players[j] = temp;
				}
			}
			
		}
		if (players[0].get_conf_weight() == players[1].get_conf_weight()) {
			if (players[0].get_card_weight() < players[1].get_card_weight()) {
				return players[1];
			} else if ((players[0].get_card_weight() == players[1]
					.get_card_weight())
					&& (players[0].get_highest_card().get_Picture() == players[1]
							.get_highest_card().get_Picture())) {
				remis=true;
				return null;
						
			}
			return players[0];
		}

		return players[0];
	}

	public void przyjmij_karte(Card card) {
		deck.deck_of_cards.addLast(card);

	}

}



