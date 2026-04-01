import java.util.ArrayList;
import java.util.List;

public class SoovitusteSüsteem {
    public static List<Jook> soovita(Kasutaja kasutaja, List<Jook> kõik) {
        List<Jook> soovitused = new ArrayList<>();

        for (Jook jook : kõik) {
            if (kasutaja.onHinnatud(jook)) continue;
            int skoor = 0;

            for (Jook meeldib : kasutaja.liked) {
                if (jook.kirjeldus.equals(meeldib.kirjeldus)) skoor++;
            }

            for (Jook meeldib : kasutaja.superLiked) {
                if (jook.kirjeldus.equals(meeldib.kirjeldus)) skoor +=2;
            }

            if (skoor > 0) {
                soovitused.add(jook);
            }
        }
        return soovitused;
    }
}
