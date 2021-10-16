public class PointStackedSet {
    /*
    * Organizzo lo stack di punti come una lista dinamica, le cui operazioni di pop e di push sono effettuate
    * in testa alla lista.
    * */
    private Punto insiemeDiPunti;

    public PointStackedSet() {
        insiemeDiPunti = null;
    }

    public void push(Punto... nuoviPunti) {
        /*
        * Come detto in precedenza i punti vengono aggiunti in testa alla lista. La gestione dei puntatori
        * è semplice in quanto si utilizzano fino da subito dei riferimenti ad oggetti di tipo Punto.
        * In questa variante dell'esercizio, i punti sono aggiunti allo stack solamente se non è già presente all'interno
        * un punto uguale.
        * */
        Punto scorriLista;
        boolean validPush;

        for(Punto punto:nuoviPunti) {
            /*
             * Verifico l'unicità del punto in inserimento.
             * */
            scorriLista = insiemeDiPunti;
            validPush = true;

            while (scorriLista != null) {
                if (scorriLista.equals(punto)) validPush = false;
                scorriLista = scorriLista.getRef();
            }

            /*
             * Se il punto non è duplicato lo pusho sullo stack.
             * */
            if(validPush) {
                if (insiemeDiPunti == null) {
                    insiemeDiPunti = new Punto(punto.getX(), punto.getY());
                    insiemeDiPunti.setRef(null);
                } else {
                    Punto oldRef = insiemeDiPunti;
                    insiemeDiPunti = new Punto(punto.getX(), punto.getY());
                    insiemeDiPunti.setRef(oldRef);
                }
            }
        }
    }

    public Punto pop(int numeroPuntiDaEstrarre) {
        /*
        * Anche l'estrazione è semplice. Il garbage collector ci permette di non curarci dell'oggetto dereferenziato
        * in quanto la pulizia dell'heap è svolta in automatico.
        * */

        /*
        * Volendo aver la possibilità di estrarre più punti contemporaneamente accetto come parametro il numero di punti
        * da estrarre. A questo punto assegnerò a toReturn il riferimento del primo Punto, mentre ad insieme di punti
        * il riferimento del numeroPuntiDaEstrarre-esimo punto + 1.
        * */
        int i=0;
        Punto scorriLista;

        scorriLista = insiemeDiPunti;
        while(i < numeroPuntiDaEstrarre) {
            scorriLista = scorriLista.getRef();
            i++;
        }

        Punto toReturn = insiemeDiPunti;
        insiemeDiPunti = scorriLista;

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
