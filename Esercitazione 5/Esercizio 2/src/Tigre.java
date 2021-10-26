public class Tigre implements Animale {
    private String nome;
    // ...
    public Tigre(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
