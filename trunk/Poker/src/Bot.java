
/**
 * @author gravoo
 *
 */
public final class Bot extends Player{

	/**
	 * @param args
	 */
	
	Bot(){
		this.ilosc_kart=0;
	}

	@Override
	protected int uklad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nr_ukladu() {
		// TODO Auto-generated method stub
		return 0;
	}

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
