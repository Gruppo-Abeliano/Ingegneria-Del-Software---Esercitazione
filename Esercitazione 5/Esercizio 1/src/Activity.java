public class Activity {
    int tipo;
    int durata;
    int calorie;

    public Activity(int tipo) {
        this.tipo = tipo;
        this.durata = 0;
        this.calorie = 0;
    }

    public int getCalorie() {
        return calorie;
    }

    public int getDurata() {
        return durata;
    }

    public int getTipo() {
        return tipo;
    }

    public void inizia() {/*...*/}
    public void termina() {/*...*/}
}
