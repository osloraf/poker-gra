import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int liczba_graczy;
		System.out.println("Podaj liczbę graczy ");
		
		Scanner odczyt = new Scanner(System.in); 

		liczba_graczy = odczyt.nextInt();

		
		if((liczba_graczy<=2)&&liczba_graczy>=4){
			System.out.println("Zaczynamy grę dla  " + liczba_graczy+" graczy");
			Table tester = new Table();}
		else
			System.out.println("Za dużo lub za malo graczy");
		
			

	}

}
