package SystemManagement;

import CsvFiles.ReadWrite;
import Departament.Departament;
import Departament.DepartamentHr;
import Departament.DepartamentIt;
import Departament.DepartamentShip;
import Departament.DepartamentAdmin;
import DetaliiAngajat.*;
import DetaliiAngajat.Date;
import Interface.DepartmentsManager;
import Job.Jobs;
import Job.NormalJob;
import Job.SpecialJob;
import org.w3c.dom.ls.LSOutput;

import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Services {
    //FileWriter csvWriter = new FileWriter("./src/FileResources/
    static File fl = new File("./src/FileResources/File");
    static Vector<Departament[]> depart = new Vector<Departament[]>();
    static Vector<Jobs> jobs = new Vector<Jobs>();
    static Vector<Angajat> employees = new Vector<Angajat>();
    static List<DepartamentIt> department_it = new ArrayList<DepartamentIt>();
    static List<DepartamentHr> department_hr = new Vector<DepartamentHr>();
    static List<DepartamentShip> department_ship = new Vector<DepartamentShip>();
    static List<DepartamentAdmin> department_admin = new Vector<DepartamentAdmin>();
    static List<List<String>> employeeDataTable = new ArrayList<>();
    static List<List<String>> departmentsDataTable = new ArrayList<>();
    static List<List<String>> jobsDataTable = new ArrayList<>();
    static Scanner scanner;
    static int lastId;

    public static Vector<Departament[]> getDepart() {
        return depart;
    }

    static int isConsole;

    public void yellow() {
        System.out.println("hey");
    }

    static Statement stm;
    private static Services instance;

    public static Services getInstance(Scanner sc, Statement stm) throws IOException, SQLException {
        if (instance == null)
            instance = new Services(sc, stm);
        return instance;
    }
     private Services(Scanner scanner, Statement stm) throws  SQLException {
        this.scanner = scanner;
        this.stm = stm;
        initializeTables();
    }

    public static void setDepart(Vector<Departament[]> depart) {
        Services.depart = depart;
    }

    public static Vector<Jobs> getJobs() {
        return jobs;
    }

    public static void setJobs(Vector<Jobs> jobs) {
        Services.jobs = jobs;
    }

    public static Vector<Angajat> getEmployees() {
        return employees;
    }

    public static void setEmployees(Vector<Angajat> employees) {
        Services.employees = employees;
    }

    static void init_depart() {
        while (true) {
            System.out.println("Choose type of department:IT ADMIN HR SHIPPING");
            {

                String typeOfDeb = (scanner.next());
                //  scanner.next(typeOfDeb);
                if (typeOfDeb.equals("IT")) {
                    System.out.println("Choose type of subdepartment to fit in: (Ex:IT HelpDesk.IT Bigdata-Center_and_Research");

                    DepartamentIt di = new DepartamentIt(scanner.next());
                    di.setThread(Thread.currentThread().getName());
                    System.out.println(di.toString());
                    lastId = di.getMyId();
                    department_it.add(di);

                } else if (typeOfDeb.equals("HR")) {
                    System.out.println("Choose type of subdepartment to fit in: (Ex:Labour_Relations. HR_MANAGEMENT");

                    DepartamentHr dh = new DepartamentHr(scanner.next());
                    dh.setThread(Thread.currentThread().getName());
                    System.out.println(dh.toString());
                    lastId = dh.getMyId();
                    department_hr.add(dh);

                } else if (typeOfDeb.equals("ADMIN")) {
                    System.out.println("Choose type of subdepartment to fit in: (Ex:Work_Control");

                    DepartamentAdmin da = new DepartamentAdmin(scanner.next());
                    da.setThread(Thread.currentThread().getName());
                    System.out.println(da.toString());
                    lastId = da.getMyId();
                    department_admin.add(da);

                } else if (typeOfDeb.equals("SHIPPING")) {
                    System.out.println("Choose type of subdepartment to fit in: (Ex:Sea_Freight_Shipping");

                    DepartamentShip ds = new DepartamentShip(scanner.next());
                    ds.setThread(Thread.currentThread().getName());
                    System.out.println(ds.toString());
                    lastId = ds.getMyId();
                    department_ship.add(ds);

                } else {
                    System.out.println("You've chosen a wrong department name (THEY HAVE TO BE UPPERCASE)");
                }

                System.out.println("Do you want to add more departments Type? 0-NO 1-YES (After closing you'll not be able to add more)");
                if (scanner.nextInt() == 0)
                    break;


            }
        }
        DepartamentIt[] newListIt = new DepartamentIt[department_it.size()];
        for (int i = 0; i < department_it.size(); ++i) {
            newListIt[i] = department_it.get(i);
        }

        DepartamentHr[] newListHr = new DepartamentHr[department_hr.size()];
        for (int i = 0; i < department_hr.size(); ++i)
            newListHr[i] = department_hr.get(i);

        DepartamentAdmin[] newListAdmin = new DepartamentAdmin[department_admin.size()];
        for (int i = 0; i < department_admin.size(); ++i)
            newListAdmin[i] = department_admin.get(i);

        DepartamentShip[] newListShip = new DepartamentShip[department_ship.size()];
        for (int i = 0; i < department_ship.size(); ++i)
            newListShip[i] = department_ship.get(i);

        depart.set(0, newListIt);
        depart.set(1, newListHr);
        depart.set(2, newListAdmin);
        depart.set(3, newListShip);


    }

    private static void initialiseDep() {
        DepartamentIt[] newListIt = new DepartamentIt[department_it.size()];
        for (int i = 0; i < department_it.size(); ++i) {
            newListIt[i] = department_it.get(i);
            System.out.println(newListIt[i]);
        }

        DepartamentHr[] newListHr = new DepartamentHr[department_hr.size()];
        for (int i = 0; i < department_hr.size(); ++i)
            newListHr[i] = department_hr.get(i);

        DepartamentAdmin[] newListAdmin = new DepartamentAdmin[department_admin.size()];
        for (int i = 0; i < department_admin.size(); ++i)
            newListAdmin[i] = department_admin.get(i);

        DepartamentShip[] newListShip = new DepartamentShip[department_ship.size()];
        for (int i = 0; i < department_ship.size(); ++i)
            newListShip[i] = department_ship.get(i);

        depart.add(newListIt);
        depart.add(newListHr);
        depart.add(newListAdmin);
        depart.add(newListShip);

    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Services.lastId = lastId;
    }

    static void init_jobs() throws IOException {
        System.out.println("Choose type of job: special or normal");

        String typeOfJob = scanner.next();

        if (typeOfJob.equals("special")) {
            System.out.println("Specify the job name , the bonus (in $) for workcond and disability");
            SpecialJob sj = new SpecialJob(scanner.next(), scanner.nextInt(), scanner.nextInt());
            sj.setThread(Thread.currentThread().getName());
            jobs.add(sj);

            setLastId(sj.getMyId());
            FileWriter fw = new FileWriter(fl);
            fw.append(" 6 " + sj.getMyId() + " 0 " + " 0 ");
            fw.flush();
            scanner.reset();

        } else if (typeOfJob.equals("normal")) {
            System.out.println("Specify the job name");
            NormalJob nj = new NormalJob(scanner.next());
            nj.setThread(Thread.currentThread().getName());
            setLastId(nj.getMyId());
            jobs.add(nj);
            System.out.println(nj.toString());
            FileWriter fw = new FileWriter(fl);
            fw.append(" 6 " + nj.getMyId() + " 0 " + " 0 ");
            fw.flush();
            scanner.reset();
        } else {
            System.out.println("Job cannot be created because you didn't choose between a special or normal job type");
        }


    }

    static void init_employee() throws FileNotFoundException {

        int raspuns = 1;
        int okey = 1;
        while (raspuns != 0) {

            Random rand = new Random();
            Angajat employee = null;
            try {
                System.out.println("Implement Nume(nume,prenume,CNP)");
                Nume nume = new Nume((scanner.next()), (scanner.next()), scanner.nextLong());
                System.out.println("Implement Date(an,luna,zi)");


                Date date = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                System.out.println("Implement Domiciliu(adresa,numar)");
                Domiciliu domiciliu = new Domiciliu((scanner.next()), scanner.nextInt());

                System.out.println("Implement ReviewAngajat(Work Overtime,Study(0-Graduate 1-MsD 2-PhD))");
                ReviewAngajat review = new ReviewAngajat(scanner.nextInt(), scanner.nextInt());
                employee = new Angajat(nume, domiciliu, review, date);
                System.out.println("Implement JobID,DepartmentID");
                employee.setJobID(scanner.nextInt());
                employee.setDepartID(scanner.nextInt());
                employee.setThread(Thread.currentThread().getName());
                if (update(employee) == false) {

                    okey = 0;
                    return;
                }

                employees.add(employee);
                Collections.sort(employees);
                lastId = employee.getName().getid();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Eroare in introducerea datelor de intrare");
                e.printStackTrace();
            } finally {
                assert employee != null;
                if (okey == 1)
                    System.out.println("A-ti introdus urmatoarele date:  " + employee.toString());
            }
            System.out.println("Do you want to add another employee? 1-Yes 0-No");
            raspuns = scanner.nextInt();
        }
        try {
            FileWriter fileWriter = new FileWriter("./src/FileResources/History.csv", true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileWriter.append("Initializing new employees");
            fileWriter.append(",");
            fileWriter.append(String.valueOf(timestamp));
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void well() {
        System.out.println("The informations inside the tabels: ");
        for (Angajat x : employees) {
            System.out.println(x.toString());
        }
        for (Departament[] x : depart) {

            for (Departament y : x) {
                System.out.println(y.getNume());
                if (y instanceof DepartamentIt)
                    System.out.println(y.toString());
                if (y instanceof DepartamentHr)
                    System.out.println(y.toString());
                if (y instanceof DepartamentShip)
                    System.out.println(y.toString());
                if (y instanceof DepartamentAdmin)
                    System.out.println(y.toString());
            }
        }
        for (Jobs job : jobs) {
            if (job instanceof NormalJob)
                System.out.println(job.toString());
            if (job instanceof SpecialJob)
                System.out.println(job.toString());
        }
    }

    static void extractDataSql() {
        try {
            ResultSet lenDep = stm.executeQuery("select count(*) from departments");
            lenDep.next();
            List<List<String>> dataDep = new ArrayList<>(lenDep.getInt(1));
            ResultSet lenEmp = stm.executeQuery("select count(*) from employee");
            lenEmp.next();
            List<List<String>> dataEmp = new ArrayList<>(lenEmp.getInt(1));

            ResultSet lenJob = stm.executeQuery("select count(*) from jobs");
            lenJob.next();

            List<List<String>> dataJob = new ArrayList<>(lenJob.getInt(1));
            ResultSet resultSetDep = stm.executeQuery("select * from departments");

            while (resultSetDep.next()) {
                int id = resultSetDep.getInt(1);
                String subDep = resultSetDep.getString("subDepartment");
                String departCateg = resultSetDep.getString("departCateg");
                dataDep.add(Arrays.asList(String.valueOf(id), subDep, departCateg, resultSetDep.getString(4)));
            }
            ResultSet resultSetEmp = stm.executeQuery("select * from employee");
            while (resultSetEmp.next()) {
                int id = resultSetEmp.getInt(1);
                String lastName = resultSetEmp.getString(2);
                String firstName = resultSetEmp.getString(3);
                int CNP = resultSetEmp.getInt(4);
                String adress = resultSetEmp.getString(5);
                int nr = resultSetEmp.getInt(6);
                java.sql.Date hireDate = resultSetEmp.getDate(7);
                System.out.println(hireDate);
                int exp = resultSetEmp.getInt(8);
                String level = resultSetEmp.getString(9);
                int wovertime = resultSetEmp.getInt(10);
                int bs = resultSetEmp.getInt(11);
                int salariu = resultSetEmp.getInt(12);
                int depId = resultSetEmp.getInt(13);
                int jobId = resultSetEmp.getInt(14);
                dataEmp.add(Arrays.asList(String.valueOf(id), lastName, firstName, adress + " " + nr, String.valueOf(hireDate), String.valueOf(exp),
                        level, String.valueOf(wovertime), String.valueOf(bs), String.valueOf(salariu), String.valueOf(depId), String.valueOf(jobId), resultSetEmp.getString(15)));
            }
            ResultSet resultSetJob = stm.executeQuery("select * from jobs");
            while (resultSetJob.next()) {
                int id = resultSetJob.getInt(1);
                String jobType = resultSetJob.getString(2);
                int amount = resultSetJob.getInt(3);
                int workcond = resultSetJob.getInt(4);
                int disability = resultSetJob.getInt(5);
                String jobName = resultSetJob.getString(6);
                dataJob.add(Arrays.asList(String.valueOf(id), jobType, String.valueOf(amount), String.valueOf(workcond), String.valueOf(disability), jobName, resultSetJob.getString(7)));
            }
            extractFileData(dataEmp, dataDep, dataJob);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void extractFileData(List<List<String>> angaj, List<List<String>> depar, List<List<String>> jobul) {
        employeeDataTable = new ArrayList<>(angaj);
        departmentsDataTable = new ArrayList<>(depar);
        jobsDataTable = new ArrayList<>(jobul);
        int dIdMax = 0;
        for (int i = 0; i < departmentsDataTable.size(); ++i) {

            List<String> newObjectDep = departmentsDataTable.get(i);

            dIdMax = dIdMax < Integer.valueOf(newObjectDep.get(0)) ? Integer.valueOf(newObjectDep.get(0)) : dIdMax;
            if (newObjectDep.get(2).equals(DepartamentIt.class.getSimpleName())) {
                DepartamentIt di = new DepartamentIt(newObjectDep.get(1));
                di.setMyId(Integer.valueOf(newObjectDep.get(0)));
                di.setThread(newObjectDep.get(3));
                department_it.add(di);
            }
            if (newObjectDep.get(2).equals(DepartamentHr.class.getSimpleName())) {
                System.out.println(newObjectDep.get(2));
                DepartamentHr dh = new DepartamentHr(newObjectDep.get(1));
                dh.setMyId(Integer.valueOf(newObjectDep.get(0)));
                dh.setThread(newObjectDep.get(3));
                department_hr.add(dh);
            }
            if (newObjectDep.get(2).equals(DepartamentAdmin.class.getSimpleName())) {
                System.out.println(newObjectDep.get(2));
                DepartamentAdmin da = new DepartamentAdmin(newObjectDep.get(1));
                da.setThread(newObjectDep.get(3));
                da.setMyId(Integer.valueOf(newObjectDep.get(0)));
                department_admin.add(da);
            }
            if (newObjectDep.get(2).equals(DepartamentShip.class.getSimpleName())) {
                DepartamentShip ds = new DepartamentShip(newObjectDep.get(1));
                ds.setMyId(Integer.valueOf(newObjectDep.get(0)));
                ds.setThread(newObjectDep.get(3));
                department_ship.add(ds);
            }
        }
        Departament.setId(dIdMax);
        initialiseDep();
        int jIdMax = 0;
        for (int i = 0; i < jobsDataTable.size(); ++i) {
            List<String> jobb = jobsDataTable.get(i);
            jIdMax = jIdMax < Integer.valueOf(jobb.get(0)) ? Integer.valueOf(jobb.get(0)) : jIdMax;
            if (jobb.get(1).equals("special")) {
                SpecialJob sj = new SpecialJob(jobb.get(5), Integer.valueOf(jobb.get(3)), Integer.valueOf(jobb.get(4)), Integer.valueOf(jobb.get(2)));
                sj.setMyId(Integer.valueOf(jobb.get(0)));
                jobs.add(sj);

            }
            if (jobb.get(1).equals("normal")) {
                NormalJob nj = new NormalJob(jobb.get(5), Integer.valueOf(jobb.get(2)));
                nj.setMyId(Integer.valueOf(jobb.get(0)));
                jobs.add(nj);
            }
        }
        Jobs.setId(jIdMax);
        for (int i = 0; i < employeeDataTable.size(); ++i) {

            List<String> newObjectAng = employeeDataTable.get(i);
            String[] adresa = newObjectAng.get(3).split(" ");
            System.out.println("yes=" + newObjectAng.get(4).split("-"));
            String[] data = newObjectAng.get(4).split("-");

            System.out.println("data=" + data[0]);
            System.out.println(adresa[1]);
            //List<String> newObjectJob = (List<String>) jobsDataTable.stream().filter(obj -> obj.get(1) == newObjectAng.get(7));
            Date date = new Date(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2]));
            Domiciliu domiciliu = new Domiciliu(adresa[0], Integer.valueOf(adresa[1]));
            Nume nume = new Nume(newObjectAng.get(1), newObjectAng.get(2), Long.valueOf(newObjectAng.get(0)));
            ReviewAngajat reviewAngajat = new ReviewAngajat(Integer.valueOf(newObjectAng.get(7)), Integer.valueOf(newObjectAng.get(8)));
            Angajat employee = new Angajat(nume, domiciliu, reviewAngajat, date);
            employee.getReview().setSalariu(Integer.valueOf(newObjectAng.get(9)));
            employee.setDepartID(Integer.valueOf(newObjectAng.get(10)));
            employee.setJobID(Integer.valueOf(newObjectAng.get(11)));
            employee.setThread(newObjectAng.get(12));
            update(employee);
            employees.add(employee);
            Collections.sort(employees);

        }
        well();
    }

    static void makeTheChange(String table, int ID, String valueToSet, String setValue) {
        String updateRow = null;
        if (table.equals("employee"))
            updateRow = "update  employee" + " set " + valueToSet + " = " + setValue + " where employeeID= " + ID;
        else if (table.equals("departments"))
            updateRow = "update  departments" + " set " + valueToSet + " = " + setValue + " where DepartmentID= " + ID;
        else if (table.equals("jobs"))
            updateRow = "update  jobs" + " set " + valueToSet + " = " + setValue + " where jobID= " + ID;
        try {
            System.out.println(updateRow);
            stm.executeUpdate(updateRow);
            System.out.println("Row updated succesfully");

        } catch (SQLException e) {
            System.out.println("ID invalid");
            e.printStackTrace();
        }
    }

    static void updateRow() {
        while (true) {
            System.out.println("Choose in which table to update(employees/departments/jobs");
            String chooseTable = scanner.next();
            System.out.println(chooseTable);
            if (chooseTable.equals("employees")) {
                System.out.println("Select the employee ID you want to update");
                int id = scanner.nextInt();
                System.out.println("Choose to update : 0-salary/1-hours_overtime/2-level");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("Specify the salary: ");
                    int salary = scanner.nextInt();
                    makeTheChange("employee", id, "salariu", String.valueOf(salary));
                    break;
                } else if (choice == 1) {
                    System.out.println("Specify the hours overtime: ");
                    int wovertime = scanner.nextInt();
                    makeTheChange("employee", id, "wovertime", String.valueOf(wovertime));
                    break;

                } else if (choice == 2) {
                    System.out.println("Specify the level(Junior/Middle/Senior) ");
                    String level = scanner.next();
                    makeTheChange("employee", id, "level", "'" + (level) + "'");
                    break;
                }

            } else if (chooseTable.equals("jobs")) {
                System.out.println("Select the job ID you want to update");
                int id = scanner.nextInt();
                System.out.println("Choose to update : 0-bonus workcond / 1-bonus disability");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("Specify the workcondition bonus amount: ");
                    int workcond = scanner.nextInt();
                    makeTheChange("jobs", id, "workcond", String.valueOf(workcond));
                    break;
                } else if (choice == 1) {
                    System.out.println("Specify the workcondition bonus amount: ");
                    int disability = scanner.nextInt();
                    makeTheChange("jobs", id, "disability", String.valueOf(disability));
                    break;
                }
            } else if (chooseTable.equals("departments")) {
                System.out.println("Select the department ID you want to update");
                int id = scanner.nextInt();


                System.out.println("Update the name of the subdepartment: ");
                String subDepartment = scanner.next();
                makeTheChange("departments", id, "subDepartment", "'" + subDepartment + "'");
                break;

            } else {
                System.out.println("You have to choose between employee , departments and jobs.Try again!");
            }
        }
    }

    static void deleteRow() throws FileNotFoundException {
        while (true) {
            System.out.println("Choose in which table to delete(employees/departments/jobs");

            String chooseTable = scanner.next();
            System.out.println(chooseTable);
            if (chooseTable.equals("employees")) {
                System.out.println("Select the employee ID you want to delete");
                int id = scanner.nextInt();

                String deleteRow = "delete from employee where employeeID= " + id;
                try {
                    stm.executeUpdate(deleteRow);
                    System.out.println("Row deleted succesfully");
                    break;
                } catch (SQLException e) {
                    System.out.println("employeeID invalid");
                    e.printStackTrace();
                }
            } else if (chooseTable.equals("departments")) {
                System.out.println("Select the department ID you want to delete");
                int id = scanner.nextInt();
                String deleteRow = "delete from departments where departmentID= " + id;
                try {
                    stm.executeUpdate(deleteRow);
                    System.out.println("Row deleted succesfully");
                    break;
                } catch (SQLException e) {
                    System.out.println("departmentID invalid");
                    e.printStackTrace();
                }
            } else if (chooseTable.equals("jobs")) {
                System.out.println("Select the job ID you want to delete");
                int id = scanner.nextInt();
                String deleteRow = "delete from jobs where JobID= " + id;
                try {
                    stm.executeUpdate(deleteRow);
                    System.out.println("Row deleted succesfully");
                    break;
                } catch (SQLException e) {
                    System.out.println("jobID invalid");
                    e.printStackTrace();
                }
            } else {

            }
        }

    }
    static void initializeTables() throws SQLException {
        String createDeps="Create table  if not exists departments  (" +
                "departmentID int not null primary key," +
                "subDepartment varchar(25),departCateg varchar(25),thread varchar(25))";
        stm.executeUpdate(createDeps);
        String createJobs="Create table  if not exists jobs  (" +
                "jobID int not null primary key," +
                "jobType varchar(25),amount int,workcond int,disability int,jobName varchar(25),thread  varchar(25))";
        stm.executeUpdate(createJobs);
        String createEmployees="Create table  if not exists employee  (" +
                    "employeeID int not null primary key," +
                    "lastName varchar(25),firstName varchar(25),CNP int,adress varchar(25),number int,hireDate date,experience int,level  varchar(25),wovertime int,bs int,salariu int,jobID int,departmentID int,constraint departmentID foreign key(departmentID) references departments(departmentID),constraint jobID foreign key(jobID) references jobs(jobID),thread varchar(25))";

            stm.executeUpdate(createEmployees);

    }
    public static void application(ReadWrite<List<String>> readWrite) throws FileNotFoundException, IOException {
        int disableDep = 0;

        int x = 1;
        while (x != 0) {
            if (disableDep == 0)
                System.out.println("Introduce command:  1-Initialization of an employee. 2-Initialization of a subdepartment.  3-Initialization of a job.\n4-Introduce data in Employees. 5-Introduce data in Departments. 6-Introduce data in Jobs\n(RECOMMENDED FIRST EXECUTED!)7-Extract data from file to program, 8-Update a row, 9-Delete a row,\n10-Show productive employees,    11-Show overrated employees(review/reward),\n0-Exit\n");
            else {
                System.out.println("Introduce command:  1-Initialization of an employee. = 3-Initialization of a job.\n4-Introduce data in Employees. 5-Introduce data in Departments.  6-Introduce data in Jobs\n(RECOMMENDED FIRST!)7-Extract data from file to program,  8-Update a row,   9-Delete a row,\n10-Show productive employees,     11-Show overrated employees(review/reward)),\n0-Exit\n");

            }
            x = scanner.nextInt();
            if (x == 1)
                init_employee();
            if (x == 2)
                if (disableDep == 0) {
                    init_depart();
                    disableDep = 1;
                }
            if (x == 3)
                init_jobs();
            if (x == 4)
                introduceDataEmployee();
            if (x == 5)
                introduceDataDepartments();
            if (x == 6)
                introduceDataJobs();
            if (x == 7)
                extractDataSql();
            if (x == 8)
                updateRow();
            if (x == 9) {
                deleteRow();
            }
            if (x == 10)
                goodEmployees();
            if (x == 11) {
                for (int i = 0; i < employees.size(); ++i) {
                    Angajat ang = employees.get(i);
                    System.out.println(ang.getName().getNume() + " " + ang.getName().getPrenume() + " " + ang.getReview().getReview() / ang.getReview().getReward());
                }
            }

        }

    }

    public static void application() throws IOException {
        int disableDep = 0;

        int x = 1;
        while (x != 0) {
            if (disableDep == 0)
                System.out.println("Introduce command:  1-Initialization of an employee. 2-Initialization of a subdepartment.  3-Initialization of a job.\n4-Introduce data in Employees. 5-Introduce data in Departments. 6-Introduce data in Jobs\n(RECOMMENDED FIRST EXECUTED!)7-Extract data from file to program, 8-Update a row, 9-Delete a row,\n10-Show productive employees,    11-Show overrated employees(review/reward),\n0-Exit\n");
            else {
                System.out.println("Introduce command:  1-Initialization of an employee. = 3-Initialization of a job.\n4-Introduce data in Employees. 5-Introduce data in Departments.  6-Introduce data in Jobs\n(RECOMMENDED FIRST!)7-Extract data from file to program,  8-Update a row,   9-Delete a row,\n10-Show productive employees,     11-Show overrated employees(review/reward)),\n0-Exit\n");

            }
            System.out.println("X=====" + x);
            x = scanner.nextInt();
            System.out.println(x);
            if (x == 1) {
                System.out.println("INTRAMMMMMMMMMMMM");
                init_employee();
            }
            if (x == 2)
                if (disableDep == 0) {
                    init_depart();
                    disableDep = 1;
                }
            if (x == 3)
                init_jobs();
            if (x == 4)
                introduceDataEmployee();
            if (x == 5)
                introduceDataDepartments();
            if (x == 6)
                introduceDataJobs();
            if (x == 7)
                extractDataSql();
            if (x == 8)
                updateRow();
            if (x == 9)
                deleteRow();
            if (x == 10)
                goodEmployees();
            if (x == 11) {
                for (int i = 0; i < employees.size(); ++i) {
                    Angajat ang = employees.get(i);
                    if ((ang.getReview().getReward() / ang.getReview().getReview()) > 2.0)
                        System.out.println(ang.getName().getNume() + " " + ang.getName().getPrenume() + " " + ang.getReview().getReview() / ang.getReview().getReward());
                }
            }

        }

    }

    static void introduceDataEmployee() throws FileNotFoundException {
        List<List<String>> angajati = new ArrayList<>();

        int id = 0;
        int okey = 1;


        while (okey == 1) {
            System.out.println("Introduce Employee id to insert the data in tabels:\n");

            id = scanner.nextInt();
            if (id == -1)
                id = lastId;
            int finalId = id;
            Angajat ang = employees.stream().filter(obj -> obj.getName().getid() == finalId).findFirst().orElse(null);
            if (ang == null)
                System.out.println("The element which you want to introduce is invalid\n");
            else {
                List<String> listAng = Arrays.asList(String.valueOf(ang.getName().getid()), ang.getName().getNume(), ang.getName().getPrenume(), String.valueOf(ang.getName().getid()),
                        ang.getAdress().getAdresa(), String.valueOf(ang.getAdress().getNumar()), ang.getData().showDate(),
                        String.valueOf(ang.getData().getExp()), ang.getData().getLvl(), String.valueOf(ang.getReview().getWovertime()),
                        String.valueOf(ang.getReview().getBs()), String.valueOf(ang.getReview().getSalariu()), String.valueOf(ang.getDepartID())
                        , String.valueOf(ang.getJobID()), ang.getThread());

                angajati.add(listAng);
                java.util.Date date = null;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println(listAng.get(14));
                System.out.println(listAng.get(7)); //"STR_TO_DATE('"+listAng.get(6)+"',"+"'%d-%m-%y')"
                String insertAng = "insert into employee " + " (employeeID, lastName, firstName, CNP, adress, number,hireDate,  experience, level, wovertime, bs, salariu, departmentID, jobID , thread) " + " values ('" + listAng.get(0) + "','" + listAng.get(1) + "','" + listAng.get(2) + "','" + listAng.get(3)
                        + "','" + listAng.get(4) + "','" + listAng.get(5) + "','" + listAng.get(6) +
                        "','" + listAng.get(7) + "','" + listAng.get(8) + "','" + listAng.get(9) + "','" + listAng.get(10) +
                        "','" + listAng.get(11) + "','" + listAng.get(12) + "','" + listAng.get(13) + "','" + listAng.get(14) + "')";
                try {
                    stm.executeUpdate(insertAng);

                    System.out.println("Employee insert complete");
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                System.out.println("Do you want to insert more employee data into tables? 1-YES 0-NO \n");
                okey = scanner.nextInt();
            }
        }
    }

    static void introduceDataDepartments() throws FileNotFoundException {
        List<List<String>> departments = new ArrayList<>();

        int id = 0;
        int okey = 1;

        while (okey == 1) {
            System.out.println("Introduce Department id to insert the data in tabels:\n");

            id = scanner.nextInt();
            if (id == -1)
                id = lastId;

            int finalId = id;
            DepartamentHr[] depHr;
            DepartamentAdmin[] depAdm;
            DepartamentShip[] depShip;
            DepartamentShip deppShip = null;
            DepartamentAdmin deppAdm = null;
            DepartamentHr deppHr = null;
            DepartamentIt[] depIt = (DepartamentIt[]) depart.get(0);
            DepartamentIt deppIt = Arrays.stream(depIt).filter(obj -> obj.getMyId() == finalId).findFirst().orElse(null);
            if (deppIt == null) {
                depHr = (DepartamentHr[]) depart.get(1);
                deppHr = Arrays.stream(depHr).filter(obj -> obj.getMyId() == finalId).findFirst().orElse(null);
                if (deppHr == null) {
                    depAdm = (DepartamentAdmin[]) depart.get(2);
                    deppAdm = Arrays.stream(depAdm).filter(obj -> obj.getMyId() == finalId).findFirst().orElse(null);
                    if (deppAdm == null) {
                        {
                            depShip = (DepartamentShip[]) depart.get(3);
                            deppShip = Arrays.stream(depShip).filter(obj -> obj.getMyId() == finalId).findFirst().orElse(null);
                        }
                    }
                }
            }
            List<String> listDep = null;
            //IT HR ADMIN SHIP
            if (deppIt != null)
                listDep = Arrays.asList(String.valueOf(deppIt.getMyId()), deppIt.getNume(), deppIt.getClass().getSimpleName(), deppIt.getThread());
            if (deppHr != null)
                listDep = Arrays.asList(String.valueOf(deppHr.getMyId()), deppHr.getNume(), deppHr.getClass().getSimpleName(), deppHr.getThread());
            if (deppAdm != null)
                listDep = Arrays.asList(String.valueOf(deppAdm.getMyId()), deppAdm.getNume(), deppAdm.getClass().getSimpleName(), deppAdm.getThread());
            if (deppShip != null)
                listDep = Arrays.asList(String.valueOf(deppShip.getMyId()), deppShip.getNume(), deppShip.getClass().getSimpleName(), deppShip.getThread());

            //  List<String> listJob = Arrays.asList(ang.getReview().getJob(), ang.getReview().getJobType());
            System.out.println(listDep.toString());
            departments.add(listDep);
            if (listDep == null)
                System.out.println("The department wasn't found.Try again~!");
            else {
                String insertDep = "insert into departments " + " (departmentID,subDepartment,departCateg,thread )" + " values ('" + listDep.get(0) + "','" + listDep.get(1) + "','" + listDep.get(2) + "','" + listDep.get(3) + "')";
                try {
                    stm.executeUpdate(insertDep);
                    System.out.println("Department insert complete");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Do you want to insert more department data into tables? 1-YES 0-NO \n");
            okey = scanner.nextInt();
        }
    }

    static void introduceDataJobs() throws FileNotFoundException {
        List<List<String>> introdjobs = new ArrayList<>();

        int id = 0;
        int okey = 1;

        while (okey == 1) {
            System.out.println("Introduce Job id to insert the data in tabels:\n");

            id = scanner.nextInt();
            if (id == -1)
                id = lastId;
            int finalId = id;
            Jobs[] jobss = jobs.toArray(new Jobs[jobs.size()]);

            List<String> arrayJob = null;
            int finalId1 = id;
            Jobs job = Arrays.stream(jobss).filter(obj -> obj.getMyId() == finalId1).findFirst().orElse(null);

            if (job != null && job.getIdentify().equals("normal")) {
                System.out.println("aici");
                arrayJob = Arrays.asList(String.valueOf(job.getMyId()), String.valueOf(job.getIdentify()), String.valueOf(((NormalJob) job).getAmount()), "0", "0", ((NormalJob) job).getJobName(), job.getThread());
                introdjobs.add(arrayJob);
            }
            if (job != null && job.getIdentify().equals("special")) {
                SpecialJob sj = (SpecialJob) job;
                arrayJob = Arrays.asList(String.valueOf(sj.getMyId()), String.valueOf(sj.getIdentify()), String.valueOf(sj.getAmount()), String.valueOf(sj.getWorkcond()), String.valueOf(sj.getDisability()), sj.getJobName(), sj.getThread());
                introdjobs.add(arrayJob);

            }
            if (arrayJob == null)
                System.out.println("The job wasn't found.Try again~!");
            else {
                System.out.println(arrayJob.get(2) + " " + arrayJob.get(3));
                String insertJob = "insert into jobs " + " (jobID,jobType,amount,workcond,disability,jobName,thread) " + " values ('" + arrayJob.get(0) + "','" + arrayJob.get(1) + "','" + 433 + "','" + arrayJob.get(3) + "','" + arrayJob.get(4) + "','" + arrayJob.get(5) + "','" + "')";
                try {
                    stm.executeUpdate(insertJob);
                    System.out.println("Job insert complete");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Do you want to insert more job data into tables? 1-YES 0-NO \n");
            okey = scanner.nextInt();
        }
    }

    static boolean update(Angajat x) {
        int finalId = x.getJobID();
        Jobs[] jobss = new Jobs[jobs.size()];
        for (int i = 0; i < jobs.size(); ++i)
            jobss[i] = jobs.get(i);
        Jobs job = Arrays.stream(jobss).filter(obj -> obj.getMyId() == finalId).findFirst().orElse(null);
        if (job == null) {
            System.out.println("ID for this job doesn't exist,the employee wasn't created");
            return false;
        } else
            job.getcalcul(x);
        return true;
    }

    static void goodEmployees() {
        System.out.println("Employees with high points of productivity (Review>3.0)");
        for (int i = 0; i < employees.size(); ++i) {

            if (employees.get(i).getReview().getReview() > 3.0)
                System.out.println(employees.get(i).getName().getNume() + " " + employees.get(i).getName().getPrenume() + " review: " + employees.get(i).getReview().getReview());
        }


    }
}



