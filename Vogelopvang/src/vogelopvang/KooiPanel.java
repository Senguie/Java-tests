/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Senguie
 */
public class KooiPanel extends JPanel {

    private Vogel[] vogelLijst;

    KooiPanel(Vogel[] vogelLijst) {
        this.vogelLijst = vogelLijst;

    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i <= 9; i++) {
            Vogel v = this.vogelLijst[i];
            super.paintComponent(g);
            g.drawRect(10 + i*10, 10, 100, 100);
            if (v != null) {

            }

        }
    }
}
