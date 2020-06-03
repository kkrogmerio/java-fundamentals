package Job;

import DetaliiAngajat.Angajat;

import java.util.Random;

public class SpecialJob extends Jobs {
    private int workcond, disability, amount;

    private String jobName;

    @Override
    public int getid() {
        return myId;
    }

    @Override
    public String toString() {
        return "SpecialJob{" +
                "myId=" + myId +
                ", jobName='" + jobName + '\'' +
                ", identify='" + identify + '\'' +
                ", workcond=" + workcond +
                ", disability=" + disability +
                ", amount=" + amount +

                '}';
    }

    public SpecialJob(String jobName, int workcond, int disability) {
        super("special");
        this.workcond = workcond;
        this.jobName = jobName;
        this.disability = disability;
        Random rand = new Random();
        this.amount = rand.nextInt(900) + 100;
    }

    public SpecialJob(String jobName, int workcond, int disability, int amount) {
        super("special");
        this.workcond = workcond;
        this.jobName = jobName;
        this.disability = disability;
        Random rand = new Random();
        this.amount = amount;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void getinfo() {
        System.out.println("This is a class to create jobs for ppl with disabilities");
    }

    public void getcalcul(Angajat x) {
        x.getReview().setJobType("Special");
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
        x.getReview().setReview(x.getReview().getReview() + (float) (workcond + disability) / 333.0f);
        x.getReview().setReview(x.getReview().getReview() + (float) (x.getReview().getWovertime() / 5.0));
        x.getReview().setSalariu(x.getReview().getSalariu() + amount);
        x.getReview().setReward(x.getReview().getReward() + this.amount / 333f);
        x.getReview().setSalariu(x.getReview().getSalariu() + disability);
        x.getReview().setSalariu(x.getReview().getSalariu() + workcond);
    }

    public int getWorkcond() {
        return workcond;
    }

    public void setWorkcond(int workcond) {
        this.workcond = workcond;
    }

    public int getDisability() {
        return disability;
    }

    public void setDisability(int disability) {
        this.disability = disability;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
