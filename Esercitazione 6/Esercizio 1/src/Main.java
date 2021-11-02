public class Main {
    public static void main(String[] args) {
        Printer printer1 = new Printer();
        Printer printer2 = new Printer();

        printer1.print("Ciao1");
        printer2.print("Ciao2");
        printer1.print("Ciao2");
    }
}
