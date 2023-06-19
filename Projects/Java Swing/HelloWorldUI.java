import javax.swing.*;
import java.awt.*;

public class HelloWorldUI extends JFrame {
    // JFrame is one of the available top-level classes used to create a GUI window.
    // The class containing the program's UI should inherit from JFrame.
    public HelloWorldUI() {
        // This constructor builds the GUI window
        super("My Graphical UI");
        this.setMinimumSize(new Dimension(250, 250));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Add the text "Hello, world" to the window
        this.add(new JLabel("Hello, world!"));

        // Assemble the window and display it
        this.pack();
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        // When the program starts, the HelloWorldUI constructor is called.
        SwingUtilities.invokeLater(HelloWorldUI::new);
    }
}