import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main( String[] args) {

		int liczba_graczy;
		System.out.println("Podaj liczbę graczy\n ");
		Scanner odczyt;
		Table gra;
		try {

			odczyt = new Scanner(System.in);
			liczba_graczy = odczyt.nextInt();

			if ((liczba_graczy >= 2) && liczba_graczy <= 4) {
				System.out.println("Zaczynamy grę dla  " + liczba_graczy
						+ " graczy\n");
				 gra= new Table(liczba_graczy);
				 gra.gramy();
			} else
				System.out.println("Nie dozwolona liczba graczy");
			odczyt.close();
		} catch (InputMismatchException oy) {
			System.out.println("Cos ci nie wyszlo, spróbuj jeszcze raz\n ");
		}

	}

}
