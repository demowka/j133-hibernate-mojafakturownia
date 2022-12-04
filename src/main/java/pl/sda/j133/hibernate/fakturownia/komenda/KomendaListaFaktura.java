package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Faktura;

public class KomendaListaFaktura implements Komenda {
    private DataAccessObject<Faktura> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista faktura";
    }

    @Override
    public void obsluga() {
        dao.findAll(Faktura.class).forEach(System.out::println);
    }
}
