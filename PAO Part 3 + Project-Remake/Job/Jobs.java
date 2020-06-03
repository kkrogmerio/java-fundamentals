package Job;

import DetaliiAngajat.Angajat;
import DetaliiAngajat.Company;

public abstract class Jobs extends Company {
    int myId = 0;
    static int id;
    String identify;
    String thread;

    public abstract void getcalcul(Angajat x);

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public Jobs(String identity) {
        identify = identity;
        id += 1;
        myId = id;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Jobs.id = id;
    }

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }


}
