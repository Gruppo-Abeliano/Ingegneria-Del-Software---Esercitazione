public class Pappagallo implements Animale{
    private String nome;
    // ...
    public Pappagallo(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
