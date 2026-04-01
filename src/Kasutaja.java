import java.util.ArrayList;
import java.util.List;

public class Kasutaja {
    List<Jook> liked = new ArrayList<>();
    List<Jook> superLiked = new ArrayList<>();
    List<Jook> disliked = new ArrayList<>();

    public void eemaldaKõikjalt(Jook jook) {
        liked.remove(jook);
        superLiked.remove(jook);
        disliked.remove(jook);
    }

    public boolean onHinnatud(Jook jook) {
        return liked.contains(jook) || superLiked.contains(jook) || disliked.contains(jook);
    }
}
