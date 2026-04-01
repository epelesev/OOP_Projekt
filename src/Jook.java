public class Jook {
    private String nimi;
    private String kirjeldus;
    private String koostisosad;

    public Jook(String nimi, String kirjeldus, String koostisosad) {
        this.nimi = nimi;
        this.kirjeldus = kirjeldus;
        this.koostisosad = koostisosad;
    }

    public String getNimi() {
        return nimi;
    }
    @Override
    public String toString() {
        return String.format("--- %s ---\nKirjeldus: %s\nKoostis: %s",
                nimi.toUpperCase(), kirjeldus, koostisosad);
    }
}
