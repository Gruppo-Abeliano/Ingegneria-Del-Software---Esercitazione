public class Docente extends Persona{
    /*
    * Definisco il ruolo come classe interna. E' un'enumerazione dei 3 possibili valori che potranno assumere gli oggetti
    * di tipo Ruolo.
    * */
    public enum Ruolo {ORDINARIO, ASSOCIATO, RICERCATORE};

    private Ruolo ruoloDocente;

    /*
    * Utilizzo 2 costruttori:
    *   (1) Docente generico. Gli viene assegnato il ruolo RICERCSTORE come ricercatore di default.
    *   (2) Il docente viene creato specificando il suo ruolo.
    * */
    public Docente(String nome, String cognome, String email) {
        this(nome,cognome,email,Ruolo.RICERCATORE);
    }

    public Docente(String nome, String cognome, String email, Ruolo ruolo) {
        super(nome,cognome,email);

        this.ruoloDocente = ruolo;
    }

    /*
    * Setters
    * */
    public void setRuoloDocente(Ruolo ruoloDocente) { this.ruoloDocente = ruoloDocente; }

    /*
    * Getters
    * */
    public Ruolo getRuoloDocente() { return ruoloDocente; }
}
