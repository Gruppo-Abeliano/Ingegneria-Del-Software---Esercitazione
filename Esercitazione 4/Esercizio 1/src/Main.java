public class Main {
    public static void main(String[] args) throws CorsoInesistenteException{
        PianoDiStudi pianoStudi = new PianoDiStudi(
          new Studente("Paolo", "Pertino", "paolo.pertino@mail.polimi.it",10729600)
        );
        Docente ingSwDocente = new Docente("Gianpaolo","Cugola","gianpaolo.cugola@polimi.it", Docente.Ruolo.ORDINARIO);
        Docente apiDocente = new Docente("Davide", "Martinenghi", "davide.martinenghi@polimi.it", Docente.Ruolo.ASSOCIATO);

        Corso corso1 = new Corso(100234, "Ingegneria del Software", 10);
        Corso corso2 = new Corso(100235, "Algoritmi e Principi dell'Informatica", 10);
        pianoStudi.addCorso(corso1,ingSwDocente);
        pianoStudi.addCorso(corso2, apiDocente);

        /*
        * Se l'eccezione è catturata nel try-catch una volta gestita il programma continua ad essere eseguito.
        * Altrimenti essa terminerebbe l'esecuzione del programma.
        * */
        try {
            pianoStudi.supera(new Data(10,10,2021),30,true,corso1);
        } catch (CorsoInesistenteException ex) {
            ex.printStackTrace();
        }
        try {
            pianoStudi.supera(new Data(26,8,2021),29,false,corso2);
        } catch (CorsoInesistenteException ex) {
            ex.printStackTrace();
        }

        pianoStudi.stampa();
    }
}
