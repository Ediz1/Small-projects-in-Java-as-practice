import java.util.Scanner;

/**
 * Ausgabe aller Primzahlen bis zu einer Zahl die man selbst bestimmt.
 *
 */
public class SiebEratosthenes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int rahmengröße;
		boolean[] isnotprime;

		System.out.println("Geben Sie ein bis zu welcher Zahl Sie eine Primzahl ausgeben lassen wollen: ");
		rahmengröße = in.nextInt();

		isnotprime = new boolean[rahmengröße + 1];
		// Beschreibt den Rahmen der gefragten Zahlen... plus 1 weil Arrays ab 0
		// beginnen.

		for (int nummer = 2; nummer + nummer <= rahmengröße; nummer++) {
			// nummer ist hier die Variable die jede Stelle im Array durchgeht und prüft ob
			// es eine primzahl ist
			if (isnotprime[nummer] == false) {
				for (int doppelnummer = nummer + nummer; doppelnummer <= rahmengröße; doppelnummer = doppelnummer
						+ nummer) {
					// doppelnummer wendet das Prinzip des Eratosthenes an und streicht jedes
					// vielfache einer Primzahl raus.
					isnotprime[doppelnummer] = true;
				}
			}

		}

		for (int zähler = 2; zähler <= rahmengröße; zähler++) {

			if (isnotprime[zähler] == false) {
				System.out.println("Primzahlen:" + zähler);
				// Ausgabe der false markierten Zahlen bzw. Primzahlen

			}

		}

		in.close();

	}

}
