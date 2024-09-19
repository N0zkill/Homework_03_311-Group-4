package org.example;

import com.sun.tools.javac.Main;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.ThreadPoolExecutor;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MazeGame {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setSize(700,700);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) (screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
        frame.setResizable(false);
        frame.setTitle("Maze");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}