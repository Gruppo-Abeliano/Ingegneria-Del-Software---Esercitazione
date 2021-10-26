public class PrimeNumbersMultiCount {
    private boolean isPrime(int number) {
        for(int i=2; i<=number; i++) {
            if(number%2==0)return false;
        }
        return true;
    }

    public int countPrimes(int first, int last) {
        int numPrimes = 0;
        for(int i=first;i<last;i++) {
            if(isPrime(i)) numPrimes++;
        }

        return numPrimes;
    }

    public static void main(String args[]) {
        PrimeNumbersMultiCount pn = new PrimeNumbersMultiCount();
        int last = Integer.parseInt(args[0]);
        int nThread = Integer.parseInt(args[1]);
        int chunkSize = last/nThread + 1;
        PrimeCounter[] pc = new PrimeCounter[nThread];

        for(int i=0;i<nThread;i++) {
            pc[i] = new PrimeCounter(pn,i*chunkSize,Math.min(chunkSize,(i+1)*chunkSize));
            pc[i].start();
        }

        for(int i=0;i<nThread;i++) {
            try {
                pc[i].join();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        int total = 0;
        for(int i=0;i<nThread;i++) {
            total+=pc[i].getContaPrimi();
        }
        System.out.println(total);
    }
}

/*
 * Creo l'oggetto Thread che stamperà i numeri primi. Gli serve sapere quale intervallo stampare e ridefinire il metodo
 * run.
 * */
class PrimeCounter extends Thread {
    int first, last;
    int contaPrimi = 0;
    PrimeNumbersMultiCount pn;

    public PrimeCounter(PrimeNumbersMultiCount pn, int first, int last) {
        this.first = first;
        this.last = last;
        this.pn = pn;
        this.contaPrimi = 0;
    }

    @Override
    public void run() {
        this.contaPrimi += pn.countPrimes(this.first,this.last);
    }

    public int getContaPrimi() {
        return contaPrimi;
    }
}
