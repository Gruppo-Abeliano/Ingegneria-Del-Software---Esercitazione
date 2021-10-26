public class CreatoreDiPappagalli implements CreatoreDiAnimali{
    public Animale creaAnimale(String nome) {
        return new Pappagallo(nome);
    }
}
