public class Forest extends Room {
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
                    You're engulfed in trees and branches. The air is
                    dense with the scent of pine and earth.
                    The air gusts through the canopy now and then..""");
            this.state = "look";

            return "look";
        } else if (state.equals("look") && roomState.equals("look")) {
            // Case: user has already been here.
            System.out.println("""
                    You're engulfed in trees and branches. The air is
                    dense with the scent of pine and earth.
                    The air gusts through the canopy now and then..
                    
                    You begin to feel comfortable here..""");

            return "look";
        }

        return "unknown";
    }
}
