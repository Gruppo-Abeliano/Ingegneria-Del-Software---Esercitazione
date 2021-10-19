import java.util.Objects;

public class Studente extends Persona{
    private int idPersona;

    public Studente(String nome, String cognome, String email, int idPersona) {
        super(nome,cognome,email);
        this.idPersona = idPersona;
    }

    /*
    * Getters
    * */
    public int getIdPersona() {
        return idPersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Studente)) return false;

        Studente studente = (Studente) o;
        return this.idPersona == studente.idPersona;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona);
    }

    @Override
    public String toString() {
        return idPersona+" -- "+super.toString();
    }
}
