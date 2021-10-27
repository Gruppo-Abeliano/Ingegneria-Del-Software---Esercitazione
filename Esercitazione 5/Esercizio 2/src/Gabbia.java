import java.util.ArrayList;
import java.util.List;

public class Gabbia {
    private CreatoreDiAnimali factory;
    private List<Animale> animali;

    public Gabbia(CreatoreDiAnimali creatoreDiAnimali) {
        this.factory = creatoreDiAnimali;
        animali = new ArrayList<Animale>();
    }

    public void addAnimale(String nome) {
        animali.add(factory.creaAnimale(nome));
    }
}
