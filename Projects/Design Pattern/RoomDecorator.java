public abstract class RoomDecorator implements LookGenerator{

    private final LookGenerator generator;

    public RoomDecorator(LookGenerator generator){
        this.generator = generator;
    }

    public void look(String room){
        generator.look(room);
    }
}
