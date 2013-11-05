import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rafal Klasa będzie odpowiedzialna za wyswietlanie kard i wszystkiego
 *         co dzieje się na stole
 */
public class Table {

	int ilosc_graczy;
	Player[] players;

	Table(int gracze) {
		

		ilosc_graczy = gracze;
		players = new Player[ilosc_graczy];
		System.out.println(ilosc_graczy);
		Scanner odczyt = new Scanner(System.in);

		System.out.println("Podaj swoj nick\n");

		String imie = odczyt.nextLine();

		Krupier kr = new Krupier();

		Human p1 = new Human(imie);

		players[0] = p1;
		for (int i = 1; i < ilosc_graczy; i++) {
			Bot bot = new Bot("bot_" + i);
			players[i] = bot;
		}
		/**
		 * Rozdaje karty
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < ilosc_graczy; j++) {
				players[j].get_card(kr.wydaj_karte());
				}
		}
		for(int i=0;i<ilosc_graczy;i++){
			players[i].arrange();	
			
		}
		players[0].draw();
	


 // p1.wymien_karty(); b1.draw(); System.out.println("");
 
 //for (int i = 0; i < ilosc_graczy; i++) { if (b1.pragnienie()) { short ch =
 //b1.wymien_karty(); for (int j = 0; j < ch; j++) {
 //b1.get_card(kr.wydaj_karte()); } } }
 
// b1.arrange(); b1.draw();
 
// Player.Configurations.check_conf(p1.karty_na_reku); System.out.println("\n");
 // p1.draw();
 
 }
 
 }
