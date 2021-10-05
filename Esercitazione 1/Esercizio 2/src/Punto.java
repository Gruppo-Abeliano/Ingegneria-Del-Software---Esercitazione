public class Punto {
    /*
    * Ogni punto ha 2 coordinate, essendo bidimensionale, ed un riferimento ad un altro punto che lo rende
    * inseribile in una lista concatenata di punti.
    * */
    private double x;
    private double y;

    private Punto pNext;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        this.pNext = null;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setRef(Punto pNext) {
        this.pNext = pNext;
    }
    public Punto getRef() {
        return pNext;
    }
}
