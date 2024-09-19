package org.example;

import javax.accessibility.Accessible;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainPanel extends javax.swing.JPanel implements ActionListener {

    Player player;

    ArrayList<Wall> walls = new ArrayList<>();



    Timer gameTimer;




    public MainPanel(){



        player = new Player(400,400, this);

        makeWalls();

        //Timer for application
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
            player.set();
            repaint();

            }
        }, 0, 17);// 17  = 60 frames per second
    }

    public void makeWalls(){
        for(int i = 50; i < 650; i += 50) {
            walls.add(new Wall(i,600,50,50));

        }
        walls.add(new Wall(50,550,50, 50));
    }



    public  void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);

        for(Wall wall: walls) wall.draw(gtd);

    }






    void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) player.keyLeft = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player.keyRight = true;
        if(e.getKeyCode() == KeyEvent.VK_UP) player.keyUp = true;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player.keyDown = true;

    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) player.keyLeft = false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player.keyRight = false;
        if(e.getKeyCode() == KeyEvent.VK_UP) player.keyUp = false;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player.keyDown = false;

    }






    @Override
    public void actionPerformed(ActionEvent ae){

    }
}
