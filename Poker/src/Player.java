import java.util.ArrayList;
import java.util.LinkedList;

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

	/**
	 * Funkcja przyjmuje karty od krupiera i zapisuje je w tablicy
	 * 
	 * @param karta
	 *            karta
	 * @param poz
	 *            ilosc kart na reku
	 */
	public abstract void get_card(Card karta);

	protected abstract void arrange(); // sprawdz uklad;

	public abstract void wymien_karty(short poz);

	abstract void draw();

	public abstract String get_name();

	public static class Configurations {
		private static int last_checked_card;

		public static int check_conf(LinkedList<Card> cards) {
			if (cards.size() != 5)
				return -1;
			last_checked_card = 0;

			if (check_double(cards));
			{
				System.out.print("masz pare");
			}

			return 0;
		}

		/**
		 * Sprawdza czy w uk�adzie jest para
		 * 
		 * @return Prawda jak jest
		 */
		private static Boolean check_double(LinkedList<Card>cards)
		{
			
			for(int i=0;i<4;i++)
			{
				if(cards.get(i).get_Picture()==cards.get(i+1).get_Picture());
				return true;
			}
			return false;
			
		}

		private static Boolean check_dwo_double() {
			return null;

		}

		private static Boolean check_triple() {
			return null;

		}

		private static Boolean check_strit() {
			return null;

		}

		private static Boolean check_color() {
			return null;

		}

		private static Boolean check_full() {
			return null;

		}

		private static Boolean check_four() {
			return null;

		}

		private static Boolean check_poker() {
			return null;

		}

	}

}
