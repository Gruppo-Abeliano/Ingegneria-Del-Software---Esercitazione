public class Main {
    public static void main(String[] args) {
        /*
        * Istanzio uno stack di punti ed eseguo alcune operazioni implementate su di esso.
        * */
        PointStackedSet stackA = new PointStackedSet();
        Punto popReturnPoint, scorriLista;

        stackA.push(new Punto(1,1),new Punto(2,2));

        /*
        * Siccome posso estrarre più punti alla volta, quando ottengo il primo punto estratto, è possibile che io abbia
        * estratto in realtà una parte di linked list. Pertanto la scorro tutta e la mostro a video.
        * */
        popReturnPoint = stackA.pop(2);
        scorriLista = popReturnPoint;
        while (scorriLista != null) {
            System.out.println("Dati del punto estratto dallo stack: x = " + scorriLista.getX() + " y = " + scorriLista.getY());
            scorriLista = scorriLista.getRef();
        }

        /*
        * Visualizzo infine lo stato dello stack dopo le operazioni fatte su di esso.
        * */
        stackA.showStack();
    }
}
