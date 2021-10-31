import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;
import de.ur.mi.bouncer.world.fields.FieldColor;

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
        /*
         * Anlegen (Deklarieren) der Variable für die Anzahl der Schlaglöcher. Die Anzahl wird als Ganzzahl im Programm
         * angegeben. Daher wird für die Variable der Datentyp Integer (int) verwendet. Bei der Deklaration muss noch kein
         * Wert angegeben werden. Die Variable ist dann je nach Datentyp entweder "leer" oder wird mit einem Default-Wert
         * belegt. Bei Integer-Variablen ist das "0";
         */
        int numberOfPotholesOnRoad;
        /*
         * Auf der rechten Seite des Gesamt-Ausdrucks wird die Methode aufgerufen, in der Bouncer alle Schlaglöcher auf der
         * Straße zählt. Die Methode gibt das Ergebnis dieser Zählung als Ganzzahl zurück, die in der Variable "numberOfPotholes"
         * gespeichert wird. Solche Ausdrücke (Zuweisungen) werden "von rechts nach links" gelesen. D.h. zuerst wird die Methode
         * ausgeführt und deren Ergebnis bzw. Rückgabewert eingeholt. Dann wird dieses Ergebnis der Variable auf der linken Seite des Gleich-
         * heitszeichen zugewiesen.
         */
        numberOfPotholesOnRoad = countPotholesOnWayToNextObstacle();
        /*
         * Die so gezählte Anzahl der Schlaglöcher wird. als Zahl, mit den anderen Teilen des Ausgabetexts verbunden
         * und auf der Konsole bzw. Standardausgabe des Systems, auf dem das Program ausgeführt wird, ausgegeben.
         */
        System.out.println("Auf meinem Weg über die Straße habe ich " + numberOfPotholesOnRoad + " Löcher gefunden!");
    }

    /**
     * Diese Methode lässt Bouncer von seiner aktuellen Position aus geradeaus bis zum nächsten Hindernis laufen. Dabei zählt
     * Bouncer alle Schlaglöcher (= rote Felder) über die er läuft. Die Anzahl der gefundenen Schlaglöcher wird als Ergebnis
     * aus der Methode zurückgegeben.
     *
     * @return Eine Ganzzahl (int), die der Anzahl der Schlaglöcher, die Bouncer auf dem Weg über die Strasse gefunden hat, entspricht
     */
    private int countPotholesOnWayToNextObstacle() {
        /*
         * Deklaration und spezifische Initialisierung einer Variable können in der selben Zeile erfolgen: Hier wird eine Variable mit
         * den Namen "numberOfPotholes" zum Speichern von Ganzzahlen (Typ Integer) erstellt (deklariert) und initial direkt mit dem Wert 0 belegt
         */
        int numberOfPotholes = 0;
        // Bouncer prüft, ob er sich bereits auf einem Feld mit Schlagloch befindet. Falls ja ...
        if(bouncer.isOnFieldWithColor(FieldColor.RED)) {
            // ... zählt er das Loch, in dem er 1 zu dem aktuellen Wert der Variable addiert
            // und danach den Wert der Variable mit der Summe überschreibt.
            numberOfPotholes = numberOfPotholes + 1;
        }
        // Solange Bouncer einen Schritt nach vorne gehen kann ...
        while (bouncer.canMoveForward()) {
            // ... bewegt er sich auf das nächste Feld ...
            bouncer.move();
            // ... und prüft erneut, ob ein weiteres Schlagloch gezählt werden muss
            if (bouncer.isOnFieldWithColor(FieldColor.RED)) {
                /*
                 * Wenn wir eine numerische Variable um genau 1 erhöhen möchten, können wir auch
                 * eine kürze Schreibweise mithilfe des Operators ++ verwenden
                 */
                numberOfPotholes++;
            }
        }
        // Wenn Bouncer vor dem Hindernis angekommen ist, wird die Gesamtzahl der Schlaglöcher als Ergebnis aus der Methode zurückgegeben
        return numberOfPotholes;
    }

    public static void main(String[] args) {
        BouncerLauncher.launch("BouncerZaehlt");
    }
}