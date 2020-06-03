package Job;

import DetaliiAngajat.Angajat;

import java.util.Random;

public class NormalJob extends Jobs {
    int amount;
    private String jobName;

    public NormalJob(String jobName) {
        super("normal");
        Random rand = new Random();
        this.amount = rand.nextInt(900) + 100;
        this.jobName = jobName;

    }

    public NormalJob(String jobName, int amount) {
        super("normal");
        this.jobName = jobName;
        Random rand = new Random();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "NormalJob{" +
                "myId=" + myId +
                ", jobName='" + jobName + '\'' +
                ", identify='" + identify + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void getinfo() {
        System.out.println("This class it's used to create a job for a healthy person");
    }

    @Override
    public int getid() {
        return myId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void getcalcul(Angajat x) {
        System.out.println("WELL GETCALCUL");
        x.getReview().setJobType("Normal");
        String val = x.getData().getLvl();
        System.out.println(val);
        if (val.equals("Junior"))
            x.getReview().setSalariu(x.getReview().getSalariu() + 3000);
        else if (val.equals("Middle"))
            x.getReview().setSalariu(x.getReview().getSalariu() + 5000);
        else if (val.equals("Senior"))
            x.getReview().setSalariu(x.getReview().getSalariu() + 8000);
        x.getReview().setSalariu((int) (x.getReview().getSalariu() * (1 + (float) x.getData().getExp() / 10.0)));
        if (x.getReview().getBs() == 1) {
            x.getReview().setSalariu((int) (x.getReview().getSalariu() * 1.10));
            x.getReview().setReward((float) (x.getReview().getReward() + 0.10));
        }
        if ((x.getReview().getBs() == 2)) {
            x.getReview().setSalariu((int) (x.getReview().getSalariu() * 1.20));
            x.getReview().setReward((float) (x.getReview().getReward() + 0.20));
        }
        x.getReview().setSalariu(x.getReview().getSalariu() + amount);
        x.getReview().setReview(x.getReview().getReview() + (float) (x.getReview().getWovertime() / 5.0));
        x.getReview().setReward(x.getReview().getReward() + this.amount / 333.0f);
    }
}
