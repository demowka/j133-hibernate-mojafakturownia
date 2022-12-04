package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Firma;
import pl.sda.j133.hibernate.fakturownia.model.Kontrahent;

public class KomendaUsunKontrahent implements Komenda {
    private DataAccessObject<Kontrahent> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "usun kontrahent";
    }
    public void obsluga() {
        System.out.println("Podaj id kontrahenta:");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Kontrahent.class, id);
    }
}

