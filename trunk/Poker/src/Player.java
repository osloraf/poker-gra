import java.util.LinkedList;

/**
 * 
 */

/**
 * @author rafal
 *
 */
public abstract class Player {
	private int money;
	protected int ilosc_kart;
	public String nazwa_gracza;
	protected LinkedList<Card> karty_na_reku;
	/**
	 * Funkcja przyjmuje karty od krupiera i zapisuje je w tablicy
	 * @param karta karta
	 * @param poz	ilosc kart na reku
	 */
	public abstract void get_card(Card karta);
	protected abstract int uklad();
	public abstract int nr_ukladu();
	public abstract void wymien_karty(short poz);
	abstract void draw();
	public abstract String get_name();

}
