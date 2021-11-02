/*
 * Si implementi una classe Printer che forinisce un metodo print che inserisce un documento nella coda di stampa.
 * Un thread separato stampa i documenti in coda. Si consideri prima il caso di coda infinita, poi il caso di coda
 * limitata (in tal caso il metodo print deve sospendere il chiamante se la coda è piena).
 */

import java.util.*;

public class Printer extends Thread {
    private Queue<String> queue;

    public Printer() {
        /*
        * Il costruttore istanzia la coda come una linked list e fa partire il thread.
        * */
        queue = new LinkedList<String>();
        this.start();
    }

    synchronized public void print(String documentToPrint) {
        queue.add(documentToPrint);
        this.notify();
    }

    @Override
    public void run() {
        /*
        * Finchè ci sono elementi in coda li prelevo e li stampo. Se non trovo documenti da stampare metto in wait il
        * thread che stampa.
        * */
        String toPrint;
        while (true) {
            /*
            * Sincronizzo l'operazione che modifica la coda in quanto tale struttura dati è condivisa da più thread.
            * */
            synchronized (this) { toPrint = queue.poll(); }
            while (toPrint == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /*
            * Se pesco un elemento dalla coda lo stampo a video e metto in pausa il thread per 1 secondo.
            * */
            System.out.println("Stampando il documento...");
            System.out.println(toPrint);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fine stampa.");
        }
    }
}
