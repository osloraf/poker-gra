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
	public void wymien_karty(short poz) {
		
		karty_na_reku.remove(poz);
		
	}

	@Override
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
