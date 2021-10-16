package it.polimi.ingsw2021;

public class Geometria {
    /**
    * Aver dichiarato la funzione static mi permette di invocarla senza creare un'istanza della classe Geometria.
    */
    static public double distanzaDa(PuntoND punto1, PuntoND punto2) {
        double acc = 0.0;
        for (int i = 1; i <= punto2.getDimensioni(); i++) {
            acc += Math.pow(punto2.getCoordinata(i) - punto1.getCoordinata(i), 2);
        }
        return Math.sqrt(acc);
    }
}
