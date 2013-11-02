import java.util.LinkedList;
/**
 * Klasa Deck odpowiada za wypelnienie talii kartami
 * @author gravoo
 *
 */
public class Deck {
	/**
	 * talia
	 */
	protected LinkedList<Card> deck_of_cards;
/**
 * Konstruktor nadaje kazdej karcie wartosci a potem dopasowuje jej kazdy z 4 kolorow
 */
	Deck() {
		// figura, kolor, obrazek
		deck_of_cards=new LinkedList();
		for (short i = 2; i < 15; i++) {
			for (short j = 0; j < 4; j++)
				deck_of_cards.add(new Card(i, j, (short) 0));}
		
	

}}
