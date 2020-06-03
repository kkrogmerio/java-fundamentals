package Departament;

public class DepartamentIt extends Departament {


    public DepartamentIt(String nume) {

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
        return "DepartamentIt{" +
                "nume='" + nume + '\'' +
                ", myId=" + myId +
                '}';
    }
}
