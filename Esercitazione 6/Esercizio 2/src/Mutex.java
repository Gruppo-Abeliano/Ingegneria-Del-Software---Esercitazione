/*
* Si implementi una classe Mutex con i metodi: lock, unlock e tryLock.
* */

public class Mutex {
    /*
    * Mi serve un attrivuto booleano per identificare se sono in stato di lock o meno.
    * Inoltre utilizzo un attriuto thread per poter specificare in seguito
    * */
    private Boolean locked;
    private Thread locker;

    public Mutex() {
        this.locked = false;
    }

    synchronized public void lock() throws Exception{
        /*
        * Se l'oggetto è lockato allora aspetto che venga sbloccato. Altrimento lo locko e salvo il thread che locka
        * per poter successivamente controllare che sia tale thread a sbloccare l'oggetto.
        * */
        while (this.locked) this.wait();

        this.locked = true;
        this.locker = Thread.currentThread();
    }
    synchronized public void unlock() throws IllegalArgumentException{
        /*
        * Controllo che chi unlocka sia lo stesso thread che sta lockando l'oggetto. In caso non fosse così c'è un
        * problema e sollevo un'eccezione.
        *
        * Se tutto è OK allora procedo ad unlockare l'oggetto e fare una notify per svegliare un thread in coda se
        * presente.
        * */
        if(this.locker != Thread.currentThread()) throw new IllegalArgumentException();

        locked = false;
        locker = null;
        this.notify();
    }
    synchronized public boolean tryLock() {
        /*
        * Molto simile a lock(), tuttavia restituisce un booleano in base alla disponibilità dell'oggetto di essere lockato.
        * Se non posso lockare, restituisco false, altrimenti eseguo il lock e restituisco true.
        * */
        if(this.locked) return false;

        locked = true;
        locker = Thread.currentThread();
        return true;
    }
}
