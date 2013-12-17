public class Move {
	public static void make_move(Bot gracz) {
		if ((Check_conf.check_conf(gracz.get_cards()) > 1)) {

		}
	}
	/**
	 * Okresla czy bot ma wejsc do gry po zagraniu all-in, czy jednak nie. Bot wejdzie do gry jezeli:
	 * 
	 * 1. Ma co najmniej 3 w kartach
	 * 
	 * 2. Jest najbogatszy
	 * 
	 * 3. Nie bedzie go stac na wpisowe w nastepnej kolejce
	 * @param player
	 * @return
	 */
	public static Boolean graj_all_in(Bot player)
	{
		if(Check_conf.check_conf(player.get_cards())>1)
			return true;
		int bet_casch=0;
		for(int i=0;i<Table.ilosc_graczy;i++)
		{
			if(Table.players[i].bet.getCzy_all_in())
			{
				if(Table.players[i].bet.getMoney()>bet_casch)
					bet_casch=Table.players[i].bet.getMoney();
			}
		}
		if(player.money<Krupier.minimal_raise) 
			return true;
		
		int max_player_money=0;
		for(int i=0;i<Table.ilosc_graczy;i++)
			if(Table.players[i].nr_gracza!=player.nr_gracza)			
				if(Table.players[i].money+Table.players[i].bet.getMoney()>max_player_money)
					max_player_money=Table.players[i].money+Table.players[i].bet.getMoney();
			
		
		if((player.money+player.bet.getMoney())-max_player_money-Krupier.minimal_raise>5)
			return true;
		
		return false;
	}
}
