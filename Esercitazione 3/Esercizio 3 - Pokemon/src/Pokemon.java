public class Pokemon {
    enum Tipo {NORMALE,ERBA,FUOCO,ACQUA};

    private String nome;
    private Tipo tipoPokemon;
    private double fattoreDiForza;
    private double puntiSalute;
    private static final double MOLTIPLICATORE_SUPEREFFICACE = 0.2;

    public Pokemon(String nomePokemon, Tipo tipoPokemon, double forza) {
        this.nome = nomePokemon;
        this.tipoPokemon = tipoPokemon;
        this.fattoreDiForza = forza;
        this.puntiSalute = 100.0;
    }

    public void attacca(Pokemon pokemonDaAttaccare) {
        /*
        * Quando un pokemon A attacca un pokemon B, verifico i vincoli di superefficacia e calcolo di conseguenza i danni
        * da applicare. A questo punto posso procedere ad aggiornare lo status del pokemon attaccato.
        * */
        double danno;

        /*
        * Se il pokemon è esausto non può attaccare
        * */
        if(this.isEsausto()) {
            System.out.println(this.getNome() + " è esausto e non può combattere.");
            return;
        }

        /*
        * Il danno base è fornito dal fattore di forza del pokemon attaccante.
        * Procediamo con il calcolo di eventuali multiplier.
        * */
        danno = this.fattoreDiForza;
        switch (this.tipoPokemon) {
            case ERBA:
                if(pokemonDaAttaccare.getTipoPokemon() == Tipo.ACQUA) danno += danno * Pokemon.MOLTIPLICATORE_SUPEREFFICACE;
                break;
            case FUOCO:
                if(pokemonDaAttaccare.getTipoPokemon() == Tipo.ERBA) danno += danno * Pokemon.MOLTIPLICATORE_SUPEREFFICACE;
                break;
            case ACQUA:
                if (pokemonDaAttaccare.getTipoPokemon() == Tipo.FUOCO) danno += danno * Pokemon.MOLTIPLICATORE_SUPEREFFICACE;
                break;
            default:
                break;
        }

        pokemonDaAttaccare.aggiornaStatus(this,danno);
    }

    void aggiornaStatus(Pokemon pokemonAttaccante, double danno) {
        /*
        * Aggiorno i punti salute del pokemon attaccato. Se essi sono inferiori o uguali a 0, il pokemon non può più lottare.
        * */
        this.puntiSalute -= danno;
        if(this.isEsausto()) {
            this.puntiSalute = 0;
            System.out.println(this.getNome() + " è esausto e non può più lottare.");
        }
    }

    private boolean isEsausto() {
        return this.puntiSalute <= 0;
    }

    public void getStatus() {
        System.out.println("Pokemon: " + this.getNome() + "\nSalute: " + this.getPuntiSalute() + "\nTipo: " + this.getTipoPokemon());
    }

    /*
    * Getters
    * */
    public double getFattoreDiForza() {
        return fattoreDiForza;
    }

    public double getPuntiSalute() {
        return puntiSalute;
    }

    public Tipo getTipoPokemon() {
        return tipoPokemon;
    }

    public String getNome() {
        return nome;
    }

    /*
    * Setters
    * */
    protected void setTipo(Tipo tipo) { this.tipoPokemon = tipo; }
}
