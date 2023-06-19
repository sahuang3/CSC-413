// Factory example
public class GreetingFactory {
    public Greeting getGreeting(String option){
        if(option.equals("hello")){
            return new GreetHello();
        } else{
            return new GreetHowdy();
        }
    }
}
