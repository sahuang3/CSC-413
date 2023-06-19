public class Sprite {
    private final String[] rows;
    private int x;
    private int y;
    private boolean visible;

    public Sprite(String[] rows) {
        // A sprite is a small image typically
        // representing a component of a 2D video game.
        // Because our sprite will only be printed to
        // the console, our "artwork" consists of
        // several rows of strings.
        this.rows = rows;


        // The sprite's X and Y coordinates
        // track its position in the game
        // world, not on the screen.
        x = 0;
        y = 0;
        visible = true;
    }

    public int getWidth() {
        return rows[0].length();
    }

    public int getHeight() {
        return rows.length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // To render the sprite, we need to test
    // whether a sprite is covering a given
    // screen pixel.
    //
    // We can accomplish this by allowing a user
    // such as the ScreenBuffer to check what
    // should be drawn to correctly display
    // this sprite at a given screen location.
    //
    // To do this, we need to convert the
    // screen coordinates to local coordinates,
    // i.e. a point relative to the top-left
    // corner of the sprite, rather than the
    // screen.
    public char getSymbol(int screenX, int screenY) {
        if (!visible) {
            return ' ';
        }

        try {
            return rows[screenY - this.y].charAt(screenX - this.x);
        } catch (Exception e) {
            return ' ';
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
