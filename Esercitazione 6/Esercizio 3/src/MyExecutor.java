/*
* Implemento un "gestore" di thread. Passando un runnable all'executor, esso lo da in gestione ad un suo thread. Notare
* che i thread non vengono creati e distrutti ogni volta, ma bensì creati una sola volta e poi in continua attività,
* attendendo che l'executor gli assegni un runnable.
* */
import java.util.*;

public class MyExecutor {
    /*
    * Istanzio una lista di runnable. Questi verranno prelevati dai thread disponibili per essere eseguiti.
    * */
    private List<Runnable> runnableObjList;

    public MyExecutor(int threadPoolSize) {
        /*
        * Istanzio la lista di runnable e creo tanti thread quanti sono stati definiti attraverso threadPoolSize.
        * */
        this.runnableObjList = new ArrayList<Runnable>();
        for (int i=0;i<threadPoolSize;i++) new MyThread().start();
    }
    public void esegui(Runnable runnableObj) {
        /*
        * Mi sincronizzo sulla lista di runnable per modificarla. Una volta aggiunto il runnable notifico eventuali
        * thread in attesa.
        * */
        synchronized (runnableObjList) {
            this.runnableObjList.add(runnableObj);
            notify();
        }
    }

    private class MyThread extends Thread {
        Runnable myJob;

        public void run() {
            /*
            * Verifico la presenza di un runnable nella lista ed in caso lo prelevo (acquisendo (se possibile) il lock)
            * e lo eseguo.
            * */
            while(true) {
                synchronized (runnableObjList) {
                    while (runnableObjList.isEmpty()) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    myJob = runnableObjList.remove(0);
                }

                myJob.run();
            }
        }
    }
}
