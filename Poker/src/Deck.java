import java.util.LinkedList;
/**
 * Klasa Deck odpowiada za wypelnienie talii kartami
 * @author gravoo
 *
 */
public class Deck {
	protected LinkedList<Card> deck_of_cards;
/**
 * Konstruktor nadaje kazdej karcie wartosci a potem dopasowuje jej kazdy z 4 kolorow
 */
	Deck() {
		// figura, kolor, obrazek
		for (short i = 2; i < 14; i++) {
			for (short j = 0; j < 4; j++)
				deck_of_cards.add(new Card(i, j, (short) 0));}
		
	}

}
