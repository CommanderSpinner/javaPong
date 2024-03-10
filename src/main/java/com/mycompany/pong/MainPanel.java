
package com.mycompany.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JMenu;
import javax.swing.Timer;


/* @author Lorenz Schaller */
public class MainPanel extends JPanel implements ActionListener, KeyListener{
    private Form ball;
    private Form player1;
    private Form player2;
    MenuLeiste ml;
    JFrame frame;
    
    int points1 = 0;
    int points2 = 0;
    
    int playerBewegung = 0;     
    int player2Bewegung = 0;     

    public MainPanel(MenuLeiste ml, JFrame frame) {
        ball = new Form(400, 250, 30, Color.GREEN);
        player1 = new Form(100, 250, 100,  Color.RED);
        player2 = new Form(700, 250, 100, Color.BLUE);
        
        ball.setVx(5);
        ball.setVx(5);
        
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
        this.ml = ml;
        this.frame = frame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.drawBall(g); 
        player1.drawSquare(g);
        player2.drawSquare(g);
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        movePlayer(playerBewegung, player2Bewegung);        
        moveBall();
        checkPoints();
        displayPoints();
        
    }
    
    public void displayPoints(){
        String pointsPlayer1 = " spieler1: " + points1;
        String pointsPlayer2 = " spieler2: " + points2;
        ml.setMenu_punkte1Text(pointsPlayer1);
        ml.setMenu_punkte2Text(pointsPlayer2);
        
        ml.addMenu();
        
        System.out.println("punkte spieler1: " + points1);
        System.out.println("punkte spieler2: " + points2);
    }
    
    public void checkPoints(){
        if(ball.getXcoords() >= 0 && ball.getXcoords() <= 10){
            points1++;
            ball.center();
        }
        
        if(ball.getXcoords() >= 750 && ball.getXcoords() <= 800){
            points2++;
            ball.center();
        }
    }
    
    //shit
    public void collides(Form p1, Form p2, Form ball){
        if(p1.intersects(ball) || p2.intersects(ball)){
            ball.apbrallen();
            System.out.println("ball berührt einen spieler");
        }
    }
    
    public void moveBall() {
        ball.move(getWidth(), getHeight()); 
        
        collides(player1, player2, ball);
        repaint(); 
    }
    
    public void movePlayer(int zahl, int zahl2){
        player1.move(zahl);
        player2.move(zahl2);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            playerBewegung = -10;
        } else if (keyCode == KeyEvent.VK_S) {
            playerBewegung = 10;
        }
        
        if (keyCode == KeyEvent.VK_UP) {
            player2Bewegung = -10;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            player2Bewegung = 10;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerBewegung = 0;
        player2Bewegung = 0;
    }
}
