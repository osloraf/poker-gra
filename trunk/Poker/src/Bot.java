import java.util.LinkedList;


/**
 * @author gravoo
 *
 */
public final class Bot extends Player{

	/**
	 * @param args
	 */
	
	Bot(String name){
		this.ilosc_kart=0;
		karty_na_reku=new LinkedList();
		this.nazwa_gracza=name;
		
	}


	@Override
	public void wymien_karty(short poz) {
		
		karty_na_reku.remove(poz);
		
	}

	
}

	


