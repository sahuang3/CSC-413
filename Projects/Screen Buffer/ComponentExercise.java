public class ComponentExercise {
    public static void main(String[] args) {
        // The ScreenBuffer class represents the area
        // of the screen we are drawing sprites on.
        // It has a fixed width and height, and
        // sprites outside the boundaries are
        // not rendered.
        ScreenBuffer buffer = new ScreenBuffer(20, 10);
        SpriteFactory factory = new SpriteFactory();

        // Note: The "working path", where the computer
        // looks for the files, is the root directory
        // of the project. i.e. Where the "src/" folder is.
        Sprite s = factory.load("./character.txt");
        s.setPosition(2, 3);

        // Add the sprite to the screen buffer and
        // draw the contents of the screen buffer.
        buffer.addSprite(s);
        buffer.draw();
    }
}
