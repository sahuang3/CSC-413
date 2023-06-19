// For Observer
public interface EventSourceInterface {
    public void updateObservers(String event);
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
}
