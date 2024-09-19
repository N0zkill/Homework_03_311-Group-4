package org.example;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker  extends KeyAdapter {

    MainPanel panel;
    public KeyChecker(MainPanel panel){
        this.panel = panel;
    }
    @Override
    public void keyPressed(KeyEvent e){
        panel.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e){
        panel.keyReleased(e);
    }
}
