package Departament;

public class DepartamentShip extends Departament {

    public DepartamentShip(String nume) {
        super(nume);
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        super.nume = nume;
    }

    @Override
    public String toString() {
        return "DepartamentShip{" +
                "nume='" + nume + '\'' +
                ", myId=" + myId +
                '}';
    }
}
