/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;
//scherm imports

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//menubalk imports
import javax.swing.JMenuBar;

/**
 *
 * @author Senguie
 */
public class MijnEigenSchermpje extends JFrame implements ActionListener {

    //atributen
    private Vogel[] vogelLijst;
    // scherm
    private JButton btnVoegPapegaaiToe;
    private JButton btnVoegZangvogelToe;
    private JButton btnPrintLijst;
    private JButton btnToonKooibezetting;
    private JTextArea taOverzicht;

    //menu
    private JMenuBar mbMenubalk;
    private JMenuItem printAction;
    private JMenuItem toonAction;
    private JMenuItem mnuVoegZangvogelToe;
    private JMenuItem mnuVoegPapegaaiToe;
    private JMenuItem mnuSchoonLijst;

    public MijnEigenSchermpje() {
        super();
        //constructor
        this.vogelLijst = new Vogel[10];
        geneerTestSet();
        System.out.println(this.vogelLijst[1]);
        //scherm instellingen
        this.setTitle("Vogel Opvang");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.yellow);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        // menubalk
        mbMenubalk = new JMenuBar();
        setJMenuBar(mbMenubalk);

        JMenu menuPrinten = new JMenu("Printen");
        mbMenubalk.add(menuPrinten);
        printAction = new JMenuItem("Print Lijst");
        toonAction = new JMenuItem("Toon Kooibezetting");
        mnuSchoonLijst = new JMenuItem("Lijst schoonmaken");
        printAction.addActionListener(this);
        mnuSchoonLijst.addActionListener(this);
        menuPrinten.add(printAction);
        menuPrinten.add(toonAction);
        toonAction.addActionListener(this);
        menuPrinten.add(mnuSchoonLijst);

        JMenu menuToevoegen = new JMenu("Toevoegen");
        mbMenubalk.add(menuToevoegen);
        mnuVoegPapegaaiToe = new JMenuItem("Voeg papegaai toe");
        mnuVoegPapegaaiToe.addActionListener(this);
        mnuVoegZangvogelToe = new JMenuItem("Voeg zangvogel toe");
        mnuVoegZangvogelToe.addActionListener(this);

        menuToevoegen.add(mnuVoegPapegaaiToe);
        menuToevoegen.add(mnuVoegZangvogelToe);
        //knoppen en velden

        btnVoegPapegaaiToe = new JButton("Papegaai toevoegen");
        this.add(btnVoegPapegaaiToe, BorderLayout.WEST);
        btnVoegPapegaaiToe.addActionListener(this);

        btnVoegZangvogelToe = new JButton("Zangvogel Toevoegen");
        this.add(btnVoegZangvogelToe, BorderLayout.EAST);
        btnVoegZangvogelToe.addActionListener(this);

        btnPrintLijst = new JButton("Print Lijst");
        this.add(btnPrintLijst, BorderLayout.NORTH);
        btnPrintLijst.addActionListener(this);

        btnToonKooibezetting = new JButton("Toon Kooibezetting");
        this.add(btnToonKooibezetting, BorderLayout.SOUTH);
        btnToonKooibezetting.addActionListener(this);

