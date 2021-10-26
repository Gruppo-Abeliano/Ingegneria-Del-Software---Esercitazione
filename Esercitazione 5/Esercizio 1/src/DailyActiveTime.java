public class DailyActiveTime implements ActivityObserver{
    private int durataTotale;

    public DailyActiveTime(ActivityTracking tracker) {
        tracker.attach(this);
    }

    public void attTerminata(Activity act) {
        durataTotale += act.getDurata();
    }
}
