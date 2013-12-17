
/**
 * 
 */

/**
 * @author Rafal
 *
 */
public class Bet {

	Player gamer;
	private int money;
	/**
	 * 
	 * @param cash Ilosc pieniedzy postawiona przez dana osobe
	 * @param player Gracz ktory postawil pieniadze 
	 */
	public Bet(Player player)
	{
		this.gamer=player;
		this.setMoney(Krupier.minimal_raise);
	}
	public void update_bet(int cash)
	{
		setMoney(getMoney() + cash);
		gamer.set_money(gamer.get_money()-cash);
	}
	public void reset_bet()
	{
		this.setMoney(0);
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

}