        taOverzicht = new JTextArea(200, 200);
        this.add(taOverzicht, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void geneerTestSet() {
        Papegaai p = new Papegaai();
        p.voegToeAanWoordenschat("Lorre");
        p.voegToeAanWoordenschat("Koekje");
        Zangvogel z = new Zangvogel("Pietje", 12);
        z.setZangKwaliteit(3);
        Papegaai p2 = new Papegaai("Willem", 15);
        p2.voegToeAanWoordenschat("Hup");
        p2.voegToeAanWoordenschat("Holland");
        this.vogelLijst[0] = p;
        this.vogelLijst[1] = z;
        this.vogelLijst[2] = p2;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Actie uitgevoerd !!!");
        if (ae.getSource() == btnPrintLijst) {
            taOverzicht.append("Overzicht van vogels: \n***********************\n");
            for (int i = 0; i <= 9; i++) {
                Vogel v = this.vogelLijst[i];
                if (v != null) {
                    taOverzicht.append(v.toString() + "\n");
                }
            }
        }
        if (ae.getSource() == printAction) {
            taOverzicht.append("Overzicht van vogels: \n***********************\n");
            for (int i = 0; i <= 9; i++) {
                Vogel v = this.vogelLijst[i];
                if (v != null) {
                    taOverzicht.append(v.toString() + "\n");
                }
            }
        }
        if (ae.getSource() == mnuSchoonLijst) {
            taOverzicht.setText("");
        }
        if (ae.getSource() == btnVoegPapegaaiToe) {
            PapegaaiDialoog dialoog = new PapegaaiDialoog(this, true);
            dialoog.setVisible(true);
            System.out.println("De waarde van het kooinummer is " + dialoog.getKooiNummer());
            System.out.println("De waarde van het ringnummer is " + dialoog.getRingNummer());
            System.out.println("De waarde van de naam is " + dialoog.getNaam());
            // controle en toevoegen
            if (dialoog.getRingNummer() != 0 && !dialoog.getNaam().equals("")
                    && dialoog.getKooiNummer() != 0) {
                Papegaai p = new Papegaai(dialoog.getNaam(), dialoog.getRingNummer());
                this.vogelLijst[dialoog.getKooiNummer() - 1] = p;
            }

        }
        if (ae.getSource() == mnuVoegPapegaaiToe) {
            PapegaaiDialoog dialoog = new PapegaaiDialoog(this, true);
            dialoog.setVisible(true);
            System.out.println("De waarde van het kooinummer is " + dialoog.getKooiNummer());
            System.out.println("De waarde van het ringnummer is " + dialoog.getRingNummer());
            System.out.println("De waarde van de naam is " + dialoog.getNaam());
            // controle en toevoegen
            if (dialoog.getRingNummer() != 0 && !dialoog.getNaam().equals("")
                    && dialoog.getKooiNummer() != 0) {
                Papegaai p = new Papegaai(dialoog.getNaam(), dialoog.getRingNummer());
                this.vogelLijst[dialoog.getKooiNummer() - 1] = p;
            }

        }
        if (ae.getSource() == btnVoegZangvogelToe) {
            ZangvogelDialoog zDialoog = new ZangvogelDialoog(this, true);
            zDialoog.setVisible(true);
            System.out.println("De waarde van het kooinummer is " + zDialoog.getKooiNummer());
            System.out.println("De waarde van het ringnummer is " + zDialoog.getRingNummer());
            System.out.println("De waarde van de naam is " + zDialoog.getNaam());
            System.out.println("De waarde van de zangkwaliteit is " + zDialoog.getZangKwaliteit());
            if (zDialoog.getRingNummer() != 0 && !zDialoog.getNaam().equals("")
                    && zDialoog.getKooiNummer() != 0 && zDialoog.getZangKwaliteit() != 0) {
                Zangvogel z = new Zangvogel(zDialoog.getNaam(), zDialoog.getRingNummer());
                this.vogelLijst[zDialoog.getKooiNummer() - 1] = z;
            }

        }        if (ae.getSource() == mnuVoegZangvogelToe) {
            ZangvogelDialoog zDialoog = new ZangvogelDialoog(this, true);
            zDialoog.setVisible(true);
            System.out.println("De waarde van het kooinummer is " + zDialoog.getKooiNummer());
            System.out.println("De waarde van het ringnummer is " + zDialoog.getRingNummer());
            System.out.println("De waarde van de naam is " + zDialoog.getNaam());
            System.out.println("De waarde van de zangkwaliteit is " + zDialoog.getZangKwaliteit());
            if (zDialoog.getRingNummer() != 0 && !zDialoog.getNaam().equals("")
                    && zDialoog.getKooiNummer() != 0 && zDialoog.getZangKwaliteit() != 0) {
                Zangvogel z = new Zangvogel(zDialoog.getNaam(), zDialoog.getRingNummer());
                this.vogelLijst[zDialoog.getKooiNummer() - 1] = z;
            }

        } if (ae.getSource() == btnToonKooibezetting){
            KooiDialoog kDialoog = new KooiDialoog(this, vogelLijst);
            kDialoog.setVisible(true);
        } if (ae.getSource() == toonAction){
            KooiDialoog kDialoog = new KooiDialoog(this, vogelLijst);
            kDialoog.setVisible(true);
            
        }
    }
}
