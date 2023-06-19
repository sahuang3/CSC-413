public class Garden extends Room {
    public String update(String command, String progress) {
        // The Room base class has a state variable
        // we can use to create dynamic behavior
        // depending on progress through the game.
        //
        // The behavior can become more complex when
        // user input is also considered (i.e. the
        // "state" parameter of this update method).
        String roomState = this.state;

        if (command.equals("look") && roomState.equals("")) {
            // Case: input state says user entered "look" command
            // and the Room state is empty, meaning the user has not
            // looked around yet to see the statue.
            System.out.println("""
                    You step out into a serene garden. The air smells of
                    lilac and roses, and the only sound is the occasional
                    rush of air through the trees..
                    ..and the unsettling hum of the ancient ~statue~
                    you notice complimenting the lilacs...""");

            this.state = "found_statue";

            return "found_statue";
        } else if (command.equals("look") && roomState.equals("found_statue")) {
            // Case: input state says user entered "look" command
            // and the Room state says the user has already
            // looked around and seen the statue.
            System.out.println("You step out into a serene garden.\n" +
                    "There is a ~statue~ here.");

            this.state = "found_statue";

            return "found_statue";
        } else if (command.equals("look_statue") && roomState.equals("found_statue")) {
            // Case: user entered "look statue" and has been
            // made aware of it by looking around the room.
            System.out.println("""
                    The statue's hum seems to fluctuate..
                    You hear a faint whisper... _= ^ ``
                    
                    --+``~=@ Youuuu there!|/__
                    ~~\\Could you help out an old statue?
                    `\\_/`I was once an adventurer as you are...
                    ^^\\)Until I was encased in this statue.__
                    |]}For.. reasons not entirely clear.
                    
                    All I need to continue my quest is an orb
                    the evil wizard hmmfrmmm dropped down a well.""");

            return "look_statue";
        } else if (command.equals("use_orb") && progress.equals("use_well")) {
            // Case: User has orb.
            System.out.println("""
                    The statue humms again..
                    
                    ||!!]} You have returned! And you have my orb!|}}]!
                    
                    |\\_ Thanks, I guess. _/|""");

            return "done";
        }

        return "unknown";
    }
}
