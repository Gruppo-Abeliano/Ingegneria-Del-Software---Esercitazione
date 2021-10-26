public class CreatoreDiTigri implements CreatoreDiAnimali{
    public Animale creaAnimale(String nome) {
        return new Tigre(nome);
    }
}
