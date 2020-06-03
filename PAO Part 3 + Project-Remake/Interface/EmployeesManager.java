package Interface;

import SystemManagement.Services;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.border.LineBorder;

class EmployeesManager extends JFrame implements ActionListener {


    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    static Services s;
    JButton insertEmployeeButton;
    JButton deleteEmployeeButton;
    JButton updateEmployeeButton;
    JScrollPane scrollPane;
    JTextArea insertJobId;
    JTextArea insertDepartmentId;
    JTextArea insertCNP;
    JTextArea insertYear;
    JTextArea insertMonth;
    JTextArea insertDay;
    JTextArea insertAdress;
    JTextArea insertNr;
    JTextArea insertWovertime;
    JTextArea insertStudy;
    JTextArea levelUpdate;
    JTextArea salaryUpdate;
    JTextArea wovertimeUpdate;
    JTextArea idDelete;
    JButton dataEmployee;
    JButton insertEmployee;
    JButton deleteEmployee;
    JButton updateEmployee;
    JPanel deletePanel;
    JPanel updatePanel;
    JPanel insertPanel;
    JPanel dataPanel;
    JTextArea idUpdate;
    private JTextField insertLastName;
    private JTable table;
    private JTable table_1;
    private JPanel cardPanel;
    FileWriter fw;
    private JLabel lblNewLabel_7;
    private JTextArea insertFirstName;
    private Statement stm;
    private static EmployeesManager instance;

    public static EmployeesManager getInstance(Services st, Statement stm) throws IOException, SQLException {
        if (instance == null)
            instance = new EmployeesManager(st, stm);
        return instance;
    }

