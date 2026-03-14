
package licneFinansije.transakcije;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import licneFinansije.KategorijaTrosak;

/**
 *
 * @author Strahinja
 */
public abstract class Transakcija implements Serializable{
    private double iznosTransakcije;
    private LocalDateTime vremeTransakcije;
    
    private  int ID;
    private String opis;
    private static int brojac;

    public Transakcija(double iznosTransakcije, LocalDateTime vremeTransakcije, String opis) {
    setIznosTransakcije(iznosTransakcije);
    this.vremeTransakcije = vremeTransakcije;
    this.ID = ++brojac;
     setOpis(opis);
}

    
    
    
    public double getIznosTransakcije() {
        return iznosTransakcije;
    }

    public void setIznosTransakcije(double iznosTransakcije) {
        if(iznosTransakcije <=0)
            throw new TransakcijaException("Iznos transakcije mora biti veci od 0!");
        this.iznosTransakcije = iznosTransakcije;
    }

    public LocalDateTime getVremeTransakcije() {
        return vremeTransakcije;
    }

    public void setVremeTransakcije(LocalDateTime vremeTransakcije) {
        this.vremeTransakcije = vremeTransakcije;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        if(opis.length()>40)
            throw new TransakcijaException("Makismalna dužina opisa je 40 karaktera!");
            
        this.opis = opis;
    }
    public abstract double uticajNaBilans();

   @Override
public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
    return iznosTransakcije + " " + vremeTransakcije.format(formatter) + " " + opis;
}

    @Override
    public boolean equals(Object obj) {
       if(!(obj instanceof Transakcija))
           return false;
       Transakcija t=(Transakcija)obj;
       return t.ID==ID;
    }
    
    
   
public static void setBrojac(int vrednost) {
    brojac = vrednost;
}

    
    
}
