import java.util.LinkedList;
import java.util.Random;

/**
 * @author gravoo
 * 
 */
public final class Bot extends Player {

	/**
	 * @param args
	 */

	Bot(String name, int casch) {
		this.ilosc_kart = 0;
		karty_na_reku = new LinkedList<Card>();
		this.nazwa_gracza = name;
		randomizer = new Random();
		money=casch;

	}

	public Boolean pragnienie() {
		Boolean poz = randomizer.nextBoolean();
		if (poz)
			return true;
		return false;
	}

	public short wymien_karty() {
		int i = 0;
		short poz = (short) randomizer.nextInt(4);
		while (i < poz) {
			karty_na_reku.remove();
			ilosc_kart--;
			i++;
		}
/**test**/
		return poz;

	}

	public void make_move() {
		Move.make_move(this);
	}

	@Override
	public Boolean zagrano_all_in() {
		// TODO Auto-generated method stub
		return null;
	}

}
