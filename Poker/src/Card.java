import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author gravoo
 *	Klasa Card reprezentuje karte
 */
public class Card{
	/**
	 * @param picture figura karty od 2 do 10 i od J do A
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
	 * @param val wartosc
	 * @param col kolor
	 * 
	 * @param stat stan karty 
	 */
	Card(short pic,short col,short stat){
		picture=pic;
		col=col;
		state=stat;
		//img=imgA;
		
	}
	

}
