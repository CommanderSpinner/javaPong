
package com.mycompany.pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Oberflaeche extends JFrame implements ActionListener{
    MainPanel mp;
    
    MenuLeiste ml;
    
    public Oberflaeche(){
        this.setSize(800, 500);
        ml = new MenuLeiste();
        mp = new MainPanel(ml, this);
        
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.add(mp);
        this.setJMenuBar(ml);
        
        this.setTitle("Pong");
        
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
