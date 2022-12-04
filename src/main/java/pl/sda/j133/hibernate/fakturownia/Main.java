package pl.sda.j133.hibernate.fakturownia;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.komenda.Komenda;
import pl.sda.j133.hibernate.fakturownia.komenda.KomendaDodajFirme;
import pl.sda.j133.hibernate.fakturownia.model.Firma;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // SELECT * FROM firma;
      //  new DataAccessObject<Firma>().findAll(Firma.class);

        List<Komenda> listaKomend = List.of(
                new KomendaDodajFirme()


        );
        String komenda;
        do {

            System.out.println("Lista dostępnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                //wiersz po wierszu wypisza sie komendy w formie
                //1. dodaj x
                //2. dodaj y ...
                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());

            }
            System.out.println(); //pusta nowa linia która oddziela poprzednia liste

            System.out.println("Podaj komende:");
            komenda = Komenda.SCANNER.nextLine();

            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equals(komenda)) {
                    dostepnaKomenda.obsluga();
                }

            }
        }    while (!komenda.equalsIgnoreCase("exit")) ;

    }
}
