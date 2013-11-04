import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author gravoo
 *	Klasa Card reprezentuje karte
 */
public class Card{
	/**
	 * @param colop[] tablica przechowujaca znaki kolorów
	 */
	char colo[]={'T','K','R','P'};
	/**
	 * @param pictu[] tablica przechowujaca wartosci kart
	 */
	char pictu[]={'2','3','4','5','6','7','8','9','1','J','D','K','A'};
	/**
	 * @param picture figura karty od 2 do 10 i od J=11 do A=14
	 */
	private short picture;
	/**
	 * @param color kolor karty od 0 do 3 {trefl,karo,kier,pik} 
	 */
	private short color;
	/**
	 * miejsce przechowywania obrazków karty
	 */
	BufferedImage img = null;
	/**
	 * @param state stan karty {0 - w talii, 1 - u gracza, 2 do wymiany}
	 */
	private short state;
	/**
	 * Konstruktor przyjmujacy wartosc danej karty i kolor
	 * @param pic figura
	 * @param col kolor
	 * 
	 * @param stat stan karty 
	 */
	Card(short pic,short col,short stat){
		picture=pic;
		color=col;
		state=stat;
		//img=imgA;
		
	}
	public void draw(){
		System.out.println(pictu[picture-2]+" "+colo[color]+" "+state);
	}
	
	

}
