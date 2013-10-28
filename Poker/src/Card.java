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
	 * Konstruktor przyjmujacy wartosc danej karty i kolor
	 * @param val wartosc
	 * @param col kolor
	 * @param imgA obrazek 
	 */
	Card(char pic,char col,BufferedImage imgA){
		picture=pic;
		col=col;
		
		img=imgA;
		
	}
	

}
