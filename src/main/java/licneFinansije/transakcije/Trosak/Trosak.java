/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package licneFinansije.transakcije.Trosak;

import java.time.LocalDateTime;
import licneFinansije.KategorijaTrosak;
import licneFinansije.transakcije.Transakcija;

/**
 *
 * @author Strahinja
 */
public class Trosak extends Transakcija{
    private KategorijaTrosak kategorija;
    public Trosak(double iznosTransakcije, LocalDateTime vremeTransakcije,String opis,KategorijaTrosak kategorija) {
        super(iznosTransakcije,vremeTransakcije,opis);
        this.kategorija=kategorija;
    }

    public KategorijaTrosak getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaTrosak kategorija) {
        this.kategorija = kategorija;
    }
        
    @Override
    public double uticajNaBilans() {
        return getIznosTransakcije()*(-1);
    }

    @Override
    public String toString() {
        return "Trosak " + super.toString()+" "+kategorija; 
    }
}
