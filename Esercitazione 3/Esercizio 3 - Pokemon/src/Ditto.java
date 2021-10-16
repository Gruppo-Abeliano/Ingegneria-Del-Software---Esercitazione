public class Ditto extends Pokemon{
    public Ditto(String nomePokemon, Tipo tipoPokemon, double forza) {
        super(nomePokemon,tipoPokemon,forza);
    }

    @Override
    public void attacca(Pokemon pokemonDaAttaccare) {
        super.attacca(pokemonDaAttaccare);

        /*
        * Aggiungo ad attacca la proprietà speciale di Ditto quando attacca.
        * */
        if(this.getPuntiSalute() > 10.0) {
            this.setTipo(pokemonDaAttaccare.getTipoPokemon());
        }
    }

    @Override
    void aggiornaStatus(Pokemon pokemonAttaccante, double danno) {
        super.aggiornaStatus(pokemonAttaccante,danno);

        /*
         * Aggiungo ad aggiornaStatus la proprietà speciale di Ditto quando subisce molti danni e la sua salute scende
         * sotto il 10%.
         * */
        if(this.getPuntiSalute() <= 10) this.setTipo(Tipo.NORMALE);
    }
}
