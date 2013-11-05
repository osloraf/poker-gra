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

	@Override
	protected void arange() {
		// TODO Auto-generated method stub
		
	}

	

}
