import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaneSelectionUI extends JFrame
        implements ActionListener {
    static String select1 = "pane1";    // Action to select pane 1
    static String select2 = "pane2";    // Action to select pane 2


    JPanel activeSubpane;   // Subpane being displayed
    JPanel subpane1;        // Subpane option 1
    JPanel subpane2;        // Subpane option 2
    JPanel pane;            // Main content pane 

    private void buildLayout(String selection) {
        // Reset the content pane to a blank window
        // and rebuild the UI elements including the
        // chosen subpane.
        pane.removeAll();
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        BorderLayout layout = new BorderLayout();
        pane.setLayout(layout);

        // Create the radio buttons to choose subpane 1 or 2
        JRadioButton pane1Button = new JRadioButton("Option 1");
        pane1Button.setActionCommand(select1);

        JRadioButton pane2Button = new JRadioButton("Option 2");
        pane2Button.setActionCommand(select2);

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(pane1Button);
        group.add(pane2Button);

        // Subscribe to the radio buttons
        pane1Button.addActionListener(this);
        pane2Button.addActionListener(this);

        // Put the radio buttons in a column in a panel
        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(pane1Button);
        radioPanel.add(pane2Button);

        // Add radio buttons to top of layout
        pane.add(radioPanel, BorderLayout.PAGE_START);

        // Add a subpane to center of layout
        if (selection.equals(select1)) {
            // Activate pane 1
            pane1Button.setSelected(true);
            activeSubpane = subpane1;
        } else {
            // Activate pane 2
            pane2Button.setSelected(true);
            activeSubpane = subpane2;
        }

        // Add the selected subpane to the window
        pane.add(activeSubpane, BorderLayout.CENTER);

        // Display window
        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public PaneSelectionUI() {
        super("Radio Button UI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set up content panes
        pane = new JPanel();

        // Set up subpanes
        subpane1 = new PaneOptionText("Pane 1 Selected!");
        subpane2 = new PaneOptionText("Pane 2 Selected!");

        // Build the window, displaying the first
        // subpane by default.
        buildLayout(select1);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action: " + e.getActionCommand());

        // When a radio button is pressed, rebuild
        // the UI with the chosen subpane.
        buildLayout(e.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PaneSelectionUI::new);
    }
}