/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huiswerkCollege7;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 *
 * @author Senguie
 */
public class HuiswerkCollege7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrintWriter writer = null;
        try{
        writer = new PrintWriter("bestandsnaam.txt");
        writer.println("hoofdstuk 1");
        writer.close();
        }catch (FileNotFoundException e){
            System.out.println("Locatie voor aanmaken bestand niet gevonden");
        }

    }

}
