public class PointStackedSet {
    /*
    * Organizzo lo stack di punti come una lista dinamica, le cui operazioni di pop e di push sono effettuate
    * in testa alla lista.
    * */
    private Punto insiemeDiPunti;

    public PointStackedSet() {
        insiemeDiPunti = null;
    }

    public void push(Punto nuovoPunto) {
        /*
        * Come detto in precedenza i punti vengono aggiunti in testa alla lista. La gestione dei puntatori
        * è semplice in quanto si utilizzano fino da subito dei riferimenti ad oggetti di tipo Punto.
        * */
        if(insiemeDiPunti == null) {
            insiemeDiPunti = new Punto(nuovoPunto.getX(), nuovoPunto.getY());
            insiemeDiPunti.setRef(null);
        } else {
            Punto oldRef = insiemeDiPunti;
            insiemeDiPunti = new Punto(nuovoPunto.getX(), nuovoPunto.getY());
            insiemeDiPunti.setRef(oldRef);
        }
    }

    public Punto pop() {
        /*
        * Anche l'estrazione è semplice. Il garbage collector ci permette di non curarci dell'oggetto dereferenziato
        * in quanto la pulizia dell'heap è svolta in automatico.
        * */
        Punto toReturn = insiemeDiPunti;
        insiemeDiPunti = toReturn.getRef();

        return toReturn;
    }

    public void showStack() {
        /*
        * Scorro semplicemente lo stack quando esso non è vuoto.
        * */
        Punto scorriLista = this.insiemeDiPunti;

        if(scorriLista == null) {
            System.out.println("Lo stack è vuoto.");
            return;
        }

        while(scorriLista != null) {
            System.out.println("x: "+scorriLista.getX()+" y: "+scorriLista.getY());
            scorriLista = scorriLista.getRef();
        }
    }
}
