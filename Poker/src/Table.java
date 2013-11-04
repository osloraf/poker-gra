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
		
			System.out.println(p1.get_name());
			System.out.println(b1.get_name());
			System.out.println(b2.get_name());
			System.out.println(b3.get_name());
			
		p1.draw();
		b1.draw();
		b2.draw();
		b3.draw();
		
		
	}
	

}
