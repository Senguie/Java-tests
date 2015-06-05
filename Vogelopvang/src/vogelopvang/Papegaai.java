/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vogelopvang;

import java.util.ArrayList;

/**
 *
 * @author Senguie
 */
public class Papegaai extends Vogel {
    //attributen
    ArrayList<String> woordenschat;

    //constructors
    public Papegaai() {
        naam = "Lorre";
        ringNummer = 12;
        woordenschat = new ArrayList<>();
    }
    public Papegaai(String n, int r){
        naam = n;
        ringNummer = r;
        woordenschat = new ArrayList<>();
    }
    public void voegToeAanWoordenschat(String woord){
        woordenschat.add(woord);
    }
    public void printWoordenschat(){
	for (int i = 0; i < woordenschat.size(); i++) {
	    String value = woordenschat.get(i);
	    System.out.println(value);
}
        

    }
    public String toString(){
String ZV = super.toString();
ZV += " Mijn woordenschat is ";

for (String woord : woordenschat) {
    ZV += woord+' ';
}

return ZV;
    }
}
