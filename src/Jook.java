import java.util.List;

public class Jook {
    String nimi;
    String kirjeldus;
    List<String> koostisosad;

    public Jook(String nimi, String maitse, List<String> koostisosad) {
        this.nimi = nimi;
        this.kirjeldus = maitse;
        this.koostisosad = koostisosad;
    }

    @Override
    public String toSring() {
        if (koostisosad.isEmpty()) return nimi + " (" + kirjeldus +")";
        return nimi + " (" + kirjeldus +") - koostisosad: " + String.join(", ", koostisosad);
    }
}
