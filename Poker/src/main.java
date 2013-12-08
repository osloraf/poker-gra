import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int liczba_graczy;
		System.out
				.println("Witaj nieznajomy, czy chcesz sie dosiasc do naszej gry w pokera? \n1.Tak\n2.Nie");
		Scanner odczyt;
		Table gra;
		try {
			odczyt = new Scanner(System.in);
			if (odczyt.nextInt() != 1)
				System.out.println("Jak nie chcesz to ¿egnaj \nProgram zakoñczy³ swoje dzia³anie");
			else {

				System.out
						.println("Wspaniale, zapros zatem jeszcze od 1 do 3 graczy od komputera do gry. Ilu zaprosisz?");
				liczba_graczy = odczyt.nextInt();
				if ((liczba_graczy >= 1) && liczba_graczy <= 3) {
					liczba_graczy++;
					System.out.println("Zaczynamy gre dla " + liczba_graczy
							+ " graczy\n");
					gra = new Table(liczba_graczy);
					gra.new_sesion();
				} else
					System.out.println("Niedozwolona liczba graczy");
				odczyt.close();
			}
		} catch (InputMismatchException oy) {
			System.out.println("Cos ci nie wyszlo, sprobuj jeszcze raz\n ");
		}

	}

}
