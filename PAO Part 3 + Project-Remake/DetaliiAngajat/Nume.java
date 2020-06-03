package DetaliiAngajat;

public class Nume extends Company {
    private String nume, prenume, seria;
    private long CNP;

    @Override
    public int getid() {
        return (int) CNP;
    }

    @Override
    public void getinfo() {
        System.out.println("Name identifier");
    }

    public Nume(String nume, String prenume, long CNP) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
    }

    boolean director() {
        if (CNP % 1000 == 570 && nume.equals("Andreescu") && prenume.equals("Mihai"))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Nume{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", CNP=" + CNP +
                '}';
    }

    long getCNP() {
        return CNP;
    }

    public String getSeria() {
        String val = seria;
        return val;
    }

    void specific() {
        if (this.getSeria().equals("IZ"))
            System.out.println("Are domiciliul aproape de HQ");
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public void setCNP(long CNP) {
        this.CNP = CNP;
    }


}
