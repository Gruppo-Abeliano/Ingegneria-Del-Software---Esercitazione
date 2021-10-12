package it.polimi.ingsw2021;

public class Poligono extends Forma{
    /**
    * Creo una macchina a stati per evidenziare lo stato del mio poligono.
    *   - Attraverso la enum creo un nuovo tipo.
    *   - dichiaro poi "private Stato statoPoligono" per dichiarare una variabile del tipo Stato appena definito.
    * */
    private enum Stato {VUOTO,APERTO,CHIUSO};

    private PuntoND[] vertici;
    private int next;
    private static final int MIN_CAPACITY = 3;
    private boolean perimetroValid = false;
    private Double perimetroCache = null;
    private Stato statoPoligono;

    /**
    * Voglio avere la possibilità di creare un poligono vuoto, ovvero un poligono inizializzato senza vertici.
    * In sostanza sto ricreando il mio costruttore di default.
    * */
    public Poligono() {
        this.vertici = new PuntoND[Poligono.MIN_CAPACITY];
        this.next = 0;
        this.setStato(Stato.VUOTO);
    }

    public Poligono(PuntoND[] vertici) {
        this();

        for(PuntoND vertice : vertici) {
            this.appendVertice(vertice);
        }

        this.setStato(Stato.CHIUSO);
    }

    public void setVertice(int i, PuntoND p) {
        this.vertici[i] = p;
        this.perimetroValid = false;
    }

    public void chiudi() {
        this.setStato(Stato.CHIUSO);
    }

    /**
    * Aggiungo i vertici del poligono punto per punto. Siccome l'array inizializzato ha dimensione fissa a MIN_CAPACITY
    * se eccedo questa dimensione devo espandere l'array (eseguito con expand()).
    * */
    public Poligono appendVertice(PuntoND puntoDaAggiungere) {
        boolean presente = false;
        for(PuntoND punto : this.vertici) {
            if(puntoDaAggiungere.equals(punto)) {
                presente = true;
            }
        }
        if(presente) {
            return this;
        }

        if(this.next >= this.vertici.length) {
            this.expand();
        }
        this.vertici[this.next] = puntoDaAggiungere;
        this.next++;
        this.setStato(Stato.APERTO);

        return this;
    }

    /**
     * Implementazione dell'interfaccia fornita dalla classe Forma.
     */
    public Double getPerimetro() {
        if (perimetroValid) {
            System.out.println("-- uso la cache --");
            return this.perimetroCache;
        } else {
            Double perimetro = null;

            switch (this.statoPoligono) {
                case CHIUSO:
                    perimetro = 0.0;
                    for (int i = 0; i < vertici.length; i++) {
                        PuntoND a = vertici[i];
                        PuntoND b = vertici[(i+1) % vertici.length];

                        perimetro += Geometria.distanzaDa(a,b);
                    }
                    break;
                case APERTO:
                    perimetro = 0.0;
                    for (int i = 0; i < vertici.length - 1; i++) {
                        PuntoND a = vertici[i];
                        PuntoND b = vertici[(i+1) % vertici.length];

                        perimetro += Geometria.distanzaDa(a,b);
                    }
                    break;
                case VUOTO:
                    perimetro = null;
                    break;
            }


            this.perimetroCache = perimetro;
            this.perimetroValid = true;
            return perimetro;
        }
    }

    private void setStato(Stato stato) {
        this.statoPoligono = stato;
        this.perimetroValid = false;
    }

    private void expand() {
        PuntoND[] newVertici = new PuntoND[this.vertici.length + 1];
        for (int i=0;i < this.vertici.length; i++) {
            newVertici[i] = this.vertici[i];
        }

        this.vertici = newVertici;
    }
}
