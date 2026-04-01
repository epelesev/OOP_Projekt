import java.util.Scanner;

public class Otsused {
    /*
    suhtleb kasutajaga
    - kuvab joogid
    - küsib inputi
    - näitab menüüd
    - laseb muuta valikuid
    siin on kogu input/output
     */
    private static void muuda(Kasutaja kasutaja, Jook jook, Scanner sc) {
        System.out.println("Uus hinnang (l, s, d / eemalda) : ");
        String uus = sc.nextLine();

        if (uus.equals("eemalda")) {
            kasutaja.eemaldaKõikjalt(jook);
        } else {
            Swipeimine.swipe(kasutaja, jook, uus);
        }
    }
}
