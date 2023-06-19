import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ScreenBuffer {
    private String[] rows;
    private int height;
    private int width;
    private Deque<Sprite> sprites = new LinkedList<Sprite>();

    public ScreenBuffer(int w, int h) {
        height = h;
        width = w;
        rows = new String[height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rows[i] += " ";
            }
        }
    }

    public void fill(char c) {
        for (int i = 0; i < height; i++) {
            char[] row = rows[i].toCharArray();

            for (int j = 0; j < width; j++) {
                row[j] = c;
            }

            rows[i] = String.valueOf(row);
        }
    }

    public void clear() {
        fill(' ');
    }

    public void draw() {
        draw(true);
    }

    public void draw(boolean clear) {
        if (clear) {
            clear();
        }

        for (Sprite sprite : sprites) {
            drawSprite(sprite);
        }

        for (int i = 0; i < height; i++) {
            System.out.println(rows[i]);
        }
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }

    public void drawSprite(Sprite sprite) {
        for (int y = 0; y < height; y++) {
            char[] row = rows[y].toCharArray();

            for (int x = 0; x < width; x++) {
                char symbol = sprite.getSymbol(x, y);
                if (symbol != ' ') {
                    row[x] = symbol;
                }
            }

            rows[y] = String.valueOf(row);
        }
    }
}