    private EmployeesManager(Services st, Statement stm) throws IOException, SQLException {
        fw = new FileWriter("./src/FileResources/File");

        this.stm = stm;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(this, popupMenu);
        JButton btnNewButton = new JButton("New button");
        popupMenu.add(btnNewButton);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(Color.GRAY);
        toolBar.setForeground(Color.BLACK);
        toolBar.setBounds(0, 0, 596, 38);
        contentPane.add(toolBar);
        Border b = BorderFactory.createLineBorder(Color.black);
        insertEmployee = new JButton("Insert Employee");
        toolBar.add(insertEmployee);
        insertEmployee.setBackground(Color.WHITE);
        insertEmployee.addActionListener(this);

        deleteEmployee = new JButton("Delete Employee");
        toolBar.add(deleteEmployee);
        deleteEmployee.setBackground(Color.WHITE);
        deleteEmployee.addActionListener(this);
        updateEmployee = new JButton("Update Employee");
        updateEmployee.setBackground(Color.WHITE);
        toolBar.add(updateEmployee);
        updateEmployee.addActionListener(this);
        dataEmployee = new JButton("Data Employee");
        dataEmployee.addActionListener(this);
        dataEmployee.setBackground(Color.WHITE);
        toolBar.add(dataEmployee);

        cardPanel = new JPanel();
        cardPanel.setBounds(10, 39, 576, 324);
        contentPane.add(cardPanel);
        cardPanel.setLayout(new CardLayout(0, 0));

        insertPanel = new JPanel();
        cardPanel.add(insertPanel, "name_40189397865800");
        insertPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Insert an Employee");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(224, 0, 156, 48);
        insertPanel.add(lblNewLabel);

        insertLastName = new JTextField();
        insertLastName.setBounds(72, 49, 111, 22);
        insertPanel.add(insertLastName);
        insertLastName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Last name");
        lblNewLabel_1.setBounds(10, 53, 128, 13);
        insertPanel.add(lblNewLabel_1);

        insertEmployeeButton = new JButton("Insert Employee");
        insertEmployeeButton.addActionListener(this);
        insertEmployeeButton.setBounds(235, 293, 120, 21);
        insertPanel.add(insertEmployeeButton);

        lblNewLabel_7 = new JLabel("First Name");
        lblNewLabel_7.setBounds(193, 58, 73, 13);
        insertPanel.add(lblNewLabel_7);

        insertFirstName = new JTextArea();
        insertFirstName.setBounds(258, 47, 114, 22);
        insertPanel.add(insertFirstName);

        insertCNP = new JTextArea();
        insertCNP.setBounds(452, 47, 114, 22);
        insertPanel.add(insertCNP);

        insertYear = new JTextArea();
        insertYear.setBounds(72, 99, 114, 22);
        insertPanel.add(insertYear);

        insertMonth = new JTextArea();
        insertMonth.setBounds(258, 99, 114, 22);
        insertPanel.add(insertMonth);

        insertDay = new JTextArea();
        insertDay.setBounds(452, 99, 114, 22);
        insertPanel.add(insertDay);

        insertAdress = new JTextArea();
        insertAdress.setBounds(115, 154, 114, 22);
        insertPanel.add(insertAdress);

        insertNr = new JTextArea();
        insertNr.setBounds(411, 154, 114, 22);
        insertPanel.add(insertNr);

        insertWovertime = new JTextArea();
        insertWovertime.setBounds(115, 214, 114, 22);
        insertPanel.add(insertWovertime);

        insertStudy = new JTextArea();
        insertStudy.setBounds(411, 214, 114, 22);
        insertPanel.add(insertStudy);

        JLabel text = new JLabel("Year");
        text.setBounds(10, 105, 45, 13);
        insertPanel.add(text);

        JLabel lblCnp = new JLabel("CNP");
        lblCnp.setBounds(382, 53, 45, 13);
        insertPanel.add(lblCnp);

        JLabel lblNewLabel_8 = new JLabel("Hire Date");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_8.setBounds(288, 79, 59, 13);
        insertPanel.add(lblNewLabel_8);

        JLabel text1 = new JLabel("Month");
        text1.setBounds(193, 105, 45, 13);
        insertPanel.add(text1);

        JLabel text2 = new JLabel("Day");
        text2.setBounds(382, 105, 45, 13);
        insertPanel.add(text2);

        JLabel text4 = new JLabel("Nr");
        text4.setBounds(288, 160, 45, 13);
        insertPanel.add(text4);

        JLabel lblHoursOvertime = new JLabel("Hours overtime");
        lblHoursOvertime.setBounds(10, 220, 78, 13);
        insertPanel.add(lblHoursOvertime);

        JLabel lblStudygraduatemsdphd = new JLabel("Study(0-Graduate 1-MsD 2-PhD)");
        lblStudygraduatemsdphd.setBounds(245, 220, 156, 13);
        insertPanel.add(lblStudygraduatemsdphd);

        JLabel lblNewLabel_9 = new JLabel("Adress");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_9.setBounds(288, 131, 45, 13);
        insertPanel.add(lblNewLabel_9);

        JLabel text3 = new JLabel("Adress");
        text3.setBounds(43, 160, 45, 13);
        insertPanel.add(text3);

        JLabel lblReviewEmployee = new JLabel("Review employee");
        lblReviewEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblReviewEmployee.setBounds(269, 183, 111, 27);
        insertPanel.add(lblReviewEmployee);

        insertJobId = new JTextArea();
        insertJobId.setBounds(135, 261, 114, 22);
        insertPanel.add(insertJobId);

        insertDepartmentId = new JTextArea();
        insertDepartmentId.setBounds(398, 261, 114, 22);
        insertPanel.add(insertDepartmentId);

        JLabel lblNewLabel_11 = new JLabel("Department IT");
        lblNewLabel_11.setBounds(306, 267, 74, 13);
        insertPanel.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("Job ID");
        lblNewLabel_12.setBounds(80, 267, 45, 13);
        insertPanel.add(lblNewLabel_12);

        updatePanel = new JPanel();
        updatePanel.setLayout(null);
        cardPanel.add(updatePanel, "name_40189412089400");

        JLabel lblNewLabel_2 = new JLabel("Update an Employee");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(236, 79, 153, 32);
        updatePanel.add(lblNewLabel_2);

        idUpdate = new JTextArea();
        idUpdate.setBounds(108, 152, 114, 22);
        updatePanel.add(idUpdate);

        salaryUpdate = new JTextArea();
        salaryUpdate.setBounds(47, 225, 114, 22);
        updatePanel.add(salaryUpdate);

        wovertimeUpdate = new JTextArea();
        wovertimeUpdate.setBounds(275, 225, 114, 22);
        updatePanel.add(wovertimeUpdate);

        JLabel lblNewLabel_3 = new JLabel("ID");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(53, 158, 45, 13);
        updatePanel.add(lblNewLabel_3);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(10, 231, 88, 13);
        updatePanel.add(salary);

        JLabel hoursOvertime = new JLabel("Hours Overtime");
        hoursOvertime.setBounds(188, 231, 77, 13);
        updatePanel.add(hoursOvertime);

        updateEmployeeButton = new JButton("Update Employee");
        updateEmployeeButton.setBounds(235, 274, 85, 21);
        updateEmployeeButton.addActionListener(this);
        updatePanel.add(updateEmployeeButton);

        levelUpdate = new JTextArea();
        levelUpdate.setBounds(452, 225, 114, 22);
        updatePanel.add(levelUpdate);

        JLabel lblNewLabel_13 = new JLabel("Level");
        lblNewLabel_13.setBounds(399, 231, 45, 13);
        updatePanel.add(lblNewLabel_13);

        JLabel lblNewLabel_14 = new JLabel("!Hint: Level(Junior/Middle/Senior)");
        lblNewLabel_14.setBounds(10, 278, 165, 13);
        updatePanel.add(lblNewLabel_14);

        deletePanel = new JPanel();
        cardPanel.add(deletePanel, "name_40189426321000");
        deletePanel.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Delete an Employee");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_4.setBounds(149, 88, 276, 30);
        deletePanel.add(lblNewLabel_4);

        deleteEmployeeButton = new JButton("Delete Employee");
        deleteEmployeeButton.addActionListener(this);
        deleteEmployeeButton.setBounds(258, 220, 85, 21);
        deletePanel.add(deleteEmployeeButton);

        JLabel lblNewLabel_5 = new JLabel("ID");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_5.setBounds(166, 178, 59, 13);
        deletePanel.add(lblNewLabel_5);

        idDelete = new JTextArea();
        idDelete.setBounds(235, 172, 123, 22);
        deletePanel.add(idDelete);

        dataPanel = new JPanel();
        cardPanel.add(dataPanel, "name_41104845133400");
        dataPanel.setLayout(null);
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 5, 576, 300);
        dataPanel.add(scrollPane);
        ResultSet length = stm.executeQuery("select count(*) from employee");
        length.next();
        Object[][] data = new Object[length.getInt(1)][];
        ResultSet resultSetEmployee = stm.executeQuery("select * from employee");


