import java.util.LinkedList;
import java.util.Random;

/**
 * Klasa Krupier odpowiada za tasowanie, rozdawanie i przyjmowanie kart od
 * graczy
 * 
 * 
 */
public class Krupier extends Deck {
	public Boolean remis = false;
	/**
	 * @param random
	 *            obiekt odpowiedzialny za losowanie
	 */
	Random random;
	/**
	 * @param ilosc_kart_wydanych
	 *            liczba kart wsrod graczy
	 */
	short ilosc_kart_wydanych;
	/**
	 * @param rozmiar
	 *            rozmiar talii
	 */
	int rozmiar = 52;
	public static int minimal_raise;
	private static LinkedList<Bet> bets;

	public Krupier(int gracze) {
		reset();
		ilosc_kart_wydanych = 0;
		random = new Random();
		minimal_raise = 5;
		bets = new LinkedList<Bet>();
		Bet b;
		for (int i = 0; i < Table.ilosc_graczy; i++) {
			bets.add(new Bet(Table.players[i]));
			b=bets.getLast();
			Table.players[i].setBet(b);
			Table.players[i].nr_gracza = i;
		}

		// rozmiar=52;
	}

	public static Boolean check(Player player) {
		for (int i = 0; i < Table.ilosc_graczy; i++) {
			if (bets.get(i).getMoney() != minimal_raise) {
				return false;
			}
		}
		return true;

	}

	public static Boolean call(Player player) {
		int max_bet = 0;
		int roznica;
		for (int i = 0; i < bets.size(); i++) {
			if (max_bet < Table.players[i].bet.getMoney())
				max_bet = Table.players[i].bet.getMoney();
		}
		roznica=max_bet-player.bet.getMoney();
		if (roznica>0) {
			if (player.get_money() >= roznica) {
				bets.get(player.nr_gracza).update_bet(
						roznica);
				return true;
			}

		}
		return false;

	}

	public static Boolean raise(Player player, int ile) {
		if((call(player)) &&(player.get_money()>ile))
		{
			bets.get(player.nr_gracza).update_bet(ile);
			return true;
		}
		return false;
		

	}

	public static void fold(Player player) {
		Table.players[player.nr_gracza]=Table.players[Table.players.length-1];
		

	}

	public static Boolean bet(Player player) {
		for(int i=0;i<Table.ilosc_graczy;i++)
		{
			if(bets.get(i).getMoney()!=minimal_raise)
				return false;
		}
		player.bet.update_bet(1);
		return true;

	}

	public static void all_in(Player player) {
		player.bet.czy_all_in=true;
		for(int i=0;i<Table.ilosc_graczy;i++)
		{
			if(Table.players[i].zagrano_all_in());
			{
				Table.players[i].bet.update_bet(Table.players[i].money);
			}
		}

	}

	public void reset() {
		create_Deck();
		ilosc_kart_wydanych = 0;
		bets=null;

		for (int i = 0; i < Table.ilosc_graczy; i++) {
			try {
				Table.players[i].clear_cards();
			} catch (java.lang.NullPointerException e) {

			}
		}
	}

	public void end_of_game() {
		if (ilosc_zwyciezcow(Table.players) > 1) {
			for (int i = 0; i < Table.ilosc_graczy; i++)
				bets.get(i).setMoney(0);

		} else {
			for(int i=0;i<Table.ilosc_graczy;i++)
			{
				if(Table.players[i].bet.czy_all_in)
				{
					int casch=0;
					Player zwyciezcza=ustal_zwyciezce(Table.players);
					for(int j=0;i<Table.ilosc_graczy;i++)
					{
						if(Table.players[j].bet.getMoney()>=zwyciezcza.bet.getMoney())
						{
							casch+=Table.players[i].bet.getMoney();
							Table.players[j].money+=Table.players[j].bet.getMoney()-zwyciezcza.bet.getMoney();							
						}
						else
						{
							casch+=Table.players[j].bet.getMoney();
						}
					}
					zwyciezcza.money+=casch;
					return;
				}
			}			
			int casch = 0;
			for (int i = 0; i < Table.ilosc_graczy; i++)
				casch += bets.get(i).getMoney();
			Table.players[0].money += casch;
			
		}
	}

