package it.polimi.ingsw2021;

/**
 * Forma è un qualcosa che raggruppa molti oggetti astratti ma non sappiamo a priori com'è fatta e quindi non posso
 * costruire una forma generica.
 * Verrà poi ad esempio specificata in questo esercizio come poligono.
 */

public abstract class Forma {
    private String colore;

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public abstract Double getPerimetro();
}
