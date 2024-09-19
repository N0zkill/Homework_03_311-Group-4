package org.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {

    MainPanel panel;
    int x;
    int y;
    int width;
    int height;

    double xspeed;
    double yspeed;

    Rectangle hitBox;

    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;



    public Player (int x , int y, MainPanel panel){

        this.panel = panel;
        this.x =x;
        this.y = y;

        width = 50;
        height = 50;
        hitBox = new Rectangle(x,y, width, height);

    }
    public void set(){

        //Left Right Key check
        if(keyLeft && keyRight || !keyLeft && !keyRight) xspeed *= .5;
        else if (keyLeft && !keyRight)  xspeed --;
        else if (keyRight && !keyLeft) xspeed ++;
        if (xspeed> 0 && xspeed < 0.75) xspeed =0;
        if(xspeed < 0 && xspeed > -0.75) xspeed =0;

        if(xspeed > 5) xspeed = 5;
        if (xspeed < -5) xspeed = -5;

        // up down Key Check
        if(keyUp && keyDown || !keyUp && !keyDown) yspeed *= .5;
        else if (keyUp && !keyDown)  yspeed --;
        else if (keyDown && !keyUp) yspeed ++;
        if (yspeed> 0 && yspeed < 0.75) yspeed =0;
        if(yspeed < 0 && yspeed > -0.75) yspeed =0;

        if(yspeed > 5) yspeed = 5;
        if (yspeed < -5) yspeed = -5;


        // Wall Check Collision
        hitBox.x += xspeed;
        for (Wall wall: panel.walls){
            if (hitBox.intersects(wall.hitBox)){
                hitBox.x -= xspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xspeed);
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;

            }
        }
        // Vertical Check Collision
        hitBox.y += yspeed;
        for (Wall wall: panel.walls){
            if (hitBox.intersects(wall.hitBox)){
                hitBox.y -= yspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;

            }
        }



        x += xspeed;
        y += yspeed;

        hitBox.x= x;
        hitBox.y= y;


    }

    public void draw(Graphics2D gtd){
        gtd.setColor(Color.white);
        gtd.fillRect(x,y, width,height);

    }

}
