// IF light, print room number + description
public class LightDecorator extends RoomDecorator{
    public LightDecorator(LookGenerator generator){
        super(generator);
    }

    public void look(String room){
        System.out.println("Room: " + room);
        super.look(room);
    }
}