	/**
	 * Funkcja losujaca karte z talii
	 * 
	 * @return zwraca wylosowanÄ… kartÄ™
	 */
	public Card wydaj_karte() {
		int karta = random.nextInt(rozmiar - ilosc_kart_wydanych);

		ilosc_kart_wydanych++;
		Card help = null;
		help = Deck.deck_of_cards.get(karta);
		Deck.deck_of_cards.remove(karta);
		return help;

	}

	/**
	 * Krupier przyjmuje karte i wymienia ja na inna z talii
	 * 
	 * @param poz
	 * @return
	 */
	public Card zamien_karte(short poz) {

		return null;

	}
	/**
	 * Ustala jaka wage maja konfiguracje poszczegolnych graczy
	 * @param players Gracze grajacy w grze
	 */
	public void sprawdz_konf(Player players[]) {
		for (int i = 0; i < Table.ilosc_graczy; i++) {
			players[i].weight_conf = Check_conf.check_conf(players[i]
					.get_cards());
			players[i].weight_card = Check_conf.weight_of_card;
		}
	}
	/**
	 * Ustala zwyciezce i dopisuje mu wartosc wszystkich zakladow
	 * @param players tablica grajacych w rozdaniu
	 * @return gracz, ktory wygral rozdanie
	 */
	public Player ustal_zwyciezce(Player players[]) {

		sprawdz_konf(players);
		sort_on_configuration(players);
		int wygrywajacy = ilosc_zwyciezcow(players);
		if (wygrywajacy > 1) {
			sort_on_card(players, wygrywajacy);
		}
		for(int i=1;i<Table.ilosc_graczy;i++)
		{
			players[0].money+=players[i].bet.getMoney();
			players[i].money-=players[i].bet.getMoney();
		}
		return players[0];
	}
	/**
	 * Sortuje graczy wg sily ukladu, ktory posiadaja
	 * @param players gracze grajacy w rozdaniu
	 */
	private void sort_on_configuration(Player[] players) {
		int size = players.length;

		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if (players[j - 1].get_conf_weight() < players[j]
						.get_conf_weight()) {
					Player temp = players[j - 1];
					players[j - 1] = players[j];
					players[j] = temp;
				}
			}

		}
	}
	/**
	 * Sortuje graczy wygrywajacych po najwy¿szej karcie, jezeli nie ma jednego zwyciezcy
	 * @param players
	 * @param ilosc_wygrywajacych
	 */
	private void sort_on_card(Player[] players, int ilosc_wygrywajacych) {
		int size = ilosc_wygrywajacych;

		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if (players[j - 1].get_card_weight() < players[j]
						.get_card_weight()) {
					Player temp = players[j - 1];
					players[j - 1] = players[j];
					players[j] = temp;
				}
			}

		}
	}
	/**
	 * Zawraca ilu graczy wygra³o partiê
	 * @param players Gracze aktualnie graj¹cy w rozdaniu
	 * @return Ilosc zwyciezcow wg konfiguracji
	 */
	private int ilosc_zwyciezcow(Player[] players) {
		int ilosc = 1;
		for (int i = 0; i < players.length - 1; i++) {
			if (players[i].get_conf_weight() == players[i + 1]
					.get_conf_weight()) {
				ilosc++;
			} else {
				return ilosc;
			}
		}
		return ilosc;
	}
	/**
	 * Dodaj karte zwrocon¹ przez gracza
	 * @param card karta zwrocona przez gracza
	 */
	public void przyjmij_karte(Card card) {
		Deck.deck_of_cards.addLast(card);

	}
	/**
	 * Pokaz zaklad gracza 
	 * @param index index gracza, ktorego zaklad pokazujemy
	 */
	private static void show_bet(int index) {

		System.out.println("Zak³ad gracza " + bets.get(index).gamer.get_name()
				+ " to " + bets.get(index).getMoney());
	}
	/**
	 * pokaz zaklady wszystkich graczy
	 */
	public static void show_bets() {
		for (int i = 0; i < Table.ilosc_graczy; i++)
			show_bet(i);
	}

}
