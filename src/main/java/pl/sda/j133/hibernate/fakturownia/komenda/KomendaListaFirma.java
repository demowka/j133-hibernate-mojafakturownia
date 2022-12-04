package pl.sda.j133.hibernate.fakturownia.komenda;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.database.HibernateUtil;
import pl.sda.j133.hibernate.fakturownia.model.Firma;

import java.util.List;

public class KomendaListaFirma implements Komenda {
    private DataAccessObject<Firma> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "lista firma";
    }
    public void obsluga() {
        dao.findAll(Firma.class).forEach(System.out::println);
    }

}
