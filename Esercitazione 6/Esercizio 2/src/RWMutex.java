/*
* Si implementi una classe RWMutex con i metodi: readLock, writeLock, readUnlock e writeUnlock. Più lock in lettura sono
* possibili in contemporanea fin tanto che non vi siano un lock in scrittura.
* */

public class RWMutex {
    private int numeroReadLocker;
    private boolean writeLocked;

    public RWMutex() {
        /*
        * Alla costruzione posso avere sia thread che tentano di leggere, sia thread che tentano di scrivere.
        * */
        this.numeroReadLocker = 0;
        this.writeLocked = false;
    }

    synchronized public void readLock() throws InterruptedException{
        /*
        * Se non c'è un thread che scrive, allora posso sicuramente assegnare un lock ad un thread che tenta di leggere
        * (Questi ultimi possono essere potenzialmente infiniti). Se invece c'è un thread che scrive allora mi metto in
        * pausa.
        * */
        while(this.writeLocked) wait();

        this.numeroReadLocker++;
    }

    /*
    * Assumiamo che il chiamante della readUnlock sia il possessore del readLock.
    * */
    synchronized public void readUnlock() {
        /*
        * Diminuisco il contatore che indica i diritti di lettura che ho concesso ai thread. In caso non vi siano
        * ulteriori thread in lettura allora notifico un thread svegliandolo (che esso sia in lettura o in scrittura)
        * */
        this.numeroReadLocker--;

        if(this.numeroReadLocker == 0) this.notify();
    }

    synchronized public void writeLock() throws InterruptedException{
        /*
        * Se ci sono thread che stanno scrivendo o se ce ne sono in lettura allora non posso acquisire il lock e devo
        * attendere la loro fine.
        *
        * Non appena le condizione descritte non sono più verificate allora posso acquisire il lock per scrivere.
        * */
        while(this.writeLocked || this.numeroReadLocker > 0) wait();

        this.writeLocked = true;
    }

    /*
     * Assumiamo che il chiamante della writeUnlock sia il possessore del writeLock.
     * */
    synchronized public void writeUnlock() {
        /*
        * Sblocco il lock e notifico un thread in coda (se presente).
        * */
        this.writeLocked = false;
        this.notify();
    }
}
