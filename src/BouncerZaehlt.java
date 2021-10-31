import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;


public class BouncerZaehlt extends BouncerApp {

    @Override
    public void bounce() {
        loadMap("Strasse");
    }

    public static void main(String[] args) {
        BouncerLauncher.launch("BouncerZaehlt");
    }
}