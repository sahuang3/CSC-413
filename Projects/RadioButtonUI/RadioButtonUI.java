/*
 *  ADAPTED FROM ORACLE'S RadioButtonDemo:
 *
 *  Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonUI extends JFrame
        implements ActionListener {
    static String birdString = "Bird";
    static String catString = "Cat";
    static String dogString = "Dog";
    static String rabbitString = "Rabbit";
    static String pigString = "Pig";

    JLabel image;
    JPanel pane;

    public RadioButtonUI() {
        super("Radio Button UI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set up content pane
        pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        BorderLayout layout = new BorderLayout();
        pane.setLayout(layout);

        // Create the radio buttons
        JRadioButton birdButton = new JRadioButton(birdString);
        birdButton.setActionCommand(birdString);
        birdButton.setSelected(true);

        JRadioButton catButton = new JRadioButton(catString);
        catButton.setActionCommand(catString);

        JRadioButton dogButton = new JRadioButton(dogString);
        dogButton.setActionCommand(dogString);

        JRadioButton rabbitButton = new JRadioButton(rabbitString);
        rabbitButton.setActionCommand(rabbitString);

        JRadioButton pigButton = new JRadioButton(pigString);
        pigButton.setActionCommand(pigString);

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Subscribe to the radio buttons
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Set up the picture label
        String imagePath = getImagePath(birdString);
        ImageIcon imageIcon = ImageLoader.getImageIcon(imagePath);
        image = new JLabel(imageIcon);
        image.setPreferredSize(new Dimension(177, 122));

        // Put the radio buttons in a column in a panel
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Add radio buttons to first place in layout (Left)
        add(radioPanel, BorderLayout.LINE_START);

        // Add image to center of layout
        add(image, BorderLayout.CENTER);

        // Display window
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String imagePath = getImagePath(e.getActionCommand());
        ImageIcon imageIcon = ImageLoader.getImageIcon(imagePath);
        image.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonUI::new);
    }

    private String getImagePath(String imageName) {
        return "images/" + imageName + ".gif";
    }
}