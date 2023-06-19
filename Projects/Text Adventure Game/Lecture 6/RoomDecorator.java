// TODO: Exercise 2 - Decorator
public abstract class RoomDecorator extends Room {
    private IRoom room;
    public RoomDecorator(IRoom r){
        this.room = r;
    }
    public String update(String command, String progress){
     return room.update(command, progress);
    }
}
