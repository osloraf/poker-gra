import java.util.LinkedList;
import java.util.Random;

/**
 * 
 */

/**
 * @author rafal
 * 
 */
public abstract class Player {
	@SuppressWarnings("unused")
	private int money;
	protected int ilosc_kart;
	public String nazwa_gracza;
	protected LinkedList<Card> karty_na_reku;
	protected Random randomizer;
	protected int weight_conf = 0;
	protected int weight_card = 0;

	/**
	 * Funkcja przyjmuje karty od krupiera i zapisuje je w tablicy
	 * 
	 * @param karta
	 *            karta
	 * @param poz
	 *            ilosc kart na reku
	 */
	public void get_card(Card karta) {
		karty_na_reku.add(karta);
		ilosc_kart++;
	};

	/**
	 * Uklada karty w kolejnosci od najslabszej figury do najmocniejszej
	 */
	protected void arrange() {
		Card tmp;
		int i = 0, j;
		for (i = 0; i < ilosc_kart; i++) {
			for (j = 1; j < (ilosc_kart - i); j++) {
				if (karty_na_reku.get(j - 1).get_Picture() > karty_na_reku.get(
						j).get_Picture()) {
					tmp = karty_na_reku.get(j - 1);
					karty_na_reku.set(j - 1, karty_na_reku.get(j));
					karty_na_reku.set(j, tmp);
				}
			}
		}
	}

	public void check() {
		this.weight_conf = Configurations.check_conf(karty_na_reku);
		weight_card = Configurations.weight_of_card;
	}

	public int get_conf_weight() {

		return this.weight_conf;

	}

	public int get_card_weight() {

		return weight_card;
	}

	public Card get_highest_card() {
		return karty_na_reku.get(4);
	}

	/**
	 * wypisuje karty
	 */
	public void draw() {
		for (int i = 0; i < ilosc_kart; i++) {
			Card karta = karty_na_reku.get(i);
			karta.draw();
			System.out.print("; "); 

		}
	}

	/**
	 * wypisuje nazwe gracza
	 * 
	 * @return nazwa gracza
	 */

	public String get_name() {

		return nazwa_gracza;
	}

	public static class Configurations {
		public static int weight_of_card = 0;

		public static int check_conf(LinkedList<Card> cards) {
			if (cards.size() != 5)
				return -1;
			int weight_of_conf = 0;

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
					.get_Picture() != cards.get(4).get_Picture())) {
				if ((cards.get(0).get_Picture() == cards.get(1).get_Picture())
						&& (cards.get(3).get_Picture() == cards.get(4)
								.get_Picture())) {
					weight_of_card = cards.get(0).get_Picture();
					if (cards.get(4).get_Picture() > weight_of_card)
						weight_of_card = cards.get(4).get_Picture();
					return true;
				}
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

}
