public class Cabin extends Room {
    public String update(String state, String progress) {
        // The Room base class has a state variable
        // we can use to create dynamic behavior
        // depending on progress through the game.
        //
        // The behavior can become more complex when
        // user input is also considered (i.e. the
        // "state" parameter of this update method).
        String roomState = this.state;

        if (state.equals("look") && roomState.equals("")) {
            // Case: input state says user entered "look" command
            // and the Room state is empty, meaning the user has not
            // looked around yet to find the book.
            System.out.println("There's something on the desk.");
            this.state = "found_book";
            return "found_book";
        } else if (state.equals("look") && roomState.equals("found_book")) {
            // Case: user entered "look" command and Room state
            // says the user already looked around and was told
            // about the desk. When this case is true, the user
            // must have entered the "look" command again after
            // being told about the desk. Give additional
            // instructions about the "look" command.
            System.out.println("There's something on the desk.\n" +
                    "Look at the desk by entering \"look desk\"");
            return "found_book";
        } else if (state.equals("look_desk") && roomState.equals("found_book")) {
            // Case: user entered "look desk" and has been
            // made aware of the book by looking around
            // the room. Read the book.
            System.out.println("""
                    You see an old, dusty book on the desk.
                    A scrap of paper is lodged between the pages..
                    The ink is smudged and the edges ragged, but you
                    can make out a few words...

                    $@^$H=~one who's eyes glow bright at night
                    and in watery orbs delights `', =?a &#5t*@
                    """);
            return "look_desk";
        } else {
            return "unknown";
        }
    }
}
