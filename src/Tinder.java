import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tinder {
    /*
    käivitab programmi
    - loob objektid
    - käivitab flowd
    ainult juhtimine, mitte mingit loogikat
    */

    public static List<Jook> loeJoogid(String fail) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] osad = line.split(";", 3);
            String nimi = osad[0];
            String maitse = osad[1];
            List<String> koostisosad = new ArrayList<>();
            if (osad.length==3 && !osad[2].isEmpty()) {
                String[] osadKoost = osad[2].split(",");
                koostisosad.addAll(Arrays.asList(osadKoost));
            }
        }
    }


    public static void main(String[] args) throws Exception {
        List<Jook> joogid = loeJoogid("Joogid.txt");
        Kasutaja kasutaja = new loeJoogid();
        Scanner sc = new Scanner()


    }

}
