/**
 * 
 */

/**
 * Klasa reprezentujaca gracza w grze
 * @author rafal
 *
 */
public final class Human extends Player {
	
	Human(){
		this.ilosc_kart=0;
		
		
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
	void wymien_karty() {
		// TODO Auto-generated method stub

	}

	@Override
	public void get_card(Card karta) {
		this.karty[ilosc_kart]=karta;
		this.ilosc_kart++;
		
	}

}
