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

class JobsManager extends JFrame implements ActionListener {

    //@SuppressWarnings("unused")
    //private Statement stm=null;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    static Services s;
    JButton insertJobButton;
    JButton deleteJobButton;
    JButton updateJobButton;
    JScrollPane scrollPane;

    /**
     * Create the frame.
     */
    JTextArea bonusWorkcondUpdate;
    JTextArea bonusDisabilityUpdate;
    JTextArea idDelete;
    JButton dataJob;
    JButton insertJob;
    JButton deleteJob;
    JButton updateJob;
    JPanel deletePanel;
    JPanel updatePanel;
    JPanel insertPanel;
    JPanel dataPanel;
    JTextArea idUpdate;
    private JTextField typeJobInsert;
    private JTextField bonusWorkcondInsert;
    private JTextField bonusDisabInsert;
    private JTable table;
    private JTable table_1;
    private JPanel cardPanel;
    FileWriter fw;
    private JPanel panel_1;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JTextArea jobNameInsert;
    private Statement stm;
    private static JobsManager instance;

    public static JobsManager getInstance(Services st, Statement stm) throws IOException, SQLException {
        if (instance == null)
            instance = new JobsManager(st, stm);
        return instance;
    }

    private JobsManager(Services st, Statement stm) throws IOException, SQLException {
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
        insertJob = new JButton("Insert Job");
        toolBar.add(insertJob);
        insertJob.setBackground(Color.WHITE);
        insertJob.addActionListener(this);

        deleteJob = new JButton("Delete Job");
        toolBar.add(deleteJob);
        deleteJob.setBackground(Color.WHITE);
        deleteJob.addActionListener(this);
        updateJob = new JButton("Update Job");
        updateJob.setBackground(Color.WHITE);
        toolBar.add(updateJob);
        updateJob.addActionListener(this);
        dataJob = new JButton("Data Job");
        dataJob.addActionListener(this);
        dataJob.setBackground(Color.WHITE);
        toolBar.add(dataJob);

        cardPanel = new JPanel();
        cardPanel.setBounds(10, 48, 576, 305);
        contentPane.add(cardPanel);
        cardPanel.setLayout(new CardLayout(0, 0));

        insertPanel = new JPanel();
        cardPanel.add(insertPanel, "name_40189397865800");
        insertPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Insert a job");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(221, 68, 134, 48);
        insertPanel.add(lblNewLabel);

        typeJobInsert = new JTextField();
        typeJobInsert.setBounds(164, 158, 96, 19);
        insertPanel.add(typeJobInsert);
        typeJobInsert.setColumns(10);

        bonusDisabInsert = new JTextField();
        bonusDisabInsert.setText("0");
        bonusDisabInsert.setColumns(10);
        bonusDisabInsert.setBounds(349, 226, 96, 19);
        insertPanel.add(bonusDisabInsert);

        JLabel lblNewLabel_1 = new JLabel("Type Job (normal/special)");
        lblNewLabel_1.setBounds(26, 161, 128, 13);
        insertPanel.add(lblNewLabel_1);

        JLabel lblBonusDisability = new JLabel("Bonus disability");
        lblBonusDisability.setBounds(269, 229, 70, 13);
        insertPanel.add(lblBonusDisability);

        insertJobButton = new JButton("Insert Job");
        insertJobButton.addActionListener(this);
        insertJobButton.setBounds(240, 263, 85, 21);
        insertPanel.add(insertJobButton);

        panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(26, 209, 451, 48);
        insertPanel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblBonusWorkcond = new JLabel("Bonus workcond");
        lblBonusWorkcond.setBounds(10, 22, 82, 13);
        panel_1.add(lblBonusWorkcond);

        bonusWorkcondInsert = new JTextField();
        bonusWorkcondInsert.setText("0");
        bonusWorkcondInsert.setBounds(102, 19, 96, 19);
        panel_1.add(bonusWorkcondInsert);
        bonusWorkcondInsert.setColumns(10);

        lblNewLabel_6 = new JLabel("Only for special job:");
        lblNewLabel_6.setBounds(26, 186, 96, 13);
        insertPanel.add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel("Job Name");
        lblNewLabel_7.setBounds(299, 161, 45, 13);
        insertPanel.add(lblNewLabel_7);

        jobNameInsert = new JTextArea();
        jobNameInsert.setBounds(363, 155, 114, 22);
        insertPanel.add(jobNameInsert);

        updatePanel = new JPanel();
        updatePanel.setLayout(null);
        cardPanel.add(updatePanel, "name_40189412089400");

        JLabel lblNewLabel_2 = new JLabel("Update a job");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(236, 79, 102, 32);
        updatePanel.add(lblNewLabel_2);

        idUpdate = new JTextArea();
        idUpdate.setBounds(108, 152, 114, 22);
        updatePanel.add(idUpdate);

        bonusWorkcondUpdate = new JTextArea();
        bonusWorkcondUpdate.setBounds(108, 225, 114, 22);
        updatePanel.add(bonusWorkcondUpdate);

        bonusDisabilityUpdate = new JTextArea();
        bonusDisabilityUpdate.setBounds(373, 225, 114, 22);
        updatePanel.add(bonusDisabilityUpdate);

        JLabel lblNewLabel_3 = new JLabel("ID");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(53, 158, 45, 13);
        updatePanel.add(lblNewLabel_3);

        JLabel lblWorkcond = new JLabel("Bonus Workcond");
        lblWorkcond.setBounds(10, 231, 88, 13);
        updatePanel.add(lblWorkcond);

        JLabel lblBonusDisability_1 = new JLabel("Bonus disability");
        lblBonusDisability_1.setBounds(286, 231, 77, 13);
        updatePanel.add(lblBonusDisability_1);

        updateJobButton = new JButton("Update job");
        updateJobButton.setBounds(235, 274, 85, 21);
        updateJobButton.addActionListener(this);
        updatePanel.add(updateJobButton);

        deletePanel = new JPanel();
        cardPanel.add(deletePanel, "name_40189426321000");
        deletePanel.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Delete a job");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_4.setBounds(149, 88, 276, 30);
        deletePanel.add(lblNewLabel_4);

        deleteJobButton = new JButton("Delete job");
        deleteJobButton.addActionListener(this);
        deleteJobButton.setBounds(258, 220, 85, 21);
        deletePanel.add(deleteJobButton);

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
        ResultSet length = stm.executeQuery("select count(*) from jobs");
        length.next();
        Object[][] data = new Object[length.getInt(1)][];
        ResultSet resultSetJob = stm.executeQuery("select * from jobs");


        int i = -1;
        while (resultSetJob.next()) {
            int id = resultSetJob.getInt(1);
            String jobType = resultSetJob.getString(2);
            int amount = resultSetJob.getInt(3);
            int workcond = resultSetJob.getInt(4);
            int disability = resultSetJob.getInt(5);
            String jobName = resultSetJob.getString(6);
            String thread = resultSetJob.getString(7);

            i += 1;
            data[i] = new Object[]{id, jobType, amount, workcond, disability, jobName, thread};

            //dataJob.add(Arrays.asList(String.valueOf(id),jobType,String.valueOf(amount),String.valueOf(workcond),String.valueOf(disability),jobName,resultSetJob.getString(7)));
        }

        String[] column = {"jobID", "jobType", "amount", "workcond", "disabiity", "jobName", "thread"};
        table = new JTable(data, column);

        scrollPane.setViewportView(table);


        //dataJob.add(table);
        dataJob.addActionListener(this);

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
        if (clicked == deleteJob) {
            switchPanels(deletePanel);

        } else if (clicked == insertJob) {
            switchPanels(insertPanel);
        } else if (clicked == updateJob) {
            switchPanels(updatePanel);
        } else if (clicked == dataJob) {
            switchPanels(dataPanel);
            ResultSet length = null;

            try {
                length = stm.executeQuery("select count(*) from jobs");

                length.next();
                Object[][] data = new Object[length.getInt(1)][];
                ResultSet resultSetJob = stm.executeQuery("select * from jobs");


                int i = -1;
                while (resultSetJob.next()) {
                    int id = resultSetJob.getInt(1);
                    String jobType = resultSetJob.getString(2);
                    int amount = resultSetJob.getInt(3);
                    int workcond = resultSetJob.getInt(4);
                    int disability = resultSetJob.getInt(5);
                    String jobName = resultSetJob.getString(6);
                    String thread = resultSetJob.getString(7);

                    i += 1;
                    data[i] = new Object[]{id, jobType, amount, workcond, disability, jobName, thread};

                    //dataJob.add(Arrays.asList(String.valueOf(id),jobType,String.valueOf(amount),String.valueOf(workcond),String.valueOf(disability),jobName,resultSetJob.getString(7)));
                }


                String[] column = {"jobID", "jobType", "amount", "workcond", "disabiity", "jobName", "thread"};
                table = new JTable(data, column);

                scrollPane.setViewportView(table);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (clicked == deleteJobButton) {
            int val = Integer.parseInt(idDelete.getText());
            try {

                fw.append("9 jobs " + idDelete.getText() + " 0 ");
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

        } else if (clicked == updateJobButton) {
            try {

                if (bonusWorkcondUpdate.getText().equals("") == false) {

                    fw.append("8 jobs " + idUpdate.getText());
                    fw.append(" 0 " + bonusWorkcondUpdate.getText() + " 0 ");
                    fw.flush();
                    s.application();
                }


                if (bonusDisabilityUpdate.getText().equals("") == false) {
                    fw.append("8 jobs " + idUpdate.getText());
                    fw.append(" 1 " + bonusDisabilityUpdate.getText() + " 0 ");
                    fw.flush();
                    s.application();
                }


                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }
        } else if (clicked == insertJobButton) {
            try {
                fw.append("7 3 " + typeJobInsert.getText() + " ");
                if (typeJobInsert.getText().equals("special")) {
                    fw.append(jobNameInsert.getText() + " " + bonusWorkcondInsert.getText() + " " + bonusDisabInsert.getText() + " 6 " + " -1 " + " 0 " + " 0 ");//+s.getLastId()+" 0 "+" 0 ");
                    fw.flush();

                    s.application();
                } else if (typeJobInsert.getText().equals("normal")) {
                    fw.append(jobNameInsert.getText() + " 6 " + " -1 " + " 0 " + " 0 ");

                    fw.flush();
                    s.application();
                }
                jobNameInsert.setText("");
                bonusWorkcondInsert.setText("0");
                bonusDisabInsert.setText("0");
                typeJobInsert.setText("");

                JOptionPane.showMessageDialog(this, "Succesful");
            } catch (FileNotFoundException ef) {
                ef.printStackTrace();
            } catch (IOException eio) {
                eio.printStackTrace();
            }
        }


    }
}
