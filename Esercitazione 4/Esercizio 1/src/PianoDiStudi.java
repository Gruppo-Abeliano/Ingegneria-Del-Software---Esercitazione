import java.util.*;

public class PianoDiStudi implements Iterable<Corso>{
    /*
     * Uso una struttura dati del Collection Set per definire la lista di esami che compongono il piano di studi.
     * Rendo la lista di esami Package Visibile in modo tale da poter lavorare con l'iteratore costruito successivamente.
     * */
    List<Esame> esami;
    private Studente titolarePianoDiStudi;

    /*
    * Non scrivendo public, questa classe Esame è private ed è visibile solamente dentro al Piano di studi.
    * */
    static class Esame {
        private Data data = null;
        Corso corso;
        private Docente docente;
        private int voto = 0;
        private boolean lode = false;

        public Esame(Corso corso, Docente docente) {
            this.corso = corso;
            this.docente = docente;
        }
        public void setLode(boolean lode) { this.lode = lode; }
        public void setData(Data data) { this.data = data; }
    }

    /*
    * Definisco il costruttore di PianoDiStudi, assegnando un titolare al piano di studi in costruzione ed
    * inizializzando un ArrayList di elementi Esame (RICORDA: non i può istanziare oggetti di tipo List in quanto
    * non è classe reale, bensì un'interfaccia.
    * */
    public PianoDiStudi(Studente titolarePianoDiStudi) {
        this.titolarePianoDiStudi = titolarePianoDiStudi;
        this.esami = new ArrayList<Esame>();
    }

    /*
    * Per aggiungere un corso al piano di studi, di fatto aggiungo la sua entry nell'ArrayList. Ricordiamo che
    * l'esame di default ha data = null, voto = 0 e lode = false ed essi sono tutti valori che verranno compilati quando
    * l'esame relativo al corso verrà superato.
    * */
    public void addCorso(Corso corso, Docente docente) {
        this.esami.add(new Esame(corso, docente));
    }

    /*
    * Per superare l'esame di un corso, cerco nella lista la riga dell'esame del corso di interesse e gli setto
    * i parametri.
    * Se il corso non è presente nel piano di studio "lancio" un'eccezione che ho definito ad hoc (CorsoInesistenteException),
    * che va dichiarata all'intestazione del metodo perchè è di tipo checked.
    * */
    public void supera(Data data, int voto, boolean lode, Corso corso) throws CorsoInesistenteException{
        for (Esame esame : esami) {
            if(esame.corso.equals(corso)) {
                esame.data = data;
                esame.voto = voto;
                esame.lode = lode;
                return;
            }
        }

        throw new CorsoInesistenteException(corso.getNome() + " inesistente.");
    }

    /*
    * Controllo se un esame è stato superato, controllando se la data di sottomissione di tale esame non è null.
    * Cerco pertanto l'esame nella lista di esami iterando appunto la lista e se la trovo controllo effettivamente la data.
    * Se il corso non è presente nel piano di studio "lancio" un'eccezione che ho definito ad hoc (CorsoInesistenteException),
    * che va dichiarata all'intestazione del metodo perchè è di tipo checked.
    * */
    public boolean superato(Corso corso) throws CorsoInesistenteException{
        for(Esame esame : esami) {
            if(esame.corso.equals(corso)) {
                if(esame.data != null) return true;
                else return false;
            }
        }

        throw new CorsoInesistenteException(corso.getNome() + " inesistente.");
    }

    public void stampa() {
        System.out.println("Titolare: " + titolarePianoDiStudi);
        for(Esame esame : esami) {
            if(esame.data != null) {
                if(esame.lode) System.out.println(esame.corso+"\t("+esame.docente+")\t"+esame.data+"\t"+esame.voto+"L");
                else System.out.println(esame.corso+"\t("+esame.docente+")\t"+esame.data+"\t"+esame.voto);
            } else {
                System.out.println(esame.corso+"\t("+esame.docente+")");
            }
        }
    }

    /*
    * Getters
    * */
    public Studente getTitolarePianoDiStudi() { return titolarePianoDiStudi; }

    /*
    * Implemento un'iteratore per i corsi nella lista di esami.
    * */
    public Iterator<Corso> iterator() {
        return new MyIterator(this);
    }
}

class MyIterator implements Iterator<Corso> {
    private PianoDiStudi pianoDiStudi;
    private int current;
    public MyIterator(PianoDiStudi pianoDiStudi) {
        this.pianoDiStudi = pianoDiStudi;
        this.current = 0;
    }

    public boolean hasNext() { return current < pianoDiStudi.esami.size(); }
    public Corso next() {
        return pianoDiStudi.esami.get(current++).corso;
    }
}

