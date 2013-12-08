
/**
 * 
 */

/**
 * @author Rafal
 *
 */
public class Bet {

	static Player gamer;
	static int money;
	/**
	 * 
	 * @param cash Ilosc pieniedzy postawiona przez dana osobe
	 * @param player Gracz ktory postawil pieniadze 
	 */
	public static void make_Bet(int cash, Player player)
	{
		money = cash;
		gamer = player;
	} 

}
