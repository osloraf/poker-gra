/**
 * 
 */

/**
 * @author rafal
 *
 */
public abstract class Player {
	private int money;
	private int ilosc_kart;
	public String nazwa_gracza;
	private Card karty;
	
	
	public abstract int nr_ukladu();
	abstract void wymien_karty();

}
