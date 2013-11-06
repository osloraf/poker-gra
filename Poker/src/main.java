import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int liczba_graczy;
		System.out.println("Podaj liczbę graczy\n ");

		try {

			Scanner odczyt = new Scanner(System.in);
			liczba_graczy = odczyt.nextInt();

			if ((liczba_graczy >= 2) && liczba_graczy <= 4) {
				System.out.println("Zaczynamy grę dla  " + liczba_graczy
						+ " graczy\n");
				Table tester = new Table(liczba_graczy);
			} else
				System.out.println("Nie dozwolona liczba graczy");

		} catch (InputMismatchException oy) {
			System.out.println("Cos ci nie wyszlo, spróbuj jeszcze raz\n ");
		}

	}

}
