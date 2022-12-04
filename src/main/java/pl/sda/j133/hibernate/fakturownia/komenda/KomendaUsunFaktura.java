package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Faktura;

public class KomendaUsunFaktura implements Komenda {
    private DataAccessObject<Faktura> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun faktura";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id firmy:");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Faktura.class, id);
    }
}