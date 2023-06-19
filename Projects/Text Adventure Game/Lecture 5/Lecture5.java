import java.util.Scanner;

public class Lecture5 {
    public static void main(String[] args) {
        System.out.println("Welcome to Adventures of CSC!\n\n");

        mainMenu();
    }

    public static void mainMenu() {
        // Display menu options
        System.out.println("""
        Choose an option:
        1) New Game
        2) Exit
        """);

        // Get an integer option from the user
        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        // Decide what to do
        switch (choice) {
            case 1:
                World newWorld = new World();
                newWorld.runGame(newWorld, "start");
                break;
            case 2:
                System.out.println("Thanks for playing!");
                return;
        }

        // Repeat menu options until a valid choice is entered
        mainMenu();
    }

    /* BEFORE SINGLETON
    public static void newGameMenu() {
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

        // Run game loop
        runGame(cabin, "start");
    }

    public static String processCommand(IRoom currentRoom, String progress, String input) {
        // Process the input to separate into command and subject
        String newState = "";
        String command = "";
        String subject = "";

        int spaceIdx = input.indexOf(" "); // Find first space in input
        if (spaceIdx != -1) {
            // A space was found in the input string.
            // The input is (probably) a two-word command.
            command = input.substring(0, spaceIdx);
            subject = input.substring(spaceIdx+1);
        } else {
            // No space was found.
            // The input is a one-word command.
            command = input;
        }

        // Interpret the command

        // See if the user is attempting to use an exit.
        for (int i=0; i < currentRoom.getNumExits(); i++) {
            String exitDirection = currentRoom.getExitDirection(i);

            if (exitDirection.equals(command)) {
                // Move in the given direction
                IRoom exit = currentRoom.getExit(i);
                runGame(exit, progress);
            }
        }

        // Run generic commands
        if (command.equals("look") && subject.isEmpty()) {
            // Describe the room the player is in
            System.out.println("\n" + currentRoom.getName() + "\n");
            System.out.println(currentRoom.getDescription() + "\n");

            // Describe the exits
            System.out.println("Exits: ");
            for (int i=0; i < currentRoom.getNumExits(); i++) {
                try {
                    // An exception is thrown if index is out of bounds
                    IRoom exit = currentRoom.getExit(i);
                    String exitDirection = currentRoom.getExitDirection(i);

                    System.out.println(exitDirection + "     " + exit.getName());
                } catch (Exception e) {
                    //
                }
            }
        }
        System.out.println();

        // See if any logic is built into the room to respond
        // to the given command.
        if (subject.isEmpty()) {
            newState = currentRoom.update(command, progress);
        } else {
            newState = currentRoom.update(command + "_" + subject, progress);
        }

        return newState;
    }


    // Game I/O (i.e. command/response) loop
    public static void runGame(IRoom currentRoom, String progress) {
        // Command prompt
        System.out.print("\n>  ");
        String input = ""; 			// Raw input
        String newState = "unknown"; // Track result of commands

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        // Update game state by running command
        newState = processCommand(currentRoom, progress, input);

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
        runGame(currentRoom, progress);
    }

     */
}
