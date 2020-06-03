package DetaliiAngajat;

public class ReviewAngajat {
    private String job;
    private int bs, wovertime, special, salariu; //Bs0-Undergraduate/Bs1-Graduated/Bs2-Ms (master in CS) /wovertime-Numarul de ore suplimentare muncite pe luna pentru a dobandi experienta
    private float review = 1.0f, reward = 1.0f;
    private String position;
    private String jobType;

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public ReviewAngajat(int wovertime, int bs) {

        this.wovertime = wovertime;
        this.bs = bs;

        //Departament.Departament.update(this);
    }

    @Override
    public String toString() {
        return "ReviewAngajat{" +
                "bs='" + bs + '\'' +
                ", wovertime=" + wovertime +
                ", special=" + special +
                ", salariu=" + salariu +
                ", review=" + review +
                ", reward=" + reward +
                '}';
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void specific() {
        if (review / reward > 1.0)
            System.out.println("Undervalued employee");
        else if (review / reward == 1.0)
            System.out.println("Correct valued employee");
        else
            System.out.println("Overvalued employee");
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getBs() {
        return bs;
    }

    public void setBs(int bs) {
        this.bs = bs;
    }

    public int getWovertime() {
        return wovertime;
    }

    public void setWovertime(int wovertime) {
        this.wovertime = wovertime;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public float getReview() {
        return review;
    }

    public void setReview(float review) {
        this.review = review;
    }

    public float getReward() {
        return reward;
    }

    public void setReward(float reward) {
        this.reward = reward;
    }

    public String getPosition() {
        return position;
    }
}
