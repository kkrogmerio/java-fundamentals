package CsvFiles;

import java.io.FileWriter;
import java.io.IOException;

public class ActivityHistory {
    public ActivityHistory() {
        try {       //"./src/FileResources/Date.csv"
            FileWriter csvWriter = new FileWriter("./src/FileResources/History.csv");
            csvWriter.append("Action");
            csvWriter.append(",");
            csvWriter.append("Timestamp");
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
