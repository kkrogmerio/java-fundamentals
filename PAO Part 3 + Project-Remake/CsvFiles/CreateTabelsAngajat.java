package CsvFiles;
import java.io.FileWriter;
import java.io.IOException;


public class CreateTabelsAngajat {
    public  CreateTabelsAngajat()  {

        try {       //"./src/FileResources/Date.csv"
            FileWriter csvWriter = new FileWriter("./src/FileResources/Angajat.csv");
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("Nume");
            csvWriter.append(",");
            csvWriter.append("Prenume");
            csvWriter.append(",");
            csvWriter.append("Adresa");
            csvWriter.append(",");
            csvWriter.append("Data Angajarii");
            csvWriter.append(",");
            csvWriter.append("Experienta(Ani)");
            csvWriter.append(",");
            csvWriter.append("Grad");
            csvWriter.append(",");
            csvWriter.append("Ore suplim/sapt");
            csvWriter.append(",");
            csvWriter.append("Nivel studii:0-Graduate;1-MsD;2-PhD");
            csvWriter.append(",");
            csvWriter.append("Salariu");
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
