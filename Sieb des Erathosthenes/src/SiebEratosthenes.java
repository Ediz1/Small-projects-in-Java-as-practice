import java.util.Scanner;

/**
 * Ausgabe aller Primzahlen bis zu einer Zahl die man selbst bestimmt.
 *
 */
public class SiebEratosthenes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int rahmengr��e;
		boolean[] isnotprime;

		System.out.println("Geben Sie ein bis zu welcher Zahl Sie eine Primzahl ausgeben lassen wollen: ");
		rahmengr��e = in.nextInt();

		isnotprime = new boolean[rahmengr��e + 1];
		// Beschreibt den Rahmen der gefragten Zahlen... plus 1 weil Arrays ab 0
		// beginnen.

		for (int nummer = 2; nummer + nummer <= rahmengr��e; nummer++) {
			// nummer ist hier die Variable die jede Stelle im Array durchgeht und pr�ft ob
			// es eine primzahl ist
			if (isnotprime[nummer] == false) {
				for (int doppelnummer = nummer + nummer; doppelnummer <= rahmengr��e; doppelnummer = doppelnummer
						+ nummer) {
					// doppelnummer wendet das Prinzip des Eratosthenes an und streicht jedes
					// vielfache einer Primzahl raus.
					isnotprime[doppelnummer] = true;
				}
			}

		}

		for (int z�hler = 2; z�hler <= rahmengr��e; z�hler++) {

			if (isnotprime[z�hler] == false) {
				System.out.println("Primzahlen:" + z�hler);
				// Ausgabe der false markierten Zahlen bzw. Primzahlen

			}

		}

		in.close();

	}

}
