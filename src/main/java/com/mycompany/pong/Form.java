
package com.mycompany.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Form extends Rectangle {

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    private int vx = 10;
    private int vy = 10;
    private Color color;
    
    public int getXcoords() {
        return x;
    }
    
    public int getYcoords() {
        return y;
    }
    
    public void center(){
        x = 400;
        y = 250;
    }

    public void apbrallen() {
        vx *= -1;
        vy *= -1;
    }

    public Form(int x, int y, int height, Color color) {
        super(x, y, 30, height);
        this.color = color;
    }

    public void drawBall(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    public void drawSquare(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void move(int panelWidth, int panelHeight) {
        x += vx;
        y += vy;

        if (x <= 0 || x >= panelWidth - width) {
            vx = -vx;
        }
        if (y <= 0 || y >= panelHeight - height) {
            vy = -vy;
        }
    }

    public void move(int zahl) {
        y += zahl;
    }
}

/*
public class Form extends Rectangle{
    
    private int x;
    private int y;
    
    public void center(){
        x = 400;
        y = 250;
    }

    
    
    private int vx = 10;
    private int vy = 10;
    private Color color;
    
    public void apbrallen(){
        vx *= -1;
        vy *= -1;
    }

    public Form(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    

    public void drawBall(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 30, 30);
    }
    
    public void drawSquare(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 10, 100);
    }

    public void move(int panelWidth, int panelHeight) {
        x += vx;
        y += vy;

        if (x <= 0 || x >= panelWidth - 30) {
            vx = -vx;
        }
        if (y <= 0 || y >= panelHeight - 30) {
            vy = -vy;
        }
    }
    
    public void move(int zahl) {
        y += zahl;
    }
}
*/
