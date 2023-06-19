// TODO: Exercise 2 - Decorator
public class RoomDecNight extends RoomDecorator{

    public RoomDecNight(IRoom r){
        super(r);
    }

    public String update(String command, String progress){
        System.out.println("The stars are out\n");
        return super.update(command, progress);
    }
}
