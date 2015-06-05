package vogelopvang;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;

public class ZangvogelDialoog extends JDialog implements ActionListener {

    //atributen
    private JLabel Naam;
    private JLabel RingNummer;
    private JLabel KooiNummer;
    private JLabel ZangKwaliteit;
    private JTextField nV;
    private JTextField rnV;
    private JTextField knV;
    private JTextField zkV;
    private JButton cancel;
    private JButton ok;
    //atributen invoer
    private int ringnummer;
    private int kooinummer;
    private int zangkwaliteit;
    private String naamVogel;

    // getters invoer
    public String getNaam() {
        return naamVogel;
    }

    public int getRingNummer() {
        return ringnummer;
    }

    public int getZangKwaliteit() {
        return zangkwaliteit;
    }

    public int getKooiNummer() {
        return kooinummer;
    }
    //constructor invoer

    //dialoog scherm instellingen
    public ZangvogelDialoog(JFrame frame, boolean isModal) {
        super(frame, true);
        this.setLayout(new GridLayout(5, 2));
        setTitle("Voeg zangvogel toe");
        setSize(400, 120);
        //standaard invulling velden
        naamVogel = "";
        ringnummer = 0;
        kooinummer = 0;
        zangkwaliteit = 0;
        //buttons and fields
        //labels
        Naam = new JLabel("Naam: ");
        RingNummer = new JLabel("Ringnummer: ");
        ZangKwaliteit = new JLabel("Zangkwaliteit: ");
        KooiNummer = new JLabel("Kooinummer (1 tot 10): ");
        //fields
        nV = new JTextField();
        rnV = new JTextField();
        zkV = new JTextField();
        knV = new JTextField();
        //add
        this.add(Naam);
        this.add(nV);

        this.add(RingNummer);
        this.add(rnV);

        this.add(ZangKwaliteit);
        this.add(zkV);

        this.add(KooiNummer);
        this.add(knV);

        //buttons
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
                this.zangkwaliteit = Integer.parseInt(zkV.getText());
                if (kooinummer <= 1 || kooinummer >= 10) {
                    this.setVisible(true);
                } else {
                    this.setVisible(false);
                }
            } catch (NumberFormatException ae) {
                this.setVisible(true);
                JOptionPane.showMessageDialog(this, "Graag cijfers invullen bij kooi- ringnummer en zangkwaliteit");

            }
        }
    }
}
