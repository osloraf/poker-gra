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
	/**
	 * Funkcja układa karty od najwiekszej figuty do najmniejszej
	 */
	@Override
	protected void arrange() {
		Card tmp;
		int i=0, j,t=0;
		  for(i = 0; i < ilosc_kart; i++){
		  for(j = 1; j < (ilosc_kart-i); j++){
		  if(karty_na_reku.get(j-1).get_Picture() > karty_na_reku.get(j).get_Picture()){
			  tmp = karty_na_reku.get(j-1);
			  karty_na_reku.set(j-1,karty_na_reku.get(j));
			  karty_na_reku.set(j, tmp);
		  }
		  }
		  }
		
	}

	

}
