import java.util.Scanner;

public class World {
    private IRoom curRoom;
    private static World INSTANCE = null; // TODO: Exercise 1 - Singleton (Creating world)
    private int timeOfDay = 0; // TODO: Exercise 2 - Decorator

    private World() { // TODO: change to private, so that there's no way to externally create a new world
        // Set up game world
        Cabin cabin = new Cabin();
        cabin.setName("Cabin");
        cabin.setDescription("An old cabin.");

        Garden garden = new Garden();
        garden.setName("Garden");
        garden.setDescription("A garden in a forest clearing.");

        Forest forest1 = new Forest();
        forest1.setName("Forest");
        forest1.setDescription("There are trees here.");

        Forest forest2 = new Forest();
        forest2.setName("Forest");
        forest2.setDescription("There are trees here.");

        Well well = new Well();
        well.setName("Well in a Clearing");
        well.setDescription("Someone put a well in a clearing. Hmm..");

        cabin.setExit("out", garden);
        garden.setExit("cabin", cabin);
        garden.setExit("south", forest1);

        forest1.setExit("north", garden);
        forest1.setExit("south", forest2);

        forest2.setExit("north", forest1);
        forest2.setExit("south", well);

        well.setExit("north", forest2);

        curRoom = cabin;
    }

    // TODO: Exercise 1 - Singleton (Creating world)
    public static World getInstance(){
        if(INSTANCE == null){
            INSTANCE = new World();
        }
        return INSTANCE;
    }

    // Game I/O (i.e. command/response) loop
    public void runGame(String progress) {
        // TODO: Exercise 2 - Decorator (Each time a command is run, update time of day)
       timeOfDay += 1;
       if (timeOfDay >= 24){
           timeOfDay = 0;
       }

        // Command prompt
        System.out.print("\n>  ");
        String input = ""; 			// Raw input
        String newState = "unknown"; // Track result of commands

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        // Update game state by running command
        newState = CommandPrompt.processCommand(this, progress, input);

        // Handle progress updates if new state indicates quest progression.
        if (newState.equals("use_well")) {
            progress = "use_well"; // Player collected orb from well
        } else if (newState.equals("look_statue")) {
            progress = "look_statue";
        } else if (newState.equals("use_orb")) {
            progress = "use_orb";
        } else if (newState.equals("done")) {
            progress = "done";
            System.out.println("\n\nCONGRATULATIONS! You finished a quest!");
        }

        // Repeat the command prompt without moving from the current room.
        // If an exit was chosen, the runGame() call above would run instead
        // to update the currentRoom.
        runGame(progress);
    }

    // TODO: Exercise 2 - Decorator, changed from "return curRoom" to lines 85-91;
    public IRoom getCurrentRoom() {
        RoomDecorator timeDecorator;
        if(timeOfDay > 12){
            timeDecorator = new RoomDecDay(curRoom);
        } else {
            timeDecorator = new RoomDecNight(curRoom);
        }
        return timeDecorator;
    }


    public void setCurrentRoom(IRoom room) {
        curRoom = room;
    }
}
