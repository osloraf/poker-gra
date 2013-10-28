import java.util.LinkedList;


public class Deck {
	LinkedList<Card> deck_of_cards;
	Deck()
	{
		//figura, kolor, obrazek
		for(short i=0;i<4;i++)
		{
			for(short j=2;j<14;j++)
				deck_of_cards.add(new Card(j,i,(short)0));
		}
	}

}
