import java.util.ArrayList;
import java.util.List;

public abstract class Room implements IRoom {
    protected final List<IRoom> exits = new ArrayList<>();
    protected final List<String> exitDirections = new ArrayList<>();
    protected String name;
    protected String description;
    protected String state;

    public Room() {
        name = "";
        description = "";
        state = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IRoom getExit(String direction) {
        for (int i = 0; i < getNumExits(); i++) {
            if (exitDirections.get(i).equals(direction)) {
                return exits.get(i);
            }
        }

        throw new RuntimeException("Invalid Index");
    }

    public IRoom getExit(int idx) {
        if (idx >= 0 && idx < getNumExits()) {
            return exits.get(idx);
        }

        throw new RuntimeException("Invalid Index");
    }

    public String getExitDirection(int idx) {
        if (idx >= 0 && idx < getNumExits()) {
            return exitDirections.get(idx);
        }

        throw new RuntimeException("Invalid Index");
    }

    public void setExit(String direction, IRoom room) {
        // Determine if direction has already been set
        for (int i=0; i < getNumExits(); i++) {
            if (exitDirections.get(i).equals(direction)) {
                // Direction requested is stored at index "i"
                exitDirections.set(i, direction);
                exits.set(i, room);
            }
        }

        // If not, add the new direction
        exitDirections.add(direction);
        exits.add(room);
    }
    public int getNumExits() {
        return exits.size();
    }

    public abstract String update(String state, String progress);
}
