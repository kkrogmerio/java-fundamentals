package CsvFiles;

import java.io.FileWriter;
import java.io.IOException;

public class CreateTabelsDepartment {
    public  CreateTabelsDepartment() {

        try {       //"./src/FileResources/Date.csv"
            FileWriter csvWriter = new FileWriter("./src/FileResources/Department.csv");
                csvWriter.append("Departament");
                csvWriter.append(",");
                csvWriter.append("Subdepartament");
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
