
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
	
	protected int money;
	protected int ilosc_kart;
	public String nazwa_gracza;
	protected LinkedList<Card> karty_na_reku;
	protected Random randomizer;
	public int weight_conf = 0;
	public int weight_card = 0;
	protected Bet bet;
	
	/**
	 * Funkcja ma wykonywaæ ruchy w danej turze gry gracza
	 * @return rodzaj ruchu, 0 gdy siê poddaje
	 */
	public abstract int make_move();

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
		
		this.weight_conf = Check_conf.check_conf(karty_na_reku);
		weight_card = Check_conf.weight_of_card;
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
	public LinkedList<Card> get_cards()
	{
		return this.karty_na_reku;
	}

	/**
	 * wypisuje nazwe gracza
	 * 
	 * @return nazwa gracza
	 */

	public String get_name() {

		return nazwa_gracza;
	}
	

}

