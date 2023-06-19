// For Observer
public class Echo implements Observer{
    public void update(String event){
        System.out.println("Echo: " + event);
    }
}
