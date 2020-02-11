import java.io.*;

/**
 * Verschl�sselung von Buchstaben. Zahlen und Sonderzeichen werden ignoriert.
 *
 */
public class Verschl�sselungCaeser {

	public static void main(String[] args) throws IOException {
		if (args.length != 3) {
			System.out.println("Fehler: Sie haben die Argumente falsch eingegeben. Das Programm wird terminiert.");
			System.out.println(
					"Kurzanleitung: \nGeben sie als erstes Argument einen Pfad zur einer Textdatei ein die verschl�sselt werden soll.");
			System.out.println("Geben sie als zweites Argument den Zielpfad f�r die Verschl�sselte Datei.");
			System.out.println(
					"Geben sie als drittes Argument eine Zahl  zwischen 0 und 25, welche die Verschiebung angibt.");
			return;
		}
		/**
		 * Argumente werden deklariert und zugewiesen. Integer.parsInt wandelt string in
		 * int um.
		 */
		String dateipfad = args[0];
		String zielpfad = args[1];
		int verschiebung = Integer.parseInt(args[2]);

		if (new File(dateipfad).exists() == false) {
			System.out.println(dateipfad);
			System.out.println("Es existiert keine Datei in dem angegebenen Pfad.");
		}
		/**
		 * mit file wird auf die datei zugegriffen fileReader liest die Datei.
		 * BufferedReader beschleunigt diesen Vorgang nochmal. FileWriter schreibt in
		 * eine neue datei rein. BufferedWriter beschleunigt diesen Vorgang damit er
		 * selbst bei gro�en Dateien(1GB und mehr) kein Problem hat.
		 */
		File datei = new File(dateipfad);

		FileReader eingabestrom = new FileReader(datei);
		BufferedReader lesen = new BufferedReader(eingabestrom);

		FileWriter ausgabestrom = new FileWriter(zielpfad);
		BufferedWriter schreiben = new BufferedWriter(ausgabestrom);

		System.out.println("Die Datei " + dateipfad + " wird verschl�sselt.\nBitte warten sie.");
		long startTime = System.nanoTime();

		int buchstabe;

		while ((buchstabe = lesen.read()) != -1) {
			schreiben.write(verschl�sselung(buchstabe, verschiebung));
		}
		lesen.close();
		schreiben.close();

		long endTime = System.nanoTime();
		double duration = (endTime - startTime);
		// Dividieren um von nanosekunden in Sekunden umzuwandeln
		System.out.println("Dauer: " + duration / 1_000_000_000 + " Sekunden");

		System.out.println("Die Datei wurde in " + zielpfad + " verschl�sselt!");
		System.out.println("Das Programm beendet nun!");
	}

	/**
	 * Hier wird die eingegebene Zahl gepr�ft ob sie im Grenzbereich liegt, falls ja
	 * wird sie verschoben.Man kann die Verschiebung anhand von der ASCII tabelle
	 * nachsehen. ASCII (A)65 bis (Z)90 (a)97 bis (z)122 mit Modulo pr�fen ob die
	 * Verschiebung au�erhalb vom Rahmen liegt. Anschlie�end wird gepr�ft ob es sich
	 * um ein Buchstabe handelt und wird verschoben. Falls die Verschiebung �ber den
	 * Grenzbereich hinaus geht wird der Buchstabe minus 26 genommen.
	 * 
	 */
	public static int verschl�sselung(int verschl�sselt, int verschiebung) {
		int zwischenvariable = verschl�sselt;
		verschiebung %= 26; // wenn verschiebung > 25 || < 0

		if ((verschl�sselt >= 'A' && verschl�sselt <= 'Z') || (verschl�sselt >= 'a' && verschl�sselt <= 'z')) {
			verschl�sselt += verschiebung;
			if (zwischenvariable <= 'Z' && verschl�sselt > 'Z') {
				verschl�sselt -= 26;
			} else if (zwischenvariable >= 'a' && verschl�sselt > 'z') {
				verschl�sselt -= 26;
			}
		}
		return verschl�sselt;
	}
}