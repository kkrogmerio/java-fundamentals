package Interface;

import SystemManagement.Services;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu extends JPanel implements ActionListener {
    private JButton button_msg;
    private JPanel panelMain;
    private JButton employeesDataManager;
    private JButton jobsDataManager;
    private JButton departmentsDataManager;
    private JButton extractFileData;
    private JButton oldEmployees;
    private Services s;
    private Statement stm;
    final static String FORM_ONE = "Form One";

    public Menu(Services s, Statement stm) {
        this.s = s;
        this.stm = stm;
        setLayout(new BorderLayout());
        employeesDataManager = new JButton("Employees Manager");
        employeesDataManager.addActionListener(this);
        jobsDataManager = new JButton("Jobs Manager");
        jobsDataManager.addActionListener(this);
        departmentsDataManager = new JButton("Departments Manager");
        departmentsDataManager.addActionListener(this);
        extractFileData = new JButton("Extract file data");
        extractFileData.addActionListener(this);
        extractFileData.addActionListener(this);
        oldEmployees = new JButton("Show old employees");
        oldEmployees.addActionListener(this);
        oldEmployees.addActionListener(this);
        add(employeesDataManager, BorderLayout.CENTER);
        add(jobsDataManager, BorderLayout.EAST);
        add(departmentsDataManager, BorderLayout.WEST);
        add(extractFileData, BorderLayout.NORTH);
        add(oldEmployees, BorderLayout.SOUTH);


    }

    public void showTable() {


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == employeesDataManager) {
            try {
                EmployeesManager employeesManager = EmployeesManager.getInstance(s, stm);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (clicked == jobsDataManager) {

            try {
                JobsManager jobsManager = JobsManager.getInstance(s, stm);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException es) {
                es.printStackTrace();
            }
        } else if (clicked == departmentsDataManager) {
            try {
                DepartmentsManager departmentsManager = DepartmentsManager.getInstance(s, stm);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (clicked == oldEmployees) {
            setOldEmployees();
        } else if (clicked == extractFileData) {
            try {
                FileWriter fw = new FileWriter("./src/FileResources/File");
                fw.write("7 0 0");
                fw.flush();
                s.application();

                return;
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    void setOldEmployees() {
        JFrame frame = new JFrame();
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 5, 576, 300);
        contentPane.add(scrollPane);
        ResultSet length = null;
        try {
            length = stm.executeQuery("SELECT count(*)\n" +
                    "from employee\n" +
                    "where TIMESTAMPDIFF(YEAR, hireDate, CURDATE())=2");

            length.next();
            Object[][] data = new Object[length.getInt(1)][];
            ResultSet resultSetJob = stm.executeQuery("SELECT *\n" +
                    "from employee\n" +
                    "where TIMESTAMPDIFF(YEAR, hireDate, CURDATE())=2");


            int i = -1;
            while (resultSetJob.next()) {
                int id = resultSetJob.getInt(1);
                String lastName = resultSetJob.getString(2);
                String firstName = resultSetJob.getString(3);

                i += 1;
                data[i] = new Object[]{id, lastName, firstName};
            }

            String[] column = {"Employee ID", "Last Name", "First Name"};
            JTable table = new JTable(data, column);
            scrollPane.setViewportView(table);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setPreferredSize(new Dimension(600, 400));
            frame.pack();
            frame.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            //dataJob.add(Arrays.asList(String.valueOf(id),jobType,String.valueOf(amount),String.valueOf(workcond),String.valueOf(disability),jobName,resultSetJob.getString(7)));
        }
    }
}
