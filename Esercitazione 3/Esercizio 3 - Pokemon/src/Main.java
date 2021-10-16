public class Main {
    public static void main(String[] args) {
        Pokemon Turtwig = new Pokemon("Turtwig", Pokemon.Tipo.ERBA,10.0);
        Pokemon Chimchar = new Pokemon("Chimchar", Pokemon.Tipo.FUOCO, 10.0);
        Pokemon Piplup = new Pokemon("Piplup", Pokemon.Tipo.ACQUA, 10.0);
        Pokemon Ditto = new Ditto("Ditto", Pokemon.Tipo.NORMALE, 10.0);


        Turtwig.attacca(Piplup);
        Ditto.attacca(Chimchar);

        Turtwig.getStatus();
        Chimchar.getStatus();
        Piplup.getStatus();
        Ditto.getStatus();

        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);
        Chimchar.attacca(Ditto);

        Ditto.getStatus();
    }
}
