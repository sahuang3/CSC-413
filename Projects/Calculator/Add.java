// Sub-class of Operation class
public class Add extends Operation{
    public Add(){
        super();
    }
    public double process(){
        super.process();

        return this.x + this.y;
    }

    public void displayResult(double result){
        System.out.println(x + " + " + y + " = " + result);
    }
}
