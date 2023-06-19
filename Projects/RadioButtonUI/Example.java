import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* TODO: Write a GUI that displays a text field, a label, and 2 radio buttons. When
         Option 1 is selected, allow the user to enter text in the text box. When
         Option 2 is selected, do not update the label ever if text is entered.

 */
public class Example extends JFrame implements ActionListener {
    JRadioButton button1;
    JRadioButton button2;
    JTextField text;
    JLabel label;
    JPanel pane;

    public Example(){
        super("Example3");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pane = new JPanel();
        label = new JLabel("Empty Text");
        text = new JTextField("Enter text here!");


        // Define Buttons and actions
        button1 = new JRadioButton("Option 1");
        button2 = new JRadioButton("Option 2");
        button1.setActionCommand("button1_clicked");
        button1.addActionListener(this);
        button2.setActionCommand("button2_clicked");
        button2.addActionListener(this);

        // Add to ButtonGroup
        ButtonGroup g = new ButtonGroup();
        g.add(button1);
        g.add(button2);

        // Arrange in Layout
        GridLayout layout = new GridLayout(0, 1);
        JPanel radio = new JPanel(layout);
        radio.add(button1);
        radio.add(button2);

        // Render in window
        pane.add(radio, BorderLayout.LINE_START);

        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("button1_clicked")) {
            label.setText(" ");

        } else if(e.getActionCommand().equals("text_entered")){
            String s = text.getText();
            label.setText(s);
        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(Example::new);
    }
}
