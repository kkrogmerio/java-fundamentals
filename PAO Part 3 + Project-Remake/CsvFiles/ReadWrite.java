package CsvFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWrite<T> {
    public static final String BASE_PATH = "./src/FileResources/";
    private static ReadWrite instance;
    private List<T> valuesDep;
    private List<T> valuesJobs;

    private List<T> valuesAng;
    private File fAng = new File(BASE_PATH + "Angajat" + ".csv");
    private File fDep = new File(BASE_PATH + "Department" + ".csv");
    private File fJob = new File(BASE_PATH + "Job" + ".csv");
    private File fHis = new File(BASE_PATH + "History" + ".csv");
    public List<T> getValuesDep() {
        return valuesDep;
    }

    public List<T> getValuesJobs() {
        return valuesJobs;
    }

    public List<T> getValuesAng() {
        return valuesAng;
    }

    public void setValuesDep(List<T> valuesDep) {
        this.valuesDep = valuesDep;
    }

    public void setValuesJobs(List<T> valuesJobs) {
        this.valuesJobs = valuesJobs;
    }

    public void setValuesAng(List<T> valuesAng) {
        this.valuesAng = valuesAng;
    }

    private ReadWrite() {
        try{
            if (fHis.createNewFile()){
                System.out.println("History Activity tabel will be created");
                ActivityHistory activityHistory=new ActivityHistory();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            if (fAng.createNewFile() ||fDep.createNewFile()||fJob.createNewFile() ) {
                System.out.println("The files didn't exist , will be created");
                CreateTabelsAngajat ctA = new CreateTabelsAngajat();
                CreateTabelsDepartment ctD = new CreateTabelsDepartment();
                CreateTabelsJob ctJ = new CreateTabelsJob();
            } else {
                valuesAng = read(fAng);
                valuesJobs=read(fJob);
                valuesDep=read(fDep);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> read(File file) throws IOException {
        String row = null;
        List<T> fetchData= new ArrayList<>();
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        while (true) {
            try {
                if ((row = csvReader.readLine()) == null) break;

                List<String>data = Arrays.asList(row.split(","));
                fetchData.add((T) data);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        csvReader.close();
        return fetchData;
    }

        public void write (List<List<String>> rowsAng,List<List<String>> rowsDep,List<List<String>> rowsJob) {
            try {
                if(rowsAng.size()!=rowsDep.size()||rowsDep.size()!=rowsJob.size()){
                    System.out.println("Lungimile segmentelor difera,vor exista un numar de linii inegal in fisiere/scrierea in fisier nu s-a efectuat");
                    return;}
                FileWriter csvWriter = new FileWriter(fAng,true);
                for (List<String> rowData : rowsAng) {
                    csvWriter.append(String.join(",", rowData));
                    csvWriter.append("\n");
                }

                csvWriter.flush();
                csvWriter.close();
                csvWriter = new FileWriter(fDep,true);
                for (List<String> rowData : rowsDep) {
                    csvWriter.append(String.join(",", rowData));
                    csvWriter.append("\n");
                }

                csvWriter.flush();
                csvWriter.close();
                csvWriter = new FileWriter(fJob,true);
                for (List<String> rowData : rowsJob) {
                    csvWriter.append(String.join(",", rowData));
                    csvWriter.append("\n");
                }

                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        public static ReadWrite getInstance () {
            instance = new ReadWrite();
            return instance;
        }

}
