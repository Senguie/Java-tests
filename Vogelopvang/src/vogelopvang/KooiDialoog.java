/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Senguie
 */
public class KooiDialoog extends JDialog {
   
    public KooiDialoog(JFrame frame, Vogel[] vogelLijst) {
        super(frame, true);
    

        setTitle("Kooibezetting");
        setSize(1020,200);
        this.add(new KooiPanel(vogelLijst));
}
}