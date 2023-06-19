import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class EventSource implements EventSourceInterface{
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void updateObservers(String event){
        for(int i=0; i < observers.size(); i++){
            observers.get(i).update(event);
        }
    }

    public void getInput(){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        updateObservers(input);
    }

}
