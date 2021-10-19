import java.util.Objects;

public class Corso {
    private int codice;
    private String nome;
    private int crediti;

    public Corso(int codice, String nome, int crediti) {
        this.codice = codice;
        this.nome = nome;
        this.crediti = crediti;
    }

    /*
    * Getters
    * */
    public String getNome() { return nome; }
    public int getCodice() { return codice; }
    public int getCrediti() { return crediti; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Corso)) return false;
        Corso corso = (Corso) o;
        return codice == corso.codice && crediti == corso.crediti && Objects.equals(nome, corso.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice, nome, crediti);
    }

    @Override
    public String toString() {
        return codice+"\t"+nome+"\t"+crediti;
    }
}
