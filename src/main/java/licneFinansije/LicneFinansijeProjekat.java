
import licneFinansije.Serijalizacija;
import licneFinansije.korisnik.Korisnik;
import licneFinansije.transakcije.Transakcija;

public static void main(String[] args) {
    try {
    List<Korisnik> lista = Serijalizacija.deserijalizuj();
    int maxId = 0;
    for(Korisnik k : lista) {
        for(Transakcija t : k.getTransakcije()) {
            if(t.getID() > maxId)
                maxId = t.getID();
        }
    }
    Transakcija.setBrojac(maxId);
} catch(Exception e) {}
    new licneFinansije.gui.Pocetna().setVisible(true);
}