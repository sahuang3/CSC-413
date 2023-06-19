public class Well extends Room {
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
            // looked around yet to see the well.
            System.out.println("""
                    You enter a clearing with a small stone ~well~.
                    "A wooden beam supports a rope hanging down the
                    "well. Something seems to be at the end of it..""");

            this.state = "look_well";

            return "look_well";
        } else if (command.equals("look") && roomState.equals("look_well")) {
            // Case: input state says user entered "look" command
            // and the Room state is empty, meaning the user has not
            // looked around yet to see the well.
            System.out.println("""
                    You see a small stone ~well~. There seems to be something
                    at the bottom, dangling from the rope.""");

            return "look_well";
        } else if (command.equals("use_well") && roomState.equals("look_well")
                && progress.equals("look_statue")) {
            System.out.println("""
                    You pull on the rope.. As it ascends
                    a light at the bottom grows brighter..
                    
                    When it reaches the surface, you take the
                    glowing ~orb~ from the bucket it sat in.""");

            return "use_well";
        }

        return "unknown";
    }
}
