import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 
 */

/**
 * @author gravoo
 *
 */
public class Card{
	/**
	 * @param picture figura karty od 2 do 10 i od J do A
	 */
	char picture;
	/**
	 * @param color kolor karty od 0 do 3 {kier,pik,karo,trafl} 
	 */
	char color;
	/**
	 * miejsce przechowywania obrazków karty
	 */
	BufferedImage img = null;
	/**
	 * @param state stan karty {0 - w talii, 1 - u gracza, 2 do wymiany}
	 */
	short state;
	/**
	 * Konstruktor przyjmujacy wartosc danej karty i kolor
	 * @param val wartosc
	 * @param col kolor
	 * @param imgA obrazek 
	 * @param stat stan karty 
	 */
	Card(char pic,char col,BufferedImage imgA,short stat){
		picture=pic;
		col=col;
		state=stat;
		img=imgA;
		
	}
	

}
