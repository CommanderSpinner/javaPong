package com.mycompany.pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuLeiste extends JMenuBar implements ActionListener {

    JMenu menu_punkte1;

    public void setMenu_punkte1Text(String menu_punkte1) {
        this.menu_punkte1.setText(menu_punkte1);
    }

    public void setMenu_punkte2Text(String menu_punkte2) {
        this.menu_punkte2.setText(menu_punkte2);
    }
    JMenu menu_punkte2;
    
    public void addMenu(){
        this.add(menu_punkte1);
        this.add(menu_punkte2);
    }
    
    public MenuLeiste() {
        menu_punkte1 = new JMenu("punkte spieler1: ");
        menu_punkte2 = new JMenu("punkte spieler2: ");
        addMenu();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
