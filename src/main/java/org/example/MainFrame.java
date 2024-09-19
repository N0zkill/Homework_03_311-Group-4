package org.example;

import java.awt.*;

public class MainFrame extends javax.swing.JFrame{
    //Creating Frame Method
    public MainFrame(){
        MainPanel panel = new MainPanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.black);
        panel.setVisible(true);
        this.add(panel);
        addKeyListener(new KeyChecker(panel));
    }


}
