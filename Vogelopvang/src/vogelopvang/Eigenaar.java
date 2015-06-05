/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;

import java.util.ArrayList;

public class Eigenaar {

    private String naam;
    ArrayList<Vogel> Vogel;
   //constructor

    public Eigenaar(String ne) {
        naam = ne;
        Vogel = new ArrayList();
    }

    //getters & setters

    public String getNaam() {
        return naam;
    }

    public void setNaam(String nieuwNaam) {
        naam = nieuwNaam;
    }
    public void voegVogelToe(Vogel naam){
        Vogel.add(naam);
    }

    public void printVogels() {
        for (int i = 0; i < Vogel.size(); i++) {
            String value = Vogel.get(i).toString();
            System.out.println(value);
        }
    }

}
