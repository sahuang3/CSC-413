import java.util.Scanner;
// Using Regular class
public class Calculator {
    private final Scanner input;

    public Calculator() {
        this.input = new Scanner(System.in);
        //
    }

    public void menuLoop() {
        String option = "";

        while (true) {
            showMenu();

            option = getOption();
            if (option.equals("quit")) {
                System.out.println("Quitting...");
                return;
            }
            /*
            double x = getValue();
            double y = getValue();

            doOperation(option, x, y);
            */
            double result = doOperation(option);

        }
    }
    public String getOption(){
        String value = this.input.next();
        return value;
    }

    public double getValue(){
        double value = this.input.nextDouble();
        return value;
    }


    public void showMenu(){
        System.out.println("Pick an Operation");
        System.out.println("Add");
        System.out.println("Subtract");
    }

    public void doOperation(String operation, double x, double y){
        double result = 0.0;
        Operation op;

        switch (operation){
            case "add":
                System.out.println("Adding...");
                /* Method 1:
                result = x + y;
                System.out.println(x + " + " + y + " = " + result);
                */
                // Method 2:
                op = new Add();
                result = op.process();
                op.displayResult(result);
                break;

            case "sub":
                System.out.println("Subtracting...");
                /*
                result = x - y;
                System.out.println(x + " - " + y + " = " + result);
                */
                op = new Sub();
                result = op.process();
                op.displayResult(result);
                break;
        }
    }
}



