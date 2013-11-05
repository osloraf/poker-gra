import java.util.LinkedList;

/**
 * 
 */

/**
 * Klasa reprezentujaca gracza w grze
 * @author rafal
 *
 */
public final class Human extends Player {
	
	
	Human(String name){
		this.ilosc_kart=0;
		this.karty_na_reku=new LinkedList();
		nazwa_gracza=name;
	}

	/* (non-Javadoc)
	 * @see Player#wymien_karty()
	 */
	@Override
	public void wymien_karty(short poz) {
		karty_na_reku.remove(poz);
	}

	

	

}

	





