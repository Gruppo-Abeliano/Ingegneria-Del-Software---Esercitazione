/*
* Java implementa il tipo Date. Implementiamo la nostra classe data come segue per esercitazione.
* */
public class Data {
    private int giorno,mese,anno;

    public Data(int giorno, int mese, int anno) {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int getAnno() {
        return anno;
    }

    @Override
    public String toString() {
        return giorno+"/"+mese+"/"+anno;
    }
}
