import java.util.Random;
/**
 * Klasa Krupier odpowiada za tasowanie, rozdawanie i przyjmowanie 
 * kart od graczy 
 * 
 *
 */
public class Krupier extends Deck {
	/**
	 * @param deck obiekt reprezentujacy talie kart
	 */
	Deck deck;
	/**
	 * @param random obiekt odpowiedzialny za losowanie
	 */
	Random random;
	short ilosc_kart_wydanych;
	int rozmiar=52-1;
	Krupier() {
		deck = new Deck();
		ilosc_kart_wydanych=0;
		//rozmiar=52;
	}

	/**
	 * 
	 */
	public Card wydaj_karte() {
		
		short karta=(short)random.nextInt(rozmiar-ilosc_kart_wydanych);
		ilosc_kart_wydanych++;
		Card help = deck.deck_of_cards.get(karta);
		deck.deck_of_cards.remove(karta);
		return help;

	}

	public void przyjmij_karte(Card card) {
		deck.deck_of_cards.add(card);
		

	}

}
