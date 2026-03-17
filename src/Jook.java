import java.util.List;

public class Jook {
    String nimi;
    String maitse;
    List<String> koostisosad;

    public Jook(String nimi, String maitse, List<String> koostisosad) {
        this.nimi = nimi;
        this.maitse = maitse;
        this.koostisosad = koostisosad;
    }

    @Override
    public String toSring() {
        if (koostisosad.isEmpty()) return nimi + " (" + maitse +")";
        return nimi " (" + maitse +") - koostisosad: " + String.join(", " koostisosad);
    }
}
