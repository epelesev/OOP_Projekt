import java.util.*;

public class Tinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menüü menüü = new Menüü();
        Kasutaja kasutaja = new Kasutaja();

        menüü.laeJoogid("Joogid.txt");
        Swipeimine swipeMootor = new Swipeimine(menüü.getJoogid(), kasutaja);

        System.out.println("AlkoTinder");

        while (true) {
            System.out.println("\nPeamenüü: [S] Alusta swipeimist | [P] Profiil | [Q] Välju");
            String sisend = sc.nextLine().toUpperCase();

            if (sisend.equals("Q")) {
                kasutaja.salvestaValikud();
                System.out.println("\nProgramm suletud. Valikud salvestatud.");
                break;
            }

            else if (sisend.equals("S")) {
                // UUS SISEMINE TSÜKKEL JÄRJEST SWIPEIMISEKS
                while (true) {
                    Jook jook = swipeMootor.valiJärgmineJook();

                    if (jook == null) {
                        System.out.println("\n--- Kõik saadaval olevad joogid on hinnatud! ---");
                        break; // Läheb tagasi peamenüüsse
                    }

                    System.out.println("\n" + jook);
                    System.out.println("1: Tahaks proovida | 2: Ei meeldi | 3: Meeldib | 4: Jäta vahele | [T] Tagasi peamenüüsse");

                    String valik = sc.nextLine().toLowerCase();

                    if (valik.equals("t")) {
                        break; // Katkestab swipeimise ja läheb peamenüüsse
                    }

                    swipeMootor.annaHinnang(jook, valik);
                }
            }

            else if (sisend.equals("P")) {
                profiiliVaade(kasutaja, sc);
            }
        }
        sc.close();
    }

    // ProfiiliVaade meetod jääb samaks nagu varem...
    private static void profiiliVaade(Kasutaja kasutaja, Scanner sc) {
        Map<String, String> valikud = kasutaja.getHinnangud();
        if (valikud.isEmpty()) {
            System.out.println("Sul pole veel ühtegi valikut.");
            return;
        }

        List<String> nimed = new ArrayList<>(valikud.keySet());
        System.out.println("\n--- SINU VALIKUD ---");
        for (int i = 0; i < nimed.size(); i++) {
            System.out.println((i + 1) + ". " + nimed.get(i) + " [" + valikud.get(nimed.get(i)) + "]");
        }

        System.out.println("\nSisesta joogi number muutmiseks või '0' tagasiminekuks:");
        try {
            int nr = Integer.parseInt(sc.nextLine());
            if (nr > 0 && nr <= nimed.size()) {
                String nimi = nimed.get(nr - 1);
                System.out.println("Vali uus staatus joogile " + nimi + ":");
                System.out.println("1: Tahaks proovida | 2: Ei meeldi | 3: Meeldib | 4: EEMALDA VALIK");
                String uus = sc.nextLine();
                if (uus.equals("4")) {
                    kasutaja.lisaHinnang(nimi, null);
                    System.out.println("Valik eemaldatud.");
                } else {
                    String[] sildid = {"", "like (tahaks proovida)", "dislike (ei meeldi)", "super like (meeldib)"};
                    kasutaja.lisaHinnang(nimi, sildid[Integer.parseInt(uus)]);
                    System.out.println("Staatus muudetud.");
                }
            }
        } catch (Exception e) {
            System.out.println("Naaseme peamenüüsse.");
        }
    }
}