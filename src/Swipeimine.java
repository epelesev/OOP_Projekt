public class Swipeimine {
    /*
    tegeleb swipe'i loogikaga
    - lisab joogi õigesse listi (liked/dislike/super-liked)
    - tagab, et sama jook ei oleks mitmes listis korraga (ei saa olla like ja dislike)
     */

    public static void swipe(Kasutaja kasutaja, Jook jook, String tegevus) {
        kasutaja.eemaldaKõikjalt(jook);

        if (tegevus.equals("l")) {
            kasutaja.liked.add(jook);
        } else if (tegevus.equals("s")) {
            kasutaja.superLiked.add(jook);
        } else if (tegevus.equals("d")) {
            kasutaja.disliked.add(jook);
        }
    }
}
