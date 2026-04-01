import java.util.*;

public class Tinder {
    public static void main(String[] args) {
        // 1. Algseadistus
        Scanner sc = new Scanner(System.in);
        Menüü menüü = new Menüü();
        Kasutaja kasutaja = new Kasutaja();

        // 2. Andmete laadimine
        menüü.laeJoogid("Joogid.txt");
        Swipeimine swipeMootor = new Swipeimine(menüü.getJoogid(), kasutaja);

        System.out.println("=== ALKOTINDER ===");

        // 3. Peamine programmi tsükkel
        while (true) {
            System.out.println("\nPEAMENÜÜ: [S] Swipe | [P] Profiil | [Q] Välju");
            String sisend = sc.nextLine().toUpperCase();

            // VÄLJUMINE
            if (sisend.equals("Q")) {
                kasutaja.salvestaValikud();
                System.out.println("\nSinu tehtud otsused:");
                // Kuvame lõpuks kõik tehtud valikud
                kasutaja.getHinnangud().forEach((nimi, hinnang) ->
                        System.out.println("- " + nimi + ": " + hinnang));
                System.out.println("\nAndmed salvestatud. Nägemist!");
                break;
            }

            // SWIPEIMINE (Sisemine tsükkel järjestikuseks hindamiseks)
            else if (sisend.equals("S")) {

                while (true) {
                    Jook hetkeJook = swipeMootor.valiJärgmineJook();

                    if (hetkeJook == null) {
                        System.out.println("Rohkem uusi jooke hetkel pole. Vaata oma profiili või lisa jooke juurde!");
                        break;
                    }

                    System.out.println("\n" + hetkeJook);
                    System.out.println("1: Tahaks proovida | 2: Ei meeldi | 3: Meeldib | 4: Jäta vahele | [T] Tagasi peamenüüsse");

                    String valik = sc.nextLine().toLowerCase();

                    if (valik.equals("t")) {
                        break; // Katkestab sisemise tsükli ja läheb peamenüüsse
                    }

                    // Kui vajutatakse lihtsalt Enter või valik 4, liigub loogika lihtsalt edasi
                    swipeMootor.annaHinnang(hetkeJook, valik);
                }
            }

            // PROFIIL (Kutsume välja Kasutaja klassi meetodi)
            else if (sisend.equals("P")) {
                kasutaja.kuvaJaMuudaProfiili(sc);
            }

            else {
                System.out.println("Tundmatu käsk. Kasuta S, P või Q.");
            }
        }
        sc.close();
    }
}