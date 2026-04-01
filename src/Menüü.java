import java.io.*;
import java.util.*;

public class Menüü {
    private List<Jook> joogid = new ArrayList<>();

    public void laeJoogid(String failiNimi) {
        try (BufferedReader br = new BufferedReader(new FileReader(failiNimi))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                String[] osad = rida.split(";");
                if (osad.length == 3) {
                    joogid.add(new Jook(osad[0], osad[1], osad[2]));
                } else if (osad.length == 2) {
                    joogid.add(new Jook(osad[0], osad[1], "Koostis teadmata"));
                }
            }
        } catch (IOException e) {
            System.out.println("Jookide faili ei leitud!");
        }
    }

    public List<Jook> getJoogid() { return joogid; }
}