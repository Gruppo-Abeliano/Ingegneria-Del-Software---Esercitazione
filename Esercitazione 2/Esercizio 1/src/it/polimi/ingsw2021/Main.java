package it.polimi.ingsw2021;

public class Main {

    public static void main(String[] args) {
        PuntoND[] verticiQuadrato = {new PuntoND(0.0, 0.0, 0.0), new PuntoND(0.0, 1.0, 0.0), new PuntoND(1.0, 1.0 , 1.0), new PuntoND(1.0, 0.0, 1.0)};
        Poligono quadrato = new Poligono(verticiQuadrato);
        double perimetroQuadrato = quadrato.getPerimetro();
        System.out.println("Il perimetro del quadrato è " + perimetroQuadrato);

        PuntoND[] verticiTriangolo = {new PuntoND(0.0, 0.0), new PuntoND(1.0, 0.0), new PuntoND(0.0, 1.0)};
        Poligono triangolo = new Poligono(verticiTriangolo);
        double perimetroTriangolo = triangolo.getPerimetro();
        System.out.println("Il perimetro del triangolo è " + perimetroTriangolo);

        PuntoND[] verticiParallelogramma = verticiQuadrato;
        Poligono parallelogramma = new Poligono(verticiParallelogramma);
        System.out.println("Il perimetro del parallelogramma è " +  parallelogramma.getPerimetro());
        System.out.println("Il perimetro del parallelogramma è " +  parallelogramma.getPerimetro());
        verticiParallelogramma[2].setCoordinata(1, verticiParallelogramma[2].getCoordinata(1) + 0.5);
        verticiParallelogramma[3].setCoordinata(1, verticiParallelogramma[3].getCoordinata(1) + 0.5);
        parallelogramma.setVertice(2, verticiParallelogramma[2]);
        parallelogramma.setVertice(3, verticiParallelogramma[3]);
        System.out.println("Il perimetro del parallelogramma è " +  parallelogramma.getPerimetro());

        Poligono rombo = (new Poligono())
                .appendVertice(new PuntoND(0.0,0.0))
                .appendVertice(new PuntoND(1.0,1.0))
                .appendVertice(new PuntoND(2.0,0.0))
                .appendVertice(new PuntoND(1.0,-1.0));
        System.out.println("Il perimetro del rombo è " +  rombo.getPerimetro());

        Poligono cubo = (new Poligono())
                .appendVertice(new PuntoND(0.0,0.0,0.0))
                .appendVertice(new PuntoND(1.0,0.0,0.0))
                .appendVertice(new PuntoND(1.0,1.0,0.0))
                .appendVertice(new PuntoND(0.0,1.0,0.0))
                .appendVertice(new PuntoND(0.0,1.0,1.0))
                .appendVertice(new PuntoND(1.0,1.0,1.0))
                .appendVertice(new PuntoND(1.0,0.0,1.0))
                .appendVertice(new PuntoND(0.0,0.0,1.0));
        cubo.chiudi();
        System.out.println("Il perimetro del cubo è " +  cubo.getPerimetro());

        System.out.println("-- RECAP --");
        System.out.println("QUADRATO        p = " + quadrato.getPerimetro());
        System.out.println("TRIANGOLO       p = " + triangolo.getPerimetro());
        System.out.println("PARALLELOGRAMMA p = " + parallelogramma.getPerimetro());
    }
}
