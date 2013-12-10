import java.util.Scanner;

import sun.misc.Cleaner;

/**
 * 
 */

/**
 * @author rafal Klasa bÄ™dzie odpowiedzialna za wyswietlanie kard i wszystkiego
 *         co dzieje siÄ™ na stole
 */
public class Table {

	static int ilosc_graczy;
	static Player[] players;
	Bot[] boty;
	Human human;
	Krupier kr;
	Scanner odczyt = new Scanner(System.in);

	Table(int gracze) {

		ilosc_graczy = gracze;
		players = new Player[ilosc_graczy];
		boty = new Bot[ilosc_graczy - 1];
		kr = new Krupier(gracze);

	}
	
	public static Player[] get_players()
	{
		return players;
	}

	/**
	 * Odpowiada za sesje przy stole, czyli za kilka gier
	 */
	public void new_sesion() {

		System.out.println("Podaj swoj nick\n");

		String imie = odczyt.nextLine();
		
		int ilosc_kasy=50;

		human = new Human(imie, ilosc_kasy);

		players[0] = human;
		for (int i = 1; i < ilosc_graczy; i++) {
			boty[i - 1] = new Bot("bot_" + i, ilosc_kasy);
			players[i] = boty[i - 1];
		}
		short next_game = 2;
		do {

			rozgrywka();
			System.out.println("Czy chcesz zagraæ ponowie? \n1.Tak \n2.Nie");
			next_game = odczyt.nextShort();
		} while (next_game == 1);
		System.out.println("Dziêkujemy za grê");

	}

	/**
	 * Odpowiada za jedn¹ konkretn¹ rozgrywkê
	 */
	private void rozgrywka() {

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
		
		/*
		 * 1 licytacja
		 */
		
		//licytuj()
		
		for (int i = 0; i < ilosc_graczy - 1; i++) {
			if (boty[i].pragnienie()) {
				short l_kart = boty[i].wymien_karty(); // liczba kart do wymiany
				for (int j = 0; j < l_kart; j++) {
					boty[i].get_card(kr.wydaj_karte());
				}
				boty[i].arrange();
			}
		}

		int do_wymiany = human.wymien_karty();

		for (int i = 0; i < do_wymiany; i++) {
			human.get_card(kr.wydaj_karte());
		}
		
		players[0].arrange();
		players[0].draw();
		
		/*
		 * 2 licytacja
		 */
		
		// licytuj_cd();
		
		//wyniki
		
		for (int i = 0; i < ilosc_graczy; i++) {
			players[i].check();
		}

		System.out.println("\n\nWygral gracz "
				+ kr.ustal_zwyciezce(players).nazwa_gracza + " !!!!");

		for (int i = 0; i < ilosc_graczy; i++) {
			System.out.print("\n\nKarty Gracza: " + players[i].nazwa_gracza
					+ ":\n");
			players[i].draw();
		}

		odczyt.close();
	}

}
