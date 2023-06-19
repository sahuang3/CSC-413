public class GoodMorningDecorator extends ResponseDecorator{
    public GoodMorningDecorator(ResponseGenerator generator){
        super(generator);
    }

    public void reply(String name){
        System.out.print("Good Morning, ");
        super.reply(name);
    }
}
