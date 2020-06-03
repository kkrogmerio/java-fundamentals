package Departament;

public class DepartamentAdmin extends Departament {


    public DepartamentAdmin(String administration) {
        super(administration);
    }

    @Override
    public String getNume() {
        return super.nume;
    }

    @Override
    public String toString() {
        return "DepartamentAdmin{" +
                "nume='" + nume + '\'' +
                ", myId=" + myId +
                '}';
    }

    @Override
    public void setNume(String val) {
        super.nume = nume;
    }
}
