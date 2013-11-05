import java.util.Random;

/**
 * 
 */

/**
 * @author rafal
 *Klasa będzie odpowiedzialna za wyswietlanie kard i wszystkiego 
 *co dzieje się na stole
 */
public class Table {
	
	Table(){
		Random random = new Random();
		
		Krupier kr=new Krupier();
		Human p1=new Human("BoB");
		Bot b1=new Bot("B1");
		Bot b2=new Bot("B2");
		Bot b3=new Bot("B3");
		/**
		 * Rozdaje karty
		 */
		for(int i=0;i<5;i++)
		{
		p1.get_card(kr.wydaj_karte());
		b1.get_card(kr.wydaj_karte());
		b2.get_card(kr.wydaj_karte());
		b3.get_card(kr.wydaj_karte());}
		p1.arrange();
		b1.arrange();
		b2.arrange();
		b3.arrange();
		
		Player.Configurations.check_conf(p1.karty_na_reku);
		System.out.println(" kurwa \n");
		p1.draw();
		
		
		
	}
	

}
