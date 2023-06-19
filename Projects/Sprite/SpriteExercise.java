public class SpriteExercise {
    public static void main(String[] args) throws InterruptedException {
        // The ScreenBuffer class represents the area
        // of the screen we are drawing sprites on.
        // It has a fixed width and height, and
        // sprites outside the boundaries are
        // not rendered.
        ScreenBuffer buffer = new ScreenBuffer(20, 10);

        // Sprites represent the individual images
        // drawn to the screen. This sprite
        // will remain in a fixed position on the
        // screen while another sprite moves
        // across it.
        Sprite backgroundSprite = new Sprite("background");
        backgroundSprite.setPosition(6, 5);
        buffer.addSprite(backgroundSprite);

        Sprite movingSprite = new Sprite("character");
        movingSprite.setPosition(0, 0);
        buffer.addSprite(movingSprite);

        // An example of animation. Notice that
        // as the moving sprite overlaps with
        // the background sprite, the moving
        // sprite appears transparent. The
        // background can still be seen.
        for (int i = 0; i < 50; i++) {
            // To slow down the loop to render
            // the animation at 1 frame per
            // second, we wait 1000ms before
            // drawing a new frame.
            Thread.sleep(1000);

            // The screen buffer is cleared
            // of any sprites to start each
            // frame with a blank slate.
            buffer.clear();

            // Then we can update the position of
            // the moving sprite in the game world.
            movingSprite.setPosition(i % 10, i % 5);

            // And draw the sprite in the new location
            // as it appears on the screen.
            buffer.draw();
        }
    }
}
