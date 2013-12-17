
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
	private Boolean czy_all_in;
	/**
	 * 
	 * @param cash Ilosc pieniedzy postawiona przez dana osobe
	 * @param player Gracz ktory postawil pieniadze 
	 */
	public Bet(Player player)
	{
		this.gamer=player;
		this.setMoney(Krupier.minimal_raise);
		this.setCzy_all_in(false);
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
	/**
	 * @return the czy_all_in
	 */
	public Boolean getCzy_all_in() {
		return czy_all_in;
	}
	/**
	 * @param czy_all_in the czy_all_in to set
	 */
	public void setCzy_all_in(Boolean czy_all_in) {
		this.czy_all_in = czy_all_in;
	}
	

}
