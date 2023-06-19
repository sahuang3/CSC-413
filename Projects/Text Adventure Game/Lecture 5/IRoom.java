import java.util.ArrayList;
import java.util.List;

public interface IRoom {
    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

    IRoom getExit(String direction);
    IRoom getExit(int idx);
    String getExitDirection(int idx);
    void setExit(String direction, IRoom room);
    int getNumExits();
    String update(String state, String progress);
}
