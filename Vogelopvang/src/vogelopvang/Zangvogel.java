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
public class Zangvogel extends Vogel {
    //atributen
private int zangKwaliteit;
    
    //constructor
public Zangvogel(){
    naam = "Hendrik";
    ringNummer = 17;
}
    public Zangvogel(String n, int r){
        naam = n;
        ringNummer = r;
    
    }
    //getters en setters
    public int getZangKwaliteit(){
        return this.zangKwaliteit;
    }
    public void setZangKwaliteit(int nieuwZK){
        zangKwaliteit=nieuwZK;
        if(nieuwZK < 1){
          zangKwaliteit = 1;
        }if(nieuwZK > 10){
            zangKwaliteit = 10;
        }
    }

public String toString(){
String ZV = super.toString();
ZV += " mijn zangkwaliteit is " + getZangKwaliteit() ;
return ZV;
}
}
