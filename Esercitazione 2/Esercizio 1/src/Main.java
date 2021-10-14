public class Main {
    public static void main(String[] args) {
        Poligono quadrato,cubo;

        quadrato = new Poligono(2, new PuntoND[]{
                new PuntoND(new double[]{0.0,0.0}),
                new PuntoND(new double[]{1.0,0.0}),
                new PuntoND(new double[]{1.0,1.0}),
                new PuntoND(new double[]{0.0,1.0}),
        });

        cubo = new Poligono(3, new PuntoND[]{
                new PuntoND(new double[]{0.0,0.0,0.0}),
                new PuntoND(new double[]{1.0,0.0,0.0}),
                new PuntoND(new double[]{1.0,1.0,0.0}),
                new PuntoND(new double[]{0.0,1.0,0.0}),
                new PuntoND(new double[]{0.0,1.0,1.0}),
                new PuntoND(new double[]{0.0,0.0,1.0}),
                new PuntoND(new double[]{1.0,0.0,1.0}),
                new PuntoND(new double[]{1.0,1.0,1.0}),
        });

        System.out.println("Il perimetro del quadrato è: " + quadrato.getPerimetro() + " ed il perimetro del cubo è: "+ cubo.getPerimetro());
    }
}
