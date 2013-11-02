import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class KrupierTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKrupier() {
	
	}

	@Test
	public void testWydaj_karte() {
		Krupier tester = new Krupier();
		assertEquals("wynik powinien byc 0", 0, tester.ilosc_kart_wydanych);
		Card karta=tester.wydaj_karte();
		tester.przyjmij_karte(karta);
	}

	@Test
	public void testPrzyjmij_karte() {
		
	}

}
