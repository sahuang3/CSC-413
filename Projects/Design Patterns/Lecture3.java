import java.util.Scanner;

public class Lecture3 {

    public static void main(String[] args) {
        /*
        // Singleton
        System.out.println("Singleton:");
        Singleton helloWorldPrinter = Singleton.getInstance();
        helloWorldPrinter.printMessage();

        Singleton otherPrinter = Singleton.getInstance();
        otherPrinter.printMessage();


        // Decorator
        System.out.println("Decorator:");
        ResponseGenerator responder = new SimpleResponse();

        System.out.println("Morning or night? 1/2");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();

        if(choice == 1) {
            responder = new GoodMorningDecorator(responder);
        } else {
            responder = new GoodNightDecorator(responder);
        }
        responder.reply("Samson");


        // Factory
        String os = "Windows";
        UserInterfaceFactory factory;
        if(os.equals("Windows")){
            factory = new WindowsFactory();
        } else{
            factory = new MacFactory();
        }
        UserInterface ui = factory.getUserInterface(os);

        ui.draw();

        // Factory Example
        System.out.println("Factory Example:");
        GreetingFactory gfactory = new GreetingFactory();
        Greeting greeting = gfactory.getGreeting("hello");
        greeting.greet("Samson");


        // Observer
        System.out.println("Observer: ");
        EventSource s = new EventSource();
        Echo echo = new Echo();

        s.addObserver(echo);
        s.addObserver(new Echo());

        s.getInput();


        // Strategy
        System.out.println("Strategy: ");
        StrategyInterface numeric = new ValidateNumeric();
        Validator validator = new Validator(numeric);

        System.out.println(validator.validate("5"));
        System.out.println(validator.validate("five"));
        */


        // Memento
        System.out.println("Memento: ");
        StateOwner so = new StateOwner();
        so.setState("original state");
        so.printState();

        StateOwner.StateRecord original_state = so.saveSate();

        so.setState("other state");
        so.printState();
        so.setState("different state");
        so.printState();
        so.setState("vague state");
        so.printState();

        so.restoreState(original_state);
        so.printState();

    }
}
