import java.util.Scanner;

/**
 * 
 */

/**
 * @author rafal Klasa bÄ™dzie odpowiedzialna za wyswietlanie kard i wszystkiego
 *         co dzieje siÄ™ na stole
 */
public class Table {

	static int ilosc_graczy;
	/**
	 * gracze, którzy graj¹ w aktualnej grze, bez tych co powiedzieli pas
	 */
	static Player[] players;
	/**
	 * tworzy zbiór graczy, którzy graj¹ waktualnej sesji gry
	 */
	static Player[] gracze_w_grze;
	private Bot[] boty;
	private Human human;
	private Krupier kr;
	private Scanner odczyt2 = new Scanner(System.in);

	Table(int gracze) {

		ilosc_graczy = gracze;
		players = new Player[ilosc_graczy];
		boty = new Bot[ilosc_graczy - 1];

	}

	public static Player[] get_players() {
		return players;
	}

	/**
	 * Odpowiada za sesje przy stole, czyli za kilka gier
	 */
	public void new_sesion() {

		System.out.println("Podaj swoj nick\n");

		String imie = odczyt2.nextLine();

		int ilosc_kasy = 50;

		human = new Human(imie, ilosc_kasy);

		players[0] = human;
		for (int i = 1; i < ilosc_graczy; i++) {
			boty[i - 1] = new Bot("bot_" + i, ilosc_kasy);
			players[i] = boty[i - 1];
		}

		gracze_w_grze = new Player[ilosc_graczy];

		kr = new Krupier(ilosc_graczy);
		do {
			for (int i = 0; i < gracze_w_grze.length; i++) {
				gracze_w_grze[i] = players[i];
			}
			ilosc_graczy = gracze_w_grze.length;
			rozgrywka(); // odpala now¹ rozgeywkê
			kr.reset(); // resetuje ustawienia krupiera
			odczyt2.reset();
			wyswietl_ranking();
		} while (ilosc_graczy > 1);
		System.out.println("Dziêkujemy za grê");
		odczyt2.close();

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
		int obecny_gracz = 0;
		do {
			for (; obecny_gracz < ilosc_graczy; obecny_gracz++) {

				try {
					players[obecny_gracz].make_move();
				} catch (Exception e) {

					zwyciezca_przed_czasem(obecny_gracz);
					koniec_parti();
					break;
				}

			}
			obecny_gracz = obecny_gracz % ilosc_graczy;
		} while (!zaklady_rowne());

		/*
		 * 1 licytacja
		 */

		// licytuj()

		// wymiana kart
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
		// koniec wymiany kart

		/*
		 * 2 licytacja
		 */
		if (obecny_gracz != 0)
			obecny_gracz++;
		obecny_gracz = obecny_gracz % ilosc_graczy;

		do {
			for (; obecny_gracz < ilosc_graczy; obecny_gracz++) {

				try {
					players[obecny_gracz].make_move();
				} catch (Exception e) {

					if (e.getMessage().equals("end")) {
						zwyciezca_przed_czasem(obecny_gracz);
						koniec_parti();
					}
				}

			}
			obecny_gracz = obecny_gracz % ilosc_graczy;
		} while (!zaklady_rowne());

		// wyniki

		for (int i = 0; i < ilosc_graczy; i++) {
			players[i].check_cards();
		}
		koniec_parti();

		

	}

	private void zwyciezca_przed_czasem(int nr_gracza) {
		for (int i = 0; i < gracze_w_grze.length; i++) {
			players[nr_gracza].money += players[i].bet.getMoney();
			if (nr_gracza != i)
				players[i].money -= players[i].bet.getMoney();
		}

	}
	private void koniec_parti()
	{
		System.out.println("\n\nWygral gracz "
				+ kr.ustal_zwyciezce(players).nazwa_gracza + " !!!!");

		for (int i = 0; i < ilosc_graczy; i++) {
			System.out.print("\n\nKarty Gracza: " + players[i].nazwa_gracza
					+ ":\n");
			players[i].draw();
		}
	}

	/**
	 * Usuwa gracza z sesji gry
	 * 
	 * @param player_name
	 *            Gracz do usuniêcia
	 */
	public void delete_player(String player_name) {
		for (int i = 0; i < ilosc_graczy; i++) {
			if (players[i].nazwa_gracza.equals(player_name)) {
				if (i == 0) {
					System.out
							.println("Niestety zrezygnowales z gry, lub Cie na nia nie stac, z czego jest nam bardzo przykro. \nGra sie zakonczy");
					System.exit(0);
				}
				System.out.println("Gracz " + players[i].nazwa_gracza
						+ " zrezygnowa³ z gry, lub go na ni¹ nie staæ\n");
				players[i] = players[ilosc_graczy - 1];
				// players[ilosc_graczy-1]=null;
				ilosc_graczy--;

			}
		}
	}

	/**
	 * Wyswietla aktualny stan konta graczy
	 */
	private void wyswietl_ranking() {
		System.out.print("\n");
		for (int i = 0; i < ilosc_graczy; i++)
			System.out.println(gracze_w_grze[i].nazwa_gracza + " ma na koncie "
					+ gracze_w_grze[i].money + " ");
	}

	/**
	 * Sprawdza czy wszystkie zaklady w grze sa rowne
	 * 
	 * @return Prawda/falsz rownosci zakladow
	 */
	private Boolean zaklady_rowne() {
		int casch = 0;
		try {
			casch = players[0].bet.getMoney();
		} catch (NullPointerException e) {
			return true;
		}
		for (int i = 0; i < ilosc_graczy; i++)
			if (players[i].bet.getMoney() != casch)
				return false;
		return true;

	}

}
