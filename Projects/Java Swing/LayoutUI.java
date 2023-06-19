import javax.swing.*;
import java.awt.*;

public class LayoutUI extends JFrame {
    // JFrame is one of the available top-level classes used to create a GUI window.
    // The class containing the program's UI should inherit from JFrame.
    JLabel label;
    public LayoutUI() {
        // This constructor builds the GUI window
        super("My Graphical UI");
        this.setMinimumSize(new Dimension(250, 250));
        this.setPreferredSize(new Dimension(250, 250));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create a content pane
        JPanel pane = new JPanel();
        BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        // Create components
        label = new JLabel("Hello, world!");

        JButton button = new JButton("Click");
        button.setPreferredSize(new Dimension(120, 40));

        // Add components
        pane.add(label);
        pane.add(button);

        // Assemble and display the window
        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(LayoutUI::new);
    }
}