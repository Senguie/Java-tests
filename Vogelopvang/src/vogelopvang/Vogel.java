/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;

/**
 *
 * @author Senguie
 */
public class Vogel {
    //attributen
    protected int ringNummer;
    protected String naam;
    //constructor
    public Vogel(){
        naam = "henk";
        ringNummer = 0;
    }
    public Vogel(String n, int r){
        this.naam = n;
        this.ringNummer = r;
    }
  
    //methods
    public int getRingnummer(){
        return this.ringNummer;
    }
    public String getNaam(){
        return this.naam;
    }
    public void setNaam(String nieuwNaam){
        naam = nieuwNaam;
    }
    @Override
    public String toString(){
    return "ik ben vogel " + naam + " en ik heb ringnummer " + ringNummer +".";
}
}

