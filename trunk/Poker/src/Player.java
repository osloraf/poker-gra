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
	private Card [] karty;
	
	protected abstract int uklad();
	public abstract int nr_ukladu();
	abstract void wymien_karty();

}
