public class CreatoreDiLeoni implements CreatoreDiAnimali{
    public Animale creaAnimale(String nome) {
        return new Leone(nome);
    }
}
