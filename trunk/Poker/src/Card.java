import java.awt.image.BufferedImage;


/**
 * @author gravoo Klasa Card reprezentuje karte
 */
public class Card {
	/**
	 * @param colop
	 *            [] tablica przechowujaca znaki kolorów
	 */
	String colo[] = { "Trefl", "Karo", "Kier", "Pik" };
	/**
	 * @param pictu
	 *            [] tablica przechowujaca wartosci kart
	 */
	String pictu[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Walet", "Dama",
			"Krol", "As" };
	/**
	 * @param picture
	 *            figura karty od 2 do 10 i od J=11 do A=14
	 */
	private short picture;
	/**
	 * @param color
	 *            kolor karty od 0 do 3 {trefl,karo,kier,pik}
	 */
	private short color;
	/**
	 * miejsce przechowywania obrazków karty
	 */
	BufferedImage img = null;
	/**
	 * @param state
	 *            stan karty {0 - w talii, 1 - u gracza, 2 do wymiany}
	 */
	//private short state;

	/**
	 * Konstruktor przyjmujacy wartosc danej karty i kolor
	 * 
	 * @param pic
	 *            figura
	 * @param col
	 *            kolor
	 * 
	 * @param stat
	 *            stan karty
	 */
	Card(short pic, short col) {
		picture = pic;
		color = col;
		//state = stat;
		// img=imgA;

	}
	public short get_Color()
	{
		return this.color;
	}
	public short get_Picture()
	{
		return this.picture;
		
	}

	public void draw() {
		System.out
				.print(pictu[picture - 2] + " " + colo[color]);
	}

}
