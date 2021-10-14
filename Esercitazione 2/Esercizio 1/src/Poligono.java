public class Poligono {
    private int numeroDimensioni;
    private PuntoND[] vertici;
    private Double perimetro = null;

    public Poligono(int numeroDimensioni, PuntoND[] arrayDiVertici) {
        /*
        * Ogni volta che creo un poligono definisco la dimensione dello spazio in cui esso è costruito (numeroDimensioni)
        * e l'insieme di vertici che lo compongono.
        * */
        this.numeroDimensioni = numeroDimensioni;
        this.vertici = new PuntoND[arrayDiVertici.length];

        for (int i=0; i< arrayDiVertici.length; i++) {
            this.vertici[i] = arrayDiVertici[i];
        }
    }

    public double getPerimetro() {
        if (this.perimetro != null) {
            return this.perimetro;
        } else {
            double perimetro = 0.0;
            for (int i = 0; i < vertici.length; i++) {
                PuntoND punto1 = vertici[i];
                PuntoND punto2 = vertici[(i + 1) % vertici.length];

                perimetro += punto1.getDistanza(punto2);
            }

            this.perimetro = perimetro;
            return perimetro;
        }
    }

    public void setVertice(int i, PuntoND punto) {
        this.vertici[i] = punto;

        /*
        * Ogni volta che resetto un punto devo ricalcolare il perimetro.
        * */
        this.perimetro = null;
        this.getPerimetro();
    }
}
