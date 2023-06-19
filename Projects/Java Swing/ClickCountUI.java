import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClickCountUI extends JFrame implements ActionListener {
    // JFrame is one of the available top-level classes used to create a GUI window.
    // The class containing the program's UI should inherit from JFrame.
    //
    // ActionListener is an interface analogous to the Observer.
    // Implementing the method actionPerformed(ActionEvent e)
    // allows the program to respond to UI events like mouse clicks.
    JButton button;
    JTextField text;
    JLabel label;
    JPanel pane;
    int clicks;

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("button_clicked")) {
            clicks++;
            System.out.println("Button pressed. Count: " + clicks + " times");
            label.setText("Clicks: " + clicks);
        } else if(e.getActionCommand().equals("text_entered")){
            String s = text.getText();
            System.out.println("Entered text: " + s);
            label.setText(s);
        }
    }

    public ClickCountUI() {
        super("Click count UI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        clicks = 0;

        // Setting up content pane
        pane = new JPanel();
        BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        // Setting up elements
        label = new JLabel("No Clicks");

        button = new JButton("Click Me!");
        button.setPreferredSize(new Dimension(50, 50));

        text = new JTextField("Enter text here!");
        text.setEditable(true);
        text.setActionCommand("text_entered");

        // Connect button
        button.setActionCommand("button_clicked");
        button.addActionListener(this);
        text.addActionListener(this);

        // Add components to content pane
        pane.add(label);
        pane.add(text);
        pane.add(button);

        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(ClickCountUI::new);
    }
}