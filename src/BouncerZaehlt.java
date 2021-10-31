import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;


/*
 * In diesem Beispiel lern Bouncer das Zählen. Seine Aufgabe ist es, auf dem Weg über eine Straße alle Schlaglöcher
 * zu finden, und sich bis zum Ende des Weges zu merken, wie viele Löcher insgesamt auf der Straße sind. Die Anzahl
 * aller Schlaglöcher soll er am Ende ausgeben. Dazu verwenden wir den Befehl System.out.println, der eine Textausgabe
 * in der Standardausgabe (in IntelliJ ist das das "Terminal" unten am Bildschirm), erzeugt. Bouncer merkt sich die
 * Menge der gezählten Löcher in einer Variable und setzt deren Weg am Ende für die Ausgabe in diesen Befehl, an Stelle
 * des Platzhaltes n, ein:
 *
 * System.out.println("Auf meinem Weg über die Straße habe ich " + n + " Löcher gefunden!");
 *
 * Hinweis: Texte werden in Java immer in Anführungszeichen geschrieben und so vom restlichen Code abgetrennt. Wenn ein
 * Text aus Zeichenketten und Variablenwerten zusammengesetzt werden soll, wird dafür der Plus-Operator (+) verwendet.
 */
public class BouncerZaehlt extends BouncerApp {

    @Override
    public void bounce() {
        loadMap("Strasse");
    }

    public static void main(String[] args) {
        BouncerLauncher.launch("BouncerZaehlt");
    }
}