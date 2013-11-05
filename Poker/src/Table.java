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
	Bot[]	boty;

	Table(int gracze) {

		ilosc_graczy = gracze;
		players = new Player[ilosc_graczy];
		boty=new Bot[ilosc_graczy-1];
		System.out.println(ilosc_graczy);
		Scanner odczyt = new Scanner(System.in);

		System.out.println("Podaj swoj nick\n");

		String imie = odczyt.nextLine();

		Krupier kr = new Krupier();

		Human p1 = new Human(imie);

		players[0] = p1;
		for (int i = 1; i < ilosc_graczy; i++) {
			boty[i-1] = new Bot("bot_" + i);
			players[i]=boty[i-1];
		}
		/**
		 * Rozdaje karty
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < ilosc_graczy; j++) {
				players[j].get_card(kr.wydaj_karte());
			}
		}
		for (int i = 0; i < ilosc_graczy; i++) {
			players[i].arrange();

		}
		players[0].draw();
	
		

		for (int i = 0; i < ilosc_graczy-1; i++) {
			if (boty[i].pragnienie()) {
				short l_kart = boty[i].wymien_karty();	//liczba kart do wymiany
				for (int j = 0; j < l_kart; j++) {
					boty[j].get_card(kr.wydaj_karte());
				}
			}
		}
		
		int do_wymiany=p1.wymien_karty();
		for(int i=0;i<do_wymiany;i++){
			p1.get_card(kr.wydaj_karte());
		}
		
		players[0].draw();
		players[0].check();
		

	}

}
