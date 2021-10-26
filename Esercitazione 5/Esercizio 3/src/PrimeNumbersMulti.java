public class PrimeNumbersMulti {
    private boolean isPrime(int number) {
        for(int i=2; i<=number; i++) {
            if(number%2==0)return false;
        }
        return true;
    }

    public void printPrimes(int first, int last) {
        for(int i=first;i<last;i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }

    public static void main(String args[]) {
        PrimeNumbersMulti pn = new PrimeNumbersMulti();
        int last = Integer.parseInt(args[0]);
        int nThread = Integer.parseInt(args[1]);
        int chunkSize = last/nThread + 1;

        for(int i=0;i<nThread;i++) {
            PrimePrinter p = new PrimePrinter(pn,i*chunkSize,Math.min(chunkSize,(i+1)*chunkSize));
            p.start();
        }
    }
}

/*
* Creo l'oggetto Thread che stamperà i numeri primi. Gli serve sapere quale intervallo stampare e ridefinire il metodo
* run.
* */
class PrimePrinter extends Thread {
    int first, last;
    PrimeNumbersMulti pn;

    public PrimePrinter(PrimeNumbersMulti pn, int first, int last) {
        this.first = first;
        this.last = last;
        this.pn = pn;
    }

    @Override
    public void run() {
        pn.printPrimes(this.first,this.last);
    }
}
