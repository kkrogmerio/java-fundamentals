package Departament;

public class DepartamentHr extends Departament {
    @Override
    public String getNume() {
        return super.nume;
    }

    @Override
    public void setNume(String nume) {
        super.nume = nume;
    }

    public DepartamentHr(String nume) {
        super(nume);
    }

    @Override
    public String toString() {
        return "DepartamentHr{" +
                "nume='" + nume + '\'' +
                ", myId=" + myId +
                '}';
    }
}
