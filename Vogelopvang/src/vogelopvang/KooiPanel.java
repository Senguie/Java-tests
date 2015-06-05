/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;

import java.awt.Color;
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
        super.paintComponent(g);
        for (int i = 0; i <= 9; i++) {
            Vogel v = this.vogelLijst[i];
            if (v != null) {
                if (v instanceof Vogel) {
                    g.setColor(Color.blue);
                    g.fillRect(10 + i * 120, 10, 100, 100);
                    g.setColor(Color.black);
                    g.drawRect(10 + i * 120, 10, 100, 100);
            }
                }
                if (v instanceof Papegaai) {
                    g.setColor(Color.yellow);
                    g.fillRect(10 + i * 120, 10, 100, 100);
                    g.setColor(Color.black);
                    g.drawRect(10 + i * 120, 10, 100, 100);
                }
                if (v instanceof Zangvogel) {
                    g.setColor(Color.red);
                    g.fillRect(10 + i * 120, 10, 100, 100);
                    g.setColor(Color.black);
                    g.drawRect(10 + i * 120, 10, 100, 100);
                }
                if (v == null) {
                    g.setColor(Color.black);
                    g.drawRect(10 + i * 120, 10, 100, 100);

                }
            }
        }
    }

