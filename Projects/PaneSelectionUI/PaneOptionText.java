import javax.swing.*;

public class PaneOptionText extends JPanel {
    JLabel label;

    PaneOptionText() {
        super();
        label = new JLabel("text");
        this.add(label);
    }

    PaneOptionText(String text) {
        super();
        label = new JLabel(text);
        this.add(label);
    }
}
