public class Main {
    public static void main(String[] args) {
        /*
        * Istanzio uno stack di punti ed eseguo alcune operazioni implementate su di esso.
        * */
        PointStackedSet stackA = new PointStackedSet();
        Punto popReturnPoint;

        stackA.push(new Punto(1,1),new Punto(2,2));

        popReturnPoint = stackA.pop();

        System.out.println("Dati del punto estratto dallo stack: x = " + popReturnPoint.getX() + " y = " + popReturnPoint.getY());

        stackA.showStack();
    }
}
