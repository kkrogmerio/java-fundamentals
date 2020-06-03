package DetaliiAngajat;

public class Domiciliu extends Company {
    protected String adresa;
    protected int numar;

    @Override
    public int getid() {
        return numar;
    }

    public Domiciliu(String adresa, int numar) {
        this.adresa = adresa;
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "Domiciliu{" +
                "adresa='" + adresa + '\'' +
                ", numar=" + numar +
                '}';
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public void getinfo() {
        System.out.println("In Clasa domiciliu retinem adresa Angajatului");
    }

    void specific() {
        if (adresa.equals("Matei Spiru"))
            System.out.println("Aproape de locul de munca");
    }
}
