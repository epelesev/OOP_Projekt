import java.io.*;
import java.util.*;

public class Kasutaja {
    private Map<String, String> hinnangud; //joogi nimi -> hinnang
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
        } catch (IOException e) { /* Faili ei eksisteeri veel */ }
        return laetud;
    }
}
