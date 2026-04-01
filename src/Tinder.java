import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.*;


public class Tinder {

    public static List<Jook> loeJoogid(String failnimi) throws Exception {
        List<Jook> joogid = new ArrayList<>();

        try(Scanner sc = new Scanner(new File(failnimi), "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                if (rida.isEmpty()) continue;

                String[] osad = rida.split(";");

                String nimi = osad[0];
                String maitse = osad[1];

                List<String> koostisosad = new ArrayList<>();

                if (osad.length >= 3 && ! osad[2].isEmpty()) {
                    String[] koostisOsad = osad[2].split(",");
                    koostisosad.addAll(Arrays.asList(koostisOsad));
                }
                joogid.add(new Jook(nimi, maitse, koostisosad));
            }
        }
        return joogid;
    }

    public static void main(String[] args) throws Exception {
        List<Jook> joogid = loeJoogid("Joogid.txt");
        Kasutaja kasutaja = new Kasutaja();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (true) {
            List<Jook> valimata = new ArrayList<>();
            for (Jook jook : joogid) {
                if (!kasutaja.onHinnatud(jook)) valimata.add(jook);
            }
            if (valimata.isEmpty()) break;

            Jook jook = valimata.get(rand.nextInt(valimata.size()));
            System.out.println("MIDA SA ARVAD JOOGIST: " + jook + "?");
            System.out.println("(l)ike, (s)uperlike, (d)islike, (q)uit");
            String sisend = sc.nextLine().toLowerCase();

            if (sisend.equals("q")) break;


        }


    }

}
