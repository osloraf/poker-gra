import java.util.ArrayList;
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
	protected int nr_ukladu;
	protected Random randomizer;

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
		int i = 0, j, t = 0;
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

	public abstract void wymien_karty();

	/**
	 * wypisuje karty
	 */
	public void draw() {
		for (int i = 0; i < ilosc_kart; i++) {
			Card karta = karty_na_reku.get(i);
			karta.draw();

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
		private static int last_checked_card;

		public static int check_conf(LinkedList<Card> cards) {
			if (cards.size() != 5)
				return -1;
			last_checked_card = 0;

			if (check_double(cards)) {
				System.out.print("masz pare");
			}
			if (check_triple(cards)) {

			}

			return 0;
		}

		/**
		 * Sprawdza czy w uk�adzie jest para
		 * 
		 * @return Prawda jak jest
		 */
		private static Boolean check_double(LinkedList<Card> cards) {
			for (int i = 0; i < 4; i++) {
				if (cards.get(i).get_Picture() == cards.get(i + 1)
						.get_Picture()) {
					return true;
				}

			}
			return false;

		}

		private static Boolean check_dwo_double(LinkedList<Card> cards) {
			return null;

		}

		private static Boolean check_triple(LinkedList<Card> cards) {
			for (int i = 0; i < 3; i++) {
				if ((cards.get(i).get_Picture() == cards.get(i + 1)
						.get_Picture())
						&& (cards.get(i + 1).get_Picture() == cards.get(i + 2)
								.get_Picture()))
					return true;
			}
			return false;

		}

		private static Boolean check_strit(LinkedList<Card> cards) {
			return null;

		}

		private static Boolean check_color(LinkedList<Card> cards) {
			return null;

		}

		private static Boolean check_full(LinkedList<Card> cards) {
			return null;

		}

		private static Boolean check_four(LinkedList<Card> cards) {
			return null;

		}

		private static Boolean check_poker(LinkedList<Card> cards) {
			return null;

		}

	}

}
