import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/**
 * Klasa reprezentujaca gracza w grze
 * 
 * @author rafal
 * 
 */
public final class Human extends Player {

	Human(String name) {
		this.ilosc_kart = 0;
		this.karty_na_reku = new LinkedList();
		nazwa_gracza = name;
	}

	private void pokaz_karty() {
		for (int i = 0; i < karty_na_reku.size(); i++) {
			karty_na_reku.get(i).draw();
		}
	}

	public int wymien_karty() {
		System.out.print("Czy chcesz wymieniæ kartê y/n ");
		Scanner odczyt = new Scanner(System.in);
		String decyzja;
		decyzja = odczyt.next();
		int ilosc = 0;
		if (decyzja.startsWith("y")) {
			System.out.print("\nPodaj ile kart chcesz wymieniæ, 0-4: ");
			ilosc = odczyt.nextInt();
			int wybor = 0;
			for (int i = 0; i < ilosc; i++) {
				pokaz_karty();
				System.out.print("Ktora karte chesz wymienic");
				wybor = odczyt.nextInt();
				ilosc_kart--;
				karty_na_reku.remove(wybor - 1);
			}
		}
		
		return ilosc;
	}

}
