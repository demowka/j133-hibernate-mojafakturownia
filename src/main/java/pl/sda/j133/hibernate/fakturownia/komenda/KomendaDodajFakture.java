package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Faktura;
import pl.sda.j133.hibernate.fakturownia.model.Firma;
import pl.sda.j133.hibernate.fakturownia.model.Kontrahent;

import java.time.LocalDate;
import java.util.Optional;

public class KomendaDodajFakture implements Komenda {
    private DataAccessObject<Faktura> dao = new DataAccessObject<>();
    private DataAccessObject<Firma> daoFirma = new DataAccessObject<>();
    private DataAccessObject<Kontrahent> daoKontrahent = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj faktura";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id firmy:");
        String idFirmyString = Komenda.SCANNER.nextLine();
        Long idFirmy = Long.parseLong(idFirmyString);
        Optional<Firma> firmaOptional = daoFirma.find(Firma.class, idFirmy);
        if (firmaOptional.isEmpty()) {
            System.err.println("Firma o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj id kontrahenta:");
        String idKontrahentaString = Komenda.SCANNER.nextLine();
        Long idKontrahenta = Long.parseLong(idKontrahentaString);
        Optional<Kontrahent> kontrahentOptional = daoKontrahent.find(Kontrahent.class, idKontrahenta);
        if (kontrahentOptional.isEmpty()) {
            System.err.println("Kontrahent o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj numer faktury:");
        String numer = Komenda.SCANNER.nextLine();

        System.out.println("Podaj termin płatności:");
        String terminString = Komenda.SCANNER.nextLine();
        LocalDate termin = LocalDate.parse(terminString);

        System.out.println("Podaj kwote:");
        String kwotaString = Komenda.SCANNER.nextLine();
        Double kwota = Double.parseDouble(kwotaString);

        Faktura faktura = Faktura.builder()
                .kontrahent(kontrahentOptional.get())
                .firma(firmaOptional.get())
                .terminPlatnosci(termin)
                .numerFaktury(numer)
                .kwota(kwota)
                .build();

        dao.insert(faktura);
    }
}