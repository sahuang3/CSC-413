// TODO: Exercise 2 - Decorator
public class RoomDecDay extends RoomDecorator{

    public RoomDecDay(IRoom r){
        super(r);
    }

    public String update(String command, String progress){
        System.out.println("The sun is out!\n");
        return super.update(command, progress);
    }

}
