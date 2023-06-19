// If dark, print "It's dark"
public class DarkDecorator extends RoomDecorator{
    public DarkDecorator(LookGenerator generator){
        super(generator);
    }

    public void look(String room){
        System.out.println("It's dark!");
        super.look(room);
    }
}
