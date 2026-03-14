/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package licneFinansije.korisnik;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
import licneFinansije.KategorijaPrihodi;
import licneFinansije.KategorijaTrosak;

import licneFinansije.Serijalizacija;
import licneFinansije.Validacija;
import licneFinansije.transakcije.Transakcija;
import licneFinansije.transakcije.Trosak.Trosak;
import licneFinansije.transakcije.prihod.Prihod;

/**
 *
 * @author Strahinja
 */
public class Korisnik implements Serializable{
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private String userName;
    private String lozinka;
    private List<Transakcija> transakcije=new LinkedList<>();

    public String getIme() {
        return ime;
    }
    public boolean sadrziSamoSlova(String ime){
        for(int i=0;i<ime.length();i++){
            if(!Character.isLetter(ime.charAt(i)))
                return false;
        }
        return true;
    }
    public void setIme(String ime) {
        if(ime==null|| ime.isEmpty() || !sadrziSamoSlova(ime) || ime.length()<2)
            throw new RuntimeException("Ime mora biti duzine bar 2 slova i ne sme sadrzati nista osim slova!");
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
         if(prezime==null|| prezime.isEmpty() || !sadrziSamoSlova(prezime) || prezime.length()<2)
            throw new RuntimeException("Prezime mora biti duzine bar 2 slova i ne sme sadrzati nista osim slova!");
        this.prezime = prezime;
    }
    
    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        if(datumRodjenja==null || !datumRodjenja.isBefore(LocalDate.now())|| Period.between(datumRodjenja, LocalDate.now()).getYears()<16)
            throw new RuntimeException("Datum rodjenja mora biti datum u proslosti i minimalni broj godina korisnika aplikacije je 16 godina!");
        this.datumRodjenja = datumRodjenja;
    }

    public String getUserName() {
        return userName;
    }
    

    public void setUserName(String userName) {
        if(userName==null || userName.length()<5)
            throw new RuntimeException("Korisnicko ime mora sadrzati bar 5 karaktera!");
        if(Validacija.zauzetuserName(userName))
            throw new RuntimeException("Korisnicko ime je zauzeto!");
        this.userName = userName;
    }

    public String getLozinka() {
        return lozinka;
    }
    public void setLozinka(String lozinka) {
    if(lozinka == null || !lozinka.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$"))
        throw new RuntimeException("Lozinka mora sadrzati najmanje 8 karaktera, veliko, malo slovo, cifru i specijalni karakter!");
    this.lozinka = lozinka;
    }

    public List<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void setTransakcije(List<Transakcija> transakcije) {
        this.transakcije = transakcije;
    }
    public List<Trosak> vratiTroskove(){
        List<Trosak>listaTroskova=new LinkedList<>();
        for(Transakcija t:transakcije){
            if(t instanceof Trosak){
                Trosak tr=(Trosak) t;
                listaTroskova.add(tr);
            }
        }
        return listaTroskova;
        
    }
     public List<Prihod> vratiPrihode(){
        List<Prihod>listaPrihoda=new LinkedList<>();
        for(Transakcija t:transakcije){
            if(t instanceof Prihod){
                Prihod p=(Prihod) t;
                listaPrihoda.add(p);
            }
        }
        return listaPrihoda;
        
    }
     public double izracunajBilans(List<Transakcija> transakcije){
         double sum=0;
         for(Transakcija tr:transakcije){
             sum+=tr.uticajNaBilans();
         }
         return sum;
     }
     public double izracunajTroskove(List<Trosak>troskovi){
         double sum=0;
         
         for(Trosak tr:troskovi){
             sum+=tr.uticajNaBilans();
         }
         return sum*(-1);
     }
     public double izracunajPrihode(List<Prihod>prihodi){
         double sum=0;
         
         for(Prihod p:prihodi){
             sum+=p.uticajNaBilans();
         }
         return sum;
     }
     public void dodajTransakciju(Transakcija t){
         transakcije.add(t);
     }
     
     
     public List<Trosak> filtrirajTroskovePoKategoriji(KategorijaTrosak kategorija){
         List<Trosak>filtriranaLista=new LinkedList<>();
         List<Trosak>troskovi=new LinkedList<>();
         troskovi=vratiTroskove();
         for(Trosak t:troskovi){
             if(t.getKategorija()==kategorija)
                 filtriranaLista.add(t);
         }
         return filtriranaLista;
     }
     public List<Prihod> filtrirajPrihodePoKategoriji(KategorijaPrihodi kategorija){
         List<Prihod>prihodi=new LinkedList<>();
         prihodi=vratiPrihode();
         List<Prihod>filtriranaLista=new LinkedList<>();
         for(Prihod p:prihodi){
             if(p.getKategorija()==kategorija)
                 filtriranaLista.add(p);
         }
         return filtriranaLista;
     }
     
     public List<Trosak> filtrirajTroskoveZaVremenskiInterval(LocalDate datumOd, LocalDate datumDo){
         List<Trosak>troskovi;
         troskovi=vratiTroskove();
         List<Trosak>filtriranaLista=new LinkedList<>();
         for(Trosak t:troskovi){
             LocalDate datum=t.getVremeTransakcije().toLocalDate();
             if(!datum.isBefore(datumOd) && !datum.isAfter(datumDo)){
                filtriranaLista.add(t);
             }
         }
         return filtriranaLista;
         
     }
    public List<Prihod> filtrirajPrihodeZaVremenskiInterval(LocalDate datumOd, LocalDate datumDo){
         List<Prihod>prihodi;
         prihodi=vratiPrihode();
         List<Prihod>filtriranaLista=new LinkedList<>();
         for(Prihod p:prihodi){
             LocalDate datum=p.getVremeTransakcije().toLocalDate();
             if(!datum.isBefore(datumOd) && !datum.isAfter(datumDo)){
                filtriranaLista.add(p);
             }
         }
         return filtriranaLista;
         
     }
   
    public List<Transakcija> filtrirajTransakcijeZaVremenskiInterval(LocalDate datumOd, LocalDate datumDo){
         
         List<Transakcija>filtriranaLista=new LinkedList<>();
         for(Transakcija t:transakcije){
             LocalDate datum=t.getVremeTransakcije().toLocalDate();
             if(!datum.isBefore(datumOd) && !datum.isAfter(datumDo)){
                filtriranaLista.add(t);
             }
         }
         return filtriranaLista;
         
     }
    public void obrisiTransakciju(int ID){
        int index=-1;
        for(Transakcija t:transakcije){
            if(t.getID()==ID){
                index=transakcije.indexOf(t);
                break;
            }
        }
        if(index==-1){
            throw new RuntimeException("Transakcija nije pronadjena!");
        }
        transakcije.remove(index);
    }
   
    public void izmeniTransakciju(int id,Transakcija t){
        for(int i=0;i<transakcije.size();i++){
            if(transakcije.get(i).getID()==id){
                transakcije.set(i,t );
                break;
            }
        }
    }
    public String ispisTransakcija(){
        String ispis="";
        for(Transakcija t:transakcije){
            ispis=ispis+t+"\n";
        }
        return ispis;
    }
}
