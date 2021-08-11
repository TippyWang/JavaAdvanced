package com.tippy;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JPanel panel = new JPanel();
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");

    public MainFrame() {
        setSize(600,400);
        setLocation(200, 200);
        panel.add(ok);
        panel.add(cancel);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
}
