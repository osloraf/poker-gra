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
	 * @see Player#uklad()
	 */
	@Override
	protected int uklad() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see Player#nr_ukladu()
	 */
	@Override
	public int nr_ukladu() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see Player#wymien_karty()
	 */
	@Override
	public void wymien_karty(short poz) {
		karty_na_reku.remove(poz);
	}

	@Override
	/**
	 * funkcja przyjmuje jedna wylosowana karte od krupiera i dodaje ja do swojej
	 * prywatnej talii
	 */
	public void get_card(Card karta) {
		karty_na_reku.add(karta);
		ilosc_kart++;
	}

	@Override
	public void draw() {
		for(int i=0;i<ilosc_kart;i++){
			Card karta=karty_na_reku.get(i);
			karta.draw();
			
		}
	}

	@Override
	public String get_name() {
		
		return nazwa_gracza;
	}

}
