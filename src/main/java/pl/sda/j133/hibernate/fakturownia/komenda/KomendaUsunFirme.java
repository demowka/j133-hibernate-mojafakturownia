package pl.sda.j133.hibernate.fakturownia.komenda;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.fakturownia.Main;
import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.database.HibernateUtil;
import pl.sda.j133.hibernate.fakturownia.model.Firma;

public class KomendaUsunFirme implements Komenda {
    private DataAccessObject<Firma> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "usun firma";
    }
    public void obsluga() {
        System.out.println("Podaj id firmy:");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Firma.class, id);
    }
}
