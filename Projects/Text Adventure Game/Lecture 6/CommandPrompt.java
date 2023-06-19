public class CommandPrompt {
    public static String processCommand(World world, String progress, String input) {
        // Process the input to separate into command and subject
        String newState = "";
        String command = "";
        String subject = "";
        IRoom currentRoom = world.getCurrentRoom();

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
                world.setCurrentRoom(exit);
                world.runGame(progress);
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
}
