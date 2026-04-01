import java.io.*;
import java.util.*;

public class Kasutaja {
    private Map<String, String> hinnangud;
    private final String failiNimi = "kasutaja_valikud.txt";

    public Kasutaja() {
        this.hinnangud = laeValikud();
    }

    public void lisaHinnang(String joogiNimi, String hinnang) {
        if (hinnang == null) {
            hinnangud.remove(joogiNimi);
        } else {
            hinnangud.put(joogiNimi, hinnang);
        }
    }

    public Map<String, String> getHinnangud() { return hinnangud; }

    // UUS MEETOD: Kogu profiili kuvamine ja muutmise loogika on siin
    public void kuvaJaMuudaProfiili(Scanner sc) {
        if (hinnangud.isEmpty()) {
            System.out.println("Sul pole veel ühtegi valikut.");
            return;
        }

        List<String> nimed = new ArrayList<>(hinnangud.keySet());
        System.out.println("\n--- SINU PROFIIL ---");
        for (int i = 0; i < nimed.size(); i++) {
            System.out.println((i + 1) + ". " + nimed.get(i) + " [" + hinnangud.get(nimed.get(i)) + "]");
        }

        System.out.println("\nSisesta number muutmiseks või '0' tagasi minemiseks:");
        try {
            int nr = Integer.parseInt(sc.nextLine());
            if (nr > 0 && nr <= nimed.size()) {
                String nimi = nimed.get(nr - 1);
                System.out.println("Uus staatus: 1: Tahaks | 2: Ei meeldi | 3: Meeldib | 4: EEMALDA");
                String uus = sc.nextLine();

                String[] sildid = {"", "tahaks proovida", "ei meeldi", "meeldib"};
                if (uus.equals("4")) lisaHinnang(nimi, null);
                else lisaHinnang(nimi, sildid[Integer.parseInt(uus)]);

                System.out.println("Muudetud!");
            }
        } catch (Exception e) {
            System.out.println("Tagasi peamenüüsse.");
        }
    }

    public void salvestaValikud() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(failiNimi))) {
            for (Map.Entry<String, String> entry : hinnangud.entrySet()) {
                pw.println(entry.getKey() + ";" + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Viga salvestamisel!");
        }
    }

    private Map<String, String> laeValikud() {
        Map<String, String> laetud = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(failiNimi))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                String[] osad = rida.split(";");
                if (osad.length == 2) laetud.put(osad[0], osad[1]);
            }
        } catch (IOException e) { }
        return laetud;
    }
}