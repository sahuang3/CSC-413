public class GoodNightDecorator extends ResponseDecorator{
    public GoodNightDecorator(ResponseGenerator generator){
        super(generator);
    }

    public void reply(String name){
        System.out.print("Good Night, ");
        super.reply(name);
    }
}
