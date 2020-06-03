package DetaliiAngajat;

import java.text.ParseException;
import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Date  {
    int an,luna,zi;
    LocalDateTime myObj = LocalDateTime.now();
    private String lvl;
    private int exp;
    public Date(int an, int luna, int zi) {
        this.an = an;
        this.luna = luna;
        this.zi = zi;
        System.out.println("an="+an);
        experience();
    }
    public String showDate(){
        return String.valueOf(an) + '-' + String.valueOf(luna) + '-' + String.valueOf(zi);
    }
    @Override
    public String toString() {
        return "Date{" +
                "an=" + an +
                ", luna=" + luna +
                ", zi=" + zi +
                ", lvl='" + lvl + '\'' +
                ", exp=" + exp +
                '}';
    }

    void experience() {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
            String inputString1 = zi + " " + luna + " " + an;

            LocalDateTime date1 = LocalDate.parse(inputString1, dtf).atStartOfDay();
            // LocalDateTime date2 = LocalDateTime.parse(myObj, dtf);
            int daysBetween = (int) Duration.between(date1, myObj).toDays();
            if((0 < daysBetween) && daysBetween< 365)
                lvl="Junior";
            else if ((365<daysBetween)&& daysBetween<3*365)
                lvl="Middle";
            else if (daysBetween>3*365)
                lvl="Senior";
            exp=(int)(daysBetween/365);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getLuna() {
        return luna;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public int getZi() {
        return zi;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    void specific(){
        if((20<=myObj.getYear()-an)&&myObj.getYear()-an<30)
            System.out.println("Young employee");
        if((30<=myObj.getYear()-an)&&myObj.getYear()-an<44)
            System.out.println("Millenial employee");
        if((44<=myObj.getYear()-an)&&myObj.getYear()-an<65)
            System.out.println("Experienced employee");
    }

}
