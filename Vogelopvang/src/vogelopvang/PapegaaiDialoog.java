/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Senguie
 */
public class PapegaaiDialoog extends JDialog implements ActionListener {

    //atributen
    private JLabel Naam;
    private JLabel RingNummer;
    private JLabel KooiNummer;
    private JTextField nV;
    private JTextField rnV;
    private JTextField knV;
    private JButton cancel;
    private JButton ok;
    //atributen invoer
    private int ringnummer;
    private int kooinummer;
    private String naamVogel;

    // getters invoer
    public String getNaam() {
        return naamVogel;
    }

    public int getRingNummer() {
        return ringnummer;
    }

    public int getKooiNummer() {
        return kooinummer;
    }
    //constructor invoer

    //dialoog scherm instellingen
    public PapegaaiDialoog(JFrame frame, boolean isModal) {
        super(frame, true);
        this.setLayout(new GridLayout(4, 2));
        setTitle("Voeg papegaai toe");
        setSize(400, 120);
        //standaard invulling velden
        naamVogel = "";
        ringnummer = 0;
        kooinummer = 0;
        //buttons and fields
        Naam = new JLabel("Naam: ");
        this.add(Naam);
        RingNummer = new JLabel("Ringnummer: ");
        nV = new JTextField();
        this.add(nV);
        this.add(RingNummer);
        rnV = new JTextField();
        this.add(rnV);
        KooiNummer = new JLabel("Kooinummer (1 tot 10): ");
        this.add(KooiNummer);
        knV = new JTextField();
        this.add(knV);
        cancel = new JButton("Cancel");
        this.add(cancel);
        cancel.addActionListener(this);
        ok = new JButton("OK");
        this.add(ok);
        ok.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Dialoog actie uitgevoerd !!!");
        if (e.getSource() == cancel) {
            this.setVisible(false);
        }
        if (e.getSource() == ok) {
            this.naamVogel = nV.getText();
            try {
                this.ringnummer = Integer.parseInt(rnV.getText());
                this.kooinummer = Integer.parseInt(knV.getText());
                if (kooinummer <= 1 || kooinummer >=10) {
                    this.setVisible(true);
                }else{
                    this.setVisible(false);
                }
 

                

            } catch (NumberFormatException ae) {
                this.setVisible(true);
                JOptionPane.showMessageDialog(this, "Graag cijfers invullen bij kooi- en ringnummer");

            }

        }

    }
}
