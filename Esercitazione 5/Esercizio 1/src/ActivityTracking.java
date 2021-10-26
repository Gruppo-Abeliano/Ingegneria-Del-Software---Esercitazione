import java.util.List;
import java.util.ArrayList;

public class ActivityTracking {
    private List<ActivityObserver> observers;
    private Activity currentActivity;

    public ActivityTracking() {
        observers =  new ArrayList<ActivityObserver>();
        currentActivity = null;
    }

    public void startActivity(int tipo) {
        currentActivity = new Activity(tipo);
        // ...
    }
    public void terminaAttività() {
        // ...
    }

    public void attach(ActivityObserver observer) {
        observers.add(observer);
    }
    public void detach(ActivityObserver observer) {
        observers.remove(observer);
    }
    public void notifica() {
        for(ActivityObserver observer : observers) {
            observer.attTerminata(currentActivity);
        }
    }
}
