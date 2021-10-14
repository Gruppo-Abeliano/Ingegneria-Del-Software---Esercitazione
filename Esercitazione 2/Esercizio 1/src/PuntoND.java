public class PuntoND {
    private Double[] coordinatePunto;
    private int dimensione;

    public PuntoND(double[] arrayCoordinate) {
        /*
        * Costruisco un punto N-Dimensionale creando un nuovo oggetto ed assegnandolo ad una cella di coordinatePunto.
        * A fine scansione dell'array passato come input avrò un array di oggetti Double che identificano le
        * coordinate del punto nello spazio n-dimensionale. Salvo inoltre la dimensione dello spazio.
        * */
        int indice = 0;
        coordinatePunto = new Double[arrayCoordinate.length];
        for (double coordinata:arrayCoordinate) {
            coordinatePunto[indice] = coordinata;
            indice++;
            //System.out.println(coordinatePunto[indice]);
        }

        dimensione = coordinatePunto.length;

        //System.out.println(dimensione);
    }

    public double getDistanza(PuntoND punto2) {
        PuntoND punto1 = this;
        Double[] coordinatePunto1, coordinatePunto2;
        double sommaDiffereze = 0;


        coordinatePunto1 = punto1.coordinatePunto;
        coordinatePunto2 = punto2.coordinatePunto;

        for(int i=0;i<dimensione;i++) {
            sommaDiffereze += Math.pow((coordinatePunto1[i]-coordinatePunto2[i]), 2);
        }

        return Math.sqrt(sommaDiffereze);
    }
}
