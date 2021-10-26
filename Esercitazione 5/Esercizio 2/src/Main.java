public class Main {
    public static void main(String[] args) {
        Gabbia gLeoni = new Gabbia(new CreatoreDiLeoni());
        Gabbia gTigri = new Gabbia(new CreatoreDiTigri());

        gLeoni.addAnimale("Ciccio");
        gTigri.addAnimale("Tigro");
    }
}
