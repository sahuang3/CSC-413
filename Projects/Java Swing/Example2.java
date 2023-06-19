import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* TODO: Write a Swing GUI with a text label and two buttons "+" and "-"
         that increment or decrement the value displayed
*/

public class Example2 extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JLabel label;
    JPanel pane;
    String displayString = "";
    int count = 0;

    public Example2(){

        super("Example2");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pane = new JPanel();
        BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        label = new JLabel("Empty Text");

        button1 = new JButton("+");
        button1.setPreferredSize(new Dimension(50, 50));
        button2 = new JButton("-");
        button2.setPreferredSize(new Dimension(50, 50));

        button1.setActionCommand("button1_clicked");
        button1.addActionListener(this);
        button2.setActionCommand("button2_clicked");
        button2.addActionListener(this);

        pane.add(label);
        pane.add(button1);
        pane.add(button2);

        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("button1_clicked")){
            count = count+1;
            displayString = "Count: " + count;
            label.setText(displayString);
        } else if (e.getActionCommand().equals("button2_clicked")){
            count = count-1;
            displayString = "Count: " + count;
            label.setText(displayString);
        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(Example2::new);
    }
}
