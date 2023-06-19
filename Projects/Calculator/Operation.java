import java.util.Scanner;

// Using Abstract class
public abstract class Operation {
    private final Scanner input;
    protected double x;
    protected double y;

    public Operation(){
        this.input = new Scanner(System.in);
    }

    public double getValue(){
        return this.input.nextDouble();
    }

    public void setParameters(){
        System.out.println("X: ");
        this.x = getValue();

        System.out.println("Y: ");
        this.y = getValue();
    }

    public double process(){
        setParameters();

        return 0;
    }

    public abstract void displayResult(double result);
}
