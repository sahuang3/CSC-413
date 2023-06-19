public class Sub extends Operation{
    public Sub(){
        super();
    }
    public double process(){
        super.process();

        return this.x - this.y;
    }

    public void displayResult(double result){
        System.out.println(x + " - " + y + " = " + result);
    }
}
