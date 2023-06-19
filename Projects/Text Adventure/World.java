// SINGLETON
import java.util.Scanner;

public class World {

    public IRoom curRoom;

    public World(){

        System.out.println("You enter a vast realm of computational adventure!");

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

    // Game I/O (i.e. command/response) loop
    public static void runGame(World world, String progress) {
        // Command prompt
        System.out.print("\n>  ");
        String input = ""; 			// Raw input
        String newState = "unknown"; // Track result of commands

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        // Update game state by running command
        newState = CommandPrompt.processCommand(world, progress, input);

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
        runGame(world, progress);
    }

}
