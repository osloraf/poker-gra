import java.util.Random;

public class Move {

	public static void make_move(Bot gracz) throws Exception {
		int move = 0;
		Boolean correct = true;
		Random rand = new Random();
		do {
		
		move = rand.nextInt(6);
		move++;
		 // zmienna do sprawdzenia czy sie udalo zlozyc
								// zaklad
		

			switch (move) {
			case 1:
				correct = gracz.check();
				break;
			case 2:
				correct = gracz.bet(1);
				break;
			case 3:
				correct = gracz.raise(1);
				break;
			case 4:
				correct = gracz.call();
				break;
			case 5:
				gracz.fold();
				correct=true;
				break;
			case 6:
				gracz.all_in();
				correct=true;
				break;
			}
		} while (!correct);
		pokaz_wynik(move, gracz);
	}

	private static void pokaz_wynik(int decyzja, Bot gracz) {
		System.out.println(gracz.nazwa_gracza + " zagral: ");
		switch (decyzja) {
		case 1:
			System.out.println("Check");
			break;
		case 2:
			System.out.println("Bet");
			break;
		case 3:
			System.out.println("Raise");
			break;
		case 4:
			System.out.println("Call");
			break;
		case 5:
			System.out.println("Fold");
			break;
		case 6:
			System.out.println("All-in");
			break;
		}
	}

	/**
	 * Okresla czy bot ma wejsc do gry po zagraniu all-in, czy jednak nie. Bot
	 * wejdzie do gry jezeli:
	 * 
	 * 1. Ma co najmniej 3 w kartach
	 * 
	 * 2. Jest najbogatszy
	 * 
	 * 3. Nie bedzie go stac na wpisowe w nastepnej kolejce
	 * 
	 * @param player
	 * @return decyzja tak/nie
	 */
	public static Boolean graj_all_in(Bot player) {
		if (Check_conf.check_conf(player.get_cards()) > 1)
			return true;
		int bet_casch = 0;
		for (int i = 0; i < Table.ilosc_graczy; i++) {
			if (Table.players[i].bet.getCzy_all_in()) {
				if (Table.players[i].bet.getMoney() > bet_casch)
					bet_casch = Table.players[i].bet.getMoney();
			}
		}
		if (player.money < Krupier.minimal_raise)
			return true;

		int max_player_money = 0;
		for (int i = 0; i < Table.ilosc_graczy; i++)
			if (Table.players[i].nr_gracza != player.nr_gracza)
				if (Table.players[i].money + Table.players[i].bet.getMoney() > max_player_money)
					max_player_money = Table.players[i].money
							+ Table.players[i].bet.getMoney();

		if ((player.money + player.bet.getMoney()) - max_player_money
				- Krupier.minimal_raise > 5)
			return true;

		return false;
	}
}
