import java.util.*;

public class Swipeimine {
    private List<Jook> kõikJoogid;
    private Kasutaja kasutaja;
    private Random rand;

    public Swipeimine(List<Jook> joogid, Kasutaja kasutaja) {
        this.kõikJoogid = joogid;
        this.kasutaja = kasutaja;
        this.rand = new Random();
    }

    public Jook valiJärgmineJook() {
        List<Jook> hindamata = new ArrayList<>();
        for (Jook j : kõikJoogid) {
            // Kontrollime, kas jook on juba kasutaja nimekirjas
            if (!kasutaja.getHinnangud().containsKey(j.getNimi())) {
                hindamata.add(j);
            }
        }

        if (hindamata.isEmpty()) return null;
        return hindamata.get(rand.nextInt(hindamata.size()));
    }

    public void annaHinnang(Jook jook, String valik) {
        switch (valik) {
            case "1" -> kasutaja.lisaHinnang(jook.getNimi(), "tahaks proovida");
            case "2" -> kasutaja.lisaHinnang(jook.getNimi(), "ei meeldi");
            case "3" -> kasutaja.lisaHinnang(jook.getNimi(), "meeldib");
        }
    }
}