        int i = -1;
        while (resultSetEmployee.next()) {
            int id = resultSetEmployee.getInt(1);
            String lastName = resultSetEmployee.getString(2);
            String firstName = resultSetEmployee.getString(3);
            String thread = resultSetEmployee.getString(15);

            i += 1;
            data[i] = new Object[]{id, lastName, firstName, thread};

            //dataEmployee.add(Arrays.asList(String.valueOf(id),EmployeeType,String.valueOf(amount),String.valueOf(workcond),String.valueOf(disability),EmployeeName,resultSetEmployee.getString(7)));
        }

        String[] column = {"EmployeeID", "Last Name", "Fist Name", "thread"};
        table = new JTable(data, column);

        scrollPane.setViewportView(table);


        //dataEmployee.add(table);
        dataEmployee.addActionListener(this);

        this.s = st;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setVisible(true);
    }

    public void switchPanels(JPanel panel) {
        cardPanel.removeAll();
        cardPanel.add(panel);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == deleteEmployee) {
            switchPanels(deletePanel);

        } else if (clicked == insertEmployee) {
            switchPanels(insertPanel);
        } else if (clicked == updateEmployee) {
            switchPanels(updatePanel);
        } else if (clicked == dataEmployee) {
            switchPanels(dataPanel);
            ResultSet length = null;

            try {
                length = stm.executeQuery("select count(*) from employee");
                length.next();
                Object[][] data = new Object[length.getInt(1)][];
                ResultSet resultSetEmployee = stm.executeQuery("select * from employee");


                int i = -1;
                while (resultSetEmployee.next()) {
                    int id = resultSetEmployee.getInt(1);
                    String lastName = resultSetEmployee.getString(2);
                    String firstName = resultSetEmployee.getString(3);
                    String thread = resultSetEmployee.getString(15);

                    i += 1;
                    data[i] = new Object[]{id, lastName, firstName, thread};

                    //dataEmployee.add(Arrays.asList(String.valueOf(id),EmployeeType,String.valueOf(amount),String.valueOf(workcond),String.valueOf(disability),EmployeeName,resultSetEmployee.getString(7)));
                }

                String[] column = {"EmployeeID", "Last Name", "Fist Name", "thread"};
                table = new JTable(data, column);
                scrollPane.setViewportView(table);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (clicked == deleteEmployeeButton) {
            int val = Integer.parseInt(idDelete.getText());
            try {

                fw.append("9 employees " + idDelete.getText() + " 0");
                System.out.println(fw.toString());
                fw.flush();
                s.application();
                idDelete.setText("");
                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }

        } else if (clicked == updateEmployeeButton) {
            try {

                if (salaryUpdate.getText().equals("") == false) {
                    fw.append("8 employees " + idUpdate.getText());
                    fw.append(" 0 " + salaryUpdate.getText() + " 0 " + " 0 ");
                    fw.flush();

                    s.application();
                }
                if (wovertimeUpdate.getText().equals("") == false) {
                    fw.append("8 employees " + idUpdate.getText());
                    fw.append(" 1 " + wovertimeUpdate.getText() + " 0 " + " 0 ");
                    fw.flush();
                    s.application();
                }
                if (levelUpdate.getText().equals("") == false) {
                    fw.append("8 employees " + idUpdate.getText());
                    fw.append(" 2 " + levelUpdate.getText() + " 0 " + " 0 ");
                    fw.flush();
                    s.application();
                }
                wovertimeUpdate.setText("");
                salaryUpdate.setText("");
                levelUpdate.setText("");
                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }
        } else if (clicked == insertEmployeeButton) {
            try {
                fw.append("7 1 " + insertLastName.getText() + " " + insertFirstName.getText() + " " + insertCNP.getText() + " " + insertYear.getText() + " " + insertMonth.getText() + " " + insertDay.getText() + " " +
                        insertAdress.getText() + " " + insertNr.getText() + " " + insertWovertime.getText() + " " + insertStudy.getText() + " " + insertDepartmentId.getText() + " " + insertJobId.getText());

                fw.append(" 0 " + " 4 " + " -1 " + " 0 " + " 0 ");

                fw.flush();
                s.application();


                insertFirstName.setText("");
                insertJobId.setText("");
                insertDepartmentId.setText("");
                insertStudy.setText("");
                insertWovertime.setText("");
                insertNr.setText("");
                insertAdress.setText("");
                insertNr.setText("");
                insertLastName.setText("");

                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }
        }


    }
}
