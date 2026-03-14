/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package licneFinansije;

import java.util.LinkedList;
import java.util.List;
import licneFinansije.korisnik.Korisnik;

/**
 *
 * @author Strahinja
 */
public class Validacija {
    
     public static boolean zauzetuserName(String un){
         List<Korisnik> lista;
    try {
    lista = new LinkedList<>(Serijalizacija.deserijalizuj());
    } catch(Exception e) {
    lista = new LinkedList<>();
    }
    for(Korisnik k:lista){
        if(k.getUserName().equals(un) )
            return true;
    }
    return false;
     }
     
    public static Korisnik proveraPrijave(String userName, char []lozinkaNiz){
        String lozinka=new String(lozinkaNiz);
        Korisnik korisnik=null;
        List<Korisnik>lista;
        try{
        lista = new LinkedList<>(Serijalizacija.deserijalizuj());}
        catch(Exception e){
            throw new RuntimeException("greska deserijalizacija!");
        }
        for(Korisnik k:lista){
            if(k.getUserName().equals(userName) && k.getLozinka().equals(lozinka))
            {
                korisnik=k;
                return korisnik;
            }
        }
        return korisnik;
       
    }
}
