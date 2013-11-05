import java.util.LinkedList;
import java.util.Random;


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
		randomizer=new Random();
		
	}


public short wymien_karty() {
		
		short poz=(short)randomizer.nextInt(4);
		return poz;
		
	}

	
}

	


