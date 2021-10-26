public class Leone implements Animale{
    private String nome;
    // ...
    public Leone(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
