import java.util.Scanner;

/**
 * Umwandlung von Dezimal Zahlen in Roemische
 * 
 */
public class UmwandlungDezimal {

	public static void main(String[] args) {

		int dezimalZahl;
		// Zwei Arrays die äquivalent geordnet sind damit man sie durch iterieren kann
		// und so den Dezimal Zahlen eine Römische Zahl zuordnen kann.
		String[] roemisch = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] normaleZahlen = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		int stelle = 0;

		System.out.println("Zahl muss innerhalb 1-3999 sein.");
		System.out.print("Bitte geben Sie eine Zahl ein: ");

		Scanner in = new Scanner(System.in);
		dezimalZahl = in.nextInt();

		// Prüfen ob die Zahl zwischen 1-3999 ist.
		if (dezimalZahl < 1 || dezimalZahl > 3999) {
			System.out.println("Zahl muss innerhalb 1-3999 sein.");
		} else {

			System.out.print("Die Römische Zahl lautet: ");
			do {
				// Er prüft ob die Zahl aus einem von den normalenZahlen Array ist
				// falls es so ist gibt er die äquivalente Römische Zahl davon aus und
				// subtrahiert die Zahl von der Variable dezimalZahl ab damit er mit der
				// Differenz weiterarbeiten kann.
				// Ansonsten geht er eine stelle bei den Normale Zahlen Array und im Römischen
				// Array weiter.
				if (dezimalZahl >= normaleZahlen[stelle]) {
					System.out.print(roemisch[stelle]);
					dezimalZahl = dezimalZahl - normaleZahlen[stelle];
				} else {
					stelle++;
				}
				// Durch die While schleife hört er nicht auf bis die dezimalZahl durch die
				// subtraktion der Differenz 0 erreicht.
			} while (dezimalZahl > 0);

		}

		in.close();
	}

}
