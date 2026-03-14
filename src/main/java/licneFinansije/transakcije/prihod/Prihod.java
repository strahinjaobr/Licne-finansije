/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package licneFinansije.transakcije.prihod;

import java.time.LocalDateTime;
import licneFinansije.KategorijaPrihodi;
import licneFinansije.KategorijaTrosak;
import licneFinansije.transakcije.Transakcija;

/**
 *
 * @author Strahinja
 */
public class Prihod extends Transakcija{
    private KategorijaPrihodi kategorija;
    public Prihod(double iznosTransakcije, LocalDateTime vremeTransakcije,String opis,KategorijaPrihodi kategorija) {
        super(iznosTransakcije,vremeTransakcije,opis);
        this.kategorija=kategorija;
    }

    public KategorijaPrihodi getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaPrihodi kategorija) {
        this.kategorija = kategorija;
    }
    
    @Override
    public double uticajNaBilans() {
        return getIznosTransakcije();
    }

    @Override
    public String toString() {
        return "Prihod " + super.toString()+" "+kategorija; 
    }
    
    

    
    
    
}
