package Departament;

public abstract class Departament {
    protected String nume;
    static int id;
    String thread;
    protected int myId;

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public Departament(String administration) {
        id += 1;
        myId = id;
        nume = administration;


    }

    public int getMyId() {
        return myId;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Departament.id = id;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public abstract String getNume();

    public abstract void setNume(String val);
}
