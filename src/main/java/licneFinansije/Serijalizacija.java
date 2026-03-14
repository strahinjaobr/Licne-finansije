
package licneFinansije;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import licneFinansije.korisnik.Korisnik;

/**
 *
 * @author Strahinja
 */
public class Serijalizacija {
    public static void serijalizuj(List<Korisnik>listaKorisnika){
        try(FileOutputStream fos=new FileOutputStream("registarKorisnika.out");
                BufferedOutputStream bos=new BufferedOutputStream(fos);
                ObjectOutputStream out=new ObjectOutputStream(bos)){
            for(Korisnik k:listaKorisnika){
                out.writeObject(k);
            }
        }catch(Exception e){
            throw new RuntimeException("Greska prilikom upisivanja podataka!");
        }
          
    }
    public static List<Korisnik> deserijalizuj() throws Exception{
        List<Korisnik>korisnici=new LinkedList<>();
        try(FileInputStream fis=new FileInputStream("registarKorisnika.out");
              BufferedInputStream bis=new BufferedInputStream(fis);
                ObjectInputStream in=new ObjectInputStream(bis)){
            while(true){
                Korisnik k=(Korisnik)in.readObject();
                korisnici.add(k);
            }
            
            
        }catch(EOFException ex){} 
        catch(FileNotFoundException f){
            return korisnici;
        }
        catch(Exception e){
            throw new RuntimeException("Greska prilikom ucitavanja podataka!");
        }
        return korisnici;
    }
}
