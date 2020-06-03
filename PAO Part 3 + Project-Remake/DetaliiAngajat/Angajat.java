package DetaliiAngajat;

public class Angajat extends Company implements Comparable<Angajat>{
 private Nume name;
 private Domiciliu adress;
 private ReviewAngajat review;
 private Date data;
 private int departID;
 private int jobID;
 private String thread;
    @Override
    public int compareTo(Angajat o) {
        return this.getReview().getSalariu()-o.getReview().getSalariu();
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    @Override
   public void getinfo() {
       System.out.println("This class it's made to create an employee identity by structuring the base class 'DetaliiAngajat.Angajat' with" +
               "classes 'DetaliiAngajat.Nume' , 'DetaliiAngajat.Domiciliu','DetaliiAngajat.ReviewAngajat','DetaliiAngajat.Date' which contain informations about the worker");
   }

    public int getDepartID() {
        return departID;
    }

    public void setDepartID(int departID) {
        this.departID = departID;
    }

    public int getJobID() {
        return jobID;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "name=" + name +
                ", adress=" + adress +
                ", review=" + review +
                ", data=" + data +
                ", departID=" + departID +
                ", jobID=" + jobID +
                ", thread=" + thread +
                '}';
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    @Override
   public int getid() {
      return hashCode();
   }

    public Nume getName() {
        return name;
    }

    public void setName(Nume name) {
        this.name = name;
    }

    public Domiciliu getAdress() {
        return adress;
    }

    public void setAdress(Domiciliu adress) {
        this.adress = adress;
    }

    public ReviewAngajat getReview() {
        return review;
    }

    public void setReview(ReviewAngajat review) {
        this.review = review;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Angajat(Nume name, Domiciliu adress, ReviewAngajat review, Date data) {
      this.name = name;
      this.adress = adress;
      this.review = review;
      this.data = data;
      this.data.experience();
   }
}
