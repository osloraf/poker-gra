import java.util.LinkedList;


/**
 * @author Rafal
 * Klasa ustala wagê konfiguracji i wagê tworz¹cych j¹ kart, lub wagê karty najwy¿szej w przypadku braku uk³adu
 */
public class Check_conf {
	public static int weight_of_card = 0;

	public static int check_conf(LinkedList<Card> cards) {
		if (cards.size() != 5)
			return -1;
		int weight_of_conf = 0;
		
		weight_of_card=check_higest_card(cards);
		
		if (check_double(cards)) {
			weight_of_conf = 1;
		}
		if (check_dwo_double(cards)) {
			weight_of_conf = 2;
		}
		if (check_triple(cards)) {
			weight_of_conf = 3;
		}
		if (check_strit(cards)) {
			weight_of_conf = 4;
		}
		if (check_color(cards)) {
			weight_of_conf = 5;
		}
		if (check_full(cards)) {
			weight_of_conf = 6;
		}
		if (check_four(cards)) {
			weight_of_conf = 7;
		}
		if (check_poker(cards)) {
			weight_of_conf = 8;
		}

		return weight_of_conf;
	}

	/**
	 * Funkcja ustala najwy¿sz¹ karte jak¹ gracz posiada
	 * @param cards Lista kart
	 * @return Figura najwy¿szej karty w posiadaniu gracza
	 */
	private static short check_higest_card(LinkedList<Card> cards)
	{
		return cards.get(4).get_Picture();
	}
	
	/**
	 * Sprawdza czy w ukladzie jest para
	 * 
	 * @return Prawda jak jest
	 */
	private static Boolean check_double(LinkedList<Card> cards) {
		for (int i = 0; i < 4; i++) {
			if (cards.get(i).get_Picture() == cards.get(i + 1)
					.get_Picture()) {
				weight_of_card = cards.get(i).get_Picture();
				return true;
			}

		}
		return false;

	}


	private static Boolean check_dwo_double(LinkedList<Card> cards) {
		for (int i = 0; i < 2; i++) {
			if (cards.get(i).get_Picture() == cards.get(i + 1)
					.get_Picture()) {
				for (int j = i; j < 4; j++) {
					if ((cards.get(j).get_Picture() == cards.get(j + 1)
							.get_Picture())
							&& (cards.get(i).get_Picture() != cards.get(j)
									.get_Picture())) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static Boolean check_triple(LinkedList<Card> cards) {
		for (int i = 0; i < 3; i++) {
			if ((cards.get(i).get_Picture() == cards.get(i + 1)
					.get_Picture())
					&& (cards.get(i + 1).get_Picture() == cards.get(i + 2)
							.get_Picture())) {
				weight_of_card = cards.get(i).get_Picture();
				return true;
			}
		}
		return false;

	}

	private static Boolean check_strit(LinkedList<Card> cards) {
		short a = cards.get(0).get_Picture();
		for (int i = 0; i < 5; i++) {
			if (a + i != cards.get(i).get_Picture()) {
				return false;
			}
		}
		return true;
	}

	private static Boolean check_color(LinkedList<Card> cards) {
		short a = cards.get(0).get_Color();
		for (int i = 0; i < 5; i++) {
			if (a != cards.get(i).get_Color()) {
				return false;
			}
		}
		return true;

	}

	private static Boolean check_full(LinkedList<Card> cards) {
		if (((check_double(cards)) && (check_triple(cards)) && cards.get(0)
				.get_Picture() != cards.get(4).get_Picture())
				&& ((cards.get(0).get_Picture() == cards.get(1)
						.get_Picture()) && (cards.get(3).get_Picture() == cards
						.get(4).get_Picture()))) {
			weight_of_card = cards.get(0).get_Picture();
			if (cards.get(4).get_Picture() > weight_of_card)
				weight_of_card = cards.get(4).get_Picture();
			return true;
		}

		return false;
	}

	private static Boolean check_four(LinkedList<Card> cards) {
		for (int i = 0; i < 2; i++) {
			if ((cards.get(i).get_Picture() == cards.get(i + 1)
					.get_Picture())
					&& (cards.get(i + 1).get_Picture() == cards.get(i + 2)
							.get_Picture())
					&& (cards.get(i + 2).get_Picture() == cards.get(i + 3)
							.get_Picture())) {
				weight_of_card = cards.get(i).get_Picture();
				return true;
			}
		}

		return false;

	}

	private static Boolean check_poker(LinkedList<Card> cards) {
		if (check_color(cards) && check_strit(cards))
			return true;

		return false;

	}

}
