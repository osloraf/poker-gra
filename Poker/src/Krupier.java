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
	/**
	 * @param ilosc_kart_wydanych liczba kart wsrod graczy
	 */
	short ilosc_kart_wydanych;
	/**
	 * @param rozmiar rozmiar talii 
	 */
	int rozmiar=52;
	Krupier() {
		deck = new Deck();
		ilosc_kart_wydanych=0;
		random = new Random();
		//rozmiar=52;
	}

	/**
	 * Funkcja losujaca karte z talii 
	 * @return zwraca wylosowaną kartę
	 */
	public Card wydaj_karte() {
		int karta=random.nextInt(rozmiar-ilosc_kart_wydanych);
		ilosc_kart_wydanych++;
		Card help=null;
		help= deck.deck_of_cards.get(karta);
		deck.deck_of_cards.remove(karta);
		return help;

	}

	public void przyjmij_karte(Card card) {
		deck.deck_of_cards.addLast(card);
		

	}

}
