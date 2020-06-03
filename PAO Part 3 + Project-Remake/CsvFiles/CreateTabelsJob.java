package CsvFiles;

import java.io.FileWriter;
import java.io.IOException;

public class CreateTabelsJob {
    public  CreateTabelsJob() {

        try {       //"./src/FileResources/Date.csv"
            FileWriter csvWriter = new FileWriter("./src/FileResources/Job.csv");
                csvWriter.append("Job");
                csvWriter.append(",");
                csvWriter.append("Tipul jobului");
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
