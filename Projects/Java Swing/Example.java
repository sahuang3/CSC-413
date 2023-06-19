import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* TODO: Write a Swing program that displays a button and a label. When the
         button is pressed, add 'A' to the label.
*/

public class Example extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    JPanel pane;
    String displayString = "";

    public Example(){

        super("Example");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pane = new JPanel();
        BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        label = new JLabel("Empty Text");

        button = new JButton("Click Me!");
        button.setPreferredSize(new Dimension(50, 50));

        button.setActionCommand("button_clicked");
        button.addActionListener(this);

        pane.add(label);
        pane.add(button);

        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("button_clicked")){
            displayString+= "A";
            label.setText(displayString);
        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(Example::new);
    }
}
