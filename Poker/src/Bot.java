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
public Boolean pragnienie(){
	Boolean poz=randomizer.nextBoolean();
	if(poz) return true;
	return false;
}

public short wymien_karty() {
		int i=0;
		short poz=(short)randomizer.nextInt(4);
		while(i<poz){
			karty_na_reku.remove();
			ilosc_kart--;
			i++;
		}
		
		
		return poz;
		
	}

	
}

	


