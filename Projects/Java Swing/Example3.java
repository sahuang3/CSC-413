import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* TODO: Write a GUI program that has a text field, button, and a label. When the
         button is pressed, clear the label. When the user enters text, add the text
         to the label
 */

public class Example3 extends JFrame implements ActionListener {
    JButton button1;
    JTextField text;
    JLabel label;
    JPanel pane;
    String displayString = "";

    public Example3(){

        super("Example3");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pane = new JPanel();
        BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        label = new JLabel("Empty Text");

        button1 = new JButton("clear");

        text = new JTextField("Enter text here!");
        text.setEditable(true);
        text.setActionCommand("text_entered");

        button1.setActionCommand("button1_clicked");
        button1.addActionListener(this);
        text.addActionListener(this);

        pane.add(label);
        pane.add(text);
        pane.add(button1);

        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("button1_clicked")) {
            label.setText(" ");
            displayString = "";

        } else if(e.getActionCommand().equals("text_entered")){
            String s = text.getText();
            displayString += s + "\n";
            label.setText(displayString);
            System.out.printf(displayString);

        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(Example3::new);
    }
}
