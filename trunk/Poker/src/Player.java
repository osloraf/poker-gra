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
	protected Card [] karty;
	/**
	 * Funkcja przyjmuje karty od krupiera i zapisuje je w tablicy
	 * @param karta karta
	 * @param poz	ilosc kart na reku
	 */
	public abstract void get_card(Card karta);
	protected abstract int uklad();
	public abstract int nr_ukladu();
	abstract void wymien_karty();

}
